using System;
using System.Collections.Generic;
namespace dotnet
{
    ///<sumary>
    /// Author: brayvasq <brayvasq@gmail.com>
    /// Version: 0.1
    /// Date: 2018-03-25
    /// This is the principal in to program.
    /// This class interact with the user through a inputs. 
    ///</sumary>
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("The C# dotnet Farm");
            
            int option = 0;
            string message = "\n\n1.Add Animal\n"+
                             "2.Del Animal\n"+
                             "3.Get Info Farm\n"+
                             "4.Get Info Animals\n"+
                             "5.Search Animal\n"+
                             "6.Sort by price\n"+
                             "7.Exit\n";
            
            Farm farm = new Farm("My Farm","Av 34");

            while(option!=7){
                Console.WriteLine(message);
                option = int.Parse(Console.ReadLine());

                if(option == 1){
                    Console.WriteLine("\n\n Create Animal : \n");
                    Console.WriteLine("Id : ");
                    string id = Console.ReadLine();
                    Console.WriteLine("Name : ");
                    string name = Console.ReadLine();
                    Console.WriteLine("Age : ");
                    int age = int.Parse(Console.ReadLine());
                    Console.WriteLine("Weight : ");
                    float weight = float.Parse(Console.ReadLine());
                    Console.WriteLine("Price : ");
                    double price = double.Parse(Console.ReadLine());

                    Console.WriteLine("Type : 1.Sheep - 2.Cow : ");
                    int type_animal = int.Parse(Console.ReadLine());
                    Animal animal = null;
                    switch (type_animal)
                    {
                        case 1:
                            animal = new Sheep(id,name,age,weight,price);                        
                            break;
                        case 2:
                            animal = new Cow(id,name,age,weight,price);                                                
                            break;
                        default:
                            Console.WriteLine("Error in option");
                            break;
                    }
                    farm.addAnimal(animal);
                }else if(option==2){
                    string id = Console.ReadLine();
                    farm.delAnimal(id);
                }else if(option==3){
                    farm.getInfo();
                }else if(option==4){
                    farm.getAnimalsInfo();
                }else if(option==5){
                    string id =Console.ReadLine();
                    Animal a = farm.searchAnimal(id);
                    a.getInfo();
                }else if(option==6){
                    List<Animal> animals = farm.sortByPrice();
                    foreach (var a in animals)
                    {
                        Console.WriteLine("Id : "+a.id+" - Name : "+a.name+" - Price : "+a.price);
                    }
                }
            }
        }
    }
}
