#!/bin/bash

# -----------------------------------------------------------------------------
# bash script to create a 4GB disk image and install Arch Linux to it.
# uses GPT partitions :
#  part 1 : FAT32 /boot with syslinux bootloader
#  part 2 : ext4 / rootfs
# -----------------------------------------------------------------------------

set -e
export LANG=
export LC_ALL=

# -----------------------------------------------------------------------------
# variables
# -----------------------------------------------------------------------------

# disk image file name
disk="arch.img"
disk_size="4G"
boot_size="127M"

# -----------------------------------------------------------------------------
# check environment
# -----------------------------------------------------------------------------

if [ $(id -u) != 0 ] ; then
	echo "you must be root to run programs in this script"
	exit 1
fi

# check if required programs are installed

declare -A programs
programs[truncate]=coreutils
programs[sgdisk]=gptfdisk
programs[mkdosfs]=dosfstools
programs[mkfs.ext4]=e2fsprogs
programs[kpartx]=multipath-tools
programs[dmsetup]=device-mapper
programs[losetup]=util-linux
programs[rsync]=rsync
programs[syslinux]=syslinux
programs[pacstrap]=arch-install-scripts
programs[qemu-system-x86_64]=qemu

for program in ${!programs[@]} ; do
	package=${programs[$program]}
	if ! which $program >/dev/null 2>/dev/null; then
		echo "Program '${program}' is not installed (from package '${package}')"
		install_packages="${install_packages} $package"
	fi
done

if [ "${install_packages}" != "" ] ; then
	echo "Install missing packages with :"
	echo "pacman -S${install_packages}"
	exit 1
fi

# -----------------------------------------------------------------------------
# create disk image
# -----------------------------------------------------------------------------

if [ -e "${disk}" ] ; then
	echo "disk image '${disk}' already exists, will not remove it automatically".
	exit 1
fi

truncate --size=${disk_size} ${disk}

# -----------------------------------------------------------------------------
# create partitions
# -----------------------------------------------------------------------------

sgdisk ${disk} \
	--new=1:1M:+${boot_size}M \
	--new=2:: \
	--attributes=1:set:2

declare -a map_files
readarray -t lines < <(kpartx -a -v ${disk})

for line in "${lines[@]}"
do
    map=$(echo $line | awk '{print $3}')
    map_file="/dev/mapper/${map}"
    map_files+=("${map_file}")
done

# -----------------------------------------------------------------------------
# create aliases for partitions
# -----------------------------------------------------------------------------

device_boot=${map_files[0]}
device_root=${map_files[1]}

# -----------------------------------------------------------------------------
# create filesystems
# -----------------------------------------------------------------------------

mkdosfs -F 32 -n BOOT ${device_boot}
mkfs.ext4 -m 0 -L root ${device_root}

# -----------------------------------------------------------------------------
# mount filesystems
# -----------------------------------------------------------------------------

mount_boot=$(mktemp -d)
mount_root=$(mktemp -d)

mount ${device_boot} ${mount_boot}
mount ${device_root} ${mount_root}

# -----------------------------------------------------------------------------
# setup boot filesystem
# -----------------------------------------------------------------------------

# install syslinux

rsync -r /usr/lib/syslinux/bios/ ${mount_boot}/syslinux/

cat > ${mount_boot}/syslinux/syslinux.cfg <<EOF
DEFAULT arch
PROMPT 0
TIMEOUT 50
UI menu.c32

MENU TITLE syslinux

LABEL arch
MENU LABEL Arch Linux
LINUX ../vmlinuz-linux
APPEND rw root=/dev/disk/by-label/root nomodeset i915.modeset=0 nouveau.modeset=0 bochs-drm.fbdev=0
INITRD ../initramfs-linux.img
EOF

dd if=/usr/lib/syslinux/bios/gptmbr.bin of=${disk} bs=440 count=1 conv=notrunc
syslinux --install /dev/mapper/loop0p1

# -----------------------------------------------------------------------------
# setup root filesystem
# -----------------------------------------------------------------------------

pacstrap -c ${mount_root} base

cat > ${mount_root}/etc/mkinitcpio.conf <<EOF
MODULES="ext4 fat vfat 9pnet 9pnet_virtio"
MODULES+=" nls_iso8859-1 nls_cp437"
MODULES+=" ahci aoe ata_piix nvme usb-storage sd-mod"
MODULES+=" usbcore xhci-hcd ehci-hcd hid hid_generic usbhid evdev usb-storage atkbd"
MODULES+=" virtio_ring virtio_pci virtio virtio_mmio virtio-rng virtio_console virtio_blk"
HOOKS="base udev modconf keyboard block filesystems fsck"
COMPRESSION="xz"
COMPRESSION_OPTIONS="-1"
EOF

arch-chroot ${mount_root} mkinitcpio -p linux

# install kernel and initramfs

cp \
	${mount_root}/boot/vmlinuz-linux \
	${mount_root}/boot/initramfs-linux.img \
	${mount_boot}/

# -----------------------------------------------------------------------------
# clean up
# -----------------------------------------------------------------------------

umount ${mount_root}
umount ${mount_boot}

dmsetup remove ${map_files[@]}
losetup -D

# -----------------------------------------------------------------------------
# run image in QEMU
# -----------------------------------------------------------------------------

# choose if we want to start QEMU with virtio or SATA disk

QEMU_DISK_VIRTIO=1

if [ $QEMU_DISK_VIRTIO ] ; then
	qemu-system-x86_64 \
		-enable-kvm \
		-m 1024 \
		-drive file=${disk},format=raw,if=virtio
elif [ $QEMU_DISK_SATA ] ; then
	qemu-system-x86_64 \
		-enable-kvm \
		-m 1024 \
		-drive id=disk,file=${disk},if=none \
		-device ahci,id=ahci \
		-device ide-drive,drive=disk,bus=ahci.0
fi
