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

## Run project
```bash
# Clone repo
git clone https://github.com/brayvasq/learn-languages.git
# Create github user golang projects folder
mkdir -p mkdir -p /home/USERNAME/go/src/github.com/USERNAME/
# Move project to the project folder
mv learn-languages /home/USERNAME/go/src/github.com/USERNAME/
# Move to the golang project
cd /home/USERNAME/go/src/github.com/USERNAME/learn-languages/golang
# Run the main file
go run cmd/src/main.go
# Or compile the file
cd cmd/src
go build -o farm
./farm
```

## Usage
### Getting help
```bash
./farm
./farm h
./farm help

The Golang Farm - a simple command line animals app

Usage:
  ./farm [command]

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
Use ./farm help for more information about a command.
```

### Creating a new animal
```bash
./farm c
./farm create

The Go Farm - a simple command line animals app

Command Usage:
  [create  | c]   <name=> <type=>    creates a animal with name

Examples:
  ./farm [create  | c] name=my_animal_name
  ./farm [create  | c] name=my_animal_name type=pig
```

### Deleting an animal
```bash
./farm d
./farm delete

The Go Farm - a simple command line animals app

Command Usage:
  [delete  | d]   <name=>        deletes a animal by name

Examples:
  ./farm [delete  | d] name=my_animal_name
```

### Searching an animal
```bash
./farm s
./farm search

The Go Farm - a simple command line animals app

Command Usage:
  [search  | s]   <name=>       searchs a animal by name

Examples:
  ./farm [search  | s] name=my_animal_name
```

### Give food to an animal
```bash
./farm f
./farm food

The Go Farm - a simple command line animals app

Command Usage:
  [food  | f]   <name=>       gives food to a animal by name

Examples:
  ./farm [food  | f] name=my_animal_name
```

### Give a shower to an animal
```bash
./farm w
./farm wash

The Go Farm - a simple command line animals app

Command Usage:
  [wash  | w]   <name=>       gives a shower to a animal by name

Examples:
  ./farm [wash  | w] name=my_animal_name
```

### Check if an animal is alive
```bash
./farm a
./farm alive

The Go Farm - a simple command line animals app

Command Usage:
  [alive  | a]   <name=>       checks if an animal is alive by name

Examples:
  ./farm [alive  | a] name=my_animal_name
```

## Pending
- [ ] Improve the param receiver to avoid the underscores (_) in names
- [ ] Use interface for create and search animals.
- [ ] Document IO and Dates.
- [ ] Document regex.
- [ ] Improve CLI printing and commands.
- [ ] Add a special character when the animal is eating or bathing.
- [ ] Add unit tests.
