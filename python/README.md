
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

## Run project
```bash
virtualenv .
./main.py
```

## Usage
### Getting help
```bash
./main.py h
./main.py help

The Python Farm - a simple command line animals app

Usage:
  python main.py [command]

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
  -v, --version  show the app version

Use python main.py [command] --help for more information about a command.
```

### Creating a new animal
```bash
./main.py create
./main.py c

The Python Farm - a simple command line animals app

Command Usage:
  [create  | c]   <name=> <type=>    creates a animal with name

Examples:
  python main.py [create  | c]  name=my_animal_name
  python main.py [create  | c]  name=my_animal_name type=pig
```

### Deleting an animal
```bash
./main.py delete
./main.py d

The Python Farm - a simple command line animals app

Command Usage:
  [delete  | d]   <name=>        deletes a animal by name

Examples:
  python main.py [delete  | d]  name=my_animal_name
```

### Searching an animal
```bash
./main.py search
./main.py s

The Python Farm - a simple command line animals app

Command Usage:
  [search  | s]   <name=>       searchs a animal by name

Examples:
  python main.py [search  | s]  name=my_animal_name
```

### Give food to an animal
```bash
./main.py food
./main.py f

The Python Farm - a simple command line animals app

Command Usage:
  [food  | f]   <name=>       gives food to a animal by name

Examples:
  python main.py [food  | f]  name=my_animal_name
```

### Give a shower to an animal
```bash
./main.py wash
./main.py w

The Python Farm - a simple command line animals app

Command Usage:
  [wash  | w]   <name=>       gives a shower to a animal by name

Examples:
  python main.py [wash  | w]  name=my_animal_name
```

### Check if an animal is alive
```bash
./main.py alive
./main.py a

The Python Farm - a simple command line animals app

Command Usage:
  [alive  | a]   <name=>       checks if an animal is alive by name

Examples:
  python main.py [alive  | a]  name=my_animal_name
```

## Pending
- [ ] Document IO and Dates.
- [ ] Improve CLI printing and commands
- [ ] Add a special character when the animal is eating or bathing
- [ ] Add unit tests
