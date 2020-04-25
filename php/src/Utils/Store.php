<?php
namespace App;

include_once './Factories/AnimalFactory.php';

/**
 * A util class to operate with files
 *
 * @author brayvasq
 */
class Store{
    private $file;
    public $animals;

    /**
     * Class constructor, setup using a given path
     *
     * @param file file path to save the animals data
     */
    public function __construct(String $file = "animals.json"){
        $this->file = $file;
        $this->animals = array();
    }

    /**
     * Read the animals file and calls the read_animals() method to store the
     * animals in a list
     */
    public function load(){
        $file = fopen($this->file, "r") or die("Unable to open file!");

        $json = fread($file, filesize($this->file));

        $jsonArray = json_decode($json);

        $this->readAnimals($jsonArray);
    }

    /**
     * Creates the animals from the data parsed.
     *
     * @param animals JsonArray parsed from file
     */
    private function readAnimals($animals){
        foreach($animals as $i){
            $animal = (new AnimalFactory($i->kind))->getAnimal($i->name);
            $animal->setAge($i->age);
            $animal->setLastWash($i->lastWash->date);
            $animal->setLastFood($i->lastFood->date);
            $animal->setAlive($animal->isAlive());
            array_push($this->animals, $animal);
        }
    }

    /**
     * Search a animal in the list of animal by name
     *
     * @param name the name of the animal
     * @return The equivalent animal object to the given name
     */
    public function find($name){
        foreach($this->animals as $animal){
            if($animal->getName() == $name){
                return $animal;
            }
        }
    }

    /**
     * Add a new animal object
     *
     * @param animal the animal object to add
     * @return true if the animal was saved successfully
     */
    public function add($animal){
        array_push($this->animals, $animal);
        return $this->save();
    }

    /**
     * Delete an animal by name
     *
     * @param name the name of the animal
     * @return true if the animal was deleted successfully
     */
    public function remove($name){
        $animal = $this->find($name);
        $deleted = false;

        if($animal != null){
            foreach ($this->animals as $key => $value) {
                if($value->getName() == $animal->getName()) {
                    unset($this->animals[$key]);
                    $deleted = $this->save();
                }
            }
        }

        return $deleted;
    }

    /**
     * Parse the animal list into json data and store in a file
     *
     * @return true if the data was saved successfully
     */
    public function save(){
        $jsonString = json_encode($this->animals);

        $file = fopen($this->file, "w") or die("Unable to open file!");
        fwrite($file, $jsonString);
        fclose($file);

        return true;
    }
}
?>
