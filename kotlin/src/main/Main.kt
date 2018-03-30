import animals.Cow
import animals.Animal
import animals.Pig
import animals.Sheep
import java.util.*
import farm.Farm

/**
 * @author brayvasq <brayvasq@gmail.com>
 * @version 0.1
 * @since 2018-03-25
 * This is the principal in to program.
 * This fun interact with the user through a inputs.
 */
fun main(args: Array<String>) {
    println("The Kotlin Farm")

    var option : Int = 0
    val reader :Scanner = Scanner(System.`in`);
    val message : String = "\n\n1.Add Animal\n"+
            "2.Del Animal\n"+
            "3.Get Info Farm\n"+
            "4.Get number of animals\n"+
            "5.Get Info Animals\n"+
            "6.Search Animal\n"+
            "7.Get total Price\n"+
            "8.Sort by price\n"+
            "9.Sort by age\n"+
            "10.Exit\n";

    var farm : Farm = Farm("My Farm","Av 34")

    while (option != 10) {
        
        println(message)
        print("\nEnter Option : ")
        option = reader.nextInt()

        if(option == 1){
            println("\n\n Create Animal : \n")

            print("Id : ")
            var id : String= reader.next()
            print("Name : ")
            var name : String = reader.next()
            print("Age : ")
            var age :Int = reader.nextInt()
            print("Weight : ")
            var weight :Double = reader.nextDouble()
            print("Price : ")
            var price :Double= reader.nextDouble()

            print("Type : 1.Sheep - 2.Cow : - 3.Pig");
            var type_animal :Int= reader.nextInt();

            when  {
                type_animal == 1 -> {
                    var sheep : Animal = Sheep(id,name,age,weight,price)
                    farm.addAnimal(sheep);
                }

                type_animal == 2 -> {
                    var cow : Animal = Cow(id,name,age,weight,price)
                    farm.addAnimal(cow)
                }

                type_animal == 3 ->{
                    var pig : Animal = Pig(id,name,age,weight,price)
                    farm.addAnimal(pig)
                }

                else -> println("Error in type")
            }

        }else if(option == 2){

            println("Enter id of animal to delete : ")
            var id :String = reader.next()
            farm.delAnimal(id)

        }else if(option == 3) {

            farm.getInfo()

        }else if (option == 4){

            println(farm.getNumberAnimals())

        }else if(option == 5){

            farm.getAnimalsInfo()

        }else if(option == 6) {
            
            println("Enter id of animal to search : ")
            var id: String = reader.next();
            var a: Animal? = farm.searchAnimal(id.trim())
            println("Info Animal")
            a?.getInfo()
            a?.eat()
            a?.speak()
            a?.getLifeExpectancy()

        }else if (option == 7){

            println(farm.getTotalPrice())

        }else if(option == 8){

            var animals = farm.sortByPrice()
            animals.iterator().forEach {
                println("Id : ${it.id} - Price : ${it.price}")
            }

        }else if(option == 9){

            var animals = farm.sortByAge()
            animals.iterator().forEach {
                println("Id : ${it.id} - Age : ${it.age}")
            }

        }
    }

}
