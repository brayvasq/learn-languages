using System;
using System.Collections.Generic;

namespace dotnet
{
    ///<summary>
    /// A class that works as a kind of controller.
    ///</summary>
    class Farm
    {
        private Store StoreText;

        ///<summary>
        /// Class constructor, setup the store class and load the saved animals
        ///</summary>
        public Farm() {
            this.StoreText = new Store();
            this.StoreText.Load();
        }

        ///<summary>
        /// List all the animals stored. Also, it can filter the animals by animal
        /// type and age
        ///</summary>
        ///<param name="age">The value to filter animals by age (default: null).</param>
        ///<param name="type">The value to filter animals by animal type (default: null).</param>
        public void ListAnimals(string age, string type) {
            List<Animal> animals = this.StoreText.Animals;

            animals = age == null ? animals : animals.FindAll(item => item.Age == Int32.Parse(age));
            animals = type == null ? animals : animals.FindAll(item => item.Kind == type);

            foreach (var i in animals)
            {
                Console.WriteLine(i);
            }
        }

        ///<summary>
        /// Uses the AnimalFactory to create a new animal
        ///</summary>
        ///<param name="age">The name of the animal.</param>
        ///<param name="type">The animal type.</param>
        ///<returns>true if the animal was created successfully</returns>
        public bool CreateAnimal(string name, string type) {
            bool created = false;
            Animal animal = new AnimalFactory(type).GetAnimal(name);

            if (animal != null) {
                created = this.StoreText.Add(animal);
            }

            return created;
        }

        ///<summary>
        /// Deletes a animal by name
        ///</summary>
        ///<param name="name">The name of the animal.</param>
        ///<returns>true if the animal was deleted successfully.</returns>
        public bool DeleteAnimal(string name) {
            return this.StoreText.Remove(name);
        }

        ///<summary>
        /// Search a animal by name and prints the animal info
        ///</summary>
        ///<param name="name">The name of the animal.</param>
        public void Search(string name) {
            Animal animal = this.StoreText.Find(name);

            if (animal != null) {
                Console.WriteLine(animal);
            } else {
                Console.WriteLine("Animal not found");
            }
        }

        ///<summary>
        /// Gives food to an animal
        ///</summary>
        ///<param name="name">The name of the animal.</param>
        public void Food(string name) {
            Animal animal = this.StoreText.Find(name);

            if (animal != null) {
                animal.Eat();
                this.StoreText.Save();
            }
        }

        ///<summary>
        /// Gives a shower to an animal
        ///</summary>
        ///<param name="name">The name of the animal.</param>
        public void Wash(string name) {
            Animal animal = this.StoreText.Find(name);

            if (animal != null) {
                animal.Wash();
                this.StoreText.Save();
            }
        }

        ///<summary>
        /// Prints if an animal is alive
        ///</summary>
        ///<param name="name">The name of the animal.</param>
        public void Alive(string name) {
            Animal animal = this.StoreText.Find(name);

            if (animal != null) {
                Console.WriteLine(animal.IsAlive());
            }
        }
    }
}
