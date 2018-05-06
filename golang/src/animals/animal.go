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
	This is a simple interface that contains the basic methods
	that should have the animals of a farm
*/
type Animal interface {
	CalculatePrice() float32
	Eat()
	Speak()
	GetLifeExpectancy()
}

/*
	This is a struct that represents a Animal of a farm. This struct
	simply contains the attributes of a basic Animal and will work like a
	parent class.

	[param] id is a identifier of the animal.
    [param] name is a name for the animal.
    [param] age is an age that is used to determinate if is alive
    [param] weight is used to determinate the price in some cases
	[param] price is the simple price of animal

    The attribute alive is determinate in the child classes
*/
type FarmAnimal struct {
	Id     int
	Name   string
	Age    int
	Weight float64
	Price  float64
	Alive  bool
}

/*
	This method just show all information of the animal

	[params] nothing

	[return] nothing
*/
func (a *FarmAnimal) GetInfo() {
	fmt.Printf("Id : %v \nName : %s \nAge : %v \nWeight : %f \nPrice : %f \nAlive : %t\n", a.Id, a.Name, a.Age, a.Weight, a.Price, a.Alive)
}

func (a *FarmAnimal) Type() string {
	return "Animal"
}
