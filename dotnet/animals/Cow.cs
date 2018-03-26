using System;

namespace dotnet
{
    ///<sumary>
    /// Author: brayvasq <brayvasq@gmail.com>
    /// Version: 0.1
    /// Date: 2018-03-25
    /// This is a class that represent a Cow inheriting animal class.
    ///</sumary>
    public class Cow : Animal{
        ///<sumary>This methods is the constructor of the class and use the parent constructor.</sumary>
        ///<param name="id">is a identifier of the cow.</param>  
        ///<param name="name">is a name for the cow.</param>  
        ///<param name="age">is an age that is used to determinate if is alive</param>  
        ///<param name="weight"></param>          
        ///<param name="price">is the simple price of the cow</param>
        public Cow(string id,string name,int age, float weight,double price) : base(id,name,age,weight,price){
            this.alive = this.age <= 25 ? true:false;
        }
        ///<sumary>This is a overwritten method from the parent class.</sumary>
        /// <returns>final price based on a simple price and the weight of the animal</returns>
        public override double calculatePrice(){
            return this.price * 3 * this.weight;
        }
        ///<sumary>This is a overwritten method from the parent class.</sumary>
        ///<sumary>Just show the characteristic sound of the cow.</sumary>
        public override void speak(){
            Console.WriteLine("Muuuu!!");
        }
    }
}