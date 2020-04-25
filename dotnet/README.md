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

## Run project
```bash
dotnet run
```

## Usage
### Getting help
```bash
dotnet run

The DotNET Farm - a simple command line animals app

Usage:
  dotnet run [command] 

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
Use dotnet run help  for more information about a command.
```

### Creating a new animal
```bash
dotnet run create
dotnet run c

The DotNET Farm - a simple command line animals app

Command Usage:
  [create  | c]   <name=> <type=>    creates a animal with name

Examples:
  dotnet run [create  | c] name=my_animal_name 
  dotnet run [create  | c] name=my_animal_name type=pig
```

### Deleting an animal
```bash
dotnet run delete
dotnet run d

The DotNET Farm - a simple command line animals app

Command Usage:
  [delete  | d]   <name=>        deletes a animal by name

Examples:
  dotnet run [delete  | d] name=my_animal_name
```

### Searching an animal
```bash
dotnet run search
dotnet run s

The DotNET Farm - a simple command line animals app

Command Usage:
  [search  | s]   <name=>       searchs a animal by name

Examples:
  dotnet run [search  | s] name=my_animal_name
```

### Give food to an animal
```bash
dotnet run food
dotnet run f

The DotNET Farm - a simple command line animals app

Command Usage:
  [food  | f]   <name=>       gives food to a animal by name

Examples:
  dotnet run [food  | f] name=my_animal_name
```

### Give a shower to an animal
```bash
dotnet run wash
dotnet run w

The DotNET Farm - a simple command line animals app

Command Usage:
  [wash  | w]   <name=>       gives a shower to a animal by name

Examples:
  dotnet run [wash  | w] name=my_animal_name
```

### Check if an animal is alive
```bash
dotnet run alive
dotnet run a

The DotNET Farm - a simple command line animals app

Command Usage:
  [alive  | a]   <name=>       checks if an animal is alive by name

Examples:
  dotnet run [alive  | a] name=my_animal_name
```

## Pending
- [ ] Document IO and Dates.
- [ ] Improve CLI printing and commands
- [ ] Add a special character when the animal is eating or bathing
- [ ] Add unit tests
