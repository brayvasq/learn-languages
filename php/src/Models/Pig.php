<?php

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
namespace App;

include_once 'Animal.php';

/**
 * A child class, representing a Pig. It extends from Animal class
 * 
 * @author brayvasq
 */
class Pig extends Animal{
    /**
     * Class constructor, setup the specific Pig properties
     * 
     * @param name the name of the Pig
     */
    public function __construct(String $name = "") {
        parent::__construct($name);
        $this->limitFood = 2;
        $this->limitWash = 5;
        $this->kind = "pig";
    }
    
    /**
     * returns the Pig character, depending on the isAlive() method
     *
     * @return The Pig character
     */
    public function getCharacter() {
        $character .= $this->isAlive() ? "（`（●●）´）" : "（x（●●）x）";
        return $character;
    }

    /**
     * returns the Pig sound.
     *
     * @return The Pig sound
     */
    public function speak() {
        return "Oink Oink!!!";
    }
}
