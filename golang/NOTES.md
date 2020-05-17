# Golang Farm
Golang example implementation of a little farm game.

| Language | Versión                           | SO                |
| -------- | --------------                    | ----------------- |
| Go       | go version go1.10.4 linux/amd64   | Ubuntu 18.04.1    |

## Documentation

| Type          | Link                                                           |
| ------------- | -------------------------------------------------------------- |
| Learn Python  | https://golang.org/                                            |
| Tutorial      | https://www.wolfe.id.au/2020/03/10/starting-a-go-project/      |
| StyleGuide    | https://golang.org/doc/effective_go.html                       |
| Time          | https://golang.org/pkg/time/                                   |
| JSON          | https://blog.golang.org/json                                   |
| IO            | https://golang.org/pkg/io/ioutil/                              |
| ARGS          | https://gobyexample.com/command-line-arguments                 |
| Regex         | https://gobyexample.com/regular-expressions                    |

## Create Python environment
```bash
# Create the project folder
mkdir golang
# Create the github go project folder
mkdir -p /home/USERNAME/go/src/github.com/USERNAME/learn-languages/
# Move the project to the golang github projects directory
mv golang /home/USERNAME/go/src/github.com/USERNAME/learn-languages/
# Move to the project
cd /home/USERNAME/go/src/github.com/USERNAME/learn-languages/
cd golang/
# Initialize the go modules
go mod init github.com/USERNAME/learn-languages/golang
# Create the source folder
mkdir -p cmd/farm
# Create the main file
touch cmd/src/main.go
# Run the main file
go run cmd/src/main.go
```

## Variables
```go
// Go is a strong typed language, and also, is a compiled language.
// However, you can omit the data type and the interpreter will infer the data type.
// Variables should be named using camelCase

// Numbers
x := 5

var x int
x = 5

var x int8 // 8-bit signed integer
x = 225

var x int16 // 16-bit signed integer

var x int32 // 32-bit signed integer

var x int64 // 64-bit signed integer

var x uint8 // 8-bit unsigned integer
x = 225

var x uint16 // 16-bit unsigned integer

var x uint32 // 32-bit unsigned integer

var x uint64 // 64-bit unsigned integer

var x float32 // 32-bit signed float
x = 20.45

var x float64 // 64-bit signed float

// Strings
x := "Hello World"

var x  string
x = "Hello World"

// Booleans
x := true

var x bool
x = true

// Lists
x := make([]string, 0)

// Maps
m := make(map[string]int)
```

### Data types
```go
// We can know the data type with using the "reflect" package and the TypeOf method
fmt.Println(reflect.TypeOf(5))
// =>  int

fmt.Println(reflect.TypeOf(5.2))
// =>  float64

fmt.Println(reflect.TypeOf("My String"))
// =>  string

fmt.Println(reflect.TypeOf(true))
// =>  bool

fmt.Println(reflect.TypeOf([]int{1,2,3,4}))
// =>  []int

fmt.Println(reflect.TypeOf(map[string]int{"one": 1, "two": 2}))
// =>  map[string]int
```

### Operators
```go
// '+' operator
//// In numbers just execute the addition operation
//// In String works as concatenation
1 + 1
// => 2
1 + 1.5
// => 2.5

"My" + " String"
// => "My String"

// '-' operator
//// In numbers just execute the subtraction operation
1 - 1
// => 0

// '*'
//// In numbers execute the multiplication operation
2 * 5
// => 10

// In another languages the '*' operators works as a repeater for strings
//// In java doesn't. In java you should use the strings.Repeat method
import "strings"

strings.Repeat("x", 5)
// => "xxxxx"

// '/'
//// In numbers execute the division operation
//// To return decimals, the division should be casted to float or double
10 / 3
// => 3
float64(10) / float64(3)
// => 3.3333333333333335
10.0 / 3
// => 3.3333333333333335

// '%' Modulus
//// In numbers execute the modulus operation
//// Returns remainder
10 % 2
// => 0

// To performs exponential (power) operation
//// You should use the Math package, and the function Pow
import "math"

math.Pow(2, 5)
// => 32

// Binary Operators

// '+='
//// In numbers just execute the addition operation
//// In String works as concatenation
x := 1
// => 1
x += 1
// => 2
x += 1.5
// => constant 1.5 truncated to integer

x := "My"
// => "My"
x += " String"
// => "My String"

// '-='
// In numbers just execute the subtraction operation
x := 2
// => 2
x -= 1
// => 1

// '*='
//// In numbers execute the multiplication operation
//// In strings, repeat a string n times
x := 2
// => 2
x *= 5
// => 10

// '/='
//// In numbers execute the division operation
x := 5.0
// => 5.0
x /= 2
// => 2.5

// '%='
//// In numbers execute the modulus operation
//// Returns remainder
x := 5
// => 5
x %= 2
// => 1

// Unary Operators

// '++'
//// In numbers just execute the addition operation
x := 2
// => 2
x++
// => 3

// '--'
//// In numbers just execute the subtraction operation
x := 2
// => 2
x--
// => 1
```

## Control structures (Control flow)
```go
// If conditional
//// Used to compare or validate a element or sentence. And, depending on the result
//// executes an action
//// In golang we don't use parentheses for controls flow, not like other languages.
item := 5
if item == 5 {
    fmt.Println("Is 5")
} else  if item == 4 {
    fmt.Println("Is 4")
} else {
    fmt.Println("Unknown")
}

//// The block else if can be used how much you need it.

// Switch structure
//// Used when we need to compare with multiple options
item := 5;
switch item {
  case 1:
    fmt.Println("Is 1")
  case 2:
    fmt.Println("Is 2")
  case 3:
    fmt.Println("Is 3")
  case 4:
    fmt.Println("Is 4")
  case 5:
    fmt.Println("Is 5")
  case 6:
    fmt.Println("Is 6")
  default:
    fmt.Println("Unknown")
}

// In Golang we don't have a ternary operator like another languages.
// However we can emulate this behavior
value := func() string { if 5 % 2 == 0 {return "Is even" } else {return "Is odd"} }()
value := map[bool]string{true: "Is even", false: "Is odd"} [5 % 2 == 0]

// Loops
// In Golang we only have the for loop, and it can behaves as many
// kind of loops

// While
//// It's used to create a loop when we don't have a specific limit.
import (
    "bufio"
    "os"
    "strconv"
    "strings"
)

value := 0
reader := bufio.NewReader(os.Stdin)

for !(value == 5) {
    text, _ := reader.ReadString('\n')
    text = strings.Replace(text, "\n", "", -1) // -1 is to replace all items that match
    value, _ = strconv.Atoi(text)
}
//// Note: We can receive user input via console, using the bufio and os packages

// For
//// It's used to create a loop in a rage of values.
for i := 0; i<10; i++ {
    fmt.Println(i); // It will print the numbers between 0 and 9
}

//// You can specify the number of steps the for will do in each iteration
for i := 0; i<10; i+=2 {
    fmt.Println(i); // It will print the numbers between 0 and 10, with steps of 2
}

//// You can iterate an Array or Hash as a for each
x := []int{1,2,3,4,5,6}

for index, value := range x {
    // The %v is for a default format
    fmt.Printf("Index: %v Value: %v \n", index, value)
}

x := map[string]int{"one": 1, "two": 2, "three": 3, "four": 4, "five": 5, "six": 6}

for index, value := range x {
    // The %v is for a default format
    fmt.Printf("Index: %v Value: %v \n", index, value)
}

// Keyword 'break'
//// You can use this keyword to interrupt the loop execution
for i := 0; i<10; i++ {
    if i == 3 {
      break // Interrupt the loop
    }
    fmt.Println(i); // It will print the numbers from 0 to 2
}
// Keyword 'continue'
//// You can use this keyword to skip the current iteration
for i := 0; i<10; i++ {
    if i == 3 {
      continue // Skips this iteration and Continue to the iteration 4
    }
    fmt.Println(i); // It will print the numbers from 0 to 9, skipping 3
}
```

## Data structures
```go
// Arrays
//// In go the arrays has a static size, to create an array you should use the make function
//// make([]type, size, capacity)
//// Where:
////    type => The data type of the array
////    size => The initial size of the array
////            You can use the function len() to get the array size
////    capacity => The max size of the array, it's optional
////            You can use the function cap() to get the array capacity
//// You can modify and access to elements in the array.
//// You can't delete elements, to resize the array you must re-asign the elements to a new array
//// As in any other language you start to count from 0 for indexes
x := make([]int, 5);
x[0] = 1;
x[1] = 2;

fmt.Printf("Capacity: %v \n", cap(x)) // => 5
fmt.Printf("Size: %v \n", len(x)) // => 5
fmt.Printf("Array: %v \n", x) // [1,2,0,0,0]

//// Get value
//// You can get the value of the position using [index]
fmt.Println(x[0])
// => 1

//// append()
//// Adds a new element at the end of the list
x = append(x, 3)
fmt.Printf("Capacity: %v \n", cap(x)) // => 10
fmt.Printf("Size: %v \n", len(x)) // => 6
fmt.Printf("Array: %v \n", x) // => [1,2,0,0,0,3]

//// remove
//// In golang there is no method to remove an element from an array
//// To do this you have to reassign the array skipping the element to remove
new := make([]int, 0)
for _, i := range x {
    if i != 2 {
        new = append(new, i)
    }
}

x = new

fmt.Printf("Capacity: %v \n", cap(x)) // => 8
fmt.Printf("Size: %v \n", len(x)) // => 5
fmt.Printf("Array: %v \n", x) // => [1 0 0 0 3]

// Maps
//// Has a similar behavior to Arrays, the difference is that we can use
//// other index types
x := make(map[string]int)

//// Add a element
//// You can assign an element with the following syntax: map[key] = value
x["one"] = 1
x["two"] = 2

fmt.Printf("Size: %v \n", len(x)) // => 2
fmt.Printf("Map: %v \n", x) // => map[one:1 two:2]

//// Get value
//// You can get the value of the position using [key]
fmt.Println(x["one"]) // => 1

//// delete
//// Removes an element from the map by key
delete(x, "one")

fmt.Printf("Size: %v \n", len(x)) // => 1
fmt.Printf("Map: %v \n", x) // => map[two:2]
```

## OOP
```go
type Item struct {
    Name string
}

//// Observations:
//// In golang we don't have a class per se, we can create a struct and
//// works with this as different type of data.
//// The structs are so similar to C lang structs.

//// Instantiate an object
item := Item{}
item.Name = "pepe"

//// It works as a kind of constructor
item := Item{ Name: "pepe" }

// Inheritance
//// The inheritance allows to separate common logic in a different class
//// In golang we don't have the common inheritance as another languages (Java, C# ...)
//// We have composition, IIt's like an anonymous attribute that allows us to
//// access to his properties and attributes by transitivity

type Parent struct {
    Name string
}

//// In golang we cannot put functions inside the structs
//// However we can link the function to the struct using a pointer (called receiver)
//// that allow us to use the '.' operator to call a function
func (p *Parent) GetInfo(){
    fmt.Println("Info")
}

type Child struct {
    Parent
}

func (c *Child) SayHello() {
    fmt.Println("Heyy! "+c.Name)
}

object := Child{} // We cannot initialize the name here, because is a property of Parent struct
object.Name = "pepe"
object.GetInfo() // => prints 'Info'
object.SayHello() // => prints "Heyy! pepe"

// Interfaces
//// Are structs without functionalities, they are like a kind of template
//// where we define the methods names that child classes should have
//// to follow a standard.
//// In this case we don't use composition; If a struct defines the
//// methods of an interface, that struct implements the interface

type Parent interface {
    GetNumber()
    GetName()
}

type Child struct {
    Name string
}

func (c *Child) GetNumber() int {
    return 1
}

func (c *Child) GetName() string {
    return c.Name
}

object := Child{Name: "pepe"}
fmt.Println(object.GetNumber()) // => 1
fmt.Println(object.GetName()) // => pepe

// Static methods
//// Are methods that can be invoked without an instance
type Item struct{}

func (i Item) Method(num int) int{
    return num * 2
}

fmt.Println(Item{}.Method(3)) // => 6
```

### Scopes
```go
// Scope variable
//// It exists in the context where it was created
//// you will be able to access it outside these control structures.

type Item struct{}

func (i *Item) Method(){
    scopeVar := 10
    fmt.Println(scopeVar) // => 10
}

func (i *Item) Method2(){
    fmt.Println(scopeVar) // => undefined: scopeVar
}

func (i *Item) Method3(){
    for i:=0; i<10; i++{
      variable := i;
    }
    fmt.Println(variable); // ==> undefined: variable
}

// Object variable
//// It exists in the object scope, and it can be accessed for an object instance
type Item struct{
    Name string
}

func (i *Item) Method(){
    fmt.Println(i.Name)
}

item := Item{}
item.Name = "pepe"
item.Method() // => pepe
```

## Comments
```go
// You can define online comments using the symbol '//'
// This is a one line comment

// You can define multiline comments using /**/.
/*
This is a multiple line
comment
*/

// Docstrings
//// You can use one line or multiline comments to document your code
// In golang the one line comments is the most used in general
//// Here is an basic structure:

///// Package documentation
// Package example, a useful description of the package

//// Structs documentation
// Example, a useful description of the struct

//// Method documentation
// Method, a useful description of the struct.
// What it does.
//
// The param is for .....
//
// It returns .......
//
//      Examples:
//          ...............
```
