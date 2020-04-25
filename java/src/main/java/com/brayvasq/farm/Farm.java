/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brayvasq.farm;

import com.brayvasq.farm.models.Animal;
import com.brayvasq.farm.utils.Store;
import com.brayvasq.farm.factories.AnimalFactory;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A class that works as a kind of controller.
 *
 * @author brayvasq
 */
public class Farm {

    private Store store;

    /**
     * Class constructor, setup the store class and load the saved animals
     */
    public Farm() {
        this.store = new Store();
        this.store.load();
    }

    /**
     * List all the animals stored. Also, it can filter the animals by animal
     * type and age
     *
     * @param age The value to filter animals by age (default: null).
     * @param type The value to filter animals by animal type (default: null).
     */
    public void listAnimals(String age, String type) {
        List<Animal> animals = this.store.getAnimals();

        animals = age == null ? animals : animals.stream().filter(item -> item.getAge() == Integer.parseInt(age)).collect(Collectors.toList());
        animals = type == null ? animals : animals.stream().filter(item -> item.getKind().equals(type)).collect(Collectors.toList());

        animals.forEach(animal -> {
            System.out.println(animal);
        });
    }

    /**
     * Uses the AnimalFactory to create a new animal
     *
     * @param name The name of the animal
     * @param type The animal type
     * @return true if the animal was created successfully
     */
    public boolean createAnimal(String name, String type) {
        boolean created = false;
        Animal animal = new AnimalFactory(type).getAnimal(name);

        if (animal != null) {
            created = this.store.add(animal);
        }

        return created;
    }

    /**
     * Deletes a animal by name
     *
     * @param name The name of the animal
     * @return true if the animal was deleted successfully
     */
    public boolean deleteAnimal(String name) {
        return this.store.remove(name);
    }

    /**
     * Search a animal by name and prints the animal info
     *
     * @param name the name of the animal
     */
    public void search(String name) {
        Animal animal = this.store.find(name);

        if (animal != null) {
            System.out.println(animal);
        } else {
            System.out.println("Animal not found");
        }
    }

    /**
     * Gives food to an animal
     *
     * @param name the name of the animal
     */
    public void food(String name) {
        Animal animal = this.store.find(name);

        if (animal != null) {
            animal.eat();
            this.store.save();
        }
    }

    /**
     * Gives a shower to an animal
     *
     * @param name the name of the animal
     */
    public void wash(String name) {
        Animal animal = this.store.find(name);

        if (animal != null) {
            animal.wash();
            this.store.save();
        }
    }

    /**
     * Prints if an animal is alive
     *
     * @param name the name of the animal
     */
    public void alive(String name) {
        Animal animal = this.store.find(name);

        if (animal != null) {
            System.out.println(animal.isAlive());
        }
    }
}
