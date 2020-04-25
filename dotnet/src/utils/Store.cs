using System;
using System.IO;
using System.Text.Json;
using System.Collections.Generic;

namespace dotnet
{
    ///<summary>
    /// A util class to operate with files
    ///</summary>
    public class Store
    {
        private string FilePath;
        public List<Animal> Animals {get;}

        ///<summary>
        /// Class constructor, setup using a given path
        ///</summary>
        ///<param name="file">file path to save the animals data.</param>
        public Store(string file = "animals.json")
        {
            this.FilePath = file;
            this.Animals = new List<Animal>();
        }

        ///<summary>
        /// Read the animals file and calls the read_animals() method to store the
        /// animals in a lis
        ///</summary>
        ///<returns>
        /// true if the data was loaded
        ///</returns>
        public bool Load()
        {
            try
            {
                if (File.Exists(this.FilePath))
                {
                    string text = File.ReadAllText(this.FilePath);
                    Animal[] json = JsonSerializer.Deserialize<Animal[]>(text);
                    this.ReadAnimals(json);
                    return true;
                }
                else
                {
                    Console.WriteLine("File does not exist.");
                    return false;
                }
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex);
                return false;
            }

        }

        ///<summary>
        /// Creates the animals from the data parsed.
        ///</summary>
        ///<param name="animals">Array parsed from file.</param>
        private void ReadAnimals(Animal[] animals)
        {
            foreach (var i in animals)
            {
                Animal temp = new AnimalFactory(i.Kind).GetAnimal(i.Name);
                temp.Age = i.Age;
                temp.LastWash = i.LastWash;
                temp.LastFood = i.LastFood;
                temp.Alive = temp.IsAlive();

                this.Animals.Add(temp);
            }
        }

        ///<summary>
        /// Search a animal in the list of animal by name
        ///</summary>
        ///<param name="name">the name of the animal.</param>
        ///<returns>The equivalent animal object to the given name</returns>
        public Animal Find(string name) => this.Animals.Find(x => x.Name == name);

        ///<summary>
        /// Add a new animal object
        ///</summary>
        ///<param name="name">the animal object to add.</param>
        ///<returns>true if the animal was saved successfully</returns>
        public bool Add(Animal animal)
        {
            this.Animals.Add(animal);
            return this.Save();
        }

        ///<summary>
        ///  Delete an animal by name
        ///</summary>
        ///<param name="name">the name of the animal.</param>
        ///<returns>true if the animal was deleted successfully</returns>
        public bool Remove(string name)
        {
            Animal animal = this.Find(name);
            bool deleted = false;

            if (animal != null)
            {
                this.Animals.Remove(animal);
                deleted = this.Save();
            }

            return deleted;
        }

        ///<summary>
        ///  Parse the animal list into json data and store in a file
        ///</summary>
        ///<returns>true if the data was saved successfully</returns>
        public bool Save()
        {
            try
            {
                string jsonString = JsonSerializer.Serialize(this.Animals);
                File.WriteAllText(this.FilePath, jsonString);

                return true;
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex);
                return false;
            }
        }
    }
}
