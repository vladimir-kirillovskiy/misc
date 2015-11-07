import pygame, sys, random, math			# need to instal python-pygame from AUR
import pygame.locals as GAME_GLOBALS
import pygame.event as GAME_EVENTS
import pygame.time as GAME_TIME
import ships

windowWidth = 1024
windowHeight = 614

pygame.init()
pygame.font.init()
surface = pygame.display.set_mode((windowWidth, windowHeight))

pygame.display.set_caption('Alien\'s Are Going to Kill Me!')
textFont = pygame.font.SysFont("monospace", 50)

gameStarted = False
gameStaredTime = 0
gameFinishedTime = 0
gameOver = False

# Mouse Variables
mousePosition = (0,0)
mouseStates = None
mouseDown = False

# Image Variables
startScreen = pygame.image.load('assets/start_screen.png')
background = pygame.image.load('assets/background.png')

# Ships
ship = ships.Player(windowWidth / 2, windowHeight, pygame, surface)
enemyShips = []

lastEnemyCreated = 0
enemyInterval = random.randint(1000, 2500)

# Sound Setup
pygame.mixer.init()