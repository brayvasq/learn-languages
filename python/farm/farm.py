class Farm:
    """
        :author: brayvasq <brayvasq@gmail.com>
        :version: 0.1
        This class just simulate a Farm.
    """

    def __init__(self,name,address=""):
        """
            This method is the constructor of the class.

            :param name: is a identifier of the farm.
            :param address: is a simple phisical direction of the farm.
                            the default value is a empty string.

            The attribute animals contains all animals of the farm.
            
            :return: nothing
        """
        self.name : str = name
        self.address : str = address
        self.animals : list = []

    def get_info(self):
        """
            This Method just show the information of the farm.
            :return: nothing
        """
        print("Name : "+self.name+"\nAddress : "+self.address)

    def get_number_animals(self):
        """
            This method get the number of animals in the list of animals
            :return: lenght of the list of animals
        """
        return len(self.animals)

    def get_animals_info(self):
        """
            This method iterate the list of animals and show basic info of each animal.
            :return: nothing
        """
        if len(self.animals) > 0:
            for i in self.animals:
                print("Id : "+i.id+" - Name : "+i.name+"\n")
        else:
            print("List of animals is empty")
    
    def search_animal(self,id):
        """
            This method iterate the list of animals for search a specific animal.
            :param id: is the identifier of the animal to search.
            :return: item[0], contain the animal with the searched id
        """
        item = [x for x in self.animals if x.id == id]
        item[0].get_info()
        item[0].speak()
        return item[0]

    def get_total_price(self):
        """
            This method get the sum of the price of the all animals in the list
            :return: price, is the total price.
        """
        price = 0.0
        if len(self.animals) > 0: 
            for i in self.animals:
                price += i.price
        return price
    
    def add_animal(self,animal):
        """
            This method just add a new animal to the list of animals.
            :param animal: is a object that will be added to the list.
            :return: nothing.
        """
        self.animals.append(animal)
    
    def del_animal(self,id):
        """
            This method delete a specific animal based on a id.
            :param id: the id of animal to search and delete.
            :return: nothing.
        """
        animal = self.search_animal(id)
        try:
            self.animals.remove(animal)
            print("Animal Deleted!")
        except:
            print("Error !!!")

    def sort_by_price(self):
        """
            This method implements the algorithm bubble sort.
            Sort the list of animals based on his price.
            :return: animals_sort, is a list with the animals sorted by price.
        """
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
        """
            This method sort the list of animals based on his age.
            :return: list of animals sort by age.
        """
        return sorted(self.animals, key=lambda animal: animal.age)