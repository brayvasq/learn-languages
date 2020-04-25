# .NET Farm
.NET example implementation of a little farm game

| Lenguaje | Versión                | SO                |
| -------- | --------------         | ----------------- |
| .NET     | 3.1.201                | Ubuntu 18.04.1    |

## Documentation

| Type          | Link                                           |
| ------------- | ---------------------------------------------- |
| Install       | https://docs.microsoft.com/es-es/dotnet/core/install/linux-package-manager-ubuntu-1804    |
| Docs          | https://docs.microsoft.com/es-es/dotnet/core/get-started?tabs=linux     |
| Dates         | https://stackoverflow.com/questions/4946316/showing-difference-between-two-datetime-values-in-hours |
| JSON          | https://docs.microsoft.com/en-us/dotnet/standard/serialization/system-text-json-how-to |
| IO            | https://www.c-sharpcorner.com/UploadFile/mahesh/how-to-read-a-text-file-in-C-Sharp/ |

## Create Python environment
```bash
dotnet new console --output sample1
dotnet run
```

## Variables
```c#
// C# is a strong typed language. The code compiles to run to CLR
// The sentences must be ended in ;
// Variables should be named using camelCase

// Numbers
int x = 5;
float x = 5.5f; // Should end in f to save as a float, otherwise will be saved as double
double x = 5.5; // It has more precision
Double x = 5.5;

//// For numbers you can use the _ symbol to make it more readable
int x = 10_000;

// Strings
String x = "My String";
string x = "My String";

// Booleans
bool x = true;
Boolean x = false;

// Lists
List<int> x = new List<int>();

// Hash tables
Hashtable x = new Hashtable();
```

### Data types
```c#
10.GetType(); // System.Int32
999999999999.GetType(); // System.Int64

5.2.GetType(); // System.Double

5.2f.GetType(); // System.Single

"My String".GetType(); // System.String

true.GetType(); // System.Boolean

(new List<int>()).GetType(); // System.Collections.Generic.List`1[System.Int32]

(new Hashtable()).GetType(); // System.Collections.Hashtable
```

### Operators
```c#
// '+' operator
//// In numbers just execute the addition operation
//// In String works as concatenation

1 + 1 // 2

1 + 1.5 // 2.5

"My" + " String"  // "My String"

// '-' operator
//// In numbers just execute the subtraction operation
1 - 1 // 0

// '*'
//// In numbers execute the multiplication operation
2 * 5 // 10

// In other languages the '*' operators works as a repeater for strings
//// In c# doesn't. In c# you must create a new string with a number of times to repeat it.
new string('#', 50);

// '/'
//// In numbers execute the division operation
//// To return decimals, the division should be casted to float or double
((double) 10) / 3  // 3.33333333333333

// '%' Modulus
//// In numbers execute the modulus operation
//// Returns remainder
10 % 2  // 0

// To performs exponential (power) operation
//// You should use the Math package, and the function pow
Math.Pow(2, 5); // 32

// '+='
//// In numbers just execute the addition operation
//// In String works as concatenation
int x = 1; // 1
x += 1; // 2
x += 1.5; // Data Types error


String x = "My";  // For strings the operator '+=' doesn't work
x = String.Concat(x, " String"); // "My String"

// '-='
// In numbers just execute the subtraction operation
int x = 2; // 2
x -= 1; // 1

// '*='
//// In numbers execute the multiplication operation
//// In strings, repeat a string n times
int x = 2;  // 2
x *= 5; // 10

// '/='
//// In numbers execute the division operation
double x = 5; //5
x /= 2; // 2.5

// Unary Operators

// '++'
//// In numbers just execute the addition operation
int x = 2; // 2
x++; // 3

// '--'
//// In numbers just execute the subtraction operation
int x = 2; // 2
x--; // 1
```


## Control structures (Control flow)
```c#
// If conditional
//// Used to compare or validate a element or sentence. And, depending on the result
//// executes an action
int item = 5;

if(item == 5){
  Console.WriteLine("Is 5");
}else if(item == 4){
  Console.WriteLine("Is 4");
}else{
  Console.WriteLine("Unknown");
}

// Switch structure
//// Used when we need to compare with multiple options
int item = 5;
switch (item) {
  case 1:
    Console.WriteLine("Is 1");
    break;
  case 2:
    Console.WriteLine("Is 2");
    break;
  case 3:
    Console.WriteLine("Is 3");
    break;
  case 4:
    Console.WriteLine("Is 4");
    break;
  case 5:
    Console.WriteLine("Is 5");
    break;
  case 6:
    Console.WriteLine("Is 6");
    break;
  default:
    Console.WriteLine("Unknown");
    break;
}
//// We use the keyword 'break' to interrupt the validation, otherwise
//// The structure will continue evaluating the next cases

//// To represent the if - else, we can use a one line sentence
//// called ternary operator => condition ? true : false
bool isFive = item == 5 ? true : false;

// To negate a condition we can use the symbol '!'
bool isFive = !(item == 4) ? true : false;

// While
//// It's used to create a loop when we don't have a specific limit.
int value = 0;

while(!(value == 5)){
  value = int.Parse(Console.ReadLine());
}

//// Note: We can receive user input via console, using Console.ReadLine()

// For
//// It's used to create a loop in a rage of values.
for(int i = 0; i<10; i++){
    Console.WriteLine(i); // It will print the numbers between 0 and 9
}

//// You can specify the number of steps the for will do in each iteration
for(int i = 0; i<10; i+=2){
    Console.WriteLine(i); // It will print the numbers between 0 and 10, with steps of 2
}

//// You can iterate a List or Hash as a for each
int[] x = new int[]{1,2,3,4,5,6,7,8,9};
foreach(var i in x){
    Console.WriteLine(i); // It will print each element of the list
}

// Keyword 'break'
//// You can use this keyword to interrupt the loop execution
for(int i = 0; i<10; i++){
    if(i == 3){
      break; // Interrupt the loop
    }
    Console.WriteLine(i); // It will print the numbers from 0 to 2
}

// Keyword 'continue'
//// You can use this keyword to skip the current iteration
for(int i = 0; i<10; i++){
    if(i == 3){
      continue; // Skips this iteration and Continue to the iteration 4
    }
    Console.WriteLine(i); // It will print the numbers from 0 to 9, skipping 3
}
```

## Data structures
```c#
// Arrays
//// In c# the arrays has a static size, and you can't add new elements
//// You only can modify and access to elements in the array.
//// You can't delete elements, to resize the array you must re-asign the elements to a new array
//// As in any other language you start to count from 0 for indexes
int[] x = new int[5];
x[0] = 1;
x[1] = 2;

Console.WriteLine(x[0]); // 1
Console.WriteLine(x[2]); // 0

// Lists
//// Is the solution to work with dynamic lists
List<int> x = new List<int>();

// get item
//// You can get a value of the position using the method get(index)
x[0]

// .Add(value)
//// Adds a new element at the end of the list
x.Add(1);

// .Remove(value)
//// Remove the first item from the list whose value is x
x.Remove(4);

// .Sort() methods
//// Used to sort a list
x.Sort();

// .Find
//// is a lambda function used to search a specific element
x.Find( item => item == 4);

// .FindAll
//// is a lambda function used to filter elements
x.FindAll( item => item % 2 == 0);

// .ConvertAll
//// is used to perform an operation to each element of the list
x.ConvertAll( item => item * 2);

// Hash
Hashtable x = new Hashtable();

// .Add
// You can add an element using .put(key, value)
x.Add("one", 1);
x.Add("two", 2);

// .get
//// Obtains the value corresponding to a key
x["one"] // 1

// .Keys
/// Obtains a Collection for hash keys
x.Keys

// .Values
/// Obtains a Collection for hash values
x.Values
```

## OOP
```c#
// Classes and Objects
namespace Example {
    public class Item{
        public string Name;

        public Item(string name = ""){
            this.Name = name;
        }
    }
}
//// Observations:
//// All objects are surrounded or belongs to a namespace
//// The Item() method is the class constructor
//// We use the polymorphism to allow us to give different behaviors to objects and methods
//// this is the reference to the self object, is like the keyword self in python
//// The class names, methods names and object names are named using UpperCamelCase

//// Instantiate an object
Item item = new Item("pepe");

// Inheritance
//// The inheritance allows to separate common logic in a different class

// Abstract classes
//// Are classes that have methods without a definition, and should be defined in each Child class
namespace Example {
    public abstract class Parent {
        public void GetInfo() => Console.WriteLine("Info");

        public abstract void SayHello();
    }

    public class Child : Parent {
        public void SayHello() => Console.WriteLine("Heyy!");
    }
}

Parent obj = new Child();
obj.GetInfo();  // => prints 'Info!'
obj.SayHello(); // => prints 'Heyy!'


// Interfaces
//// Are classes without functionalities, they are like a kind of template
//// where we define the methods that child classes should have
//// to follow a standard
namespace Example {
    public interface IParent {
        int GetNumber();
        string GetName();
    }

    public class Child : IParent {
        public int GetNumber() { return 1; }
        public string GetName(){ return "name"; }
    }
}

IParent obj = new Child();
obj.GetNumber(); //1
obj.GetName(); //"name"

// Static methods
//// Are methods that can be invoked without an instance
namespace Example {
    public class Item {
        public static int x = 10;

        public static int Method(){
            return Item.x * 2;
        }
    }
}

Item.x; // 10
Item.Method() // 20
```
### Scopes
```c#
// Scope variable
//// It exists in the context where it was created
//// you will be able to access it outside these control structures.
namespace Example {
    public class Item {
        public void Method(){
            int ScopeVar = 10;
        }

        public void Method2(){
            Console.WriteLine(ScopeVar); // ==> Raises: The name `ScopeVar' does not exist in the current context
        }

        public void Method3(){
            for(int i=0; i<10; i++){
                int Variable = i;
            }
            Console.WriteLine(Variable); // ==> Raises:The name `Variable' does not exist in the current context
        }
    }
}

// Object variable
//// It exists in the object scope, and it can be accessed for an object instance
namespace Example {
    public class Item {
        // It is a public variable.
        public int x;
        // It is a private variable, it will not be accessible. It's just accessible for the object.
        private int y;
        // It is a protected variable, it will not be accessible. It's just accessible for the object and the child objects.
        protected int z;

        public Item(){
            this.X = 10;
            this.Y = 20;
            this.Z = 30;
        }
    }
}

Item item = new Item();
item.x; // 10;
item.y; // ==> Raises: `Item.y' is inaccessible due to its protection level
item.z; // ==> Raises: `Item.z' is inaccessible due to its protection level

// final variables
//// Are constants variables. They exists in the class scope. Shared across all class instances
//// The const keyword is used to define constants
//// Constants are defined in uppercase
//// Also we can use the keyword static to define as a class variable

namespace Example {
    public class Item {
        public static int x = 10;
        public static const int Y = 20;
    }
}

Item.x = 5; // 5
Item.Y = 6; // Error, it can't be reassigned
```

## Comments
```c#
// You can define online comments using the symbol '//'
// This is a one line comment

// You can define multiline comments using /**/.
/*
This is a multiple line
comment
*/

// Docstrings
//// You can use XML comments to document your code
//// Here is an basic structure:

//// Class documentation
///<summary>
/// A useful description of the Class
///</summary>

//// Method documentation:
///<summary>
/// A useful method description
///</summary>
///<param name="param">param description.</param>
///<returns> value, value description</returns>
```

