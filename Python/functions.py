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

score = {"a": 1, "c": 3, "b": 3, "e": 1, "d": 2, "g": 2, 
         "f": 4, "i": 1, "h": 4, "k": 5, "j": 8, "m": 3, 
         "l": 1, "o": 1, "n": 1, "q": 10, "p": 3, "s": 1, 
         "r": 1, "u": 1, "t": 1, "w": 4, "v": 4, "y": 4, 
         "x": 8, "z": 10}
         
def scrabble_score(word):
    word = word.lower()
    result = 0;
    for l in word:
        result += score[l]
        
    return result

def censor(text, word):
    text = text.replace(word, '*' * len(word))
    return text

def count(sequence, item):
    c = 0
    for i in sequence:
        if i == item:
            c += 1

    return c

def purify(num_list):
    new_list = []
    for i in num_list:
        print(i)
        if i % 2 == 0:
            new_list.append(i)
    return new_list

def product(intList):
    result = 1;
    for i in intList:
        result *= i
    return result

def remove_duplicates(lst):
    new_list = [];
    for i in lst:
        if (i not in new_list):
            new_list.append(i)
            
    return new_list

def median(lst):
    lst = sorted(lst)
    lstLen = len(lst)
    if lstLen % 2 == 0 and lstLen > 2:
        index1 = lstLen / 2
        index2 = index1 - 1
        
        return (lst[index1] + lst[index2]) / 2.0
    elif lstLen == 1:
        return lst[0]
    elif lstLen == 2:
        return (lst[0] + lst[1]) / 2.0
    else:
        return lst[lstLen/2]
        