# Kotlin Farm
Kotlin example implementation of a little farm game

| Lenguaje | Versión                      | SO                |
| -------- | --------------               | ----------------- |
| Kotlin   | Kotlin JVM version: 1.3.61   | Ubuntu 18.04.1    |

## Documentation
| Type          | Link                                                                         |
| ------------- | ----------------------------------------------                               |
| Documentation | https://kotlinlang.org/docs/reference/                                       |
| Gradle Install| https://linuxize.com/post/how-to-install-gradle-on-ubuntu-18-04/             |
| Gradle Install| http://yallalabs.com/devops/how-to-install-gradle-ubuntu-18-04-ubuntu-16-04/ |
| Example       | https://hackersandslackers.com/building-java-projects-with-gradle/           |
| Example       | https://docs.gradle.org/current/userguide/building_java_projects.html        |
| Example       | https://mkyong.com/gradle/gradle-create-java-project-structure-automatically/|
| Styleguide | https://kotlinlang.org/docs/reference/coding-conventions.html |
| Regex Example | http://zetcode.com/kotlin/regularexpressions/ |
| File Examples | https://chercher.tech/kotlin/read-write-files-kotlin |
| Inheritance   | https://blog.mindorks.com/understanding-open-keyword-in-kotlin |
| Interfaces    | http://programiz.com/kotlin-programming/interfaces |
| Gson  | https://howtodoinjava.com/gson/gson/ |

## Create project environment
```bash
# Gradle version
gradle -v

# Create folder
mkdir project
cd project

# Create project
gradle init

Select type of project to generate:
  1: basic
  2: application
  3: library
  4: Gradle plugin
Enter selection (default: basic) [1..4] 2

Select implementation language:
  1: C++
  2: Groovy
  3: Java
  4: Kotlin
  5: Swift
Enter selection (default: Java) [1..5] 4

Select build script DSL:
  1: Groovy
  2: Kotlin
Enter selection (default: Kotlin) [1..2] 1

Project name (default: project):
Source package (default: project): com.brayvasq.farm

# See tasks
gradle tasks
./gradlew tasks

# Compile
./gradlew build

# Run
./gradlew run

# Clean build  folder
./gradlew clean

# Run tests
./gradlew test
```
### Dependencies
Add the following dependencies to the `build.gradle` file
- `gson` - google library to work with json in java.
```groovy
dependencies {
    // Other dependencies
    // https://mvnrepository.com/artifact/com.google.code.gson/gson
    compile group: 'com.google.code.gson', name: 'gson', version: '2.8.6'
}
```

## Variables
```kotlin
// Java is a strong typed language. The code compiles to bytecode to run in the JVM
// Variables should be named using camelCase
// there are two variable tipes:
//      Constants -> val
//      Variables -> var
// You can omit the data type and the interpreter will infer the data type

// Numbers
var x : Int = 5
var x = 4

//// For numbers you can use the _ symbol to make it more readable
var x : Int = 10_000

var x : Float = 5.5f

var x : Double = 10.0

// String
var x : String = "My String"

// Booleans
var x : Boolean = true

// Lists
var x : List<Int> = ArrayList()
var x : List<Int> = LinkedList()

// Hash
var x : HashMap<String, Int> = HashMap<String, Int> () 
```

### Data types
```kotlin
10::class // class kotlin.Int
10::class.java // int
10.javaClass // int

5.2f::class // class kotlin.Float
5.2f::class.java // float
5.2f.javaClass // float

5.2888888888888888::class // class kotlin.Double
5.2888888888888888::class.java // double
5.2888888888888888.javaClass // double

"My String"::class // class kotlin.String
"My String"::class.java // class java.lang.String
"My String".javaClass // class java.lang.String

true::class // class kotlin.Boolean
true::class.java // boolean
true.javaClass // boolean

ArrayList<Int>()::class // class java.util.ArrayList
ArrayList<Int>()::class.java // class java.util.ArrayList
ArrayList<Int>().javaClass // class java.util.ArrayList

HashMap<String, Int> ()::class // class java.util.HashMap
HashMap<String, Int> ()::class.java // class java.util.HashMap
HashMap<String, Int> ().javaClass // class java.util.HashMap

//// To check the object class, we can use the keyword 'is'
var isDouble = item is Int
```

### Operators
```kotlin
// '+' operator
//// In numbers just execute the addition operation
//// In String works as concatenation
1 + 1 // 1
1 + 1.5 // 2.5

"My" + " String" // My String

// '-' operator
//// In numbers just execute the subtraction operation
1 - 1 // 0

// '*'
//// In numbers execute the multiplication operation
2 * 5 // 10

// In other languages the '*' operators works as a repeater for strings
//// In kotlin doesn't. In kotlin you should use the .repeat() method
"x".repeat(5) // xxxxx

// '/'
//// In numbers execute the division operation
//// To return decimals, the division should be casted to float or double
10.toDouble() / 3 // 3.3333333333333335

// '.div'
//// In numbers execute the division operation
//// To return decimals, the division should be casted to float or double
10.toDouble().div(3) // 3.3333333333333335

// '%' Modulus
//// In numbers execute the modulus operation
//// Returns remainder
10 % 2 // 0

// To performs exponential (power) operation
//// You should use the Math package, and the function pow
//// In kotlin the params should be doubles
Math.pow(2.0, 5.0);
32.0

// Binary Operators

// '+='
//// In numbers just execute the addition operation
//// In String works as concatenation
var x = 1 // 1
x += 1 // 2
x += 1.5 // Data Types error

//// String concatenation
var x = "My";  // For strings the operator '+=' doesn't work
x = x.concat(" String");
"My String"

//// You can join strings using String interpolation
var x = "My"
var y = "String"
var z = "${My} Other $String"

// '-='
// In numbers just execute the subtraction operation
var x = 2 // 2
x -= 1 // 1

// '*='
//// In numbers execute the multiplication operation
//// In strings, repeat a string n times
var x = 2  // 2
x *= 5 // 10

// '/='
//// In numbers execute the division operation
var x = 5f  // 5
x /= 2  // 2.5

// '%='
//// In numbers execute the modulus operation
//// Returns remainder
var x = 5 // 5
x %= 2 // 1

// Unary Operators

// '++'
//// In numbers just execute the addition operation
var x = 2 // 2
x++ // 3

// '++'
//// In numbers just execute the subtraction operation
var x = 2 // 2
x-- // 1
```

## Control structures (Control flow)
```kotlin
// If conditional
//// Used to compare or validate a element or sentence. And, depending on the result
//// executes an action
var item = 5;

if(item == 5){
  println("Is 5");
}else if(item == 4){
  println("Is 4");
}else{
  println("Unknown");
} // => prints Is 5
//// The block else if can be used how much you need it. 

// When structure
//// Used when we need to compare with multiple options
//// Is equivalent to Switch in java
when(item){
    5 -> println("Is 5")
    4 -> println("Is 4")
    else -> println("Unknown")
} // => prints Is 5

//// To represent the if - else, we can use a one line sentence
//// called ternary operator => condition ? true : false
//// Kotlin doesn't have an explicit equivalent, but we can emulate the behavior
var isFive = when { item == 5 -> true else -> false } // true
var isFour = if (item == 4) true else false  // false

//// .not()
//// Negates a condition, is the equivalent to '!'
var isNotFive = when { (item == 5).not() -> true else -> false } // true
var isNotFive = when { !(item == 5) -> true else -> false } // true
var isNotFive = when { item != 5 -> true else -> false } // true

//// in
//// To determinate if an array contains an element we can use the keyword 'in'
var isFive = when { item in arrayOf(1,2,4,6) -> true else -> false } // true

// While
//// It's used to create a loop when we don't have a specific limit.
var scan : Scanner = Scanner(System.`in`) // We must use `in` because in kotlin is a reserved keyword

var value = 0

while(value != 5){
  value = scan.nextInt();
}

//// Note: We can receive user input via console, using the Scanner Class
//// We can use the BufferedReader Class too

// For
//// It's used to create a loop in a rage of values.
for(i in 0 until 10){
    println(i);  // It will print the numbers between 0 and 9
}

//// You can iterate a List or Hash as a for each
var x = arrayOf(1,3,4,5,6)
for(i in x){
    println(i) // It will print each element of the list
}

// Keyword 'break'
//// You can use this keyword to interrupt the loop execution
for(i in 0 until 10){
    if(i == 3){
      break; // Interrupt the loop
    }
    println(i); // It will print the numbers from 0 to 2
}

// Keyword 'continue'
//// You can use this keyword to skip the current iteration
for(i in 0 until 10){
    if(i == 3){
      continue; // Skips this iteration and Continue to the iteration 4
    }
    println(i); // It will print the numbers from 0 to 9, skipping 3
}
```

## Data structures
```kotlin
//// In kotlin the arrays has a static size, and you can't add new elements
//// You only can modify and access to elements in the array.
//// You can't delete elements, to resize the array you must re-asign the elements to a new array
//// As in any other language you start to count from 0 for indexes
var x = arrayOf(1,2,3,4)
x[0] = 1;
x[1] = 2;

println(x[0]); // 1
println(x[2]); // 0

// Lists
//// Is the solution to work with dynamic lists.
var x = ArrayList<Int>()

// .get(index)
//// You can get a value of the position using the method get(index)
x.get(0)

// .add(value)
//// Adds a new element at the end of the list
x.add(1);

// .remove(value)
//// Remove the first item from the list whose value is x
x.remove(4)

// .removeAt(index)
//// Remove the element where the index == value
x.removeAt(2)

// .sorted() methods
//// Used to sort a list
//// https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-array-list/
x.sorted()

// Print array
println(x)

// .filter
//// is a lambda function used to filter elements
x.filter { i -> i % 2 == 0}

// .find
//// is a lambda function used to search an element and return the first match
x.find { i -> i == 5 }

// .map
//// is used to perform an operation to each element of the list
x.map { i -> i * 2 }

// .reduce
//// is used to perform an operation over whole array and return a single value
x.reduce { prev, next -> prev + next }

// Hash
var x = HashMap<String, Int> () 

// .put
// You can add an element using .put(key, value)
x.put("one", 1);

// Print hashtable
println(x)

// .get(key)
//// Obtains the value corresponding to a key
x.get("one"); //1
// .keys()
/// Obtains a Set for hash keys
x.keys

// .values()
//// Obtains a Collection for hash values
x.values
```

## OOP
```kotlin
class Item(var name : String = ""){
    var attribute : Int = 0
    
    init {
        this.attribute = when(name) { "pepe" -> 1 else -> 2 }
    }
}

//// Observations:
//// Classes can receive params, and It works as a constructor. Also, we can give a default value to the params
//// We have a init function, where we can put operations to execute when an object is created
//// this is the reference to the self object, is like the keyword self in python

//// Instantiate an object
var item : Item = Item("pepe")
println(item.attribute) // 1

// Inheritance
//// The inheritance allows to separate common logic in a different class
//// In kotlin, The classes, functions and variables are defined as finals
//// To be able to inherit from a class, override a function or variable, 
//// you have to use the keyword open
open class Parent {
    open var value : Int = 0
    open fun function() : String { return "" }
}

class Child : Parent(){
    override var value : Int = 2   
    override fun function() : String { return "Hello!"} 
}

val child : Parent = Child()
println(child.value) // => 2
println(child.function()) // => "Hello!"

// Abstract classes
//// In kotlin you can also use abstract classes
//// Are classes that have methods without a definition, and should be defined in each Child class
abstract class Parent {
    fun getInfo() = println("Info")
    abstract fun sayHello()
}

class Child : Parent() {
    override fun sayHello() = println("Heyy!")
}

var child : Parent = Child()
println(child.getInfo()) // => "Info"
println(child.sayHello()) // => "Heyy!"

// Interfaces
//// Are classes without functionalities, they are like a kind of template
//// where we define the methods that child classes should have
//// to follow a standard
interface Parent {
    fun getNumber() : Int
    fun getName() : String
}

class Child : Parent {
    override fun getNumber() : Int = 1
    override fun getName() : String = "pepe" 
}

var child : Parent = Child()
println(child.getNumber())
println(child.getName())

// Static methods
//// Are methods that can be invoked without an instance
class Item {
    companion object {
        var x : Int = 10
        fun method() : Int = Item.x * 2 
    }
}

println(Item.method()) // 20
```

### Scopes
```kotlin
// In kotlin all attributes are defined as final
val x : Int = 10 //It's an immutable variable
var x : Int = 20 //It's a simple variable, you can modify it

// Scope variable
//// It exists in the context where it was created
//// you will be able to access it outside these control structures.
class Item {
    fun method() {
        val scopeVar = 10
    }
    
    fun method2() {
        println(scopeVar) // Raises => Unresolved reference: scopeVar
    }
    
    fun method3(){
        for(i in 0 until 10){
          var variable = i
        }
        println(variable); // ==> Raises an error => Unresolved reference: variable
    }
}

// Object variable
//// It exists in the object scope, and it can be accessed for an object instance
class Item {
    var x : Int = 10
    
    fun add(y : Int) : Int = this.x + y   
}

var item = Item()
println(item.x) // 10
println(item.add(5)) // 15
println(Item.x) // Error => Unresolved reference: x
println(Item.add(5)) // Error => Unresolved reference: add

//// NOTE: Kotlin has compatibility with many elements of java, so you
//// can use the attributte accessors public, private and protected
```

## Comments
```kotlin
// You can define online comments using the symbol '//'
// This is a one line comment

// You can define multiline comments using /**/.
/*
This is a multiple line
comment
*/

// Docstrings
//// You can use multiline comments to document your code
//// Here is an basic structure:

//// Class documentation
/**
 * A useful description of the Class
 *
 * @author name
 */

//// Method documentation:
/**
  * A useful method description
  *
  * @param param param description
  * @return value, value description
  */
```
