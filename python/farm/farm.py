class Farm:
    def __init__(self,name,address=""):
        self.name : str = name
        self.address : str = address
        self.animals : list = []

    def get_info(self):
        print("Name : "+self.name+"\nAddress : "+self.address)

    def get_number_animals(self):
        return len(self.animals)

    def get_animals_info(self):
        if len(self.animals) > 0:
            for i in self.animals:
                print("Id : "+i.id+" - Name : "+i.name+"\n")
        else:
            print("List of animals is empty")
    
    def search_animal(self,id):
        item = [x for x in self.animals if x.id == id]
        item[0].get_info()
        item[0].speak()
        return item[0]

    def get_total_price(self):
        price = 0.0
        if len(self.animals) > 0: 
            for i in self.animals:
                price += i.price
        return price
    
    def add_animal(self,animal):
        self.animals.append(animal)
    
    def del_animal(self,id):
        animal = self.search_animal(id)
        try:
            self.animals.remove(animal)
            print("Animal Deleted!")
        except:
            print("Error !!!")

    def sort_by_price(self):
        animals_sort = self.animals
        limit = len(animals_sort)
        if limit > 1:
            for i in range(1,limit):
                for j in range(0,limit-i):
                    if animals_sort[j].price > animals_sort[j+1].price:
                        aux = animals_sort[j]
                        animals_sort[j] = animals_sort[j+1]
                        animals_sort[j+1] = aux
        return animals_sort

    def sort_by_age(self):
        return sorted(self.animals, key=lambda animal: animal.age)


    