package com.brayvasq.farm.models

/**
 * A child class, representing a Pig. It extends from Animal class
 *
 * @author brayvasq
 */
class Pig (name : String) : Animal(name) {
    /**
     * Class initializer, where is defined specific values for Pig class
     */
    init {
        this.limitFood = 2
        this.limitWash = 5
        this.kind = "cow"
    }

    /**
     * returns the Pig character, depending on the isAlive() method
     *
     * @return The Pig character
     */
    override fun getCharacter(): String {
        return when{ this.isAlive() -> "（`（●●）´）" else -> "（x（●●）x）" }
    }

    /**
     * returns the characteristic Pig sound.
     *
     * @return The Pig sound
     */
    override fun speak() : String{
        return "Oink Oink!!!";
    }
}
