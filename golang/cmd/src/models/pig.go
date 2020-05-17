// Package models contains the simple struct and interfaces
// for the representation of a general and specific animals of a farm
package models

import (
	"strconv"
	"strings"
	"time"

	"github.com/brayvasq/learn-languages/golang/cmd/src/utils"
)

// Pig contains behaviors and characteristics of a Pig
// It uses composition to use the FarmAnimal properties and behaviors
type Pig struct {
	FarmAnimal
}

// NewPig creates a new Pig instance,
// and setups the specific Pig properties
func NewPig(Name string) Pig {
	pig := Pig{}
	pig.Name = Name
	pig.Age = 0
	pig.LastWash = time.Now()
	pig.LastFood = time.Now()
	pig.Alive = true
	pig.LimitWash = 3
	pig.LimitFood = 3
	pig.Kind = "pig"
	return pig
}

// GetCharacter returns the Pig character.
// This method depending on the IsAlive() method
//
// This method was defined in the interface Animal.
// To implement the interface Animal, we just need to implement all the methods in the interface.
func (p *Pig) GetCharacter() string {
	return func() string { // This is an anonimus function
		if p.IsAlive() { // used to emulate a ternary operator
			return "（`（●●）´）"
		} else {
			return "（x（●●）x）"
		}
	}()
}

// Speak returns the Pig sound
//
// This method was defined in the interface Animal.
// To implement the interface Animal, we just need to implement all the methods in the interface.
func (p *Pig) Speak() string {
	return "Oink Oink!!!"
}

// GetInfo returns the Pig info.
// Show the cow character, all the specific properties
// And show how much time is left to give to the cow a shower or food without it having died
func (p *Pig) GetInfo() string {
	character := p.GetCharacter()
	animal := ""

	animal += strings.Repeat("#", 50) + "\n"
	animal += character + "\n"
	animal += "Name: " + p.Name + "\n"
	animal += "alive: " + strconv.FormatBool(p.Alive) + "\n"
	animal += "Sound: " + p.Speak() + "\n"

	// To show how much time have the Pig until it dies without showering,
	// just show the difference between the LimitWash and the result of
	// the  utils.Dates GetDiffInMinutes method for the LastWash, In that way we can know
	// how much the limit is exceeded
	animal += "Wash time limit: " + strconv.Itoa(int(p.LimitWash-utils.Dates{}.GetDiffInMinutes(p.LastWash))) + "\n"

	// To show how much time have the Pig until it dies without eat,
	// just show the difference between the LimitWash and the result of
	// the  utils.Dates GetDiffInMinutes method for the LastFood, In that way we can know
	// how much the limit is exceeded
	animal += "Food time limit: " + strconv.Itoa(int(p.LimitFood-utils.Dates{}.GetDiffInMinutes(p.LastFood))) + "\n"

	animal += strings.Repeat("#", 50) + "\n"

	return animal
}
