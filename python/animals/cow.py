from .animal import Animal

class Cow(Animal):
    def __init__(self,id,name,age,weight,price):
        Animal.__init__(self,id,name,age,weight,price)
        self.alive = True if self.age <= 25 else False
        
    def calculate_price(self):
        return self.price * 3 * self.weight

    def eat(self):
        print("I am a herbivoret")
    
    def speak(self):
        print("Muuuu!!")
    
    def get_life_expectancy(self):
        print("25 years")