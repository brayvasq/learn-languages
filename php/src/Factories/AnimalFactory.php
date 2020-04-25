<?php
namespace App;

include_once './Models/Cow.php';
include_once './Models/Pig.php';

class AnimalFactory {
    private $type;

    public function __construct($type = "cow"){
        $this->type = $type == null ? "cow" : $type;
    }

    public function getAnimal(String $name){
        $animal = null;

        if("cow" == $this->type){
            $animal = new Cow($name);
        } else if ("pig" == $this->type){
            $animal = new Pig($name);
        }

        return $animal;
    }
}
?>
