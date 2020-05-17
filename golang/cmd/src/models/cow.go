// Package models contains the simple struct and interfaces
// for the representation of a general and specific animals of a farm
package models

import (
	"strconv"
	"strings"
	"time"

	"github.com/brayvasq/learn-languages/golang/cmd/src/utils"
)

// Cow contains behaviors and characteristics of a Cow
// It uses composition to use the FarmAnimal properties and behaviors
type Cow struct {
	FarmAnimal
}

// NewCow creates a new Cow instance,
// and setups the specific Cow properties
func NewCow(Name string) Cow {
	cow := Cow{}
	cow.Name = Name
	cow.Age = 0
	cow.LastWash = time.Now()
	cow.LastFood = time.Now()
	cow.Alive = true
	cow.LimitWash = 3
	cow.LimitFood = 3
	cow.Kind = "cow"
	return cow
}

// GetCharacter returns the Cow character.
// This method depends on the IsAlive() method
//
// This method was defined in the interface Animal.
// To implement the interface Animal, we just need to implement all the methods in the interface.
func (c *Cow) GetCharacter() string {
	character := "  (....)  \n"
	character += func() string { // This is an anonimus function
		if c.IsAlive() { // used to emulate a ternary operator
			return "（0 .. 0）"
		} else {
			return "（X .. X）"
		}
	}()
	return character
}

// Speak returns the Cow sound
//
// This method was defined in the interface Animal.
// To implement the interface Animal, we just need to implement all the methods in the interface.
func (c *Cow) Speak() string {
	return "Muuu Muuu!!!"
}

// GetInfo returns the Cow info.
// Show the cow character, all the specific properties
// And show how much time is left to give to the cow a shower or food without it having died
func (c *Cow) GetInfo() string {
	character := c.GetCharacter()
	animal := ""

	animal += strings.Repeat("#", 50) + "\n"
	animal += character + "\n"
	animal += "Name: " + c.Name + "\n"
	animal += "alive: " + strconv.FormatBool(c.Alive) + "\n"
	animal += "Sound: " + c.Speak() + "\n"

	// To show how much time have the Cow until it dies without showering,
	// just show the difference between the LimitWash and the result of
	// the  utils.Dates GetDiffInMinutes method for the LastWash, In that way we can know
	// how much the limit is exceeded
	animal += "Wash time limit: " + strconv.Itoa(int(c.LimitWash-utils.Dates{}.GetDiffInMinutes(c.LastWash))) + "\n"

	// To show how much time have the Cow until it dies without eat,
	// just show the difference between the LimitWash and the result of
	// the  utils.Dates GetDiffInMinutes method for the LastFood, In that way we can know
	// how much the limit is exceeded
	animal += "Food time limit: " + strconv.Itoa(int(c.LimitFood-utils.Dates{}.GetDiffInMinutes(c.LastFood))) + "\n"

	animal += strings.Repeat("#", 50) + "\n"

	return animal
}
