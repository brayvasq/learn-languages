/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brayvasq.farm.models;

/**
 * A child class, representing a Cow. It extends from Animal class
 *
 * @author brayvasq
 */
public class Cow extends Animal {

    /**
     * Class constructor, setup the specific Cow properties
     *
     * @param name the name of the Cow
     */
    public Cow(String name) {
        super(name);
        this.limitFood = 3;
        this.limitWash = 10;
        this.kind = "cow";
    }

    /**
     * Returns the Cow sound.
     *
     * @return The Cow sound
     */
    @Override
    public String speak() {
        return "Muuu Muuu!!!";
    }

    /**
     * Returns the Cow character, depending on the isAlive() method
     *
     * @return The Cow character
     */
    @Override
    public String getCharacter() {
        String character = "  (....)  \n";
        character += this.isAlive() ? "（0 .. 0）" : "（X .. X）";
        return character;
    }
}
