
class Animal:
    def __init__(self,id="",name="",age=0,weight=0.0,price=0.0):
        self.id : str = id
        self.name : str = name
        self.age : int = age
        self.weight : float = weight
        self.price : float = price
        self.alive : bool = True

    def get_info(self):
        response = "Id : "+self.id+"\n"+"Name : "+self.name+"\n"+"Age : "+str(self.age)+"\n"+"Weight : "+str(self.weight)+"\n"+"Price : "+str(self.price)+"\n"+"Alive : "+str(self.alive)+"\n"
        print(response)
    
    def calculate_price(self):
        pass

    def eat(self):
        pass

    def speak(self):
        pass
    
    def get_life_expectancy(self):
        pass
