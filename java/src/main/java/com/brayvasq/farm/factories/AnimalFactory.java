/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brayvasq.farm.factories;

import com.brayvasq.farm.models.Animal;
import com.brayvasq.farm.models.Cow;
import com.brayvasq.farm.models.Pig;

/**
 * Factory to create a new animal
 *
 * @author brayvasq
 */
public class AnimalFactory {

    private String type;

    /**
     * Empty constructor to set defaults to params
     */
    public AnimalFactory() {
        this("cow");
    }

    /**
     * Class constructor to setup Factory properties
     * @param type The type of the animal to create (default: "cow").
     */
    public AnimalFactory(String type) {
        this.type = type != null ? type : "cow";
    }

    /**
     * Return a specific type of animal, depending of the type of animal
     * @param name the name of the animal to create
     * @return A new specific animal
     */
    public Animal getAnimal(String name) {
        Animal animal = null;

        if ("cow".equals(this.type)) {
            animal = new Cow(name);
        } else if ("pig".equals(this.type)) {
            animal = new Pig(name);
        }

        return animal;
    }
}
