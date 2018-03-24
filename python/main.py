from animals.sheep import Sheep
from animals.pig import Pig
from animals.cow import Cow
from farm.farm import Farm

if __name__ == "__main__":
    print("The Python Farm")
    
    option = 0
    message = """
                1.Add Animal\n
                2.Del Animal\n
                3.Get Info Farm\n
                4.Get number of animals\n
                5.Get Info Animals\n
                6.Search Animal\n
                7.Get total Price\n
                8.Sort by price\n
                9.Sort by age\n
                10.Exit\n"""
    
    farm = Farm("My Farm","Av 34")
    
    while option!=10:
        print(message)
        option = int(input("Ingrese Opcion :"))
        
        if option == 1:
            print("\n\n Create Animal : \n")
            
            id = input("Id : ")
            name = input("Name : ")
            age = int(input("Age : "))
            weight = float(input("Weight : "))
            price = float(input("Price : "))
            
            type_animal = """Enter type of animal : \n
                          1.Sheep\n
                          2.Pig\n
                          3.Cow\n"""
            option_animal = int(input(type_animal))
            
            if option_animal == 1:
                animal = Sheep(id,name,age,weight,price)
                farm.add_animal(animal)
            elif option_animal == 2:
                animal = Pig(id,name,age,weight,price)
                farm.add_animal(animal)
            elif option_animal == 3:
                animal = Cow(id,name,age,weight,price)
                farm.add_animal(animal)
            else:
                print("Error type")
        elif option == 2:
            id = input("Enter Id of animal to delete")
            farm.del_animal(id)
        elif option == 3:
            farm.get_info()
        elif option == 4:
            print(farm.get_number_animals())
        elif option == 5:
            farm.get_animals_info()
        elif option == 6:
            id = input("Enter Id of animal to search")
            farm.search_animal(id)
        elif option == 7:
            print(farm.get_total_price())
        elif option == 8:
            animal_sort = farm.sort_by_price()
            for i in animal_sort:
                print("Id : "+i.id+" - Price : "+str(i.price))
        elif option == 9:
            animal_sort = farm.sort_by_age()
            for i in animal_sort:
                print("Id : "+i.id+" - Age : "+str(i.age))
        input("Enter para continuar ...")