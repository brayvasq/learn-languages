package farm
import animals.Animal

/**
 * @author brayvasq <brayvasq@gmail.com>
 * @version 0.1
 * @since 2018-03-25
 * This class just simulate a Farm.
 * @param name is a identifier of the farm.
 * @param address is a simple phisical direction of the farm.
 * the attribute animals contains all animals of the farm.
 */
class Farm(var name:String,var address:String){

    var animals : ArrayList<Animal> = ArrayList()

    /**
     * This Method just show the information of the farm
     */
    fun getInfo() = println("Name : ${this.name}\nAddress : ${this.address}")

    /**
     * This method get the number of animals in the list of animals.
     * @return lenght of the list of animals.
     */
    fun getNumberAnimals() : Int = animals.size

    /**
     * This method iterate the list of animals and show basic info of each animal
     */
    fun getAnimalsInfo(){
        if (!this.animals.isEmpty()) {
            for (i in this.animals) {
                println("Id : " + i.id + " - Name : " + i.name)
            }
        } else {
            print("List of animals is empty")
        }
    }

    /**
     * This method iterate the list of animals for search a specific animal
     * @param id is the identifier of the animal to search
     * @return resp, contain the animal with the searched id
     */
    fun searchAnimal(id: String): Animal? {
        var resp: Animal? = null
        
        for (e in this.animals) {
            if (e.id == id) {
                resp = e
            }
        }

        return resp
    }

    /**
     * This method get the sum of the price of the all animals in the list
     * @return price, is the total price.
     * */
    fun getTotalPrice() : Double{
        var price:Double = 0.0
        if(!this.animals.isEmpty()){

            val iterator = this.animals.iterator()
            
            iterator.forEach {
                price += it.price
            }

        }

        return price
    }

    /**
     * This method just add a new animal to the list of animals
     * @param animal is a object that will be added to the list
     */
    fun addAnimal(animal: Animal) {
        this.animals.add(animal)
    }

    /**
     * This method delete a specific animal based on a id
     * @param id the id of animal to search and delete
     */
    fun delAnimal(id: String) {
        val animal = searchAnimal(id)

        try {
            this.animals.remove(animal)
        } catch (e: Error) {
            println("Error")
        }
    }

    /**
     * This method implements the algorithm bubble sort
     * to sort the list of animals based on his price
     * @return response, is a list with the animals sorted by price
     */
    fun sortByPrice(): ArrayList<Animal> {
        val response = this.animals
        val limit = response.size

        if (limit > 1) {
            for (i in 1 until limit) {
                for (j in 0 until limit - i) {
                    if (response[j].price > response[j + 1].price) {
                        val aux = response[j]
                        response[j] = response[j + 1]
                        response[j + 1] = aux
                    }
                }
            }
        }

        return response
    }

    /**
     * This method sort the list of animals based on his age.
     * @return list of animals sort by age.
     * */
    fun sortByAge() : ArrayList<Animal>{
        var sortedList : ArrayList<Animal> = (ArrayList(this.animals.sortedWith(compareBy({ it.age }))))
        return sortedList
    }
}