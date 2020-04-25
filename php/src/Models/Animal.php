<?php
namespace App;

include_once './Utils/Dates.php';

/**
 * An abstract class representing a general Animal.
 * @author brayvasq
 */
abstract class Animal implements \JsonSerializable {

    private $name;
    private $age;
    private $lastWash;
    private $lastFood;
    private $alive;
    protected $limitWash;
    protected $limitFood;
    protected $kind;

    /**
     * Class constructor to setup all Animal properties
     * @param name the name of the animal
     */
    public function __construct(String $name = "") {
        $this->name = $name;
        $this->age = 0;
        $this->lastWash = new \DateTime();
        $this->lastFood = new \DateTime();
        $this->alive = true;
        $this->kind = "";
    }

    /**
     * Gives food to the animal. It changes the last_food attribute and assign the actual date
     */
    public function eat() {
        $this->lastFood = new \DateTime();
    }

    /**
     * Gives the animal a shower. It changes the last_food attribute and assign the actual date
     */
    public function wash() {
        $this->lastWash = new \DateTime();
    }

    /**
     * returns the Animal info.
     * @return the full Animal info
     */
    public function getInfo() {
        $character = $this->getCharacter();
        $animal = str_repeat('#', 50) . "\n";
        $animal .= $character . "\n";
        $animal .= "Name: $this->name \n";
        $animal .= "Alive: {$this->isAlive()} \n";
        $animal .= "Sound: {$this->speak()} \n";
        $animal .= "Wash time limit: " . ($this->limitWash - Dates::getDiffInMinutes($this->lastWash)) . "\n";
        $animal .= "Food time limit: " . ($this->limitFood - Dates::getDiffInMinutes($this->lastFood)) . "\n";
        $animal .= str_repeat('#', 50) . "\n";

        return $animal;
    }

    /**
     * Calculates if the animal is still alive. Uses the util Dates to determinate the
     * difference in minutes between the last_wash and last_food attributes and their
     * respective limits
     * @return false if one of the limits was exceeded
     */
    public function isAlive(){
        if(Dates::isGreatter($this->lastWash, $this->limitWash)){
            $this->alive = false;
        }

        if(Dates::isGreatter($this->lastFood, $this->limitFood)){
            $this->alive = false;
        }

        return $this->alive;
    }

    /**
     * Abstract method, it return the animal sound. it's implemented in the child classes
     * @return The characteristic Animal sound
     */
    public abstract function speak();

    /**
     * Abstract method, it return the animal character. it's implemented in the child classes
     * @return The Animal character
     */
    public abstract function getCharacter();

    /**
     * @return the name
     */
    public function getName(): String {
        return $this->name;
    }

    /**
     * @param name the name to set
     */
    public function setName(String $name){
        $this->name = $name;
    }

    /**
     * @return the age
     */
    public function getAge() : String{
        return $this->age;
    }

    /**
     * @param age the age to set
     */
    public function setAge(int $age){
        $this->age = $age;
    }

    /**
     * @param lastWash the lastWash to set
     */
    public function setLastWash($lastWash){
        $this->lastWash = new \DateTime($lastWash);
    }

    /**
     * @param lastFood the lastFood to set
     */
    public function setLastFood($lastFood){
        $this->lastFood = new \DateTime($lastFood);
    }

    /**
     * @return the lastFood
     */
    public function setAlive(bool $alive){
        $this->alive = $alive;
    }

    /**
     * Obtains the object properties to serialize
     * @return array of attributes
     */
    public function jsonSerialize()
    {
        $vars = get_object_vars($this);

        return $vars;
    }

    /**
     * Uses the getInfo() method to obtain a string to represent the object
     *
     * @return the Animal in string format
     */
    public function __toString() {
        return $this->getInfo();
    }

    
    /**
     * Destroy the object
     */
    function __destruct() {}
}

?>
