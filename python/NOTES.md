# Python Farm
Python example implementation of a little farm game.

| Lenguaje | Versión        | SO                |
| -------- | -------------- | ----------------- |
| Python   | Python 3.6.9   | Ubuntu 18.04.1    |

## Documentation

| Type          | Link                                           |
| ------------- | ---------------------------------------------- |
| Learn Python  | https://developers.google.com/edu/python/      |
| Tutorial      | https://www.stavros.io/tutorials/python/       |
| Docstrings    | https://realpython.com/documenting-python-code/|
| Unit tests    | https://realpython.com/python-testing/         |

## Create Python environment
```bash
# To create a python isolated environment, we can use the
# virtualenv tool
mkdir project
cd project/
virtualenv .
source bin/activate
python main.py
```

## Variables
```python
# Python is a dynamic typed language, so you can omit the data type and the interpreter will infer the data type.
# Python is an interpreted language
# Variables should be named using snake_case

# Numbers
>>> x = 10 
>>> x : int = 10 

## For numbers you can use the _ symbol to make it more readable
>>> x = 10_000_000

>>> x = 10.3
>>> x : float = 10.3

# Strings
>>> x = "my str"
>>> x : str = "my str"

# Booleans
>>> x = True
>>> x : bool = False

# Lists
>>> x = []
>>> x : list = []

# Dictionaries
>>> x = {}
>>> x : dict = {}
```
### Data types
```python
# We can know the data type with the type() function
>>> type(10)
<class 'int'>

>>> type(5.2)
<class 'float'>

>>> type("my str")
<class 'str'>

>>> type(True)
<class 'bool'>

>>> type([])
<class 'list'>

>>> type({})
<class 'dict'>
```
### Operators
```python
# '+' operator
## In numbers just execute the addition operation
## In String works as concatenation
>>> 1 + 1
2
>>> 1 + 1.5
2.5
>>> "my_str" + "other"
'my_strother'

# '-' operator
## In numbers just execute the subtraction operation
>>> 1 - 1
0

# '*'
## In numbers execute the multiplication operation
## In strings, repeat a string n times
>>> 2 * 5
10
>>> "abcd" * 3
'abcdabcdabcd'

# '/'
## In numbers execute the division operation
>>> 10 / 3
3.3333333333333335

# '//'
## In numbers execute the division operation
## Return the integer part
>>> 10 // 3
3

# '%' Modulus
## In numbers execute the modulus operation
## Returns remainder
>>> 10 % 2
0

# '**'
## In numbers
## Performs exponential (power) operation
>>> 2 ** 5
32

# Binary operators
## Used commonly with variables

# '+='
## In numbers just execute the addition operation
## In String works as concatenation
>>> x = 1
>>> x += 1
2
>>> x += 1.5
3.5

>>> x = "str "
>>> x += "other"
'str other'

# '-='
## In numbers just execute the subtraction operation
>>> x = 2
>>> x -= 1
1

# '*='
## In numbers execute the multiplication operation
## In strings, repeat a string n times
>>> x = 2
>>> x *= 5
10

>>> x = "ab"
>>> x *= 3
"ababab"

# '/='
## In numbers execute the division operation
>>> x = 5
>>> x /= 2
2.5

# '//='
## In numbers execute the division operation
## Return the integer part
>>> x = 5
>>> x //= 2
2

# '%='
## In numbers execute the modulus operation
## Returns remainder
>>> x = 5
>>> x %= 2
1
```

### Useful functions
```python
# You can convert a number into string using str() function
>>> x = str(10)
'10'

# You can convert a string into a number using int() for integers
# and float() for decimals
>>> x = int("5")
5
>>> x = float("5.3")
5.3
```

## Control structures (Control flow)
```python
# If conditional
## Used to compare or validate a element or sentence. And, depending on the result
## executes an action
item = 5
if item == 5:
    print("Is 5")
elif item == 4:
    print("Is 4")
else:
    print("Unknown")

## The block elif can be used how much you need it. It works like a case structure
## because in python the case structure doesn't exists

## To represent the if - else, we can use a one line sentence
## called ternary operator => condition ? true : false
## In python => True if condition else False
is_five = True if item == 5 else False

## Also, we could emulate the one line conditional (commonly used in Ruby)
## if condition: True
if item == 5: is_five = True

## To compare items we can use also the keyword 'is'
## item == 5 is the same that item is 5
if item is 5: is_five = True

## To negate a condition we can use the keyword 'not'
if item is not 4: is_five = True

## To validate if an item is in a list, you can use the keyword 'in'
if 5 in [1,2,3,4,5]: in_list = True

# While
## It's used to create a loop when we don't have a specific limit.
value = 0
while value is not 5:
    value = int(input())

## Note: We can receive user input via console, using the function input()

# For
## It's used to create a loop in a rage of values.
for i in range(0, 10):
    print(i) # It will print the numbers from 0 to 9

## You can specify the number of steps the for will do in each iteration
for i in range(0, 10, 2):
    print(i) # It will print the numbers between 0 and 10, with steps of 2

## You can iterate an array or dict as a for each
for i in ["item1", "item2", "item3"]:
    print(i) # It will print each element of the list


## Keyword 'continue'
## You can use this keyword to skip the current iteration
for i in range(0,10):
    if i == 3:
        continue # Continue to the iteration 4

## Keyword 'break'
## You can use this keyword to interrupt the loop execution
for i in range(0, 10):
    if i == 3:
        break # Interrupt the loop
```

## Data structures
```python
# https://docs.python.org/2/tutorial/datastructures.html
# Arrays and Lists
array : list = []

## Get value
## You can get the value of the position using [index]
array[0]

## .append(value)
## Adds a new element at the end of the list
array.append(5)

## .insert(index, value)
## Insert an item at a given position.
## The items in positions between the las index of the list and the new element index
## that aren't assigned will be None
array.insert(10, 4)

## .remove(value)
## Remove the first item from the list whose value is x
array.remove(4)

## .pop(index)
## Remove the item at the given position in the list, and return i
## removes and returns the last item in the list
array.pop(0)

## sorted() methods
## Used to sort an array. Usually used for an array of objects
sorted(array, key=lambda item: item.value)

## Search an item
## Filter the array and return the items that match the condition
item = [x for x in array if x == 5]

## .filter
## is a lambda function used to filter elements
list(filter(lambda x: x.name == name, array))

## .map
## is used to perform an operation to each element of the list
list(map(lambda x: x * x, array))

## .reduce
## is used to perform an operation over whole array and return a single value
import functools
functools.reduce(lambda prev,next : prev + next ,[1,2,3])
6

# Dictionary
dictionary : dict = {}

## Add a element
## You can assign an element with the following syntax: dict[index] = value
dictionary['key'] = 5

## .values()
## Obtains a list of dictionary values
list(dictionary.values())

## .keys()
## Obtains a list of dictionary keys
list(dictionary.keys())

### Note: if you use the sentence for in in a dict, you will iterate the keys
```

## OOP
```python
# Classes and Objects
class Item:
    def __init__(self, name=""):
        pass

    def method(self):
        pass

## Observations:
## The __init__ method is the class constructor
## the keyword 'pass' is used to represent 'doing nothing'
## Every method must receive self as param, to represent it belongs to the class

## Instantiate an object
item = Item("pepe")

# Inheritance
## The inheritance allows to separate common logic in a different class
class Parent:
    def method(self):
        print("Hello")

class Child(Parent):
    def __init__(self):
        Parent.__init__(self)

item = Child()
item.method() #=> prints 'Hello'

## Observations:
## To represent the Inheritance in python you have to Give the Parent class
## as a Class parameter MyClass(MyParentClass):
## To invoke or super the Parent constructor, you have to call the __init__
## method an send self class as param


## Abstract methods
## Are methods that aren't defined into the Parent class
## and should be defined in each Child class
from typing import abstractmethod

class Parent:
    @abstractmethod
    def method(self):
        pass

class Child(Parent):
    def method(self):
        print('Hello from child')

item = Child()
item.method() #=> prints 'Hello from child'

## Static methods
## Are methods that can be invoked without an instance
import datetime

class Dates:
    @staticmethod
    def current_date():
        return datetime.datetime.now()

print(Dates.current_date()) #=> 2020-04-11 17:00:03.093115
```

### Scopes
```python
# Scope variable
## It exists in the context where it was created
## in python it applies to a function or object, because if you define a variable into a control structure (if, for, ...)
## you will be able to access it outside these control structures.
def function():
    scope_var = 10

print(scope_var) # ==> Raises an error

# Object variable
## It exists in the object scope, and it can be accessed for an object instance
class Item:
    def __init__(self):
        self.public_var = 10  # It is a public variable
        self.__private_var = 20 # It is a private variable, it will not be accessible

item = Item()
print(item.public_var) # => 10
print(item.__private_var) # Raises an error

# Class variable
## It exists in the class scope. Shared across all class instances
## Usually used to define constants.
class Item:
    CLASS_VAR = 30

print(Item.CLASS_VAR) # => 30

## This value is also available in a object instance
## e.g: item = Item()
##      item.CLASS_VAR
```

## Comments
```python
# You can define online comments using the symbol '#'
# This is a one line comment

# You can define multiline comments using """ """.
"""
This is a multiple line
comment
"""

# Docstrings
## You can use multiline comments to document your code
## Here is an basic structure:

## Class documentation
"""
A useful description of the Class

...
Attributes
----------
attribute : type
    attribute description

Methods
-------
method(param)
    method description
"""

## Method documentation:
"""
A useful method description

Parameters
----------
param : type
    param description

Return
------
value : type
    value description

Raises
------
TypeError
    Error description
"""
```
