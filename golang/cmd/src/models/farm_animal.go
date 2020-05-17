// Package models contains the simple struct and interfaces
// for the representation of a general and specific animals of a farm
package models

import (
	"time"

	"github.com/brayvasq/learn-languages/golang/cmd/src/utils"
)

// FarmAnimal contains behaviors and characteristics of an animal
// also It works as a parent class using composition
type FarmAnimal struct {
	Name      string    // the name of the animal, works as an identifier too
	Age       int32     // the  age of the animal
	LastWash  time.Time // the last time the animal showered
	LastFood  time.Time // the last time the animal ate
	Alive     bool      // represents if the animal is still alive
	LimitWash int32     // limit of minutes in which the animal didn't take a shower
	LimitFood int32     // limit of minutes in which the animal doesn't eat
	Kind      string    // It represents the animal type
}

// Eat gives food to the animal.
// It changes the LastFood attribute and assign the actual date
func (a *FarmAnimal) Eat() {
	a.LastFood = time.Now()
}

// Wash gives the animal a shower
// It changes the LastWash attribute and assign the actual date
func (a *FarmAnimal) Wash() {
	a.LastWash = time.Now()
}

// IsAlive calculates if the animal is still alive.
// Uses the util.Dates IsGreatter method to determinate the difference in minutes
// between the LastWash and LimitFood attributes and their respective limits
//
// If the IsAlive returns false, there is no way to bring the animal back to life
//
// Returns false if one of the limits was exceeded, true otherwise
func (a *FarmAnimal) IsAlive() bool {
	if (utils.Dates{}.IsGreatter(a.LastWash, a.LimitWash)) {
		a.Alive = false
	}

	if (utils.Dates{}.IsGreatter(a.LastFood, a.LimitFood)) {
		a.Alive = false
	}

	return a.Alive
}
