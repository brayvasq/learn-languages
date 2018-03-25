class Animal:
    """
        :author: brayvasq <brayvasq@gmail.com>
        :version: 0.1
        This is a parent class that represent a general animal.
    """

    def __init__(self,id="",name="",age=0,weight=0.0,price=0.0):
        """
            This method is the constructor of the class.

            :param id: is a identifier of the animal.
            :param name: is a name for the animal.
            :param age: is an age that is used to determinate if is alive.
            :param weight: 
            :param price: is the simple price of animal.

            The attribute alive is determinate in the child classes.
            
            :return: nothing.
        """
        self.id : str = id
        self.name : str = name
        self.age : int = age
        self.weight : float = weight
        self.price : float = price
        self.alive : bool = True

    def get_info(self):
        """
            This method just show all information of the animal.
            :return: nothing.
        """
        response = "Id : "+self.id+"\n"+"Name : "+self.name+"\n"+"Age : "+str(self.age)+"\n"+"Weight : "+str(self.weight)+"\n"+"Price : "+str(self.price)+"\n"+"Alive : "+str(self.alive)+"\n"
        print(response)
    
    def calculate_price(self):
        """
            The price is calculate in the child classes.
        """
        pass

    def eat(self):
        """
            This method just show if it is carnivorous or herbivore.
            Is implemented in the child classes.
        """
        pass

    def speak(self):
        """
            This method show the characteristic sound of the animal.
            Is implemented in the child classes.
        """
        pass
    
    def get_life_expectancy(self):
        """
            This method just show the life expectancy of the animal.
            Is implemented in the child classes.
        """
        pass