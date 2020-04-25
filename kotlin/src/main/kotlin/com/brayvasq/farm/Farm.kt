package com.brayvasq.farm

import com.brayvasq.farm.factories.AnimalFactory
import com.brayvasq.farm.models.Animal
import com.brayvasq.farm.utils.Store

/**
 * A class that works as a kind of controller.
 *
 * @author brayvasq
 */
class Farm {
    val store : Store = Store()

    /**
     * Initializer, call the store load to setup the animals list
     */
    init {
        this.store.load()
    }

    /**
     * List all the animals stored. Also, it can filter the animals by animal
     * type and age
     *
     * @param age The value to filter animals by age (default: null).
     * @param type The value to filter animals by animal type (default: null).
     */
    fun listAnimals(age : String?, type : String?) {
        var animals : List<Animal?> = this.store.animals

        animals = when { age == null -> animals else -> animals.filter { item -> item?.age == age.toInt() } }
        animals = when { type == null -> animals else -> animals.filter { item -> item?.kind == type } }

        animals.forEach { animal ->
            println(animal)
        }
    }

    /**
     * Uses the AnimalFactory to create a new animal
     *
     * @param name The name of the animal
     * @param type The animal type
     * @return true if the animal was created successfully
     */
    fun createAnimal(name : String, type : String?) : Boolean{
        var created = false
        var animal : Animal? = AnimalFactory(type).getAnimal(name)

        if(animal != null){
            created = this.store.add(animal)
        }

        return created
    }

    /**
     * Deletes a animal by name
     *
     * @param name The name of the animal
     * @return true if the animal was deleted successfully
     */
    fun deleteAnimal(name : String) : Boolean {
        return this.store.remove(name)
    }

    /**
     * Search a animal by name and prints the animal info
     *
     * @param name the name of the animal
     */
    fun search(name : String) {
        var animal : Animal? = this.store.find(name)

        if(animal != null){
            println(animal)
        } else {
            println("Animal not found")
        }
    }

    /**
     * Gives food to an animal
     *
     * @param name the name of the animal
     */
    fun food(name : String){
        var animal : Animal? = this.store.find(name)

        if (animal != null){
            animal.eat()
            this.store.save()
        }
    }

    /**
     * Gives a shower to an animal
     *
     * @param name the name of the animal
     */
    fun wash(name : String){
        var animal : Animal? = this.store.find(name)

        if (animal != null){
            animal.wash()
            this.store.save()
        }
    }

    /**
     * Prints if an animal is alive
     *
     * @param name the name of the animal
     */
    fun alive(name : String){
        var animal : Animal? = this.store.find(name)

        if(animal != null){
            println(animal.isAlive())
        }
    }
}
