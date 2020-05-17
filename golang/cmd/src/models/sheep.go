// Package models contains the simple struct and interfaces
// for the representation of a general and specific animals of a farm
package models

import (
	"strconv"
	"strings"
	"time"

	"github.com/brayvasq/learn-languages/golang/cmd/src/utils"
)

// Sheep contains behaviors and characteristics of a Sheep
// It uses composition to use the FarmAnimal properties and behaviors
type Sheep struct {
	FarmAnimal
}

// NewSheep creates a new Sheep instance,
// and setups the specific Sheep properties
func NewSheep(Name string) Sheep {
	sheep := Sheep{}
	sheep.Name = Name
	sheep.Age = 0
	sheep.LastWash = time.Now()
	sheep.LastFood = time.Now()
	sheep.Alive = true
	sheep.LimitWash = 3
	sheep.LimitFood = 3
	sheep.Kind = "sheep"
	return sheep
}

// GetCharacter returns the Sheep character.
// This method depending on the IsAlive() method
//
// This method was defined in the interface Animal.
// To implement the interface Animal, we just need to implement all the methods in the interface.
func (s *Sheep) GetCharacter() string {
	return func() string { // This is an anonimus function
		if s.IsAlive() { // used to emulate a ternary operator
			return "ᏊㅇꈊㅇᏊ"
		} else {
			return "ᏊXꈊXᏊ"
		}
	}()
}

// Speak returns the Sheep sound
//
// This method was defined in the interface Animal.
// To implement the interface Animal, we just need to implement all the methods in the interface.
func (s *Sheep) Speak() string {
	return "Oink Oink!!!"
}

// GetInfo returns the Sheep info.
// Show the cow character, all the specific properties
// And show how much time is left to give to the cow a shower or food without it having died
func (s *Sheep) GetInfo() string {
	character := s.GetCharacter()
	animal := ""

	animal += strings.Repeat("#", 50) + "\n"
	animal += character + "\n"
	animal += "Name: " + s.Name + "\n"
	animal += "alive: " + strconv.FormatBool(s.IsAlive()) + "\n"
	animal += "Sound: " + s.Speak() + "\n"

	// To show how much time have the Sheep until it dies without showering,
	// just show the difference between the LimitWash and the result of
	// the  utils.Dates GetDiffInMinutes method for the LastWash, In that way we can know
	// how much the limit is exceeded
	animal += "Wash time limit: " + strconv.Itoa(int(s.LimitWash-utils.Dates{}.GetDiffInMinutes(s.LastWash))) + "\n"

	// To show how much time have the Sheep until it dies without eat,
	// just show the difference between the LimitWash and the result of
	// the  utils.Dates GetDiffInMinutes method for the LastFood, In that way we can know
	// how much the limit is exceeded
	animal += "Food time limit: " + strconv.Itoa(int(s.LimitFood-utils.Dates{}.GetDiffInMinutes(s.LastFood))) + "\n"
	animal += strings.Repeat("#", 50) + "\n"

	return animal
}
