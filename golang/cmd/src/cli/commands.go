// Package cli provides to the user a way to interact with the app.
// It uses os.Args to receive the user input an process it.
package cli

import (
	"fmt"
	"regexp"
	"strings"
)

// Commands works as a kind of UI
// It process the user input and route it to the respective Farm action
type Commands struct {
	App  Farm     // The app that will handle the actions
	Data []string // Input array taken from os.Args
}

// NewCommands creates a new Commands instance,
// and setups the specific Farm properties.
//
// It assigns the input data to work with it.
func NewCommands(data []string) Commands {
	commands := Commands{}
	commands.App = NewFarm()
	commands.Data = data

	return commands
}

// Process Obtains the command and process the input data.
// If no command is given it show the Help, otherwise
// it uses the VerifyCommand to route the actions
func (c *Commands) Process() {
	command := c.GetCommand()

	if command != nil {
		c.VerifyCommand(*command)
	} else {
		c.Help()
	}
}

// GetCommand returns the main command,
// That tells what action will be performed
//
// It returns the main command, or nil if not command was given
func (c *Commands) GetCommand() *string {
	if len(c.Data) > 1 {
		return &(c.Data[1])
	} else {
		return nil
	}
}

// VerifyCommand takes the main command, identifies the specific action to execute
// and call the respective action.
//
// It uses the Contains custom method, to identify what action to execute. Also,
// it give the names to the commands.
//
// The param command is obtained from the GetCommand method
func (c *Commands) VerifyCommand(command string) {
	if c.Contains([]string{"list", "l"}, command) {
		c.ListCommand()
	} else if c.Contains([]string{"create", "c"}, command) {
		if c.CreateCommand() {
			c.ListCommand()
		}
	} else if c.Contains([]string{"delete", "d"}, command) {
		if c.DeleteCommand() {
			c.ListCommand()
		}
	} else if c.Contains([]string{"search", "s"}, command) {
		c.SearchCommand()
	} else if c.Contains([]string{"food", "f"}, command) {
		c.FoodCommand()
	} else if c.Contains([]string{"wash", "w"}, command) {
		c.WashCommand()
	} else if c.Contains([]string{"alive", "a"}, command) {
		c.AliveCommand()
	} else if c.Contains([]string{"help", "h"}, command) {
		c.Help()
	} else {
		c.Help()
	}
}

// ListCommand process the [list | l] command
func (c *Commands) ListCommand() {
	c.App.ListAnimals()
}

// CreateCommand process the [create | c] command
// It uses the GetParam methods to identify the user input
// and call the respective Farm action
//
// It return true if the animal was created, false otherwise
func (c *Commands) CreateCommand() bool {
	created := false
	name := c.GetParam("name=", "([a-zA-Z]+)")
	animalType := c.GetParam("type=", "([a-zA-Z]+)")

	if name != nil {
		if animalType == nil {
			// An auxiliar variable is created because
			// the GetParam method returns nil if doesn't find a match
			// and we cannot assign a string o a nil pointer
			defaultType := "cow"
			animalType = &defaultType
		}

		created = c.App.CreateAnimal(*name, *animalType)
	} else {
		fmt.Println("Error!: A name is required to create an animal")
		c.CreateCommandHelp()
	}

	return created
}

// DeleteCommand process the [delete | c] command
// It uses the GetParam methods to identify the user input
// and call the respective Farm action
//
// It return true if the animal was deleted, false otherwise
func (c *Commands) DeleteCommand() bool {
	deleted := false
	name := c.GetParam("name=", "([a-zA-Z]+)")

	if name != nil {
		deleted = c.App.DeleteAnimal(*name)
	} else {
		fmt.Println("Error!: A name is required to delete a animal")
		c.DeleteCommandHelp()
	}

	return deleted
}

// SearchCommand process the [search | s] command
// It uses the GetParam methods to identify the user input
// and call the respective Farm action
func (c *Commands) SearchCommand() {
	name := c.GetParam("name=", "([a-zA-Z]+)")

	if name != nil {
		c.App.Search(*name)
	} else {
		fmt.Println("Error!: A name is required to search a animal")
		c.SearchCommandHelp()
	}
}

// FoodCommand process the [food | f] command
// It uses the GetParam methods to identify the user input
// and call the respective Farm action
func (c *Commands) FoodCommand() {
	name := c.GetParam("name=", "([a-zA-Z]+)")

	if name != nil {
		c.App.Food(*name)
	} else {
		fmt.Println("Error!: A name is required to give food to a animal")
		c.FoodCommandHelp()
	}
}

// WashCommand process the [wash | w] command
// It uses the GetParam methods to identify the user input
// and call the respective Farm action
func (c *Commands) WashCommand() {
	name := c.GetParam("name=", "([a-zA-Z]+)")

	if name != nil {
		c.App.Wash(*name)
	} else {
		fmt.Println("Error!: A name is required to give a shower to a animal")
		c.WashCommandHelp()
	}
}

// AliveCommand process the [alive | a] command
// It uses the GetParam methods to identify the user input
// and call the respective Farm action
func (c *Commands) AliveCommand() {
	name := c.GetParam("name=", "([a-zA-Z]+)")

	if name != nil {
		c.App.Alive(*name)
	} else {
		fmt.Println("Error!: A name is required to show if a animal is alive")
		c.AliveCommandHelp()
	}
}

// GetParam returns the queried param using regex patterns
// It joins the input data into a string and applies a regex pattern
//
// The param value is the variable name to search
// The param dataType is the variable pattern equivalent
//
// It returns a pointer of the string if a match was found, nil otherwise
//   Examples:
//	    data := []string{"name=jay", "age=10"}
//
//		value := GetParam("name=", "([a-zA-Z]+)")
//		fmt.Println(*value)
//		  => "jay"
//
//		value := GetParam("age=", "(\\d+)")
//		fmt.Println(*value)
//		  => 10
//
//		value := GetParam("type=", "([a-zA-Z]+)")
//		fmt.Println(*value)
//		  => nil
func (c *Commands) GetParam(value string, dataType string) *string {
	data := strings.Join(c.Data[1:], ";")

	r, _ := regexp.Compile(value + dataType)
	result := r.FindString(data)

	if result == "" {
		return nil
	}

	result = strings.ReplaceAll(result, value, "")

	if result == "" {
		return nil
	}

	return &result
}

// CreateCommandHelp shows help for the [create | c] command
func (c *Commands) CreateCommandHelp() {
	fmt.Println("The Go Farm - a simple command line animals app")
	fmt.Println()
	fmt.Println("Command Usage:")
	fmt.Println("  [create  | c]   <name=> <type=>    creates a animal with name")
	fmt.Println("")
	fmt.Println("Examples:")
	fmt.Println("  ./farm [create  | c] name=my_animal_name")
	fmt.Println("  ./farm [create  | c] name=my_animal_name type=pig")
}

// DeleteCommandHelp shows help for the [delete | c] command
func (c *Commands) DeleteCommandHelp() {
	fmt.Println("The Go Farm - a simple command line animals app")
	fmt.Println()
	fmt.Println("Command Usage:")
	fmt.Println("  [delete  | d]   <name=>        deletes a animal by name")
	fmt.Println("")
	fmt.Println("Examples:")
	fmt.Println("  ./farm [delete  | d] name=my_animal_name")
}

// SearchCommandHelp shows help for the [search | s] command
func (c *Commands) SearchCommandHelp() {
	fmt.Println("The Go Farm - a simple command line animals app")
	fmt.Println()
	fmt.Println("Command Usage:")
	fmt.Println("  [search  | s]   <name=>       searchs a animal by name")
	fmt.Println("")
	fmt.Println("Examples:")
	fmt.Println("  ./farm [search  | s] name=my_animal_name")
}

// FoodCommandHelp shows help for the [food | f] command
func (c *Commands) FoodCommandHelp() {
	fmt.Println("The Go Farm - a simple command line animals app")
	fmt.Println()
	fmt.Println("Command Usage:")
	fmt.Println("  [food  | f]   <name=>       gives food to a animal by name")
	fmt.Println("")
	fmt.Println("Examples:")
	fmt.Println("  ./farm [food  | f] name=my_animal_name")
}

// WashCommandHelp shows help for the [wash | w] command
func (c *Commands) WashCommandHelp() {
	fmt.Println("The Go Farm - a simple command line animals app")
	fmt.Println()
	fmt.Println("Command Usage:")
	fmt.Println("  [wash  | w]   <name=>       gives a shower to a animal by name")
	fmt.Println("")
	fmt.Println("Examples:")
	fmt.Println("  ./farm [wash  | w] name=my_animal_name")
}

// AliveCommandHelp shows help for the [alive | a] command
func (c *Commands) AliveCommandHelp() {
	fmt.Println("The Go Farm - a simple command line animals app")
	fmt.Println()
	fmt.Println("Command Usage:")
	fmt.Println("  [alive  | a]   <name=>       checks if an animal is alive by name")
	fmt.Println("")
	fmt.Println("Examples:")
	fmt.Println("  ./farm [alive  | a] name=my_animal_name")
}

// Help shows help for the app
func (c *Commands) Help() {
	fmt.Println("The Golang Farm - a simple command line animals app")
	fmt.Println("")
	fmt.Println("Usage:")
	fmt.Println("  ./farm [command]")
	fmt.Println("")
	fmt.Println("Available Commands:")
	fmt.Println("  [list    | l]                      list all available animals")
	fmt.Println("  [create  | c]   <name=> <type=>    create a animal with name")
	fmt.Println("  [delete  | d]   <name=>            delete a animal")
	fmt.Println("  [search  | s]   <name=>            search a animal")
	fmt.Println("  [food    | f]   <name=>            give food to a animal")
	fmt.Println("  [wash    | w]   <name=>            give a shower to a animal")
	fmt.Println("  [alive   | a]   <name=>            show if a animal is alive")
	fmt.Println("  [help    | h]                      help about commands")
	fmt.Println("")
	fmt.Println("Flags:")
	fmt.Println("Use ./farm help for more information about a command.")
}

// Contains determine if an array of string contains a specific element.
//
// The param array is the array of string to check if contains an element
// The param value is the element to search
//
// It returns true if the array contains the element, false otherwise
func (c *Commands) Contains(array []string, value string) bool {
	found := false
	for _, val := range array {
		if val == value {
			found = true
			break
		}
	}

	return found
}
