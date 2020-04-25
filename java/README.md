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

## Run project
```bash
# Compile and create a .jar
mvn clean package
mvn exec:java

# Execute project
java -cp target/Farm-1.0-SNAPSHOT.jar com.brayvasq.farm.App

# Execute project using maven (the plugin 'exec-maven-plugin' is needed)
## you can use the project maven wrapper
## For Linux:
./mvnw clean package
./mvnw exec:java -Dexec.args='[command]' -q

## For Windows:
mvnw.cmd clean package
mvnw.cmd exec:java -Dexec.args='[command]' -q

# Run with arguments
# https://stackoverflow.com/questions/10108374/maven-how-to-run-a-java-file-from-command-line-passing-arguments
```

## Usage
### Getting help
```bash
./mvnw exec:java -Dexec.args='h' -q
./mvnw exec:java -Dexec.args='help' -q

The Java Farm - a simple command line animals app

Usage:
  ./mvnw exec:java -Dexec.args='[command]' -q

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
Use ./mvnw exec:java -Dexec.args='help' -q for more information about a command.
```

### Creating a new animal
```bash
./mvnw exec:java -Dexec.args='c' -q
./mvnw exec:java -Dexec.args='create' -q

The Java Farm - a simple command line animals app

Command Usage:
  [create  | c]   <name=> <type=>    creates a animal with name

Examples:
  ./mvnw exec:java -Dexec.args='[create  | c] name=my_animal_name' -q
  ./mvnw exec:java -Dexec.args='[create  | c] name=my_animal_name type=pig' -q
```

### Deleting an animal
```bash
./mvnw exec:java -Dexec.args='d' -q
./mvnw exec:java -Dexec.args='delete' -q

The Java Farm - a simple command line animals app

Command Usage:
  [delete  | d]   <name=>        deletes a animal by name

Examples:
  ./mvnw exec:java -Dexec.args='[delete  | d] name=my_animal_name' -q
```

### Searching an animal
```bash
./mvnw exec:java -Dexec.args='s' -q
./mvnw exec:java -Dexec.args='search' -q

The Java Farm - a simple command line animals app

Command Usage:
  [search  | s]   <name=>       searchs a animal by name

Examples:
  ./mvnw exec:java -Dexec.args='[search  | s] name=my_animal_name' -q
```

### Give food to an animal
```bash
./mvnw exec:java -Dexec.args='f' -q
./mvnw exec:java -Dexec.args='food' -q

The Java Farm - a simple command line animals app

Command Usage:
  [food  | f]   <name=>       gives food to a animal by name

Examples:
  ./mvnw exec:java -Dexec.args='[food  | f] name=my_animal_name' -q
```

### Give a shower to an animal
```bash
./mvnw exec:java -Dexec.args='w' -q
./mvnw exec:java -Dexec.args='wash' -q

The Java Farm - a simple command line animals app

Command Usage:
  [wash  | w]   <name=>       gives a shower to a animal by name

Examples:
  ./mvnw exec:java -Dexec.args='[wash  | w] name=my_animal_name' -q
```

### Check if an animal is alive
```bash
./mvnw exec:java -Dexec.args='a' -q
./mvnw exec:java -Dexec.args='alive' -q

The Java Farm - a simple command line animals app

Command Usage:
  [alive  | a]   <name=>       checks if an animal is alive by name

Examples:
  ./mvnw exec:java -Dexec.args='[alive  | a] name=my_animal_name' -q
```

## Pending
- [ ] Document IO and Dates.
- [ ] Improve CLI printing and commands
- [ ] Add a special character when the animal is eating or bathing
- [ ] Add unit tests
