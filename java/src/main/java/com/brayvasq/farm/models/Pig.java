/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brayvasq.farm.models;

/**
 * A child class, representing a Pig. It extends from Animal class
 * 
 * @author brayvasq
 */
public class Pig extends Animal {

    /**
     * Class constructor, setup the specific Pig properties
     * 
     * @param name the name of the Pig
     */
    public Pig(String name){
        super(name);
        this.limitFood = 2;
        this.limitWash = 5;
        this.kind = "pig";
    }
    
    /**
     * returns the Pig sound.
     *
     * @return The Pig sound
     */
    @Override
    public String speak() {
        return "Oink Oink!!!";
    }

    /**
     * returns the Pig character, depending on the isAlive() method
     *
     * @return The Pig character
     */
    @Override
    public String getCharacter() {
        return this.isAlive() ? "（`（●●）´）" : "（x（●●）x）";
    }
}
