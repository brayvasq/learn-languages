using System;

namespace dotnet
{
    ///<summary>
    /// Factory to create a new animal
    ///</summary>
    public class AnimalFactory {
        private string Type {get; set;}

        ///<summary>
        /// Class constructor to setup Factory properties.
        ///</summary>
        ///<param name="name">The type of the animal to create (default: "cow").</param>
        public AnimalFactory(string type){
            this.Type = type == null ? "cow" : type;
        }

        ///<summary>
        /// Return a specific type of animal, depending of the type of animal.
        ///</summary>
        ///<param name="name">The name of the animal to create.</param>
        ///<returns>A new specific animal </returns>
        public Animal GetAnimal(string name){
            Animal animal = null;

            if(this.Type == "cow"){
                animal = new Cow(name);
            }else if (this.Type == "pig"){
                animal = new Pig(name);
            }
            
            return animal;
        }
    }
}
