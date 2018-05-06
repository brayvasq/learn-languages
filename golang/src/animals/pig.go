/*
	license that can be found in the LICENSE file.

	[author] brayvasq <brayvasq@gmail.com>
	[version] 0.1
	[date] 2018-04-16

	The package Animals contains the simple struct and interfaces
	for the representation of a general and specific animals of a farm
*/
package animals

import "fmt"

/*
	This is a struct that represents a Pig of a farm
	inheriting FarmAnimal struct
*/
type Pig struct {
	FarmAnimal
}

/*
	This methods is the constructor of the class and use the parent constructor.

	[param] id is a identifier of the Pig.
 	[param] name is a name for the Pig.
 	[param] age is an age that is used to determinate if is alive
	[param] weight is used to determinate the price
	[param] price is the simple price of Pig

	the attribute alive is determinate with the param age.

	[return] a new Pig with the values give in the params
*/
func NewPig(Id int, Name string, Age int, Weight float64, Price float64) Pig {
	pig := Pig{}
	pig.Id = Id
	pig.Name = Name
	pig.Age = Age
	pig.Weight = Weight
	pig.Price = Price
	pig.Alive = func() bool {
		if pig.Age <= 25 {
			return true
		} else {
			return false
		}
	}()
	return pig
}

/*
	This is a method that was declared in the interface Animal.
	To implement an interface in Go, we just need to implement all the methods in the interface.

	[params] nothing

	[return] final price based on a simple price and the weight of the animal
*/
func (p *Pig) CalculatePrice() float64 {
	return p.Price * 2 * float64(p.Age)
}

/*
	This is a method that was declared in the interface Animal.
	To implement an interface in Go, we just need to implement all the methods in the interface.

	This method just show if it is carnivorous or herbivore.

	[params] nothing

	[return] nothing
*/
func (p *Pig) Eat() {
	fmt.Println("I am a herbivoret")
}

/*
	This is a method that was declared in the interface Animal.
	To implement an interface in Go, we just need to implement all the methods in the interface.

	Just show the characteristic sound of the Pig.

	[params] nothing

	[return] nothing
*/
func (p *Pig) Speak() {
	fmt.Println("Oig Oig!!")
}

/*
	This is a method that was declared in the interface Animal.
	To implement an interface in Go, we just need to implement all the methods in the interface.

	This method just show the life expectancy of the Pig.

	[params] nothing

	[return] nothing
*/
func (p *Pig) GetLifeExpectancy() {
	fmt.Println("15 years")
}
