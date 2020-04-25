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

## Run project
```bash
./gradlew clean build
./gradlew run

## you can use the project gradle wrapper to run the project
## For Linux:
./gradlew clean build
./gradlew run --args='[command]' -q

## For Windows:
gradlew.bat clean build
gradlew.bat run --args='[command]' -q
```
## Usage
### Getting help
```bash
./gradlew run --args='h' -q
./gradlew run --args='help' -q

The Kotlin Farm - a simple command line animals app

Usage:
  ./gradlew run --args='[command]' -q

Available Commands:
  [list    | l]   <age=>  <type=>    list all available animals
  [create  | c]   <name=> <type=>    create a animal with name
  [delete  | d]   <name=>            delete a animal
  [search  | s]   <name=>            search a animal
  [food    | f]   <name=>            give food to a animal
  [wash    | w]   <name=>            give a shower to a animal
  [alive   | a]   <name=>            show if a animal is alive
  [help    | h]                      help about commands

Flags:
Use ./gradlew run --args='help' -q for more information about a command.
```

### Creating a new animal
```bash
./gradlew run --args='create' -q
./gradlew run --args='c' -q

The Kotlin Farm - a simple command line animals app

Command Usage:
  [create  | c]   <name=> <type=>    creates a animal with name

Examples:
  ./gradlew run --args='[create  | c] name=my_animal_name' -q
  ./gradlew run --args='[create  | c] name=my_animal_name type=pig' -q
```

### Deleting an animal
```bash
./gradlew run --args='delete' -q
./gradlew run --args='d' -q

The Kotlin Farm - a simple command line animals app

Command Usage:
  [delete  | d]   <name=>        deletes a animal by name

Examples:
  ./gradlew run --args='[delete  | d] name=my_animal_name' -q
```

### Searching an animal
```bash
./gradlew run --args='search' -q
./gradlew run --args='s' -q

The Kotlin Farm - a simple command line animals app

Command Usage:
  [search  | s]   <name=>       searchs a animal by name

Examples:
  ./gradlew run --args='[search  | s] name=my_animal_name' -q
```

### Give food to an animal
```bash
./gradlew run --args='food' -q
./gradlew run --args='f' -q

The Kotlin Farm - a simple command line animals app

Command Usage:
  [food  | f]   <name=>       gives food to a animal by name

Examples:
  ./gradlew run --args='[food  | f] name=my_animal_name' -q
```

### Give a shower to an animal
```bash
./gradlew run --args='wash' -q
./gradlew run --args='w' -q

The Kotlin Farm - a simple command line animals app

Command Usage:
  [wash  | w]   <name=>       gives a shower to a animal by name

Examples:
  ./gradlew run --args='[wash  | w] name=my_animal_name' -q
```

### Check if an animal is alive
```bash
./gradlew run --args='alive' -q
./gradlew run --args='a' -q

The Kotlin Farm - a simple command line animals app

Command Usage:
  [alive  | a]   <name=>       checks if an animal is alive by name

Examples:
  ./gradlew run --args='[alive  | a] name=my_animal_name' -q
```

## Pending
- [ ] Fix isAlive() method. It's Returning true all time.
- [ ] Document IO and Dates.
- [ ] Improve CLI printing and commands
- [ ] Add a special character when the animal is eating or bathing
- [ ] Add unit tests
