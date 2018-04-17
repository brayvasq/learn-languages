package main

import (
	"fmt"

	"./animals"

	"./farm"
)

func main() {
	fmt.Println("Hello World!!")
	//animal := animals.FarmAnimal{
	//	Id:     1,
	//	Name:   "Juanito",
	//	Age:    3,
	//	Weight: 2.3,
	//	Price:  12.0,
	//	Alive:  true,
	//}
	//animal.GetInfo()
	cow := animals.NewCow(1, "Juanito", 3, 2.3, 12.0)
	cow.GetInfo()

	farm := farm.NewFarm("The Go Farm", "Cra 1 2-2")
	farm.GetInfo()
}
