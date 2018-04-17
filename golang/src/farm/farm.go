/*
	license that can be found in the LICENSE file.

	[author] brayvasq <brayvasq@gmail.com>
	[version] 0.1
	[date] 2018-04-16

	The package Farm contains the simple struct for the representation of a simple farm
*/
package farm

import "fmt"
import "../animals"

/*
	This is a struct that represents a Cow of a simple farm
*/
type Farm struct {
	Name    string
	Address string
	Animals []animals.FarmAnimal
}

/*
	This methods is the constructor of the class and use the parent constructor.

	[param] name is a identifier of the farm.
 	[param] address is a simple phisical direction of the farm.

	the attribute animals contains all animals of the farm.

	[return] a new farm with the values give in the params
*/
func NewFarm(Name string, Address string) Farm {
	farm := Farm{
		Name:    Name,
		Address: Address,
		Animals: make([]animals.FarmAnimal, 0),
	}
	return farm
}

/*
	This Method just show the information of the farm

	[params] nothing

	[return] nothing
*/
func (f *Farm) GetInfo() {
	fmt.Printf("Name : %s - Address : %s\n", f.Name, f.Address)
}

/*
	This method get the number of animals in the list of animals.

	[params] nothing

	[return] lenght of the slice of animals.
*/
func (f *Farm) GetNumberAnimals() int {
	return len(f.Animals)
}
