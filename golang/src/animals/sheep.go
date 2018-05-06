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
	This is a struct that represents a Sheep of a farm
	inheriting FarmAnimal struct
*/
type Sheep struct {
	FarmAnimal
}

/*
	This methods is the constructor of the class and use the parent constructor.

	[param] id is a identifier of the sheep.
 	[param] name is a name for the sheep.
 	[param] age is an age that is used to determinate if is alive
	[param] weight is used to determinate the price
	[param] price is the simple price of sheep

	the attribute alive is determinate with the param age.

	[return] a new sheep with the values give in the params
*/
func NewSheep(Id int, Name string, Age int, Weight float64, Price float64) Sheep {
	sheep := Sheep{}
	sheep.Id = Id
	sheep.Name = Name
	sheep.Age = Age
	sheep.Weight = Weight
	sheep.Price = Price
	sheep.Alive = func() bool {
		if sheep.Age <= 25 {
			return true
		} else {
			return false
		}
	}()
	return sheep
}

/*
	This is a method that was declared in the interface Animal.
	To implement an interface in Go, we just need to implement all the methods in the interface.

	[params] nothing

	[return] final price based on a simple price and the weight of the animal
*/
func (s *Sheep) CalculatePrice() float64 {
	return s.Price * 2 * float64(s.Age)
}

/*
	This is a method that was declared in the interface Animal.
	To implement an interface in Go, we just need to implement all the methods in the interface.

	This method just show if it is carnivorous or herbivore.

	[params] nothing

	[return] nothing
*/
func (s *Sheep) Eat() {
	fmt.Println("I am a herbivoret")
}

/*
	This is a method that was declared in the interface Animal.
	To implement an interface in Go, we just need to implement all the methods in the interface.

	Just show the characteristic sound of the sheep.

	[params] nothing

	[return] nothing
*/
func (s *Sheep) Speak() {
	fmt.Println("Meeehh!!")
}

/*
	This is a method that was declared in the interface Animal.
	To implement an interface in Go, we just need to implement all the methods in the interface.

	This method just show the life expectancy of the sheep.

	[params] nothing

	[return] nothing
*/
func (s *Sheep) GetLifeExpectancy() {
	fmt.Println("15 years")
}
