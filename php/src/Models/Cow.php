<?php

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
namespace App;

include_once 'Animal.php';

/**
 * A child class, representing a Cow. It extends from Animal class
 *
 * @author brayvasq
 */
class Cow extends Animal{
    /**
     * Class constructor, setup the specific Cow properties
     *
     * @param name the name of the Cow
     */
    public function __construct(String $name = "") {
        parent::__construct($name);
        $this->limitFood = 3;
        $this->limitWash = 10;
        $this->kind = "cow";
    }
    
    /**
     * Returns the Cow character, depending on the isAlive() method
     *
     * @return The Cow character
     */
    public function getCharacter() {
        $character = "  (....)  \n";
        $character .= $this->isAlive() ? "（0 .. 0）" : "（X .. X）";
        return $character;
    }

    /**
     * Returns the Cow sound.
     *
     * @return The Cow sound
     */
    public function speak() {
        return "Muuu Muuu!!!";
    }
}
