import projectiles, random

class Player():

	x = 0
	y = 0
	firing = False
	image = None
	SoundEffect = 'sounds/player_laser.wav'
	pygame = None
	surface = None
	width = 0
	height = 0
	bullets = []
	bulletImage = 'assets/you_pellet.png'
	bulletSpeed = -10
	health = 5

	def loadImages(self):
		self.image = self.pygame.image.load('assets/your_ship.png')

	def draw(self):
		self.surface.blit(self.image, (self.x, self.y))

	def setPosition(self, pos):
		self.x = pos[0] - self.width / 2
		#self.y = pos[1]

	def fire(self):
		self.bullets.append(
				projectiles.Bullet(
					self.x + self.width / 2,
					self.y, self.pygame, 
					self.surface, 
					self.bulletSpeed, 
					self.bulletImage))

		a = self.pygame.mixer.Sound(self.SoundEffect)
		a.setVolume(0.2)
		a.play()

	def drawBullets(self):
		for b in self.bullets:
			b.move()
			b.draw()

	def registerHit(self):
		self.health -= 1

	def checkForHit(self, thingToCheckAgains):
		bulletsToRemove = []

		for idx, b in enumerate(self.bullets):
			if b.x > thingToCheckAgains.x and b.x < thingToCheckAgains.x + thingToCheckAgains.width:
				if b.y > thingToCheckAgains.y and b.y < thingToCheckAgains.y + thingToCheckAgains.height:
					thingToCheckAgains.registerHit()
					bulletsToRemove.append(idx)

		for usedBullet in bulletsToRemove:
			del self.bullets[usedBullet]

		if thingToCheckAgains.health <= 0:
			return True

	def __init__(self, x, y, pygame, surface):
		self.x = x
		self.y = y
		self.pygame = pygame
		self.surface = surface
		self.loadImages()

		dimensions = self.image.get_rect().size
		self.width = dimensions[0]
		self.height = dimensions[1]

		self.x -= self.width / 2
		self.y -= self.height + 10

class Enemy(Player) :

	x = 0
	y = 0
	firing = False
	image = None
	soundEffect = 'sounds/enemy_laser.wav'
	bulletImage = 'assets/them_pellet.png'
	bulletSpeed = 10
	speed = 2

	def move(self) :
		self.y += self.speed

	def tryToFire(self) :
		shouldFire = random.random()

		if shouldFire <= 0.01
			self.fire()

	def loadImages(self) :
		self.image = self.pygame.image.load('assets/them_ship.png')

	def __init__(self, x, y, pygame, surface, health) :
		self.x = x
		self.y = y
		self.pygame = pygame
		self.surface = surface
		self.loadImages()
		self.bullets = []
		self.health = health

		dimensions = self.image.get_rect().size
		self.width = dimensions[0]
		self.height = dimensions[1]

		self.x -= self.width / 2

