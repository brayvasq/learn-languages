using System;
using System.Collections.Generic;
namespace dotnet
{
    ///<sumary>
    /// Author: brayvasq <brayvasq@gmail.com>
    /// Version: 0.1
    /// Date: 2018-03-25
    /// This class just simulate a Farm.
    ///</sumary>
    public class Farm
    {
        public string name {get; set;}
        public string address {get; set;}
        public List<Animal> animals;
        ///<sumary>
        /// This methods is the constructor of the class.
        /// The attribute animals contains all animals of the farm.
        ///</sumary>
        ///<param name="name">is a identifier of the farm.</param>  
        ///<param name="address">is a simple phisical direction of the farm.</param>         
        public Farm(string name,string address){
            this.name = name;
            this.address = address;
            this.animals = new List<Animal>();
        }
        ///<sumary>This Method just show the information of the farm</sumary>
        public void getInfo(){
            Console.WriteLine("Name : "+this.name+"\nAddress : "+this.address);
        }
        ///<sumary>This method iterate the list of animals and show basic info of each animal</sumary>
        public void getAnimalsInfo(){
            if(this.animals.Count>0){
                foreach (var i in this.animals)
                {
                    Console.WriteLine("Id : "+i.id+" - Name : "+i.name);
                }
            }
        }
        ///<sumary>This method iterate the list of animals for search a specific animal</sumary>
        ///<param name="id">is the identifier of the animal to search</param>          
        ///<returns>resp, contain the animal with the searched id</returns>
        public Animal searchAnimal(string id){
            Animal resp = null;
            foreach(var i in this.animals){
                if(i.id.Equals(id)){
                    resp = i;
                }
            }
            return resp;
        }
        ///<sumary>This method just add a new animal to the list of animals</sumary>
        ///<param name="animal">is a object that will be added to the list</param>                  
        public void addAnimal(Animal animal){
            this.animals.Add(animal);
        }
        ///<sumary>This method delete a specific animal based on a id</sumary>
        ///<param name="id">the id of animal to search and delete</param>                          
        public void delAnimal(string id){
            Animal animal = searchAnimal(id);
            try{
                this.animals.Remove(animal);
            }catch(Exception e){Console.WriteLine("Error"+e);}
        }
        ///<sumary>
        /// This method implements the algorithm bubble sort
        /// To sort the list of animals based on his price
        ///</sumary>
        ///<returns>response, is a list with the animals sorted by price<returns>
        public List<Animal> sortByPrice(){
            List<Animal> response = this.animals;
            int limit = response.Count;
            if(limit>1){
                for(int i=1;i<limit;i++){
                    for(int j=0;j<(limit-i);i++){
                        if(response[j].price > response[j+1].price){
                            Animal aux = response[j];
                            response[j] = response[j+1];
                            response[j+1] = aux;
                        }
                    }
                }
            }
            return response;
        }
    }
}