Python2 with www.codecademy.com

# No semicolons at the end of the line
# True and False start with capital letter
# indentation for functions
# Does not support ++/-- 
# The \ character is a continuation character. The following line is considered a continuation of the current line.



def spam():
	eggs = 12
	return eggs
        
print spam()

# Single line comment
""" 
	multi line comment
"""

# MATH

** - power of(^)

# STRINGS

multi_line_str = ''' multi
line
string '''

str = "str";
str[2]          # "r"
str[1:2]        # "tr"
len(str)        
str.lower()
str.upper()
str()       	# cast to string
str.isalpha()   # check is it is only letters. True/False

# Methods that use dot notation only work with strings.

# The % operator after a string is used to combine 
# a string with variables. The % operator will replace 
# a %s in the string with the string variable that comes after it.
str = "%s, %s" % ("Hello", "World")

raw_input("question") # get input from console

# DATETIME

from datetime import datetime	  # include datetime library

now = datetime.now() 	          # get current date 
print now
print now.year
print now.month
print now.day
print now.hour
print now.minute
print now.second

print '%s-%s-%s' % (now.year, now.month, now.day)	# print mm/dd/yyyy

# BOOLEAN
NOT is evaluated first;
AND is evaluated next;
OR 	is evaluated last.


# FLOW CONTROL
	
def greater_less_equal_5(answer):
    if answer > 5:
        return 1
    elif answer < 5:          
        return -1
    else:
        return 0


# functions

def spam():
    eggs = 12
    return eggs
        
print spam()

# Imports

import math                 # include math module
math.sqrt(15)               # can use functions of math module
from math import sqrt       # can import functions so we don't need to type math. infront of the function
from math import *          # can import every thing, this is bad idea as function can conflict with each others

# Build in function

max(10,15,-15)              # return max value
min(10,15,-15,-13)          # return min value           
abs(-64)                    # return absolute value
type(42)                    # return type of value, in this case it would be int (not a string)

# For loops

names = ["Adam","Alex","Mariah","Martine","Columbus"]

for i in names:
    print i

# can loop throu a string
for letter in "Codecademy":
    print letter


# dictionaries

prices = {
    "banana": 4,
    "apple": 2,
    "orange": 1.5,
    "pear": 3    
}