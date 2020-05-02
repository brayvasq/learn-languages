# Ruby Farm

Ruby example implementation of a little farm game.

| Language | Version        | SO                |
| -------- | -------------- | ----------------- |
| Ruby     | ruby 2.6.3p62  | Ubuntu 18.04.1    |

## Create ruby environment
```bash
mkdir ruby
bundle gem .

# Running irb for the gem project
bin/console
```

## Tools
```bash
# REPL: Read Eval Print Loop
irb

# ri 
## Ruby documentation on the terminal
ri String

# rdoc
## Generates the file documentation in a file or folder, using the html format.
## The generated docs depends on the code comments for methods and classes.
rdoc album.rb
```

## String
**Definition:** A set of characters.

**Statements:** Code lines

```ruby
# String
word = "One line string"

# Multiline String
words = <<MLS 
	Multiline
	String
MLS
```

### String interpolation
```ruby
# String interpolation allows us to concatenate elements into a string.
# These elements, can be numbers, booleans, arrays, variables etc
irb> x = 5
irb> puts "X: #{x}"
 "X: 5"
```

### Character scapes
```ruby
# Escape characters
## Lets you use special characters inside a string.
## Also, it allows you to add new lines or tab spaces in a one line string
## Strings defined with single quotes do not allow escape characters and string interpolation
irb> puts "New line \n"
New line
irb> puts "Gets symbol \\"
Gets symbol\
irb> puts "Space \t tab"
Space 	 tab
irb> puts "Gets quotation \""
Gets quotation "
```

## Print
```ruby
# How to print data
## Puts
## Print and add a new line. Long texts can be written and they will be displayed as they are written
irb> puts "Hello"
irb> puts "World!"
Hello 
World!

## Print
## Doesn't add the new line at the end
irb> print "Hello"
irb> print "World!"
HelloWorld!

## P
## Prints the object representation
irb> p "Hello \n World"
"Hello \n World"
```

### Array
```ruby
## Puts
## Print each element in the array.
irb> puts [1,2,3]
1
2
3

## Print
## Print the whole object
irb> print [1,2,3]
[1,2,3] => nil

## P
## Print the whole object
irb> p [1,2,3]
[1,2,3]
```

## Operators
```ruby
# /
# .div
## In numbers execute the division operation
irb> 10 / 3
3
irb> 10./ 3
3
irb> 10.div 3
3

# +
## In numbers just execute the addition operation
## In String works as concatenation
## In Arrays works as concatenation - join
irb> 5 + 2
7
irb> 5.+(2)
7
irb> "My"+"String"
"MyString"
irb> [1,2] + [3,4]
[1,2,3,4]

# -
## In numbers just execute the subtraction operation
## In Arrays works as intersection operation (as in sets)
irb> 3 - 2
1
irb> 3.-(2)
1
irb> [1,2] - [2]
[1]

# %
## In numbers execute the modulus operation
## Returns remainder
irb> 10 % 3
1
irb> 10.%(3)
1
irb> 10.modulo(3)
1

# *
## In numbers execute the multiplication operation
## In Strings, repeat a string n times
## In Arrays, repeat array elements n times
irb> 10 * 3
30
irb> 10.*(3)
30
irb> "a" * 3
"aaa"
irb> [1,2,3] * 3 
[1, 2, 3, 1, 2, 3, 1, 2, 3]

# '**'
## In numbers
## Performs exponential (power) operation
irb> 2 ** 5
32


# Binary operators
## The following operations are generally used with variables, because they modify the object

# '+='
## In numbers just execute the addition operation
## In String works as concatenation
x = 1
x += 1 # 2
x += 1.5 #3.5

x = "str "
x += "other" # 'str other'

# '-='
## In numbers just execute the subtraction operation
x = 2
x -= 1 # 1


# '*='
## In numbers execute the multiplication operation
## In strings, repeat a string n times
x = 2
x *= 5 #10

x = "ab"
x *= 3 # "ababab"


# '/='
## In numbers execute the division operation
x = 5
x /= 2.0 # 2

# '%='
## In numbers execute the modulus operation
## Returns remainder
x = 5
x %= 2
# => 1

# Arrays
## Union | ==> arr1 | arr2, the result does not contain duplicate elements
irb>  [1,2,3] | [3,4,5,6]
[1, 2, 3, 4, 5, 6]

## Intersects & ==> arr1 & arr2
irb> [1,2,3] & [1,2,5,6]
[1,2]
```

## Comments
```ruby
# You can define online comments using the symbol '#'
# This is a one line comment

# You can define multiline comments using =begin =end

=begin
This is a
Multiline comment
=end

# To document classes and methods, it's best to use the one line comment
# Multiline comments aren't popular in ruby

## Class documentation
# A useful description of the Class

# Method documentation
# A useful method description
#
# @param param [Type] param description
#
# Examples:
#   Method useful examples
#
# @return [Type] value description
```

## Variables
```ruby
# Ruby is a dynamic typed language, so you don't need to indicate the data types, because the interpreter will infer the data type.
# Ruby is an interpreted language
# Variables should be named using snake_case

# Numbers
x = 10 # Integer (Fixnum)
x = 10.3 # Float

# Strings
x = "String" # String

# Booleans
x = true # TrueClass
x = false # FalseClass

# Arrays
x = [] # Array

# Hash tables - Dictionaries
x = {} # Hash

# Multiple assign
## Works because, the right side is evaluated first
a,b = b,a
```

### Data types
```ruby
# We can know the data type with the .class function
irb> 10.class
FixNum

irb> 99999999999999999999999999999999.class
BigNum

## Boolean objects has independent classes
## That's because they have the same methods, but each one has a different behavior.
irb> true.class
TrueClass

irb> false.class
FalseClass

irb> [1,2,3].class
Array

irb> {}.class
Hash

irb> class MyItem; end
irb> MyItem.class
Class

irb> "a".class
String

irb> :my_symbol.class
Symbol
```

## Useful functions
```ruby
# .length
## .size is a length method alias
## It can be used in strings, arrays and hash
irb> "my_string".length
9
irb> [1,2,3,4,5].length
5
irb> {one: 1, two: 2, three: 3}.length
3

# .upcase
## Convert string to uppercase string
irb> "my_string".upcase
"MY_STRING"

# .downcase
## Convert string to lowercase string
irb> "MY_STRING".downcase
"my_string"

# .capitalize
## Convert the first character of a string to uppercase
irb> "my_string".capitalize
"My_string"

# .swapcase
## Convert the lowercase characters of a string to uppercase, and the uppercase characters to lowercase
irb> "My_String".swapcase
"mY_sTRING"

# .reverse
## Reverse the order of the characters
irb> "my_string".reverse
"gnirts_ym"
irb> [1,2,3,4].reverse
[4, 3, 2, 1]

# .next
## Increases the number by one
irb> 3.next
4

# .to_s
## Convert an object to string, usually each object has this method personalized.
## This method can be override
irb> 3.to_s
"3"

irb> 4.6.to_s
"4.6"

irb> true.to_s
"true"

irb> false.to_s
"false"

irb> [1,2,3].to_s
"[1,2,3]"

irb> {one: 1, two: 2, three: 3}.to_s
"{:one=>1, :two=>2, :three=>3}"

irb> class MyItem; end
irb> MyItem.to_s
"MyItem"

# .to_i
## Convert a Float number or a numeric String to an Integer
irb> 5.6.to_i
5
irb> "7".to_i
7

# .to_f
## Convert a Integer number or a numeric String to an Float
irb> 5.to_f
5.0
irb> "7".to_f
7.0

# .inspect
## Returns the object in its natural format represented in a string. The p function uses the .inspect method
irb> 5.inspect
"5"
irb> [1,2,4].inspect
"[1,2,4]"

# .odd?
## Tell if a numeric value is odd
irb> 5.odd?
true

irb> 4.odd?
false

# .even?
## Tell if a numeric value is even
irb> 5.even?
false
irb> 4.even?
true

# .between?
## Tell if a value is between a and b
irb> 3.between?(1,5)
true

irb> 3.between?(4,5)
false

## For strings, permutations are created that indicate if the string is between the combinations between a and b
irb> "gua".between?("gtz","jzc")

# .floor
## Returns the floor of an integer
irb> 5.5.floor
5

# .ceil
## Returns the ceil of an integer
irb> 5.5.ceil
6

# .round
## Round a floating number, with the decimal places indicated (precision)
irb> 3.14159265359.round(4)
3.1416

# .abs
## Returns the absolute value of a number
irb> -15.abs
15
```

## Terminal
```ruby
# Gets user input
## The function 'gets' obtain the user input from the terminal
## Usually used with the .chomp function to remove the '\n' at the end of the string
irb> x = gets
"4\n"

irb> x = gets.chomp
"4"
```

## Blocks
```ruby
# Block
## Blocks are portions of code enclosed in curly braces '{}' or between 'do - end', generally they are Procs.
## Blocks allow you to customize the behavior of a pre-defined function.
## Blocks are one of the few things in ruby ​​that are not an object.
irb> 10.times { |item| puts item }

irb> 5.downto(1) 
irb> 5.downto(1) { |item| puts item }

irb> 5.upto(10)

irb> 1.step(100,5)
```

## Useful methods
### String methods
```ruby
# Some useful methods for strings
## .ord
## Lets get the ASCII values ​​of a character
irb>  'a'.ord
97

## .concat
## It allows to concatenate two strings
## Concatenation can be accomplished in several ways.
### Using the .concat method
irb> "Hello".concat("World")
"HelloWorld"

### Using the + operation
irb> "Hello" + "World"
"HelloWorld"

### Using the Shovel operator
### This operator modifies the original string.
irb> "Hello" << "World"
"HelloWorld"

### Operation +=
### Create a copy of the original string
irb> str1 = "Hello"
irb> str1 += "World"
"HelloWorld"

## .prepend
## Put one string before the other
irb> "Hello".prepend("World")
"WorldHello"

## The elements of a string can be accessed through their indexes.
## Cannot use arrays .each function on strings
irb> "Hello"[2]
"l"
irb> "Hello".slice(2)
"l"
irb> "Hello"[2,3] # From position 2 take 3
"llo"
irb> "Hello".slice(2,3) # From position 2 take 3
"llo"
irb> "Hello"[2..3] ## From position 2 to 3
"ll"
```

### Objects methods
```ruby
# Some methods for objects
## '!' indicates that it will modify the object to which an operation is being applied and doesn't create another instance
irb> item = [1,2,3]
irb> item.map { |item| item * 2} # Output: [2,4,6] Item: [1,2,3], create a copy of item and on this copy the operation is applied
irb> item.map! { |item| item * 2} # Output: [2,4,6] Item: [2,4,6], modify the original object

# .nil?
## Lets know if an object is null
irb> nil.nil?
true
irb> "String".nil?
false

# .empty?
## Lets you know if a string, array or hash is empty
irb> "".empty?
true
irb> [].empty?
true
irb> {}.empty?
true

# .respond_to?
## It lets you know if an object responds or has a specific function.
irb> 5.respond_to?(:to_s)
true
irb> 4.respond_to?("to_f")
true
irb> 3.respond_to?(:to_a)
false

# .methods
## Gets the methods of an object or class
irb> String.methods
[:try_convert, :allocate, :superclass, :new, :<=>, :<=, :>=, :==, :===, ..........]
```

### Random numbers
```ruby
# .rand
## This method allows us to generate random numbers
irb> rand  # Generate number between 0 and 1
irb> rand.round # Generate 0 or 1
irb> rand(100) # Generate a number between 0 and 100, without decimals
irb> rand * 100 # Generate a number between 0 and 1, multiplied by 100, resulting in a number between 1 and 100 with decimals
irb> rand(30..50) # Generate an integer between 30 and 50
```

## Control structures (Control flow)

```ruby
# case structure
## Generally used when there is a chain of conditions
irb> item = 4
irb> case item
     when 10..20
    	puts "Between 10 y 20"
     when 4
    	puts "Is 4"
	 else
        puts "Unknown"
	 end

# If conditional
## Used to compare or validate a element or sentence. And, depending on the result
## executes an action
##
## if item == valor
##  #code
## elsif item == valor
##  #code
## else
##  #code
## end
irb> item = 5
irb> if item == 5
		puts "Is 5"
	 elsif item == 4
		puts "Is 4"
	 else
		puts "Unknown"
     end

# If conditional
## Used to compare or validate a element or sentence. And, depending on the result
## executes an action.
## Is the inverse conditional for If
## unless: when the validation is false
## unless item == value   ----> if item != value
## 	#code
## else
##	#code
## end
irb> item = 5
irb> unless item == 6
		puts "It's different from 6"
	 else
		puts "Unknown"
	 end

## To represent the if - else, we can use a one line sentence
## called ternary operator => condition ? true : false
irb> 5 > 4 ? :true : :false

## Also, we can use the one line conditional (commonly used in Ruby)
irb> puts "Es par" if 4.even?
irb> puts "Es impar" unless 5.even?

# Until
## Is the unless equivalent for the while loop. 
## the cycle stops when the condition is true, in the while the cycle stops when the condition is false
irb> until i > 4
    	puts i
    	i += 1
	 end
1
2
3
4
```

### Conditional assign
```ruby
# you can indicate a variable that assigns a certain value if it is null
# without the need to do a validation with a control structure
irb> y = nil
irb> y = y || 5
irb> y ||= 5 # If 'y' is false (nil) assign 5
```

### Spaceship Operator
```ruby
# Compare objects
a <=> b
  if a < b then return -1
  if a = b then return  0
  if a > b then return  1
  if a and b are not comparable then return nil
```

## Arrays
```ruby
# Creating arrays
irb> %w[Jack, Jill, John] ## Create an array from a string
["Jack,", "Jill,", "John"]

irb> array = [1,2,3,4,5,6]

# Get elements
irb> array[1...3] # Gets elements from index 1 to 3, not including index 3
irb> array.values_at(1,2,4) # Gets the values ​​in the indicated indexes
irb> array.slice(1) # Gets the value of index 1
irb> array.slice(1,4) # Gets an array with elements from index 1 to 4, including index 4
irb> array.slice(3..6) # Gets the values ​​from index 3 to index 6, including index 6
irb> array[3..6] # It behaves the same way as array.slice(3..6)

# Adding values
irb> array[6] = 7 # Change the value of index 6 or create the index with that value, in case the index is greater than the length of the array.
				  # [1,2,3,4] => array[6] = 7 => [1,2,3,4,nil,nil,7]

irb> array[4,2] = [7,8] # From position 4 take 2 positions, index 4 and 5, and assign values ​​7 and 8

irb> array[0..2] = [0,1,2] # From position 0 to position 2 it assigns the values ​​[0,1,2]
irb> array.push(5) # Add the value to the end of the array
irb> array << 6    # Add the value to the end of the array
irb> array << 7 << 8 # Add the value to the end of the array. Works as array concatenation
irb> array.insert(1,9) # Add item 9 in position 1
irb> array.unshift(8)  # Add item 8 to the top of the list

# Deleting elements
irb> array.pop # Remove the last item from the list
irb> array.pop(2) # Remove the last 2 items from the list
irb> array.shift  # Delete the first element
irb> array.delete(animal) # Delete the given item

# .to_a
## Converts an element to an array
irb> {one: 1, two: 2}.to_a
[[:one, 1], [:two, 2]]

# .# .is_a?
## Indicates if an object is of a specific class
irb> [].is_a?(Array)
true
irb> "".is_a?(String)
true

# Objects structure
## Objects
###    BasicObject
###		    |
###		 Object
###
###    	 Integer
###		    |
###		   / \
###	 FixNum    BigNum

# Assign values ​​to variables
## users = [User.new(name: 'Bob'), User.new(name: 'Ana'), User.new(name: 'Rob')]
## bob, ana = users
## bob ---> User <name: 'Bob'>
## ana ---> User <name: 'Ana'>
```

### Iterate arrays
```ruby
## You can iterate an array or dict as a for each
for i in [1,2]
    puts i # It will print each element of the list
end

# each with index
## To iterate Enumerable
{one: 1, two: 2}.each_with_index do |element, index|
    puts "#{element} #{index}"
end
[:one, 1] 0
[:two, 2] 1

[1,2].each_with_index do |element, index|
    puts "#{element} #{index}"
end
1 0
2 1

# .map - .collect
## is used to perform an operation to each element of the list
[1,2].map { |item| item * 2}
[2, 4]

## Keyword 'next'
## works like continue keyword in python
## You can use this keyword to skip the current iteration
for i in 0..10
    if i == 3
        next # Continue to the iteration 4
    end
    puts i # It will print the numbers from 0 to 9, skipping 3
end

## Keyword 'break'
## You can use this keyword to interrupt the loop execution
for i in 0..10
    if i == 3
        break # Interrupt the loop
    end
    puts i # It will print the numbers from 0 to 2
end

# .concat
## It allows to concatenate two arrays
irb> [1,2].concat([3,4])
[1, 2, 3, 4]

# .index - .find_index
## Returns the index of the given element
array.index(6)

# .select
## is a lambda function used to filter elements
## selects the element when the block condition is true
array.select { |i| i.odd? }

# .reject
## is a lambda function used to filter elements
## selects the element when the block condition is false
array.reject { |i| i.odd? }

# .reduce
## is used to perform an operation over whole array and return a single value
irb> [1,2,3,4,5].reduce { |p, n| p + n }
15
irb> [1,2,3,4,5].reduce(:+)
15

# .inject
## is used to perform an operation over whole array and return a single value
## It works like .reduce, but you must specify a block
irb> [1,2,3,4,5].inject { |p, n| p + n }
15
```

### Array Methods
```ruby
# .partition
## Splits an array depending on a condition
## [[true values], [false values]]
irb> (1..6).partition { |v| v.even? }
[[2, 4, 6], [1, 3, 5]]

# .each_char
## Iterate each string character
irb> "hello".each_char {|c| print c, ' ' }
h e l l o

# .chars
## Gets the string chars in an array
irb> "hello".chars
["h", "e", "l", "l", "o"]

# .join
## Join the array elements into a string
irb> ["h", "e", "l", "l", "o"].join
"hello"

# .count
## Counts the times that a string appear in another string
irb> "hello".count "l"
2

# .rindex
## Returns the position of the last occurrence of a substring
irb> "abbbcdbd".rindex 'b'
6

# .insert
## Insert an element in the index position
irb> "Hello".insert(5, "abcd")
"Helloabcd"

# .squeeze
## Replace repeated characters
irb> "abbbcd".squeeze
"abcd"

# .clear
## Replace the string with an empty string
irb> "abcd".clear
""

# .delete
## Remove the given elements from the string
irb> "hello".delete 'lo'
"he"

# .object_id
## Shows the id of the object in memory
## is the alias of the object
irb> class MyItem; end
irb> item = MyItem.new
irb> item.object_id
47341996088000

irb> item2 = item.dup
irb> item2.object_id
47341996129380

# https://www.rubyguides.com/2018/10/any-all-none-one/
# .any?
## It is a block function, it tells me if any of the elements meets a condition
irb> [1,2,3].any? { |n| n > 0 }
true

# .all?
## block function, it tells me if all the elements meet a condition.
irb> [1,2,3].all? { |n| n > 0 }
true

# .find - .detect
## returns the first element that fulfills the function of the block
irb> (1..100).find { |i| i % 5 == 0 }
5

# .uniq
## returns an array without repeated elements
irb> [1,3,4,5,3].uniq
[1, 3, 4, 5]

# .compact
## returns a copy with all nil elements removed
irb> [1,2,3,nil,5,nil,6,nil,0].compact
[1, 2, 3, 5, 6, 0]

# .flatten
## Converts an multiple array to a single array
irb> [1,2,[3,4]].flatten
[1, 2, 3, 4]
irb> [1,2,[3,[4,5]]].flatten(1)  # Indicating the number of levels to reduce
[1, 2, 3, [4, 5]]

# .shuffle
## Disorder the elements of an array
irb> [1,2,3,4,5,6,7,9].shuffle
[5, 4, 9, 3, 7, 1, 2, 6]

# .zip
## Combine the elements of two or more arrangements
irb> [1,2,3].zip([4,5,6])
[[1, 4], [2, 5], [3, 6]]

# .sample
## Returns a number n of random elements of an array
irb> [1,2,3,4,5].sample
2
irb> [1,2,3,4,5].sample(3)
[3, 2, 1]
```

## Args - Kwargs
```ruby
# *args
## To send multiple arguments
# **kwargs
## To send multiple named arguments
# https://www.rubyguides.com/2018/06/rubys-method-arguments/
def testing(a, b = 1, *c, d: 1, **x)
  p a,b,c,d,x
end

testing('a', 'b', 'c', 'd', 'e', d: 2, x: 1)
# a -> "a"
# b -> "b"
# *c -> *args -> ["c", "d", "e"]
# d -> 2
# **x -> *kwargs -> {:x=>1}
["a", "b", ["c", "d", "e"], 2, {:x=>1}]
```

### ARGV Command Line Arguments
```ruby
ARGV.each do |argument|
  number = argument.to_i
end
```

## Symbols

```ruby
# Symbols
## It is the simplest object that can be created in ruby
## They can be compared to a constant value, because a symbol is not mutable
## They are generally used to indicate the keys of the Hash
## It can also be taken as a light version of a string. It does not include all the methods of a String, therefore, it is faster and more efficient.

# .all_symbols
## It allows to see all the symbols that have been declared or used
irb> Symbol.all_symbols

# Creating symbols
irb> :my_symbol
:my_symbol
irb> %s{my_symbol}
:my_symbol

# Using symbols as keys of Hash tables
irb> my_hash = {:item_1 => 1, item_2: 2} # item_2 is also taken as a symbol
irb> my_hash[:item_1]
1
irb> my_hash[:item_2]
2

# .to_s
## Convert a Symbol to String
irb> :my_symbol.to_s
"my_symbol"

# .to_sym
## Convert a String to Symbol. When there are spaces the Symbol is created with quotes
irb> "my_symbol".to_sym
:my_symbol
irb> "my symbol".to_sym
:"my symbol"
```

## Hash
```ruby
# .fetch
## Fetch a hash value
irb> my_hash = {:item_1 => 1, :item_2: 2}
irb> my_hash.fetch(:item_1)
1
## hash.fetch(:name,"oops")
## Print the string when the key is not found
irb> my_hash.fetch(:name, "oops")
"oops"
irb> my_hash[:name] # Gets nil
nil

# .store
## Add a new value to the Hash table, it is equivalent to assigning a nonexistent key
## hash[:key] = "value"
irb> my_hash.store(:tax, 9.99)
9.99
irb> my_hash[:price] = 9.99
9.99

# .key
## Get the key of a value
irb> my_hash.key(1)
:item_1
irb> my_hash.key(9.99)
:price # Gets the first key it finds

# .each
## Iterates the Hash Table
my_hash.each { |key,value| puts "#{key} and #{value}" }

my_hash.each do |item|
  p item[0] # keys
  p item[1] # values
end

# .each_key
## Iterate the keys of the Hash table
my_hash.each_key { |item| puts item }

# .each_value
## Iterates the values ​​in the Hash table
my_hash.each_value { |item| puts item }

# .keys
## Gets all the keys of the Hash table in an Array
irb> my_hash.keys
[:item_1, :item_2, :price, :tax]

# .values
## Gets all the values ​​from the Hash table in an Array
irb> my_hash.values
[1, 2, 9.99, 9.99] 

# .to_a
## Converts a hash table to an array
irb> my_hash.to_a
[[:item_1, 1], [:item_2, 2], [:price, 9.99], [:tax, 9.99]]

# .to_h
## Converts an array to a hash table
irb> [[1,2],[3,4]].to_h
{1=>2, 3=>4}

# .sort
## Returns an array ordered by keys
irb> my_hash.sort
[[:item_1, 1], [:item_2, 2], [:price, 9.99], [:tax, 9.99]]

## A block can be given
irb> my_hash.sort_by(&:length)
[[:item_1, 1], [:item_2, 2], [:price, 9.99], [:tax, 9.99]]

# default values
## Returns the value if an element does not exist, thus avoiding the return of nil
irb> hash = Hash.new(1)
irb> hash.default = 1
irb> hash[:item]
1

# .key? - .has_key?
## Checks if it contains the given key
irb> my_hash.key? :item_1
true
irb> my_hash.has_key? :item1
false

# .value? - .has_value?
## Check if it contains an element with the given value
irb> my_hash.value? 1
true
irb> my_hash.has_value? 0
false

# .delete
## Delete the element in the hash table that corresponds to the given key
irb> my_hash.delete(:tax)
irb> my_hash
{:item_1=>1, :item_2=>2, :price=>9.99}

# .select
## is a lambda function used to filter elements
## selects the element when the block condition is true
irb> my_hash.select { |key,val| val.class == Float }
{:price=>9.99}

# .reject
## is a lambda function used to filter elements
## selects the element when the block condition is false
irb> my_hash.reject { |key,val| val.class == Float }
{:item_1=>1, :item_2=>2}

# .merge
## Joins two Hash tables
## If it has repeated keys replace the values ​​with the value of the argument
irb> my_hash.merge({ item_1: 24, foo: "value"})
{:item_1=>24, :item_2=>2, :price=>9.99, :foo=>"value"} 
```

## Procs - Lambdas
### Yield
```ruby
# yield
## Allows a code block to be specified for a method
def pass_control
	puts "Start method"
	yield
	puts "End method"
end

pass_control {
	puts "Inside the block"
}
# Start method
# Inside the block
# End method

## yield arguments
def method(name)
	yield name if block_given?
end

method("Juano") {|name| puts "#{name}"}

## Sending ruby ​​methods as parameters
["1","2","3"].map(&:to_i)
[1,2,3,4,5].select(&:even?)
```

### Procs

```ruby
# Procs
## They are blocks that keep their variables. In blocks, variables exist at the time of block execution.
## You can assign a process to a variable and somehow stop being an anonymous function
cubes = Proc.new {|number| number ** 3}
a = [1,2,3,4]
a.map(&cubes)
## Can be called directly with cubes.call 2

## bloc_given
## heck if there is a block to run and wait for it
if block_given?
   yield
end

## Sending procs as parameters
def talk(name, &myproc)
	puts "Hello"
	myproc.call(name) # Same as 'yield name'
end

good_things = Proc.new do |name|
	puts "#{name} is a genius"
end

bad_thigns = Proc.new do |name|
	puts "#{name} is a dolt!"
end

talk("Juano", &good_things)
```

### Lambdas
```ruby
# They are a kind of proc, because there is no specific object for lambdas
## They works in a different scope, while procs works in the context in which they run
squares_lambda = lambda { |num| num ** 2 }
squares_proc = Proc.new { |num| num ** 2 }

p [1,2,3].map(&squares_proc)
p squares_proc.call(5)

p [1,2,3].map(&squares_proc)
p squares_proc.call(5)

## Procs ignore extra arguments
## Lambdas throws errors, like a block.
## In lambda functions you can pass parameters without the symbol '&'

# .curry.(n) 
## Returns a new lambda with one less parameter
def metodo
  puts "1"
  yield
  puts "3"
end

myproc = Proc.new {
  puts 2
}

mylambda = -> (){puts 5}

metodo(&mylambda)
```

## Time Object
```ruby
# Time.new
## Instances a new object with the current date
## You can also send the desired date by parameter
irb> today = Time.now
irb> today = Time.new(2013,05,20)
 => 2013-05-20 00:00:00 -0500 

irb> p today + 60 		# add 60 seconds to the date
irb> today.to_s   		# Convert to string
irb> today.ctime		# Convert to string but in a "readable or natural" format
irb> today.to_a   		# Convert to array
 => [0, 0, 0, 20, 5, 2013, 1, 140, false, "-05"]

irb> today.strftime(format) # Lets format the date

# .parse and .strptime
irb> require 'time'
irb> Time.parse("2016-01-01") 				# returns a Time object
irb> Time.srtptime("03-01-2016",format) 	# returns a Time object
# The format value is to indicate what format has the date.
```

## IO - File Input and Output
```ruby
# Clase File
# Read file
File.open(file).each do |line|
  puts line
end

# Write file
File.open("newfile.txt","w") do |file|
	file.puts "Hello"
	file.write "No line break here!"
end

# Update file
# Open file if exist and add the items bellow
File.open("newfile.txt","a") do |file|
	file.puts "Hello"
	file.write "No line break here!"
end

# Rename file
File.rename("newfile.txt", "otherfile.txt")

# Delete file
File.delete("otherfile.txt") if File.exist?("otherfile.txt")
```

## Import modules
```ruby
load "end.rb" # Loads that piece of code, it runs whenever it is called
require "end" # Loads that piece of code, but run it once
require_relative "./end" # Works as require, but with relative paths
```

## Regular Expressions
```ruby
# class Regexp
## To match string patterns

# start_with and end_with
irb> phrase = "Hello World"
irb> phrase.downcase.start_with?("hello")
 => true

# Examples
## phrase =~ /regex/
## Returns the index of the first match
irb> phrase =~ /ell/
 => 1
## phrase.scan(/regex/)
## Returns an array with matches
irb> phrase.scan(/lo/)
 => ["lo"]

## phrase.scan(/[re]/)
## Evaluate each character as an individual expression and return the array with matches
irb> phrase.scan(/[re]/)
 => ["e", "r"]

## phrase.scan(/\d+/) {|digit| puts digit.length}
## The scan function can receive a block to perform an operation with the found items
irb> "He11o W0r1d".scan(/\d+/) {|digit| puts digit.length}
2 # Length for 11
1 # Length for 0
1 # Length for 1
 => "He11o W0r1d"

## .scan(/./)
## Matches any element

## .scan(/.am/)
## Searches for 'am' preceded by any character

## .scan(/\./)
## With the '\' escape the character and look for the '.' In the chain.

## \A
## Matches only at the beginning of the text
## \z
## Match only at the end of the text

## ^
## Exclude given characters

## str.sub("m","s")
## Replaces the first occurrence of 'm' with 's' in a text

## str.gsub("m", "-")
## Replaces all occurrences of 'm' with '-'
## str.gsub(regex,value)
## Replace the regex matches with value
```

## OOP
`.superclass` Returns the parent class
`.ancestors` Returns the parent classes by transition.
`.methods` Obtain the class methods

The `@` symbol is called sigil, it is used to define instance variables.

```ruby
# .superclass
irb> String.superclass
 => Object

# .ancestors
irb> String.ancestors
 => [String, Comparable, Object, Kernel, BasicObject]

# .methods
irb> String.methods
 => [:try_convert, :allocate, :superclass, :new, :<=>, :<=, :>=, :==, :===, ...........]
```

### Classes
```ruby
# Classes and Objects
class Item
	attr_accessor :name

	def initialize(name = "")
		@name = name
	end

    def method
	end
end

## Observations:
## The initialize method is the class constructor
## Every block should finish by the keyword 'end'
## Instantiate an object
item = Item.new "pepe"
```
#### Scopes
```ruby
# Variables
## my_var
## Scope variable, existing in the context in which it is created. Context: Methods, Loops ...
def function()
	scope_var = 10
end

puts scope_var # ==> undefined local variable or method `scope_var'

## @my_var
## Object variable, exist in the object scope.
class Item
	attr_accessor :public_var

    def initialize
        @public_var = 10  # It is a public variable
		@private_var = 20 # It is a private variable, it will not be accessible
	end
end
item = Item.new
puts item.public_var # => 10
puts item.private_var # undefined method `private_var' for #<Item:0x0.. @public_var=10, @private_var=20>

## @@my_var
## Class variable, single variable per class
## Class.@@my_var 
## Cannot do, you must create a method to access.
## These variables are protected by default from being exposed.
# Class variable
## It exists in the class scope. Shared across all class instances
## Usually used to define constants.
class Item
  @@my_var = 10

	def self.my_var
   	@@my_var
	end
end

puts Item.my_var #=> 10

## $my_var
## Global variable, single variable in the whole program
$my_var = 10

# private
## For private methods, only accessible from the object
class Item
    def public_method
		private_method
	end

	private
	def private_method
		"Private"
	end
end

item = Item.new
puts item.public_method # Private
puts item.private_method # private method `private_method' called for #<Item:0x0...>

# protected
## For protected methods, accessible from object and child objects
class Item
	protected
	def protected_method
		"Protected"
	end
end

class Item2 < Item
    def public_method
		protected_method
	end
end

item = Item2.new
puts item.public_method # Protected
puts item.protected_method # protected method `protected_method' called for #<Item2:0x0..>

# It's preferable to use instance methods than instance variables

# Class methods
## Are methods that can be invoked without an instance
## You can create class methods using the keyword self
## Or overwriting self
## The static method are manly used in modules
class Dates
    def self.current_date
		return Time.now
	end
end

puts Dates.current_date() #=> 2020-04-11 17:00:03.093115

module Greet
	class << self
		def say_hello
			puts "Hello Dates"
		end
	end
end

Greet.say_hello #=> Hello Dates
```

#### Override to_s
```ruby
class MyClass
	def to_s
	end
end
```
#### Getters and Setters
```ruby
class MyClass
    def username
      @username
    end

    def password=(password)
      @password = password
    end
end
```

#### Accessors
```ruby
class MyClass
	attr_accessor :username  # Creates setters and getters
	attr_reader :username 	 # Just creates the getter
	attr_writer :username    # Just creates the writer / setter
end
```

### Modules
They are containers of constants or methods that can be useful for more than one object. An example is the Math module. I understand that they are used when very common methods are needed but instantiation is not wanted.

```ruby
module LengthConversion

	WEBSITE = ""

	def self.miles_to_feet(miles)
		miles*5280
	end

end

# Inheritance
## The inheritance allows to separate common logic in a different class
## Ej: Array is a kind of Object

# Mixins
## Provides a controlled way to add functionality to a class.
## Ej: String has a Comparable property
## The order in which the mixins are included matters.
## Ruby looks at the last imported mix first.
## If there are modules that have methods with the same name, then the method of the last imported mixin that contains it is taken
## If a method with the same name as another is placed in a module in the class, the first one overwrites the second one.
## The modules appear in the ancestors.
```
#### Include modules
```ruby
# prepend
## Works like the include, but makes the module appear before the class in the result of the .ancestors

# extends
## With include and prepend the methods of a module remain as object methods.
## That is, an instance must be made and then the method can be called.
## With extends these methods of the modules become class methods.
## There is no need to instantiate. It is simply called Class.module_method
module Example
  def say_hello
    "Helllo Example"
  end
end

class Test
  extend Example
end

class Test2
  prepend Example
end

module MyModule
  def self.say_hello
    "New"
  end
end

p MyModule.say_hello # "New"

p Test.say_hello # "Helllo Example"

my_test = Test2.new
p my_test.say_hello # "Helllo Example"

p Test.ancestors # [Test, Object ....]
p Test2.ancestors # [Example, Test2, Object ....]
```

### Structs
```ruby
# Create struct
## Struct.new()
module AppStore
  App = Struct.new(:name, :developer, :version)

  APPS = [
	App.new(:Chat,:facebook,2.0),
	App.new(:Twitter,:twitter,2.0),
	App.new(:Weather,:yahoo,2.0)
  ]


  def self.find_app(name)
	APPS.find{ |app| app.name ==name}
  end
end

AppStore.find_app :Chat # <struct AppStore::App name=:Chat, developer=:facebook, version=2.0>
```

### Monkey Patching
```ruby
# Means modifying an existing class
class Array
  def sum
  end

  def new_method
  end
end
```

### Inheritance
```ruby
# Inheritance
## The inheritance allows to separate common logic in a different class
class Parent
    def method
		puts "Hello"
	end
end

class Child < Parent
    def initialize
		super
	end
end

item = Child.new
item.method() #=> prints 'Hello'

## Observations:
## The class it is inherited from is called super class or parent class
## The inheriting class is called subclass or child class
## One class can only inherit from another.
## Inheritance is represented by the symbol '<'
irb> class Employee; end
irb> class Worker < Employee; end
irb> class Manager < Employee; end

# .is_a?
## Check if the parent class is an ancestor
irb> my_worker = Worker.new
irb> my_worker.is_a?(Worker)
 => true
irb> my_worker.is_a?(Employee)
 => true

# .instance_of?()
## Check if the object is an instance of the given class
irb> my_worker.instance_of?(Worker)
 => true
irb> my_worker.instance_of?(Employee)
 => false
```

#### Super keyword
```ruby
# super
## Reference an element of the parent class.

# super()
## When the overwritten element receives a parameter but the parent class don't.

# super(param,param)
## Reference a parent class method by sending arguments, if the parent class method has arguments.
```

#### Singleton class

```ruby
# They are specific methods of an object instance.
# You can also refer to classes that allow only one instance within the application
boris = Player.new
def boris.play_game
  "Winner!"
end

p boris.singleton_methods
p boris.singleton_class
```
