// Package models contains the simple struct and interfaces
// for the representation of a general and specific animals of a farm
package models

// Animal is a simple template to define the basic Animals behaviors.
//
// To implement this interface you just need to define
// the Speak() and GetCharacter() methods
//
// 	 Example:
//		type Example struct{}
//
//		func (e *Example) Speak() string{ return "" }
//		func (e *Example) GetCharacter() string{ return "" }
type Animal interface {
	Speak() string        // Base method, Gives food to the animal. it's implemented in the child classes
	GetCharacter() string // Base method, it return the animal character. it's implemented in the child classes
}
