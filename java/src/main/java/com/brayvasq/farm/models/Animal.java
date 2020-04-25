package com.brayvasq.farm.models;

import java.util.Date;
import com.brayvasq.farm.utils.Dates;

/**
 * An abstract class representing a general Animal.
 * @author brayvasq
 */
public abstract class Animal 
{
    private String name;
    private int age;
    private Date lastWash;
    private Date lastFood;
    private Boolean alive;
    protected int limitWash;
    protected int limitFood;
    protected String kind;

    /**
     * Empty constructor to set defaults to params
     */
    public Animal()
    {
        this("");
    }
    
    /**
     * Class constructor to setup all Animal properties
     * @param name the name of the animal
     */
    public Animal(String name)
    {
        this.name = name;
        this.age = 0;
        this.lastWash = new Date();
        this.lastFood = new Date();
        this.alive = true;
        this.kind = "";
    }

    /**
     * Abstract method, it return the animal sound. it's implemented in the child classes
     * @return The characteristic Animal sound
     */
    public abstract String speak();

    /**
     * Abstract method, it return the animal character. it's implemented in the child classes
     * @return The Animal character
     */
    public abstract String getCharacter();

    /**
     * Gives food to the animal. It changes the last_food attribute and assign the actual date
     */
    public void eat()
    {
        this.lastFood = new Date();
    }

    /**
     * Gives the animal a shower. It changes the last_food attribute and assign the actual date
     */
    public void wash()
    {
        this.lastWash = new Date();
    }

    /**
     * returns the Animal info.
     * @return the full Animal info
     */
    public String GetInfo()
    {
        String character = this.getCharacter();
        String animal = "";

        animal += "#".repeat(50) + "\n";
        animal += character + "\n";
        animal += "Name: " + this.name + "\n";
        animal += "Alive: " + this.alive + "\n";
        animal += "Sound: " + this.speak() + "\n";
        animal += "Wash time limit: " + (this.limitWash - Dates.getDiffInMinutes(this.lastWash)) + "\n";
        animal += "Food time limit: " + (this.limitFood - Dates.getDiffInMinutes(this.lastFood)) + "\n";
        animal += "#".repeat(50) + "\n";

        return animal;
    }

    /**
     * Calculates if the animal is still alive. Uses the util Date to determinate the
     * difference in minutes between the last_wash and last_food attributes and their
     * respective limits
     * @return false if one of the limits was exceeded
     */
    public boolean isAlive(){
        if(Dates.isGreatter(this.lastWash, this.limitWash)){
            this.alive = false;
        }
        
        if(Dates.isGreatter(this.lastFood, this.limitFood)){
            this.alive = false;
        }
        
        return this.alive;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the lastWash
     */
    public Date getLastWash() {
        return lastWash;
    }

    /**
     * @param lastWash the lastWash to set
     */
    public void setLastWash(Date lastWash) {
        this.lastWash = lastWash;
    }

    /**
     * @return the lastFood
     */
    public Date getLastFood() {
        return lastFood;
    }

    /**
     * @param lastFood the lastFood to set
     */
    public void setLastFood(Date lastFood) {
        this.lastFood = lastFood;
    }

    /**
     * @return the alive
     */
    public Boolean getAlive() {
        return alive;
    }

    /**
     * @param alive the alive to set
     */
    public void setAlive(Boolean alive) {
        this.alive = alive;
    }

    /**
     * @return the limitWash
     */
    public int getLimitWash() {
        return limitWash;
    }

    /**
     * @param limitWash the limitWash to set
     */
    public void setLimitWash(int limitWash) {
        this.limitWash = limitWash;
    }

    /**
     * @return the limitFood
     */
    public int getLimitFood() {
        return limitFood;
    }

    /**
     * @param limitFood the limitFood to set
     */
    public void setLimitFood(int limitFood) {
        this.limitFood = limitFood;
    }

    /**
     * @return the kind
     */
    public String getKind() {
        return kind;
    }

    /**
     * @param kind the kind to set
     */
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     * Uses the getInfo() method to obtain a string to represent the object
     *
     * @return the Animal in string format
     */
    @Override
    public String toString() {
        return this.GetInfo();
    }
}
