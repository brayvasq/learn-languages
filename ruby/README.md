# Ruby Farm

Ruby example implementation of a little farm game.

| Language | Version        | SO                |
| -------- | -------------- | ----------------- |
| Ruby     | ruby 2.6.3p62  | Ubuntu 18.04.1    |

## Documentation

| Type          | Link                                           |
| ------------- | ---------------------------------------------- |
| Learn Ruby    | https://ruby-doc.org/                          |
| Tutorial      | https://bundler.io/guides/creating_gem.html    |
| Unit tests    | https://rspec.info/                            |

## Installation

Add this line to your application's Gemfile:

```ruby
gem 'ruby'
```

And then execute:

    $ bundle

Or install it yourself as:

    $ gem install ruby

Or clone the repo and run manually
    $ git clone https://github.com/brayvasq/learn-languages.git
    $ cd learn-languages/ruby
    $ bin/run

## Usage
### Getting help
```bash
bin/run h
bin/run help

The Ruby Farm - a simple command line animals app

Usage:
  bin/run [command]

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

Use bin/run [command] --help for more information about a command.
```
### Creating a new animal
```bash
bin/run c
bin/run create

The Ruby Farm - a simple command line animals app

Command Usage:
  [create  | c]   <name=> <type=>    creates a animal with name

Examples:
  bin/run [create  | c]  name=my_animal_name
  bin/run [create  | c]  name=my_animal_name type=pig
```

### Deleting an animal
```bash
bin/run d
bin/run delete

The Ruby Farm - a simple command line animals app

Command Usage:
  [delete  | d]   <name=>        deletes a animal by name

Examples:
  bin/run [delete  | d]  name=my_animal_name
```

### Searching an animal
```bash
bin/run s
bin/run search

The Ruby Farm - a simple command line animals app

Command Usage:
  [search  | s]   <name=>       searchs a animal by name

Examples:
  bin/run [search  | s]  name=my_animal_name
```

### Give food to an animal
```bash
bin/run f
bin/run food

The Ruby Farm - a simple command line animals app

Command Usage:
  [food  | f]   <name=>       gives food to a animal by name

Examples:
  bin/run [food  | f]  name=my_animal_name
```

### Give a shower to an animal
```bash
bin/run w
bin/run wash

The Ruby Farm - a simple command line animals app

Command Usage:
  [wash  | w]   <name=>       gives a shower to a animal by name

Examples:
  bin/run [wash  | w]  name=my_animal_name
```

### Check if an animal is alive
```bash
bin/run a
bin/run alive

The Ruby Farm - a simple command line animals app

Command Usage:
  [alive  | a]   <name=>       checks if an animal is alive by name

Examples:
  bin/run [alive  | a]  name=my_animal_name
```

## Development

After checking out the repo, run `bin/setup` to install dependencies. Then, run `rake spec` to run the tests. You can also run `bin/console` for an interactive prompt that will allow you to experiment.

To install this gem onto your local machine, run `bundle exec rake install`. To release a new version, update the version number in `version.rb`, and then run `bundle exec rake release`, which will create a git tag for the version, push git commits and tags, and push the `.gem` file to [rubygems.org](https://rubygems.org).

## Contributing

Bug reports and pull requests are welcome on GitHub at https://github.com/brayvasq/learn-languages.

## License

The gem is available as open source under the terms of the [MIT License](https://opensource.org/licenses/MIT).
