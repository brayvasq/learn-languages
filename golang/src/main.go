/*
	license that can be found in the LICENSE file.

	[author] brayvasq <brayvasq@gmail.com>
	[version] 0.1
	[date] 2018-04-16

	This is the principal in to program.
    The main method interact with the user through a inputs.
*/
package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"

	"./animals"
	"./farm"
)

func main() {
	fmt.Println("The Golang Farm ;)")
	option := 0
	reader := bufio.NewReader(os.Stdin)

	message := "1.Add Animal\n" +
		"2.Del Animal\n" +
		"3.Get Info Farm\n" +
		"4.Get number of animals\n" +
		"5.Get Info Animals\n" +
		"6.Search Animal\n" +
		"7.Sort by price\n" +
		"8.Exit\n"

	farm := farm.NewFarm("My Farm", "Av 34")

	for option != 8 {
		fmt.Println(message)
		fmt.Println("Enter Option: ")
		//fmt.Scanln(ln)
		text, _ := reader.ReadString('\n')
		text = strings.Replace(text, "\n", "", -1)
		option, _ = strconv.Atoi(text)

		if option == 1 {
			fmt.Println("Create Animal")
			fmt.Println("Enter Id: ")
			text, _ = reader.ReadString('\n')
			text = strings.Replace(text, "\n", "", -1)
			id, _ := strconv.Atoi(text)
			fmt.Println("Enter Name: ")
			text, _ = reader.ReadString('\n')
			text = strings.Replace(text, "\n", "", -1)
			name := text
			fmt.Println("Enter Age: ")
			text, _ = reader.ReadString('\n')
			text = strings.Replace(text, "\n", "", -1)
			age, _ := strconv.Atoi(text)
			fmt.Println("Enter Weight: ")
			text, _ = reader.ReadString('\n')
			text = strings.Replace(text, "\n", "", -1)
			weight, _ := strconv.ParseFloat(text, 64)
			fmt.Println("Enter Price: ")
			text, _ = reader.ReadString('\n')
			text = strings.Replace(text, "\n", "", -1)
			price, _ := strconv.ParseFloat(text, 64)

			tyeAnimal := "Enter type of animal : \n" +
				"1.Sheep\n" +
				"2.Pig\n" +
				"3.Cow\n"

			fmt.Println(tyeAnimal)
			text, _ = reader.ReadString('\n')
			text = strings.Replace(text, "\n", "", -1)
			option_animal, _ := strconv.Atoi(text)

			if option_animal == 1 {
				sheep := animals.NewSheep(id, name, age, weight, price)
				farm.AddSheep(sheep)
			} else if option_animal == 2 {
				pig := animals.NewPig(id, name, age, weight, price)
				farm.AddPig(pig)
			} else if option_animal == 3 {
				cow := animals.NewCow(id, name, age, weight, price)
				farm.AddCow(cow)
			} else {
				fmt.Println("Error type")
			}
		} else if option == 2 {
			fmt.Println("Enter Id: ")
			text, _ = reader.ReadString('\n')
			text = strings.Replace(text, "\n", "", -1)
			id, _ := strconv.Atoi(text)
			tyeAnimal := "Enter type of animal : \n" +
				"1.Sheep\n" +
				"2.Pig\n" +
				"3.Cow\n"

			fmt.Println(tyeAnimal)
			text, _ = reader.ReadString('\n')
			text = strings.Replace(text, "\n", "", -1)
			option_animal, _ := strconv.Atoi(text)

			if option_animal == 1 {
				farm.DelSheep(id)
			} else if option_animal == 2 {
				farm.DelPig(id)
			} else if option_animal == 3 {
				farm.DelCow(id)
			} else {
				fmt.Println("Error type")
			}
		} else if option == 3 {
			farm.GetInfo()
		} else if option == 4 {
			fmt.Printf("Nuemro animales : %v \n", farm.GetNumberAnimals())
		} else if option == 5 {
			farm.GetAnimalsInfo()
		} else if option == 6 {
			fmt.Println("Enter Id: ")
			text, _ = reader.ReadString('\n')
			text = strings.Replace(text, "\n", "", -1)
			id, _ := strconv.Atoi(text)
			tyeAnimal := "Enter type of animal : \n" +
				"1.Sheep\n" +
				"2.Pig\n" +
				"3.Cow\n"

			fmt.Println(tyeAnimal)
			text, _ = reader.ReadString('\n')
			text = strings.Replace(text, "\n", "", -1)
			option_animal, _ := strconv.Atoi(text)

			if option_animal == 1 {
				sheep := farm.SearchSheep(id)
				sheep.GetInfo()
			} else if option_animal == 2 {
				pig := farm.SearchPig(id)
				pig.GetInfo()
			} else if option_animal == 3 {
				cow := farm.SearchCow(id)
				cow.GetInfo()
			} else {
				fmt.Println("Error type")
			}
		} else if option == 7 {
			farm.SortByPrice()
			farm.GetAnimalsInfo()
		}
	}
}
