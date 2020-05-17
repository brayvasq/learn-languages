// Package db provides a way to persist data
// this package uses different methods and tools to permit data persistance
package db

import (
	"encoding/json"
	"io/ioutil"
	"log"

	"github.com/brayvasq/learn-languages/golang/cmd/src/models"
)

// Store is an useful struct that allow us
// to operate over files
// It help us with the data persistence, using the JSON format.
type Store struct {
	CowsPath   string
	PigsPath   string
	SheepsPath string
	Cows       []models.Cow
	Pigs       []models.Pig
	Sheeps     []models.Sheep
}

// NewStore creates a new Store instance,
// and setups the specific Store properties.
//
// It defines a different .json file for each kind of Animal.
// Also, It defines a different array for each kind of Animal,
// it's because Go doesn't supports Generic types
func NewStore() Store {
	store := Store{
		CowsPath:   "cows.json",             // File path where the Cows will be persisted
		PigsPath:   "pigs.json",             // File path where the Pigs will be persisted
		SheepsPath: "sheeps.json",           // File path where the Sheeps will be persisted
		Cows:       make([]models.Cow, 0),   // Array that contains all the Cows
		Pigs:       make([]models.Pig, 0),   // Array that contains all the Pigs
		Sheeps:     make([]models.Sheep, 0), // Array that contains all the Sheeps
	}

	return store
}

// Load method read the animals files and load the json data into
// the respective array of structs.
//
// It performs the process to read and load the data for each kind of animal
//
// It returns true if all the data was loaded, false otherwise
func (s *Store) Load() bool {
	// It reads the cows content stored int he CowsPath file
	byteValue, err := ioutil.ReadFile(s.CowsPath)

	// If an error occurred
	// It returns false and skip to load the data for the another kinds of animal
	if err != nil {
		log.Fatal(err)
		return false
	}

	// json.Unmarshal allow us to load the data read
	// into a struct or object.
	// It maps the data and setup the respective cow objects
	json.Unmarshal(byteValue, &(s.Cows))

	// It reads the pigs content stored int he PigsPath file
	byteValue, err = ioutil.ReadFile(s.PigsPath)

	// If an error occurred
	// It returns false and skip to load the data for the another kinds of animal
	if err != nil {
		log.Fatal(err)
		return false
	}

	// json.Unmarshal allow us to load the data read
	// into a struct or object.
	// It maps the data and setup the respective pig objects
	json.Unmarshal(byteValue, &(s.Pigs))

	// It reads the sheeps content stored int he SheepsPath file
	byteValue, err = ioutil.ReadFile(s.SheepsPath)

	// If an error occurred
	// It returns false and skip to load the data for the another kinds of animal
	if err != nil {
		log.Fatal(err)
		return false
	}

	// json.Unmarshal allow us to load the data read
	// into a struct or object.
	// It maps the data and setup the respective sheep objects
	json.Unmarshal(byteValue, &(s.Sheeps))

	return true
}

// FindCow search by name an specific Cow in the Cows array.
// It iterates the Cow array until the specific name is found.
//
// It returns the pointer of the Cow, thats because some
// operations can be performed over this Object, and we
// need to store the updated Cow
//
// NOTE: This method exists because, in Go we cannot use generics
// to return any kind of Object
func (s *Store) FindCow(name string) *models.Cow {
	var resp *models.Cow

	for i := 0; i < len(s.Cows); i++ {
		if s.Cows[i].Name == name {
			resp = &(s.Cows[i])
			break
		}
	}

	return resp
}

// FindPig search by name an specific Pig in the Pigs array.
// It iterates the Pig array until the specific name is found.
//
// It returns the pointer of the Pig, thats because some
// operations can be performed over this Object, and we
// need to store the updated Pig
//
// NOTE: This method exists because, in Go we cannot use generics
// to return any kind of Object
func (s *Store) FindPig(name string) *models.Pig {
	var resp *models.Pig

	for i := 0; i < len(s.Pigs); i++ {
		if s.Pigs[i].Name == name {
			resp = &(s.Pigs[i])
			break
		}
	}

	return resp
}

// FindSheep search by name an specific Sheep in the Sheeps array.
// It iterates the Sheep array until the specific name is found.
//
// It returns the pointer of the Sheep, thats because some
// operations can be performed over this Object, and we
// need to store the updated Sheep
//
// NOTE: This method exists because, in Go we cannot use generics
// to return any kind of Object
func (s *Store) FindSheep(name string) *models.Sheep {
	var resp *models.Sheep

	for i := 0; i < len(s.Sheeps); i++ {
		if s.Sheeps[i].Name == name {
			resp = &(s.Sheeps[i])
			break
		}
	}

	return resp
}

// Remove searchs an animal by name and remove it of the respective Array
//
// It iterates each animal arrays.
// To remove an element of an array, we have to create another array
// without including the element to remove
//
// It returns true if the animal was deleted successfully, false otherwise
func (s *Store) Remove(name string) bool {
	deleted := false

	// This is a temp cows array that will contain the new elements
	newCows := make([]models.Cow, 0)

	// Iterates all the Cows array
	// and adds the elements that doesn't match with the name.
	for _, cow := range s.Cows {
		if cow.Name != name {
			newCows = append(newCows, cow)
		} else {
			deleted = true
		}
	}

	// Reassigns the Cows array without the element to remove
	s.Cows = newCows

	// This is a temp pigs array that will contain the new elements
	newPigs := make([]models.Pig, 0)

	// Iterates all the Pigs array
	// and adds the elements that doesn't match with the name.
	for _, pig := range s.Pigs {
		if pig.Name != name {
			newPigs = append(newPigs, pig)
		} else {
			deleted = true
		}
	}

	// Reassigns the Pigs array without the element to remove
	s.Pigs = newPigs

	// This is a temp sheeps array that will contain the new elements
	newSheeps := make([]models.Sheep, 0)

	// Iterates all the Sheeps array
	// and adds the elements that doesn't match with the name.
	for _, sheep := range s.Sheeps {
		if sheep.Name != name {
			newSheeps = append(newSheeps, sheep)
		} else {
			deleted = true
		}
	}

	// Reassigns the Sheeps array without the element to remove
	s.Sheeps = newSheeps

	// If elements were deleted
	// It Saves the arrays data in their respective json files, to update the arrays state
	if deleted {
		deleted = s.Save()
	}

	return deleted
}

// Add a new animal object depending of the type of animal.
// It works as a kind of factory. However, we cannot create a
// factory per se, because Go doesn't supports Generics.
// Also in that way we avoid to have cyclic imports
//
// It returns true if the animal was saved successfully
func (s *Store) Add(name string, animalType string) bool {
	if animalType == "cow" {
		cow := models.NewCow(name)
		s.Cows = append(s.Cows, cow)
	} else if animalType == "pig" {
		pig := models.NewPig(name)
		s.Pigs = append(s.Pigs, pig)
	} else if animalType == "sheep" {
		sheep := models.NewSheep(name)
		s.Sheeps = append(s.Sheeps, sheep)
	}

	return s.Save()
}

// Save parses each animal array into json data and store them in their respective file
// It performs the same action for each kind of animal, because we have separated arrays.
//
// It returns true if the data was saved successfully
func (s *Store) Save() bool {
	// Parsing the Cows array to binnary content
	cows, _ := json.MarshalIndent(s.Cows, "", " ")

	// Parsing the Pigs array to binnary content
	pigs, _ := json.MarshalIndent(s.Pigs, "", " ")

	// Parsing the Sheeps array to binnary content
	sheeps, _ := json.MarshalIndent(s.Sheeps, "", " ")

	// Creates if doesn't exists and write the CowsPath file
	// with the binary cows content and in read mode.
	err := ioutil.WriteFile(s.CowsPath, cows, 0644)

	// If an error occurred
	// It returns false and skip to save the data for the another kinds of animal
	if err != nil {
		log.Fatal(err)
		return false
	}

	// Creates if doesn't exists and write the PigsPath file
	// with the binary pigs content and in read mode.
	err = ioutil.WriteFile(s.PigsPath, pigs, 0644)

	// If an error occurred
	// It returns false and skip to save the data for the another kinds of animal
	if err != nil {
		log.Fatal(err)
		return false
	}

	// Creates if doesn't exists and write the SheepsPath file
	// with the binary pigs content and in read mode.
	err = ioutil.WriteFile(s.SheepsPath, sheeps, 0644)

	// If an error occurred
	// It returns false and skip to save the data for the another kinds of animal
	if err != nil {
		log.Fatal(err)
		return false
	}

	return true
}
