// Package cli provides to the user a way to interact with the app.
// It uses os.Args to receive the user input an process it.
package cli

import (
	"fmt"

	"github.com/brayvasq/learn-languages/golang/cmd/src/db"
)

// Farm works as a kind of controller
// It process the animals methods for each kind of animal
// in a generic way.
//
// It uses the db package to interact with the persited data.
type Farm struct {
	Store db.Store // The object that will help to operate with persited data
}

// NewFarm creates a new Farm instance,
// and setups the specific Farm properties.
//
// It Load the persisted data, to be able to use the db.Store
// to interact with these data.
func NewFarm() Farm {
	farm := Farm{}
	farm.Store = db.NewStore()
	farm.Store.Load()
	return farm
}

// ListAnimals lists all the animals stored.
// It iterates each array of animals to print the data using the GetInfo() method
func (f *Farm) ListAnimals() {
	for _, cow := range f.Store.Cows {
		fmt.Println(cow.GetInfo())
	}

	for _, pig := range f.Store.Pigs {
		fmt.Println(pig.GetInfo())
	}

	for _, sheep := range f.Store.Sheeps {
		fmt.Println(sheep.GetInfo())
	}
}

// CreateAnimal uses the Store to create a new animal.
// It uses the db.Store.Add method, that works as a kind of factory.
//
// It returns true if the animal was created successfully, false otherwise
func (f *Farm) CreateAnimal(name string, animalType string) bool {
	return f.Store.Add(name, animalType)
}

// DeleteAnimal uses the Store to remove an animal.
//
// It returns true if the animal was deleted successfully, false otherwise
func (f *Farm) DeleteAnimal(name string) bool {
	return f.Store.Remove(name)
}

// Search searchs an animal by name and prints the animal info.
// It uses the individual Searchs methods to iterate each array.
//
// It prints the info of the animal using the GetInfo() method, if the animal was found.
func (f *Farm) Search(name string) {
	found := false

	// Iterates each element of the cows array
	cow := f.Store.FindCow(name)

	// If a cow was found, it prints the cow info
	// using his pointer.
	if cow != nil {
		found = true
		fmt.Println((*cow).GetInfo())
	}

	// If an animal doesn't found yet
	if !found {
		// Iterates each element of the pigs array
		pig := f.Store.FindPig(name)

		// If a pig was found, it prints the pig info
		// using his pointer.
		if pig != nil {
			found = true
			fmt.Println((*pig).GetInfo())
		}
	}

	// If an animal doesn't found yet
	if !found {
		// Iterates each element of the sheeps array
		sheep := f.Store.FindSheep(name)

		// If a sheep was found, it prints the sheep info
		// using his pointer.
		if sheep != nil {
			found = true
			fmt.Println((*sheep).GetInfo())
		}
	}

	if !found {
		fmt.Println("Animal not found")
	}
}

// Food gives food to an animal calling the Eat() method
// It uses the individual Searchs methods to iterate each array.
//
// It uses the Eat() method to change the last time the animal ate
func (f *Farm) Food(name string) {
	found := false

	// Iterates each element of the cows array
	cow := f.Store.FindCow(name)

	// If a cow was found, it gives food to the cow
	// using his pointer.
	if cow != nil {
		found = true
		(*cow).Eat()
		f.Store.Save()
	}

	// If an animal doesn't found yet
	if !found {
		// Iterates each element of the pig array
		pig := f.Store.FindPig(name)

		// If a pig was found, it gives food to the pig
		// using his pointer.
		if pig != nil {
			found = true
			(*pig).Eat()
			f.Store.Save()
		}
	}

	// If an animal doesn't found yet
	if !found {
		// Iterates each element of the sheeps array
		sheep := f.Store.FindSheep(name)

		// If a sheep was found, it gives food to the sheep
		// using his pointer.
		if sheep != nil {
			found = true
			(*sheep).Eat()
			f.Store.Save()
		}
	}

	if !found {
		fmt.Println("Animal not found")
	}
}

// Wash gives a shower to an animal calling the Wash() method
// It uses the individual Searchs methods to iterate each array.
//
// It uses the Wash() method to change the last time the animal was showered
func (f *Farm) Wash(name string) {
	found := false

	// Iterates each element of the cows array
	cow := f.Store.FindCow(name)

	// If a cow was found, it gives a shower to the cow
	// using his pointer.
	if cow != nil {
		found = true
		(*cow).Wash()
		f.Store.Save()
	}

	// If an animal doesn't found yet
	if !found {
		// Iterates each element of the pig array
		pig := f.Store.FindPig(name)

		// If a pig was found, it gives a shower to the pig
		// using his pointer.
		if pig != nil {
			found = true
			(*pig).Wash()
			f.Store.Save()
		}
	}

	// If an animal doesn't found yet
	if !found {
		// Iterates each element of the sheeps array
		sheep := f.Store.FindSheep(name)

		// If a sheep was found, it gives a shower to the sheep
		// using his pointer.
		if sheep != nil {
			found = true
			(*sheep).Wash()
			f.Store.Save()
		}
	}

	if !found {
		fmt.Println("Animal not found")
	}
}

// Alive shows if an animal is still alive
// It uses the individual Searchs methods to iterate each array.
//
// It uses the IsAlive() method to check if the animal is alive
func (f *Farm) Alive(name string) {
	found := false

	// Iterates each element of the cows array
	cow := f.Store.FindCow(name)

	// If a cow was found, it prints if is alive
	// using his pointer.
	if cow != nil {
		found = true
		fmt.Println((*cow).IsAlive())
	}

	// If an animal doesn't found yet
	if !found {
		// Iterates each element of the pigs array
		pig := f.Store.FindPig(name)

		// If a pig was found, it prints if is alive
		// using his pointer.
		if pig != nil {
			found = true
			fmt.Println((*pig).IsAlive())
		}
	}

	// If an animal doesn't found yet
	if !found {
		// Iterates each element of the sheeps array
		sheep := f.Store.FindSheep(name)

		// If a sheep was found, it prints if is alive
		// using his pointer.
		if sheep != nil {
			found = true
			fmt.Println((*sheep).IsAlive())
		}
	}

	if !found {
		fmt.Println("Animal not found")
	}
}
