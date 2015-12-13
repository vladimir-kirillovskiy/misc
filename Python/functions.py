#Number functions 
def is_even(x):
    if x % 2 == 0:
        return True
    else:
        return False

def is_int(x):
    if x - round(x) == 0:
        return True
    else:
        return False

def digit_sum(n):
    result = 0
    for i in str(n):
        result += int(i)
        
    return result

def factorial(x):
    result = 1
    if x == 1:
        result = 1
    else:
        for i in range(1, x+1):
            result *= i
    return result

def is_prime(x):
    if x < 2:
        return False
    for n in range(2, x-1):
        if x % n == 0:
            return False
    
    return True

# String functions

def reverse(text):
    revStr = ''
    lenStr = len(text) 
    for i in range(lenStr - 1, -1, -1):
        revStr += text[i]
    return revStr

def anti_vowel(text):
    vowels = 'aeiouAEIOU'
    new_text = ''
    for v in vowels:
            text = text.replace(v, '')
    return text