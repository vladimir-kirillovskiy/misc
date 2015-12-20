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
print(a, b)		 # better than print(a + " " + b)

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
int_list = [1,2,3,4,5]
sum(int_list[::2])			# sum(1,3,5) return every second element in a list


# Comprehensions
# consist of the cubes of the numbers 1 through 10 only if the cube is evenly divisible by four.
cubes_by_four = [x ** 3 for x in range(1, 11) if (x ** 3) % 4 == 0]		
print([x * 2 for x in range(10) if x % 2 == 0])		# another example

# list slising
# [start:end:stride] 
print l[2:9:2]

# we can omit start and end as we using enire arrays
int_list = [1,2,3,4,5]
print(int_list[::2])			# return every second element in a list
print(int_list[::-1])			# return reversed list

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
print(super_villains.items())

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

# Anonymous Functions
# with anonymus functions we can pass functions as parameters
my_list = range(16)
# filter my_list against anonymus function  
print filter(lambda x: x % 3 == 0, my_list) 	# return [0, 3, 6, 9, 12, 15]
languages = ["HTML", "JavaScript", "Python", "Ruby"]
print filter(lambda x: x == "Python", languages)

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


# bitwise operators

print (5 >> 4)  # Right Shift
print (5 << 1)  # Left Shift
print (8 & 5)   # Bitwise AND
print (9 | 4)   # Bitwise OR
print (12 ^ 42) # Bitwise XOR
print (~88)     # Bitwise NOT

# In Python, you can write numbers in binary format 
# by starting the number with 0b. When doing so, the numbers 
# can be operated on like any other number!

print 0b1,    #1
print 0b10,   #2
print 0b11,   #3
print 0b100,  #4
print 0b101,  #5
print 0b110,  #6
print 0b111   #7

bin(dec) 	# takes decimal and returns binary
hex(dec)	# takes decimal and returns hex
oct(dec)	# takes decimal and returns oct

# convert 110 bin to decimal
int("110", 2) 		# will return  6

# Left Bit Shift (<<)  
0b000001 << 2 == 0b000100 (1 << 2 = 4)
0b000101 << 3 == 0b101000 (5 << 3 = 40)       

# Right Bit Shift (>>)
0b0010100 >> 3 == 0b000010 (20 >> 3 = 2)