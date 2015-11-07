# basic program to test input and output 
# gpio features by using button to turn on and off 
# LED light

# gives runtime error every second run
# tried to catche it with try/except
# didn't work 
try:
	from gpiozero import LED, Button	# need to have gpiozero installed
	from time import sleep			# sleep() function
except RuntimeError:
	print("Error importing gpiozero")

button = Button(2)
led = LED(17)


# couldn't make it work
# it should wait till button is pressed and released
# but it did trigger without action
# could be because I do not have proper button
# and using 2 wires

# button.when_pressed = led.on()
# button.when_realesed = led.off()


while True:
	if button.is_pressed :
		print("button pressed")
		led.on()
	else:
		print("button not pressed")
		led.off()
