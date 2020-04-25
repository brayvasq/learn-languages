package com.brayvasq.farm.factories

import com.brayvasq.farm.models.Animal
import com.brayvasq.farm.models.Cow
import com.brayvasq.farm.models.Pig

/**
 * Factory to create a new animal
 *
 * @author brayvasq
 */
class AnimalFactory(var type : String?){

    /**
     * Initializer, validates if type is null and set a default value
     */
    init {
        this.type = when { type == null -> "cow" else -> type }
    }

    /**
     * Return a specific type of animal, depending of the type of animal
     *
     * @param name the name of the animal to create
     * @return A new specific animal
     */
    fun getAnimal(name : String) : Animal? {
        var animal : Animal? = null

        if(type.equals("cow")){
            animal = Cow(name)
        }else if (type.equals("pig")){
            animal = Pig(name)
        }

        return animal
    }
}