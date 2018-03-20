from .animal import Animal

class Pig(Animal):
    def __init__(self,id,name,age,weight,price):
        Animal.__init__(self,id,name,age,weight,price)
        self.alive = True if self.age <= 15 else False

    def calculate_price(self):
        return self.price * 2 * self.age

    def eat(self):
        print("I am a herbivoret")

    def speak(self):
        print("Oig Oig!!")
    
    def get_life_expectancy(self):
        print("15 years")