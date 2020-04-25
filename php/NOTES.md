# PHP Farm
PHP example implementation of a little farm game

| Lenguaje | Versión                      | SO                |
| -------- | --------------               | ----------------- |
| PHP      | PHP 7.3                      | Ubuntu 18.04.1    |


## Documentation

| Type          | Link                                           |
| ------------- | ---------------------------------------------- |
| Documentation | https://www.php.net/docs.php                   |
| DockerCompose | https://docs.docker.com/compose/install/       |
| Lamp stack    | https://github.com/jcavat/docker-lamp          |
| Dates         | https://www.w3schools.com/php/php_date.asp     |
| Dates         | https://www.geeksforgeeks.org/comparing-two-dates-in-php/ |
| Get diff minutes | https://stackoverflow.com/questions/365191/how-to-get-time-difference-in-minutes-in-php |
| PHP composer docker | https://www.digitalocean.com/community/tutorials/how-to-containerize-a-laravel-6-application-for-development-with-docker-compose-on-ubuntu-18-04-es |
| PHP composer docker | https://stackoverflow.com/questions/51443557/how-to-install-php-composer-inside-a-docker-container|
| Laravel Zero  | https://laravel-zero.com/ |
| JSON Serialize | https://stackoverflow.com/questions/7005860/php-json-encode-class-private-members |
| File handling | https://www.w3schools.com/php/php_file.asp |
| Array remove  | https://stackoverflow.com/questions/33457834/remove-object-from-array-by-object-value-in-php |
| Docstring    | http://phpdocu.sourceforge.net/howto.php |
| Regex        | https://www.phpliveregex.com/ |

## Create Python environment
```bash
# We will use Docker to run php scripts
mkdir php
cd  php
touch Dockerfile
touch docker-compose.yml

docker-compose up -d
```

File `Dockerfile`
```dockerfile
FROM php:7.4-fpm

# Install system dependencies
RUN apt-get update && apt-get install -y \
    git \
    curl \
    libpng-dev \
    libonig-dev \
    libxml2-dev \
    zip \
    unzip

# Clear cache
RUN apt-get clean && rm -rf /var/lib/apt/lists/*

# Install PHP extensions
RUN docker-php-ext-install pdo_mysql mbstring exif pcntl bcmath gd

# Get latest Composer
COPY --from=composer:latest /usr/bin/composer /usr/bin/composer

# Install Composer
RUN curl -sS https://getcomposer.org/installer | php -- --install-dir=/usr/local/bin --filename=composer

# Create system user to run Composer and Artisan Commands
RUN mkdir -p /home/$user/.composer 
```

File `docker-compose.yml`
```yaml
version: "3.1"
services:
    farm:
        build: .
        ports:
            - "8000:80"
        volumes:
            - ./:/var/www/html/
```

### Run project
```bash
docker-compose run farm /bin/bash
cd src
php Main.php
```

## Observations
```php
/*
1) Folder absolute path: __DIR__
2) The files should be included relative to the Main.php file.
3) The class DateTime, should be used as \DateTime, otherwise it will be taken as a namespace class.
4) implements \JsonSerializable to serialize the prvivate and protected attributes too.
5) var_dump() -> Prints objects
*/
```

## Variables
```php
// Python is a dynamic typed language, so you can omit the data type and the interpreter will infer the data type.
// Python is an interpreted language
// Variables should be named using camelCase

// Numbers
$x = 5;
$x = 5.5; // It has more precision

// Strings
$x = "My String";

// Booleans
$x = true;

// Lists - Hash
//// Arrays can have the behavior of a simple array an associative array
$x = array(); 
```
### Data types
```php
// We can know the data type with using the gettype() function
// However, it just can be applied to objects
gettype(10); // integer

gettype(10); // double

gettype("My String"); // string

gettype(true); // boolean

gettype(array()); // array
```

### Operators
```php
// '+' operator
//// In numbers just execute the addition operation
1 + 1 // 2

1 + 1.5 // 2.5

// In other languages the '+' operator is used to concat strings
//// In php doesn't. In php you should use the '.' symbol
"My"." String" // "My String"

// '-' operator
//// In numbers just execute the subtraction operation
1 - 1 // 0

// '*'
//// In numbers execute the multiplication operation
2 * 5 // 10

// In other languages the '*' operator works as a repeater for strings
//// In php doesn't. In php you should use the str_repeat() method
str_repeat("x", 5); // "xxxxx"

// '/'
//// In numbers execute the division operation
10 / 3  // 3.3333333

// '%' Modulus
//// In numbers execute the modulus operation
//// Returns remainder
10 % 2  // 0

// To performs exponential (power) operation
//// You should use the the function pow
pow(2, 5); // 32

// Binary Operators

// '+='
//// In numbers just execute the addition operation
//// In String works as concatenation
$x = 1; // 1
$x += 1; // 2
$x += 1.5; // 3.5

//// String concatenation
$x = "My";  // For strings the operator '+=' doesn't work
//// You can join strings using String interpolation
$y = "String";
$z = "$x Other $y"; // Only works for variables or methods.

// '-='
// In numbers just execute the subtraction operation
$x = 2; // 2
$x -= 1; // 1

// '*='
//// In numbers execute the multiplication operation
//// In strings, repeat a string n times
$x = 2;  // 2
$x *= 5; // 10

// '/='
//// In numbers execute the division operation
$x = 5; // 5
$x /= 2; //2.5

// '%='
//// In numbers execute the modulus operation
//// Returns remainder
$x = 5; // 5
$x %= 2; // 1

// Unary Operators

// '++'
//// In numbers just execute the addition operation
$x = 2; // 2
$x++; // 3

// '--'
//// In numbers just execute the subtraction operation
$x = 2; // 2
$x--; //1
```

## Control structures (Control flow)
```php
// If conditional
//// Used to compare or validate a element or sentence. And, depending on the result
//// executes an action
$item = 5;

if($item == 5){
  echo "Is 5";
}else if(item == 4){
  echo "Is 4";
}else{
  echo "Unknown";
}
//// The block else if can be used how much you need it. 

// Switch structure
//// Used when we need to compare with multiple options
$item = 5;

switch ($item) {
  case 1:
    echo "Is 1";
    break;
  case 2:
    echo "Is 2";
    break;
  case 3:
    echo "Is 3";
    break;
  case 4:
    echo "Is 4";
    break;
  case 5:
    echo "Is 5";
    break;
  case 6:
    echo "Is 6";
    break;
  default:
    echo "Unknown";
    break;
}
//// We use the keyword 'break' to interrupt the validation, otherwise
//// The structure will continue evaluating the next cases

//// To represent the if - else, we can use a one line sentence
//// called ternary operator => condition ? true : false
$isFive = $item == 5 ? true : false; // 1

// To negate a condition we can use the symbol '!'
$isFive = !($item == 4) ? true : false; // 1

// While
//// It's used to create a loop when we don't have a specific limit.
if(!function_exists("readline")) {
    function readline($prompt = null){
      if($prompt){
        echo $prompt;
      }
      $fp = fopen("php://stdin","r");
      $line = rtrim(fgets($fp, 1024));
      return $line;
    }
}

$value = 0;

while(!($value == 5)){
  $value = (int)readline("Option : ");
}

//// Note: We can receive user input via console, using the readline function
//// If it's not defined, we have to define it.

// For
//// It's used to create a loop in a rage of values.
for($i = 0; $i<10; $i++){
    echo $i; // It will print the numbers between 0 and 9
}

//// You can specify the number of steps the for will do in each iteration
for($i = 0; $i<10; $i+=2){
    echo $i; // It will print the numbers between 0 and 10, with steps of2
}

//// You can iterate a List or Hash using foreach
$list = array(1,2,3,4,5);

foreach($list as $i){
    echo $i; // It will print each element of the list
}

$hash = array(
    "one" => 1,
    "two" => 2
);

foreach($hash as $key => $value){
    echo "$key => $value"; // It will print each key,value of the hash
}

// Keyword 'break'
//// You can use this keyword to interrupt the loop execution
for($i = 0; $i<10; $i++){
    if($i == 3){
      break; // Interrupt the loop
    }
    echo $i; // It will print the numbers from 0 to 2
}
```

## Data structures
```php
// Arrays - Hash tables
//// In php the arrays can have the behavior of an array or an associative array.

$x = array();

// .get(index)
//// You can get the value of the position using [index]
$x[0];
$x[1];
$x["key"];

// array_push
//// Adds a new element at the end of the list
array_push($x, 1);
array_push($x, 2);
$x["key"] = "value";

// unset(value)
//// Remove the first item from the list whose value is x
unset($x[0]);
unset($x["key"]);

// Print array
var_dump($x);

// array_keys()
/// Obtains an Enumerator for hash keys
array_keys($x);

// array_values()
//// Obtains a Collection for hash values
array_values($x);
```

## OOP
```php
// Classes and Objects
namespace App;

class Item {
    public $name;

    public function __construct(String $name = ""){
        $this->name = $name;
    }
}

//// Observations:
//// The __construct() method is the class constructor
//// We can pass a default value to params like other languages
//// '$this' is the reference to the self object, is like the keyword self in python
//// The symbol '.' is used to join strings, so to call variables or methods
//// we use the symbols '->'.
//// Variables and the keyword '$this', have to be preceded by the symbol '$'
//// As java, al sentences have to end by ';' symbol.

//// Instantiate an object
$item = new Item("pepe");

// Inheritance
//// The inheritance allows to separate common logic in a different class

// Abstract classes
//// Are classes that have methods without a definition, and should be defined in each Child class
//// Note: PHP has reserved the 'Parent' keyword
abstract class PClass {
    public function getInfo(){
        echo "Info";
    }

    public abstract function sayHello();
}

class Child extends Pclass {
    public function sayHello(){
        echo "Heyy!";
    }
}

$object = new Child();
$object->getInfo();  // => prints 'Info!'
$object->sayHello(); // => prints 'Heyy!'

// Interfaces
//// Are classes without functionalities, they are like a kind of template
//// where we define the methods that child classes should have
//// to follow a standard

interface IPClass {
  public function getNumber();
  public function getName();
}

class Child implements IPClass {
  public function getNumber(){
    return 1;
  }

  public function getName(){
    return "name";
  }
}

$object = new Child();
$object->getNumber(); //1
$object->getName(); //"name"

// Static methods
//// Are methods that can be invoked without an instance
class Item {
  public static $x = 10;

  public static function method(){
    return Item::$x * 2;
  }
}

Item::$x; // 10
Item::method(); // 20
```

### Scopes
```php
// Scope variable
//// It exists in the context where it was created
//// you will be able to access it outside these control structures.
class Item {
  public function method(){
    $scopeVar = 10;
  }

  public function method2(){
    echo $scopeVar; // ==> Raises an error: PHP Notice:  Undefined variable: scopeVar
  }

  public function method3(){
    for($i=0; $i<10; $i++){
      $variable = $i;
    }
    echo $variable; // ==> 9
  }
}

// Object variable
//// It exists in the object scope, and it can be accessed for an object instance
class Item {
  // It is a public variable.
  public $x; 
  // It is a private variable, it will not be accessible. It's just accessible for the object.
  private $y; 
  // It is a protected variable, it will not be accessible. It's just accessible for the object and the child objects.
  protected $z;

  public function __construct(){
    $this->x = 10;
    $this->y = 20;
    $this->z = 30;
  }
}

$item = new Item();
$item->x; // 10;
$item->y; // ==> PHP Fatal error:  Uncaught Error: Cannot access private property Item::$y
$item->z; // PHP Fatal error:  Uncaught Error: Cannot access protected property Item::$z

// final variables
//// Are constants variables. They exists in the class scope. Shared across all class instances
//// The final keyword is used to define constants
//// Constants are defined in uppercase
//// Also we can use the keyword static to define as a class variable
define('Z', 3);

class Item {
  public static $x = 1;
  public const Y = 2;
}

Item::$x = 5; // 5
Item::Y = 6; // PHP Parse error:  syntax error, unexpected '='
Z = 5; // PHP Parse error:  syntax error, unexpected '='
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
