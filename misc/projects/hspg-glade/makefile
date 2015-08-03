.PHONY: all clean debug

CXX=g++
CPPFLAGS=-g $(shell pkg-config gtkmm-3.0 --cflags)
LDLIBS=$(shell pkg-config gtkmm-3.0 --libs) -lssl -lcrypto

SRCS=main.cpp gui.cpp hash.cpp
OBJS=$(subst .ccp,.o,$(SRCS))

all: gui

clean:
	rm -f gui
# need to have gdb installed
debug : gui
	gdb gui -ex run

gui: $(OBJS)
	$(CXX) $(CPPFLAGS) -o gui $(OBJS) $(LDLIBS)

main.o: main.cpp gui.cpp hash.cpp


