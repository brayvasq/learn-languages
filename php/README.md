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

## Run project
```bash
docker-compose run farm /bin/bash
cd src
php Main.php
```

## Usage
### Getting help
```bash
php Main.php h
php Main.php help

The PHP Farm - a simple command line animals app

Usage:
  php Main.php [command]

Available Commands:
  [list    | l]                      list all available animals
  [create  | c]   <name=> <type=>    create a animal with name
  [delete  | d]   <name=>            delete a animal
  [search  | s]   <name=>            search a animal
  [food    | f]   <name=>            give food to a animal
  [wash    | w]   <name=>            give a shower to a animal
  [alive   | a]   <name=>            show if a animal is alive
  [help    | h]                      help about commands

Flags:
  -v, --version  show the app version

Use php Main.php [command] --help for more information about a command.
```

### Creating a new animal
```bash
php Main.php c
php Main.php create

The PHP Farm - a simple command line animals app

Command Usage:
  [create  | c]   <name=> <type=>    creates a animal with name

Examples:
  php Main.php [create  | c]  name=my_animal_name
  php Main.php [create  | c]  name=my_animal_name type=pig
```

### Deleting an animal
```bash
php Main.php d
php Main.php delete

The PHP Farm - a simple command line animals app

Command Usage:
  [delete  | d]   <name=>        deletes a animal by name

Examples:
  php Main.php [delete  | d]  name=my_animal_name
```

### Searching an animal
```bash
php Main.php s
php Main.php search

The PHP Farm - a simple command line animals app

Command Usage:
  [search  | s]   <name=>       searchs a animal by name

Examples:
  php Main.php [search  | s]  name=my_animal_name
```

### Give food to an animal
```bash
php Main.php f
php Main.php food

The PHP Farm - a simple command line animals app

Command Usage:
  [food  | f]   <name=>       gives food to a animal by name

Examples:
  php Main.php [food  | f]  name=my_animal_name
```

### Give a shower to an animal
```bash
php Main.php w
php Main.php wash

The PHP Farm - a simple command line animals app

Command Usage:
  [wash  | w]   <name=>       gives a shower to a animal by name

Examples:
  php Main.php [wash  | w]  name=my_animal_name
```

### Check if an animal is alive
```bash
php Main.php a
php Main.php alive

The PHP Farm - a simple command line animals app

Command Usage:
  [alive  | a]   <name=>       checks if an animal is alive by name

Examples:
  php Main.php [alive  | a]  name=my_animal_name
```

## Pending
- [ ] Fix DateTimes functionalities (Food, Wash, Alive, etc).
- [ ] Document IO and Dates.
- [ ] Improve CLI printing and commands
- [ ] Add a special character when the animal is eating or bathing
- [ ] Add unit tests
