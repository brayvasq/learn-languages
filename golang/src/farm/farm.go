/*
	license that can be found in the LICENSE file.

	[author] brayvasq <brayvasq@gmail.com>
	[version] 0.1
	[date] 2018-04-16

	The package Farm contains the simple struct for the representation of a simple farm
*/
package farm

import (
	"fmt"

	"../animals"
)

/*
	This is a struct that represents a Cow of a simple farm
*/
type Farm struct {
	Name    string
	Address string
	Cows    []animals.Cow
	Pigs    []animals.Pig
	Sheeps  []animals.Sheep
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
		Cows:    make([]animals.Cow, 0),
		Pigs:    make([]animals.Pig, 0),
		Sheeps:  make([]animals.Sheep, 0),
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
	return len(f.Cows) + len(f.Pigs) + len(f.Sheeps)
}

/*
	This method just add a new cow to the list of Cows.

	[param] cow is a cow object that will be added to the list.

	[return] nothing
*/
func (f *Farm) AddCow(cow animals.Cow) {
	f.Cows = append(f.Cows, cow)
}

/*
	This method just add a new pig to the list of Pigs.

	[param] pig is a cow object that will be added to the list.

	[return] nothing
*/
func (f *Farm) AddPig(pig animals.Pig) {
	f.Pigs = append(f.Pigs, pig)
}

/*
	This method just add a new sheep to the list of Sheep.

	[param] sheep is a cow object that will be added to the list.

	[return] nothing
*/
func (f *Farm) AddSheep(sheep animals.Sheep) {
	f.Sheeps = append(f.Sheeps, sheep)
}

/*
	This method delete a specific cow based on a id.

	[param] id of cow to search and delete.

    [return] nothing.
*/
func (f *Farm) DelCow(id int) {
	newSlice := make([]animals.Cow, 0)
	for _, cow := range f.Cows {
		if cow.Id != id {
			newSlice = append(newSlice, cow)
		}
	}
	f.Cows = newSlice
}

/*
	This method delete a specific pig based on a id.

	[param] id of pig to search and delete.

    [return] nothing.
*/
func (f *Farm) DelPig(id int) {
	newSlice := make([]animals.Pig, 0)
	for _, pig := range f.Pigs {
		if pig.Id != id {
			newSlice = append(newSlice, pig)
		}
	}
	f.Pigs = newSlice
}

/*
	This method delete a specific sheep based on a id.

	[param] id of sheep to search and delete.

    [return] nothing.
*/
func (f *Farm) DelSheep(id int) {
	newSlice := make([]animals.Sheep, 0)
	for _, sheep := range f.Sheeps {
		if sheep.Id != id {
			newSlice = append(newSlice, sheep)
		}
	}
	f.Sheeps = newSlice
}

/*
    This method iterate the list of cow for search a specific Cow.

	[param] id is the identifier of the cows to search.

	[return] resp, contain the cow with the searched id
*/
func (f *Farm) SearchCow(id int) animals.Cow {
	var resp animals.Cow
	for _, cow := range f.Cows {
		if cow.Id == id {
			resp = cow
			break
		}
	}
	return resp
}

/*
    This method iterate the list of pigs for search a specific Pig.

	[param] id is the identifier of the pigs to search.

	[return] resp, contain the pig with the searched id
*/
func (f *Farm) SearchPig(id int) animals.Pig {
	var resp animals.Pig
	for _, pig := range f.Pigs {
		if pig.Id == id {
			resp = pig
			break
		}
	}
	return resp
}

/*
    This method iterate the list of sheep for search a specific Pig.

	[param] id is the identifier of the sheep to search.

	[return] resp, contain the sheep with the searched id
*/
func (f *Farm) SearchSheep(id int) animals.Sheep {
	var resp animals.Sheep
	for _, sheep := range f.Sheeps {
		if sheep.Id == id {
			resp = sheep
			break
		}
	}
	return resp
}

/*
	This method iterate the list of animals and show basic info of each animal.

	[params] nothing

	[return] nothing
*/
func (f *Farm) GetAnimalsInfo() {
	for _, cow := range f.Cows {
		fmt.Printf("Id : %v Name : %s\n", cow.Id, cow.Name)
	}

	for _, pig := range f.Pigs {
		fmt.Printf("Id : %v Name : %s\n", pig.Id, pig.Name)
	}

	for _, sheep := range f.Sheeps {
		fmt.Printf("Id : %v Name : %s\n", sheep.Id, sheep.Name)
	}
}

/*
	This method implements the algorithm bubble sort.
    Sort the list of animals based on his price.

	[params] nothing

	[return] nothing
*/
func (f *Farm) SortByPrice() {
	limit := len(f.Cows)
	if limit > 1 {
		for i := 1; i < limit; i++ {
			for j := 0; i < limit-i; j++ {
				if f.Cows[j].Price > f.Cows[j+1].Price {
					aux := f.Cows[j]
					f.Cows[j] = f.Cows[j+1]
					f.Cows[j+1] = aux
				}
			}
		}
	}

	limit = len(f.Pigs)
	if limit > 1 {
		for i := 1; i < limit; i++ {
			for j := 0; i < limit-i; j++ {
				if f.Pigs[j].Price > f.Pigs[j+1].Price {
					aux := f.Pigs[j]
					f.Pigs[j] = f.Pigs[j+1]
					f.Pigs[j+1] = aux
				}
			}
		}
	}

	limit = len(f.Sheeps)
	if limit > 1 {
		for i := 1; i < limit; i++ {
			for j := 0; i < limit-i; j++ {
				if f.Sheeps[j].Price > f.Sheeps[j+1].Price {
					aux := f.Sheeps[j]
					f.Sheeps[j] = f.Sheeps[j+1]
					f.Sheeps[j+1] = aux
				}
			}
		}
	}
}
