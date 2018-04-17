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
	This is a struct that represents a Cow of a farm
	inheriting FarmAnimal struct
*/
type Cow struct {
	FarmAnimal
}

/*
	This methods is the constructor of the class and use the parent constructor.

	[param] id is a identifier of the cow.
 	[param] name is a name for the cow.
 	[param] age is an age that is used to determinate if is alive
	[param] weight is used to determinate the price
	[param] price is the simple price of cow

	the attribute alive is determinate with the param age.

	[return] a new cow with the values give in the params
*/
func NewCow(Id int, Name string, Age int, Weight float32, Price float32) Cow {
	cow := Cow{}
	cow.Id = Id
	cow.Name = Name
	cow.Age = Age
	cow.Weight = Weight
	cow.Price = Price
	cow.Alive = func() bool {
		if cow.Age <= 25 {
			return true
		} else {
			return false
		}
	}()
	return cow
}

/*
	This is a method that was declared in the interface Animal.
	To implement an interface in Go, we just need to implement all the methods in the interface.

	[params] nothing

	[return] final price based on a simple price and the weight of the animal
*/
func (c *Cow) CalculatePrice() float32 {
	return c.Price * 3 * c.Weight
}

/*
	This is a method that was declared in the interface Animal.
	To implement an interface in Go, we just need to implement all the methods in the interface.

	This method just show if it is carnivorous or herbivore.

	[params] nothing

	[return] nothing
*/
func (c *Cow) Eat() {
	fmt.Println("I am a herbivoret")
}

/*
	This is a method that was declared in the interface Animal.
	To implement an interface in Go, we just need to implement all the methods in the interface.

	Just show the characteristic sound of the cow.

	[params] nothing

	[return] nothing
*/
func (c *Cow) Speak() {
	fmt.Println("Muuuu!!")
}

/*
	This is a method that was declared in the interface Animal.
	To implement an interface in Go, we just need to implement all the methods in the interface.

	This method just show the life expectancy of the cow.

	[params] nothing

	[return] nothing
*/
func (c *Cow) GetLifeExpectancy() {
	fmt.Println("25 - 30 years")
}
