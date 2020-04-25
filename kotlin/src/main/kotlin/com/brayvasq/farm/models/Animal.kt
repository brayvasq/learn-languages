package com.brayvasq.farm.models

import com.brayvasq.farm.utils.Dates
import java.util.*

/**
 * An abstract class representing a general Animal.
 *
 * @author brayvasq
 */
abstract class Animal(var name: String = "") {

    var age: Int = 0

    var lastWash: Date = Date()

    var lastFood: Date = Date()

    var alive: Boolean = true

    var limitWash: Int = 0
    var limitFood: Int = 0
    var kind: String = ""

    /**
     * Creates a full string with the animal attributes
     *
     * @return the full Animal info
     */
    fun getInfo(): String {
        val character: String = this.getCharacter()
        var animal: String = "";
        animal += "#".repeat(50) + "\n"
        animal += "${character}\n"
        animal += "Name: ${this.name}\n"
        animal += "Alive: ${this.alive}\n"
        animal += "Sound: ${this.speak()}\n"
        animal += "Wash time limit: ${0}\n"
        animal += "Food time limit: ${0}\n"
        animal += "#".repeat(50) + "\n"

        return animal
    }

    /**
     * Gives food to the animal. It changes the last_food attribute and assign the actual date
     */
    fun eat() {
        this.lastFood = Date()
    }

    /**
     * Gives the animal a shower. It changes the last_food attribute and assign the actual date
     */
    fun wash() {
        this.lastWash = Date()
    }

    /**
     * Calculates if the animal is still alive. Uses the util Date to determinate the
     * difference in minutes between the last_wash and last_food attributes and their
     * respective limits
     *
     * @return false if one of the limits was exceeded
     */
    fun isAlive(): Boolean {
        if (Dates.isGreatter(this.lastWash, this.limitWash)) {
            this.alive = false
        }

        if (Dates.isGreatter(this.lastFood, this.limitFood)) {
            this.alive = false
        }

        return this.alive
    }

    /**
     * Abstract method, it return the animal character. it's implemented in the child classes
     *
     * @return The Animal character
     */
    abstract fun getCharacter(): String

    /**
     * Abstract method, it return the animal sound. it's implemented in the child classes
     *
     * @return The characteristic Animal sound
     */
    abstract fun speak() : String

    /**
     * Uses the getInfo() method to obtain a string to represent the object
     *
     * @return the Animal in string format
     */
    override fun toString(): String {
        return this.getInfo()
    }
}