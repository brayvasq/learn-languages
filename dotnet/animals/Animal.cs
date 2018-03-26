using System;

namespace dotnet
{
    ///<sumary>
    /// Author: brayvasq <brayvasq@gmail.com>
    /// Version: 0.1
    /// Date: 2018-03-25
    /// This is a abstract class that represent a general animal.
    ///</sumary>
    public abstract class Animal
    {
        public string id {get; set;}
        public string name {get; set;}
        public int age {get; set;}
        public float weight {get; set;}
        public double price {get; set;}
        public bool alive{get; set;}

        ///<sumary>
        /// This methods is the constructor of the class.
        /// The attribute alive is determinate in the child classes
        ///</sumary>
        ///<param name="id">is a identifier of the animal.</param>  
        ///<param name="name">is a name for the animal.</param>  
        ///<param name="age">is an age that is used to determinate if is alive</param>  
        ///<param name="weight"></param>          
        ///<param name="price">is the simple price of animal</param>  
        public Animal(string id="",string name="",int age=0, float weight=0,double price=0.0){
            this.id = id;
            this.name = name;
            this.age = age;
            this.weight = weight;
            this.price = price;
            this.alive = true;
        }
        /// <sumary>The follow methods are implemented in the child classes.</sumary>
        public abstract double calculatePrice();
        public abstract void speak();
        
        ///<sumary>This method just show all information of the animal</sumary>
        public void getInfo(){
            string response = "Id : "+this.id+"\n"+
                              "Name : "+this.name+"\n"+
                              "Age : "+this.age+"\n"+
                              "Weight : "+this.weight+"\n"+
                              "Price : "+this.price+"\n"+
                              "Alive : "+this.alive+"\n";
            Console.WriteLine(response);
        }
    }
}