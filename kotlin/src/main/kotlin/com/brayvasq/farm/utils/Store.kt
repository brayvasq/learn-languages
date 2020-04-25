package com.brayvasq.farm.utils

import com.brayvasq.farm.factories.AnimalFactory
import com.brayvasq.farm.models.Animal
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import java.io.*
import java.util.*
import java.util.logging.Level
import java.util.logging.Logger
import kotlin.collections.ArrayList

/**
 * A util class to operate with files
 *
 * @author brayvasq
 */
class Store(val file: String = "animals.json") {
    var animals: ArrayList<Animal?> = ArrayList();

    /**
     * Read the animals file and calls the read_animals() method to store the
     * animals in a list
     *
     * @return true if the data was loaded
     */
    fun load(): Boolean {
        val reader = File(this.file)
        var loaded = false
        if (reader.exists()) {
            val text = reader.readText()

            val json: JsonArray? = Gson().fromJson(text, JsonArray::class.java)

            readAnimals(json)

            loaded = true
        } else {
            print("${this.file} file does not exist.")
            reader.createNewFile()
        }


        return loaded
    }

    /**
     * Creates the animals from the data parsed.
     *
     * @param animals JsonArray parsed from file
     */
    private fun readAnimals(animals: JsonArray?) {
        animals?.forEach { animal ->
            var json: JsonObject = Gson().fromJson(animal, JsonObject::class.java)
            var temp: Animal? = AnimalFactory(json.get("kind").asString).getAnimal(json.get("name").asString)
            temp?.age = json.get("age").asInt
            temp?.lastWash = Date(json.get("lastWash").asString)
            temp?.lastFood = Date(json.get("lastFood").asString)
            temp?.isAlive()

            this.animals.add(temp)
        }
    }

    /**
     * Search a animal in the list of animal by name
     *
     * @param name the name of the animal
     * @return The equivalent animal object to the given name
     */
    fun find(name: String): Animal? {
        var animal: Animal? = this.animals.find { item -> name.equals(item?.name) }
        return animal;
    }

    /**
     * Add a new animal object
     *
     * @param animal the animal object to add
     * @return true if the animal was added successfully
     */
    fun add(animal: Animal): Boolean {
        this.animals.add(animal)
        return this.save()
    }

    /**
     * Deletes an animal by name
     *
     * @param name the name of the animal
     * @return true if the animal was deleted successfully
     */
    fun remove(name: String): Boolean {
        val animal: Animal? = this.find(name)
        var deleted = false

        if (animal != null) {
            this.animals.remove(animal)
            deleted = this.save()
        }

        return deleted
    }

    /**
     * Parse the animal list into json data and store in a file
     *
     * @return true if the data was saved successfully
     */
    fun save(): Boolean {
        val gson: Gson = GsonBuilder().setPrettyPrinting().create()

        var json: String = gson.toJson(this.animals)

        try {
            val writer = File(this.file)
            writer.writeText(json)

            return true
        } catch (ex: IOException) {
            Logger.getLogger(Store::class.java.name).log(Level.SEVERE, null, ex)
            return false
        }
    }
}
