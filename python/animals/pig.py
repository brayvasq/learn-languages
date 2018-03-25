from .animal import Animal

class Pig(Animal):
    """
        :author: brayvasq <brayvasq@gmail.com>
        :version: 0.1
        This is a class that represent a Pig inheriting animal class.
    """
    
    def __init__(self,id,name,age,weight,price):
        """
            This method is the constructor of the class and use the parent constructor.

            :param id: is a identifier of the pig.
            :param name: is a name for the pig.
            :param age: is an age that is used to determinate if is alive.
            :param weight: 
            :param price: is the simple price of pig.

            The attribute alive is determinate whit the param age.
            
            :return: nothing.
        """
        Animal.__init__(self,id,name,age,weight,price)
        self.alive = True if self.age <= 15 else False

    def calculate_price(self):
        """
            This is a overwritten method from the parent class.
            :return: final price based on a simple price and the age of the animal.
        """
        return self.price * 2 * self.age

    def eat(self):
        """
            This is a overwritten method from the parent class.
            This method just show if it is carnivorous or herbivore.
            :return: nothing
        """
        print("I am a herbivoret")

    def speak(self):
        """
            This is a overwritten method from the parent class.
            Just show the characteristic sound of the animal.
            :return: nothing.
        """
        print("Oig Oig!!")
    
    def get_life_expectancy(self):
        """
            This is a overwritten method from the parent class.
            This method just show the life expectancy of the animal.
            :return: nothing.
        """
        print("15 years")