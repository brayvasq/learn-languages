/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brayvasq.farm.utils;

import com.brayvasq.farm.models.Animal;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.brayvasq.farm.factories.AnimalFactory;
import java.util.LinkedList;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A util class to operate with files
 *
 * @author brayvasq
 */
public class Store {

    private final String DEFAULT_FILE_LOC = "animals.json";
    private String file;
    private LinkedList<Animal> animals;

    /**
     * Empty constructor, setup usign the default file path
     */
    public Store() {
        this.file = this.DEFAULT_FILE_LOC;
        this.animals = new LinkedList<>();
    }

    /**
     * Class constructor, setup using a given path
     *
     * @param file file path to save the animals data
     */
    public Store(String file) {
        this.file = file;
        this.animals = new LinkedList<>();
    }

    /**
     * Read the animals file and calls the read_animals() method to store the
     * animals in a list
     *
     * @return true if the data was loaded
     */
    public boolean load() {
        try {
            FileReader reader = new FileReader(this.file);
            JsonArray jsonObject = new Gson().fromJson(reader, JsonArray.class);
            this.readAnimals(jsonObject);
            return true;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Store.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    /**
     * Creates the animals from the data parsed.
     *
     * @param animals JsonArray parsed from file
     */
    public void readAnimals(JsonArray animals) {
        animals.forEach(animal -> {
            JsonObject jsonObject = new Gson().fromJson(animal, JsonObject.class);
            Animal temp = new AnimalFactory(jsonObject.get("kind").getAsString()).getAnimal(jsonObject.get("name").getAsString());
            temp.setAge(jsonObject.get("age").getAsInt());
            temp.setLastWash(new Date(jsonObject.get("lastWash").getAsString()));
            temp.setLastFood(new Date(jsonObject.get("lastFood").getAsString()));
            temp.setAlive(jsonObject.get("alive").getAsBoolean());

            this.animals.add(temp);
        });
    }

    /**
     * Search a animal in the list of animal by name
     *
     * @param name the name of the animal
     * @return The equivalent animal object to the given name
     */
    public Animal find(String name) {
        Animal animal = this.animals
                .stream()
                .filter(item -> name.equals(item.getName()))
                .findAny() //Return the first element that match
                .orElse(null);

        return animal;
    }

    /**
     * Add a new animal object
     *
     * @param animal the animal object to add
     * @return true if the animal was saved successfully
     */
    public boolean add(Animal animal) {
        this.animals.add(animal);
        return this.save();
    }

    /**
     * Delete an animal by name
     *
     * @param name the name of the animal
     * @return true if the animal was deleted successfully
     */
    public boolean remove(String name) {
        Animal animal = this.find(name);
        boolean deleted = false;

        if (animal != null) {
            this.animals.remove(animal);
            deleted = this.save();
        }

        return deleted;
    }

    /**
     * Parse the animal list into json data and store in a file
     *
     * @return true if the data was saved successfully
     */
    public boolean save() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String jsonString = gson.toJson(this.animals);

        try {
            FileWriter writer = new FileWriter(this.file);
            writer.write(jsonString);
            writer.flush();

            return true;
        } catch (IOException ex) {
            Logger.getLogger(Store.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    /**
     * @return the animals
     */
    public LinkedList<Animal> getAnimals() {
        return animals;
    }
}
