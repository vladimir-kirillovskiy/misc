# Python 3.0
# https://www.youtube.com/watch?v=N4mEzFDjqtA

# !!! NO SEMICOLONS !!!
# !!! Does not support ++/-- !!!

# The \ character is a continuation character. The following line is considered a continuation of the current line.



# single line comment
''' 
	multiline comment
'''

# load module
import random
import sys
import os

# print string
print('Hello World')

#variable 
name = "Vlad"
print(name)
name = 15

# Data types:
	Numbers
	Strings
	Lists
	Tuples
	Dictionaties

# math operations:
+ - * / % ** // 

** - exponential operator
// - floor devision

# string
quote = "\"Lol\""

multiline_quote = ''' 
	heallo
''' 

new_string = quote + multiline_quote
# parametarised string
print("%s %s %s" % ('quote', quote, multiline_quote))
# no new line after print
print("No new line", end="")
# print 5 new lines 
print("\n" * 5)

# Lists
grocery_list = ['juice', 'Tomatoes',
	'Bananas']
other_events = ['wash car', 'cash check']

print('first item', grocery_list[0])
# print items between 1 and 3
print(grocery_list[1:3])

# print as string and join with spaces
print " ".join(grocery_list)

# list of lists
to_do_list = [other_events, grocery_list]

# append record to the list
# it seems it will also update to_do_list as grocery_list is part of it 
grocery_list.append('Onions')

grocery_list.insert(1, "pickle")
grocery_list.remove("pickle")
grocery_list.sort()
grocery_list.reverse()

del grocery_list[4]

# all changes to grocery list will affect to_do_list
print(to_do_list)


print(len(to_do_list))
print(max(to_do_list))
print(min(to_do_list))
print(sorted(to_do_list))

# Tuples - similar to list but can't change

pi_tuple = (3,1,4,1,5,9)

# convert into list and back
new_tuple = list(pi_tuple)
new_list = tuple(new_tuple)

len(tuple)
min(tuple)
max(tuple)

# Dictionaries/Maps - similar to list but you can't join them together

super_villains = {'Fiddler':'Isaac Bowin'}
print(super_villains['Fiddler'])
del super_villains['Fiddler']
super_villains['Fiddler'] = 'new name'

print(len(super_villains))
print(super_villains.get('Fiddler'))
print(super_villains.keys())
print(super_villains.values())

# Conditionals

if else elif == != > >= < <=

age = 21

if age > 16 :
	print("You are old enough to drive")
else :
	print("You are not old enough to drive")

# logical operators
# and or not

if ((age >= 1) and (age <= 18)) :
	print("Lol")
elif (age == 21) or (age >= 65) :
	print("Lol")
elif not(age == 30) :
	print("Lol")
else :
	print("Lol")

# Loops
# For loop
for x in range(0, 10):
	print(x, ' ', end="")

print("\n")

# use zip to handle more than one element
for a, b in zip(list_a, list_b):
	#smlthng

for y in grocery_list:
	print(y)

for x in [3,4,5,8]
	print(x)

num_list = [[1,2,3], [10,20,30], [100,200,300]]

for x in range(0,3) :
	for y in range(0,3) :
		print(num_list[x][y])

# While loop

random_number = random.randrange(0,100)
while (random_number != 15)
	print(random_number)
	random_number = random.randrange(0,100)

i = 0

while (i <= 20)
	if (i%2 == 0) :
		print(i)
	elif (i==9) :
		break
	else :
		i += 1
		continue


# functions

def addNumber(fNum, lNum) :
	sumNum = fNum + lNum
	return sumNum


print(addNumber(1,4))
string = addNumber(1,4)

# get input from user

print('What is your name?')
name = sys.stdin.readline()
print('Hello', name)

# strings

long_string = "i'll catch you if you fall - The Floor"

# first 4 chars
print(long_string[0:4])
# last 4 chars 
print(long_string[-5:])
# up to last 5 chras
print(long_string[:-5])

# concatinate/join strings
print(long_string[0:4] + "be there")


# %c - char
# %s - string 
# %d - digit/int
# %.5f - float with 5 decimal places 
print("%c is my %s letter and my number %d is %.5f" % ('X', 'favorite', 1, .14 ))

# capitalize first letter
print(long_string.capitalize())

# find string(case sensetive)
print(long_string.find("Floor"))

# check if only letters
print(long_string.isalpha())
# check if number
print(long_string.isalnum())
# length of the string
print(len(long_string))
# replace string
print(long_string.replace("Floor", "Ground"))
# strip whitespaces
print(long_string.strip())

# split string into list
qoute_list = long_string.split(" ")

# file io 

# open or create file
# "ab+" to read & append to file
test_file = open("test.txt", "ab+")

print(test_file.mode)
print(test_file.name)

test_file.write(bytes("Write me to the file\n", 'UTF-8'))

test_file.close()

# read from file
# "r+" read and write
test_file = open("test.txt", "r+")
text_in_file = test_file.read()

print(text_in_file)

# remove file
# os module used
os.remove("test.txt")

# Objects

class Animal :
	 # None signifies the lack of a value
    # You can make a variable private by starting it with __
	#__name = None
	__name = ""
	__height = 0
	__weight = 0
	__sound = 0

	# constructor
	# The constructor is called to set up or initialize an object
    # self allows an object to refer to itself inside of the class
	def __init__(self, name, height, weight, sound) :
		self.__name = name
		self.__height = height
		self.__weight = weight
		self.__sound = sound

	# setters and getters
	def set_name(self, name) :
		self.__name = name

	def get_name(self) :
		return self.__name

	def get_type(self) :
		print("Animal")

	def toString(self) :
		return "{} is {} cm tall and {} killograms and say".format(
			self.__name,
			self.__height, 
			self.__weight, 
			self.__sound
		)

cat = Animal('Whiskers', 33, 10, 'Meow')
print(cat.toString())

# inheritance
# You can inherit all of the variables and methods from another class 
class Dog(Animal) :
	__owner = None

	def __init__(self, name, height, weight, sound, owner) :
			self.__owner = owner
			# use constructor form super class(Animal)
			super(Dog, self).__init__(name, height, weight, sound)

	def set_owner (self, owner) :
		self.__owner = owner
	def get_owner (self) :
		return self.__owner
	def get_type(self) :
		print("Dog")

	# overwrite function in the super class
	def toString(self) :
		return "{} is {} cm tall and {} killograms and say and owner {}".format(
			self.__name,
			self.__height, 
			self.__weight, 
			self.__sound
			self.__owner
		)

	# You don't have to require attributes to be sent
	# This allows for method overloading
	def multiple_sounds(self, how_many=None) :
		if how_many is None :
			print(self.get_sound())
		else:
			print(self.get_sound() * how_many)


# Polymorphism 
# Polymorphism allows use to refer to objects as their super class
# and the correct functions are called automatically

class AnimalTesting :
	def get_type(self, animal):
		animal.get_type()

test_animals = AnimalTesting()

test_animals.get_type(cat) 
test_animals.get_type(dog) 


# try exept:
def index_power(array, n):
    try: return array[n] ** n
    except IndexError: return -1 		# can be different types of exeptions