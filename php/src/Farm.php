<?php

namespace App;

include_once './Utils/Store.php';
include_once './Factories/AnimalFactory.php';

/**
 * A class that works as a kind of controller.
 *
 * @author brayvasq
 */
class Farm {
    private $store;

    /**
     * Class constructor, setup the store class and load the saved animals
     */
    public function __construct(){
        $this->store = new Store();
        $this->store->load();
    }

    /**
     * List all the animals stored. Also, it can filter the animals by animal
     * type and age
     */
    public function listAnimals(){
        foreach($this->store->animals as $animal){
            echo $animal;
        }
    }

    /**
     * Uses the AnimalFactory to create a new animal
     *
     * @param name The name of the animal
     * @param type The animal type
     * @return true if the animal was created successfully
     */
    public function createAnimal($name, $type){
        $created = false;
        $animal = (new AnimalFactory($type))->getAnimal($name);

        if ($animal != null){
            $created = $this->store->add($animal);
        }

        return $created;
    }

    /**
     * Deletes a animal by name
     *
     * @param name The name of the animal
     * @return true if the animal was deleted successfully
     */
    public function deleteAnimal($name){
        return $this->store->remove($name);
    }

    /**
     * Search a animal by name and prints the animal info
     *
     * @param name the name of the animal
     */
    public function search(String $name){
        $animal = $this->store->find($name);
        if (animal != null) {
            echo $animal;
        } else {
            echo "Animal not found";
        }
    }

    /**
     * Gives food to an animal
     *
     * @param name the name of the animal
     */
    public function food(String $name){
        $animal = $this->store->find($name);

        if($animal == null){
            $animal->eat();
            $this->store->save();
        }
    }

    /**
     * Gives a shower to an animal
     *
     * @param name the name of the animal
     */
    public function wash(String $name){
        $animal = $this->store->find($name);

        if($animal == null){
            $animal->wash();
            $this->store->save();
        }
    }

    /**
     * Prints if an animal is alive
     *
     * @param name the name of the animal
     */
    public function alive(String $name){
        $animal = $this->store->find($name);

        if($animal == null){
            echo $animal->isAlive() . "\n";
        }
    }
}

?>
