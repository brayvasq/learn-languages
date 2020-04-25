using System;

namespace dotnet
{
    ///<summary>
    /// A class representing a general Animal.
    ///</summary>
    public class Animal : IAnimal {
        public string Name {get; set;}
        public int Age {get; set;}
        public DateTime LastWash {get; set;}
        public DateTime LastFood {get; set;}
        public bool Alive {get; set;}
        public int LimitWash {get; set;}
        public int LimitFood {get; set;}
        public string Kind {get; set;}

        ///<summary>
        /// Empty constructor (Parameterless) to set defaults to params
        ///</summary>
        public Animal() : base(){}

        ///<summary>
        /// Class constructor to setup all Animal properties
        ///</summary>
        ///<param name="name">the name of the animal.</param>
        public Animal(string name = "") : base(){
            this.Name = name;
            this.Age = 0;
            this.LastWash = DateTime.Now;
            this.LastFood = DateTime.Now;
            this.Alive = true;
        }

        ///<summary>
        /// Gives food to the animal. It changes the last_food attribute and assign the actual date
        ///</summary>
        public void Eat() {
            this.LastFood = DateTime.Now;
        }

        ///<summary>
        /// Gives the animal a shower. It changes the last_food attribute and assign the actual date
        ///</summary>
        public void Wash(){
            this.LastWash = DateTime.Now;
        }

        ///<summary>
        /// returns the Animal info.
        ///</summary>
        ///<returns>
        /// the full Animal info
        ///</returns>
        public string GetInfo(){
            string character = this.GetCharacter();
            string animal = "";

            animal += new string('#', 50) + "\n";
            animal += character + "\n";
            animal += "Name: " + this.Name + "\n";
            animal += "Alive: " + this.IsAlive() + "\n";
            animal += "Sound: " + this.Speak() + "\n";
            animal += "Wash time limit: " + (this.LimitWash - Dates.GetDiffInMinutes(this.LastWash)) + "\n";
            animal += "Food time limit: " + (this.LimitFood - Dates.GetDiffInMinutes(this.LastFood)) + "\n";
            animal += new string('#', 50) + "\n";

            return animal;
        }

        ///<summary>
        /// Calculates if the animal is still alive. Uses the util Date to determinate the
        /// difference in minutes between the last_wash and last_food attributes and their
        /// respective limits
        ///</summary>
        ///<returns>
        /// false if one of the limits was exceeded
        ///</returns>
        public bool IsAlive(){
            if(Dates.IsGreatter(this.LastWash, this.LimitWash)){
                this.Alive = false;
            }

            if(Dates.IsGreatter(this.LastFood, this.LimitFood)){
                this.Alive = false;
            }

            return this.Alive;
        }

        ///<summary>
        /// Uses the GetInfo() method to obtain a string to represent the object
        ///</summary>
        ///<returns>
        /// false if one of the limits was exceeded
        ///</returns>
        public override string ToString()
        {
            return this.GetInfo();
        }

        ///<summary>
        /// Abstract method, it return the animal character. it's implemented in the child classes
        ///</summary>
        ///<returns>
        /// The Animal character
        ///</returns>
        public virtual string GetCharacter()
        {
            return "";
        }

        ///<summary>
        /// Abstract method, it return the animal sound. it's implemented in the child classes
        ///</summary>
        ///<returns>
        /// The characteristic Animal sound
        ///</returns>
        public virtual string Speak()
        {
            return "";
        }
    }
}
