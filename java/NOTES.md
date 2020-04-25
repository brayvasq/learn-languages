# Java Farm
Java example implementation of a little farm game

| Lenguaje | Versión                | SO                |
| -------- | --------------         | ----------------- |
| Java     | Java version: 11.0.6   | Ubuntu 18.04.1    |

## Documentation
| Type          | Link                                                                   |
| ------------- | ----------------------------------------------                         |
| Learn Java    | https://www.learnjavaonline.org/                                       |
| Official Docs | https://docs.oracle.com/en/java/                                       |
| Install Maven | https://linuxize.com/post/how-to-install-apache-maven-on-ubuntu-18-04/ |
| Install Maven | https://www.vogella.com/tutorials/ApacheMaven/article.html             |
| Example       | https://mkyong.com/maven/how-to-create-a-java-project-with-maven/      |
| StyleGuide    | https://www.oracle.com/technetwork/java/codeconventions-135099.html    |
| Json          | https://es.ourcodeworld.com/articulos/leer/126/como-trabajar-con-json-facilmente-en-java |
| Json          | https://howtodoinjava.com/library/json-simple-read-write-json-examples/ |
| Gson  | https://howtodoinjava.com/gson/gson/ |
| Regex         |https://www.vogella.com/tutorials/JavaRegularExpressions/article.html|

## Create project environment
```bash
# Check the maven version
mvn --version

# Create project
mvn archetype:generate -DgroupId=com.brayvasq.farm -DartifactId=java -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false

# Compile project
mvn compile

# Create .jar
## The clean instruction ensures that the build target is removed before a new build
## The package instruction create the .jar package
mvn clean package

# Execute project
java -cp target/farm-1.0-SNAPSHOT.jar com.brayvasq.farm.App

# Execute tests
mvn test

# Execute project using maven (the plugin 'exec-maven-plugin' is needed)
mvn exec:java

# Show dependencies
mvn dependency:tree -Dverbose

# Create a maven wrapper
mvn -N io.takari:maven:wrapper

## After that you can use ./mvnw instead mvn
## Example:
##  For Unix:
##    ./mvnw clean package
##
##  For Windows
##    mvnw.cmd clean package
```

### Plugins
Add the following plugins to the `pom.xml` file
- `maven-compiler-plugin` - To compile the project.
- `exec-maven-plugin` - To execute the project using maven.
```xml
<!-- After <dependencies> section-->

<build> <!-- Needed for build a project -->
    <plugins>
      <plugin> <!-- To compile project -->
        <artifactId>maven-compiler-plugin</artifactId>
        <version>3.3</version>
          <configuration>
            <source>1.8</source>
            <target>1.8</target>
          </configuration>
      </plugin>
      <plugin> <!-- To exec project using mvn exec:java -->
        <groupId>org.codehaus.mojo</groupId>
          <artifactId>exec-maven-plugin</artifactId>
            <version>1.2.1</version>
            <configuration>
              <mainClass>com.brayvasq.farm.App</mainClass>
            </configuration>
      </plugin>
    </plugins>
</build>
```

### Dependencies
Add the following dependencies to the `pom.xml` file
- `gson` - google library to work with json in java.
```xml
<dependencies>
        <!-- Other dependencies -->
        <dependency>
            <groupId>com.google.code.gson</groupId>
            <artifactId>gson</artifactId>
            <version>2.8.5</version>
        </dependency>
</dependencies>
```

## Variables
```java
// Java is a strong typed language. The code compiles to bytecode to run in the JVM
// Now you can use the jshell REPL to try the language
// The sentences must be ended in ;
// Variables should be named using camelCase

// Numbers
int x = 5;
float x = 5.5f; // Should end in f to save as a float, otherwise will be saved as double
double x = 5.5; // It has more precision

//// For numbers you can use the _ symbol to make it more readable
int x = 10_000;

// Strings
String x = "My String";

// Booleans
boolean x = true;

// Lists
List<Integer> x = new ArrayList<>();
List<Integer> x = new LinkedList<>();

// Hash tables
Hashtable<Integer, String> x = new Hashtable<Integer, String>();
```
### Data types
```java
// We can know the data type with using the getClass().getName() methods
// However, it just can be applied to objects
>> ((Object) 10).getClass().getName(); 
"java.lang.Integer"

>> ((Object) 5.2).getClass().getName(); 
"java.lang.Double"

>> ((Object) 5.2f).getClass().getName(); 
"java.lang.Float"

>> "My String".getClass().getName(); 
"java.lang.String"

>> ((Object) true).getClass().getName(); 
"java.lang.Boolean"

>> (new ArrayList<>()).getClass().getName(); 
"java.util.ArrayList"

>> (new LinkedList<>()).getClass().getName(); 
"java.util.LinkedList"

>>(new Hashtable<Integer, String>()).getClass().getName(); 
"java.util.Hashtable"
```

### Operators
```java
// '+' operator
//// In numbers just execute the addition operation
//// In String works as concatenation
>> 1 + 1
2
>> 1 + 1.5 
2.5

>> "My" + " String" 
"My String"

// '-' operator
//// In numbers just execute the subtraction operation
>> 1 - 1 
0

// '*'
//// In numbers execute the multiplication operation
>> 2 * 5 
10

// In other languages the '*' operators works as a repeater for strings
//// In java doesn't. In java you should use the .repeat() method
>> "x".repeat(5) 
"xxxxx"

// '/'
//// In numbers execute the division operation
//// To return decimals, the division should be casted to float or double
>> (float) 10 / 3 
3.3333333

// '%' Modulus
//// In numbers execute the modulus operation
//// Returns remainder
>> 10 % 2 
0

// To performs exponential (power) operation
//// You should use the Math package, and the function pow
>> Math.pow(2, 5);
32.0


// Binary Operators

// '+='
//// In numbers just execute the addition operation
//// In String works as concatenation
>> int x = 1;
1
>> x += 1;
2
>> x += 1.5;
3

>> String x = "My";  // For strings the operator '+=' doesn't work
>> x = x.concat(" String");
"My String"

// '-='
// In numbers just execute the subtraction operation
int x = 2 // 2
x -= 1 // 1

// '*='
//// In numbers execute the multiplication operation
//// In strings, repeat a string n times
>> int x = 2 
2
>> x *= 5
10

// '/='
//// In numbers execute the division operation
>> float x = 5f 
5
>> x /= 2 
2.5

// '%='
//// In numbers execute the modulus operation
//// Returns remainder
>>> int x = 5
5
>>> x %= 2
1

// Unary Operators

// '++'
//// In numbers just execute the addition operation
>> int x = 2
2
>> x++
3

// '--'
//// In numbers just execute the subtraction operation
>> int x = 2
2
>> x--
1
```

## Control structures (Control flow)
```java
// If conditional
//// Used to compare or validate a element or sentence. And, depending on the result
//// executes an action
int item = 5;

if(item == 5){
  System.out.println("Is 5");
}else if(item == 4){
  System.out.println("Is 4");
}else{
  System.out.println("Unknown");
}
//// The block else if can be used how much you need it. 

// Switch structure
//// Used when we need to compare with multiple options
int item = 5;
switch (item) {
  case 1:
    System.out.println("Is 1");
    break;
  case 2:
    System.out.println("Is 2");
    break;
  case 3:
    System.out.println("Is 3");
    break;
  case 4:
    System.out.println("Is 4");
    break;
  case 5:
    System.out.println("Is 5");
    break;
  case 6:
    System.out.println("Is 6");
    break;
  default:
    System.out.println("Unknown");
    break;
}
//// We use the keyword 'break' to interrupt the validation, otherwise
//// The structure will continue evaluating the next cases


//// To represent the if - else, we can use a one line sentence
//// called ternary operator => condition ? true : false
boolean isFive = item == 5 ? true : false;

// To negate a condition we can use the symbol '!'
boolean isFive = !(item == 4) ? true : false;

// While
//// It's used to create a loop when we don't have a specific limit.
Scanner scan = new Scanner(System.in);

int value = 0;

while(!(value == 5)){
  value = scan.nextInt();
}

//// Note: We can receive user input via console, using the Scanner Class
//// We can use the BufferedReader Class too

// For
//// It's used to create a loop in a rage of values.
for(int i = 0; i<10; i++){
    System.out.println(i); // It will print the numbers between 0 and 9
}

//// You can specify the number of steps the for will do in each iteration
for(int i = 0; i<10; i+=2){
    System.out.println(i); // It will print the numbers between 0 and 10, with steps of 2
}

//// You can iterate a List or Hash as a for each
List<Integer> l = Arrays.asList(1,2,3,4,5,6);

for(int i: l){
    System.out.println(i); // It will print each element of the list
}

// Keyword 'break'
//// You can use this keyword to interrupt the loop execution
for(int i = 0; i<10; i++){
    if(i == 3){
      break; // Interrupt the loop
    }
    System.out.println(i); // It will print the numbers from 0 to 2
}
```

## Data structures
```java
// Arrays
//// In java the arrays has a static size, and you can't add new elements
//// You only can modify and access to elements in the array.
//// You can't delete elements, to resize the array you must re-asign the elements to a new array
//// As in any other language you start to count from 0 for indexes
int[] x = new int[5];
x[0] = 1;
x[1] = 2;

System.out.println(x[0]); // 1
System.out.println(x[2]); // 0

// Lists
//// Is the solution to work with dynamic lists.
List<Integer> x = new LinkedList<>();

// .get(index)
//// You can get a value of the position using the method get(index)
x.get(0)

// .add(value)
//// Adds a new element at the end of the list
x.add(1);

// .remove(value)
//// Remove the element where the index == value
x.remove(4);

//// Remove the first item from the list whose value is x
x.remove((Object) 4);

//// Remove first element
x.removeFirst()

//// Remove last element
x.removeLast()

// .sort() methods
//// Used to sort a list
Collections.sort(x);

// Print array
Arrays.toString(x)

// .filter
//// is a lambda function used to filter elements
x.stream()
  .filter(item -> item == 5)
  .findAny() //Return the first element that match
  .orElse(null);

// .map
//// is used to perform an operation to each element of the list
x.stream().map(item -> item * 2)

// .reduce
//// is used to perform an operation over whole array and return a single value
//// Identity is the initial value of the reduction -> 0 in this case
x.stream().reduce(0, (subtotal, element) -> subtotal + element)

// Hash
Hashtable<String, Integer> x = new Hashtable<String, Integer> ();

// .put
// You can add an element using .put(key, value)
x.put("one", 1);

// .get(key)
//// Obtains the value corresponding to a key
x.get("one"); //1

// .keys()
/// Obtains an Enumerator for hash keys
x.keys()

// .values()
//// Obtains a Collection for hash values
x.values()
```

## OOP
```java
// Classes and Objects
public class Item{
  public String name;

  public Item(){
    this("");
  }

  public Item(String name){
    this.name = name;
  }
}

//// Observations:
//// The Item() method is the class constructor
//// We can't pass a default value to params like other languages, so we can
//// use the polymorphism to send a default value from an empty constructor
//// this is the reference to the self object, is like the keyword self in python
//// Polymorphism allow us to give different behaviors to objects and methods.

//// Instantiate an object
Item item = new Item("pepe");

// Inheritance
//// The inheritance allows to separate common logic in a different class

// Abstract classes
//// Are classes that have methods without a definition, and should be defined in each Child class
public abstract class Parent {
  public void getInfo(){
    System.out.println("Info");
  }

  public abstract void sayHello();
}

public class Child extends Parent {
  @override
  public void sayHello(){
    System.out.println("Heyy!");
  }
}

Parent object = new Child();
object.getInfo();  // => prints 'Info!'
object.sayHello(); // => prints 'Heyy!'

// Interfaces
//// Are classes without functionalities, they are like a kind of template
//// where we define the methods that child classes should have
//// to follow a standard
public interface Parent {
  public abstract int getNumber();
  public abstract String getName();
}

public class Child implements Parent {
  @override
  public int getNumber(){
    return 1;
  }

  @override
  public String getName(){
    return "name";
  }
}

Parent object = new Child();
object.getNumber(); //1
object.getName(); //"name"

// Static methods
//// Are methods that can be invoked without an instance
public class Item {
  public static int x = 10;

  public static int method(){
    return Item.x * 2;
  }
}

Item.x; // 10
Item.method() // 20
```

### Scopes
```java
// Scope variable
//// It exists in the context where it was created
//// you will be able to access it outside these control structures.

public class Item {
  public void method(){
    int scopeVar = 10;
  }

  public void method2(){
    System.out.println(scopeVar); // ==> Raises an error
  }

  public void method3(){
    for(int i=0; i<10; i++){
      int variable = i;
    }
    System.out.println(variable); // ==> Raises an error
  }
}

// Object variable
//// It exists in the object scope, and it can be accessed for an object instance
public class Item {
  // It is a public variable.
  public int x; 
  // It is a private variable, it will not be accessible. It's just accessible for the object.
  private int y; 
  // It is a protected variable, it will not be accessible. It's just accessible for the object and the child objects.
  protected int z;

  public Item(){
    this.x = 10;
    this.y = 20;
    this.z = 30;
  }
}

Item item = new Item();
item.x; // 10;
item.y; // ==> Raises an error
item.z; // ==> Raises an error

// final variables
//// Are constants variables. They exists in the class scope. Shared across all class instances
//// The final keyword is used to define constants
//// Constants are defined in uppercase
//// Also we can use the keyword static to define as a class variable
public class Item {
  public static int x = 10;
  public static final int Y = 20;
}

Item.x = 5; // 5
Item.Y = 6; // Error, it can't be reassigned
```
## Comments
```java
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

