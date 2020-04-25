package com.brayvasq.farm.models

/**
 * A child class, representing a Cow. It extends from Animal class
 *
 * @author brayvasq
 */
class Cow(name: String) : Animal(name) {
    /**
     * Class initializer, where is defined specific values for Cow class
     */
    init {
        this.limitFood = 3
        this.limitWash = 10
        this.kind = "cow"
    }

    /**
     * returns the Cow character, depending on the isAlive() method
     *
     * @return The Cow character
     */
    override fun getCharacter(): String {
        var character = "  (....)  \n";
        character += when {
            this.isAlive() -> "（0 .. 0）"
            else -> "（X .. X）"
        }
        return character
    }

    /**
     * returns the Cow characteristic sound.
     *
     * @return The Cow sound
     */
    override fun speak(): String {
        return "Muuu Muuu!!!"
    }
}
