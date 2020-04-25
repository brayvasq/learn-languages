<?php

namespace App;

include_once './Farm.php';

/**
 * Class that works as a kind of UI
 *
 * @author brayvasq
 */
class Commands {

    private $farm;
    private $data;
    private $dataLength;

    /**
     * Class constructor
     *
     * @param data The input array
     */
    public function __construct($data) {
        $this->farm = new Farm();
        $this->data = $data;
        $this->dataLength = count($this->data);
    }

    /**
     * Obtain the command and process the input data
     */
    public function process() {
        $command = $this->getCommand();
        if ($command != null) {
            $this->verifyCommand($command);
        } else {
            $this->help();
        }
    }

    /**
     * Returns the command
     *
     * @return The first item in the input array, if it's given
     */
    private function getCommand() {
        return $this->dataLength > 1 ? $this->data[1] : null;
    }

    /**
     * Identify the specific action to execute and call the respective action
     *
     * @param command Command obtained from getCommand() method
     */
    private function verifyCommand(String $command) {
        if (in_array($command, array("list", "l"))) {
            $this->listCommand();
        } else if (in_array($command, array("create", "c"))) {
            if ($this->createCommand()) {
                $this->listCommand();
            }
        } else if (in_array($command, array("delete", "d"))) {
            if ($this->deleteCommand()) {
                $this->listCommand();
            }
        } else if (in_array($command, array("search", "s"))) {
            $this->searchCommand();
        } else if (in_array($command, array("food", "f"))) {
            $this->foodCommand();
        } else if (in_array($command, array("wash", "w"))) {
            $this->washCommand();
        } else if (in_array($command, array("alive", "a"))) {
            $this->aliveCommand();
        } else if (in_array($command, array("help", "h"))) {
            $this->help();
        } else {
            $this->help();
        }
    }

    /**
     * Process the [list | l] command
     */
    private function listCommand() {
        $this->farm->listAnimals();
    }

    /**
     * Process the [create | c] command
     *
     * @return true, if the animal was created
     */
    private function createCommand() {
        $name = $this->getParam("name=", "([a-zA-Z]+)");
        $type = $this->getParam("type=", "([a-zA-Z]+)");

        $created = false;

        if ($name != null && !empty($name)) {
            $created = $this->farm->createAnimal($name, $type);
        } else {
            echo "Error!: A name is required to create an animal" . PHP_EOL;
            $this->createCommandHelp();
        }

        return $created;
    }

    /**
     * Process the [delete | c] command
     *
     * @return true if the animal was deleted
     */
    private function deleteCommand() {
        $name = $this->getParam("name=", "([a-zA-Z]+)");
        
        $deleted = false;
        
        if ($name != null && !empty($name)) {
            $deleted = $this->farm->deleteAnimal($name);
        } else {
            echo "Error!: A name is required to delete a animal" . PHP_EOL;
            $this->deleteCommandHelp();
        }
        
        return $deleted;
    }

    /**
     * Process the [search | s] command
     */
    private function searchCommand() {
        $name = $this->getParam("name=", "([a-zA-Z]+)");

        if ($name != null) {
            $this->farm->search($name);
        } else {
            echo "Error!: A name is required to search a animal" . PHP_EOL;
            $this->searchCommandHelp();
        }
    }
    
    /**
     * Process the [food | f] command
     */
    private function foodCommand(){
        $name = $this->getParam("name=", "([a-zA-Z]+)");

        if ($name != null) {
            $this->farm->food($name);
        } else {
            echo "Error!: A name is required to give food to a animal". PHP_EOL;
            $this->foodCommandHelp();
        }
    }
    
    /**
     * Process the [wash | w] command
     */
    private function washCommand(){
        $name = $this->getParam("name=", "([a-zA-Z]+)");

        if ($name != null) {
            $this->farm->wash($name);
        } else {
            echo "Error!: A name is required to give a shower to a animal". PHP_EOL;
            $this->washCommandHelp();
        }
    }
    
    /**
     * Process the [alive | a] command
     */
    private function aliveCommand() {
        $name = $this->getParam("name=", "([a-zA-Z]+)");

        if ($name != null) {
            $this->farm->alive($name);
        } else {
            echo "Error!: A name is required to show if a animal is alive". PHP_EOL;
            $this->aliveCommandHelp();
        }
    }
    
    /**
     * Returns the queried param using regex
     *
     * @param value variable name to search
     * @param dataType variable pattern equivalent
     * @return param, the param value if a match occurs
     */
    private function getParam(String $value, String $dataType) {
        $param = null;

        if ($this->dataLength > 2) {
            $dataString = join(";", array_slice($this->data, 2));
            $matches = array();
            preg_match('/' . $value . $dataType . '/', $dataString, $matches);
            if (count($matches) > 0) {
                $param = str_replace($value, '', $matches[0]);
            }
        }

        return $param;
    }

    /**
     * Shows help for the [create | c] command
     */
    private function createCommandHelp() {
        echo "The PHP Farm - a simple command line animals app" . PHP_EOL;
        echo PHP_EOL;
        echo "Command Usage:" . PHP_EOL;
        echo "  [create  | c]   <name=> <type=>    creates a animal with name" . PHP_EOL;
        echo PHP_EOL;
        echo "Examples:" . PHP_EOL;
        echo "  php Main.php [create  | c]  name=my_animal_name" . PHP_EOL;
        echo "  php Main.php [create  | c]  name=my_animal_name type=pig" . PHP_EOL;
    }

    /**
     * Shows help for the [delete | c] command
     */
    private function deleteCommandHelp(){
        echo "The PHP Farm - a simple command line animals app" . PHP_EOL;
        echo PHP_EOL;
        echo "Command Usage:" . PHP_EOL;
        echo "  [delete  | d]   <name=>        deletes a animal by name" . PHP_EOL;
        echo "" . PHP_EOL;
        echo "Examples:" . PHP_EOL;
        echo "  php Main.php [delete  | d]  name=my_animal_name" . PHP_EOL;
    }
    
    /**
     * Shows help for the [search | s] command
     */
    private function searchCommandHelp(){
        echo "The PHP Farm - a simple command line animals app" . PHP_EOL;
        echo PHP_EOL;
        echo "Command Usage:" . PHP_EOL;
        echo "  [search  | s]   <name=>       searchs a animal by name" . PHP_EOL;
        echo PHP_EOL;
        echo "Examples:" . PHP_EOL;
        echo "  php Main.php [search  | s]  name=my_animal_name" . PHP_EOL;
    }
    
    /**
     * Shows help for the [food | f] command
     */
    private function foodCommandHelp(){
        echo "The PHP Farm - a simple command line animals app"  . PHP_EOL;
        echo PHP_EOL;
        echo "Command Usage:"  . PHP_EOL;
        echo "  [food  | f]   <name=>       gives food to a animal by name"  . PHP_EOL;
        echo PHP_EOL;
        echo "Examples:"  . PHP_EOL;
        echo "  php Main.php [food  | f]  name=my_animal_name"  . PHP_EOL;
    }
    
    /**
     * Shows help for the [wash | w] command
     */
    private function washCommandHelp(){
        echo "The PHP Farm - a simple command line animals app"  . PHP_EOL;
        echo PHP_EOL;
        echo "Command Usage:"  . PHP_EOL;
        echo "  [wash  | w]   <name=>       gives a shower to a animal by name"  . PHP_EOL;
        echo PHP_EOL;
        echo "Examples:"  . PHP_EOL;
        echo "  php Main.php [wash  | w]  name=my_animal_name"  . PHP_EOL;
    }
    
    /**
     * Shows help for the [alive | a] command
     */
    private function aliveCommandHelp(){
        echo "The PHP Farm - a simple command line animals app"  . PHP_EOL;
        echo PHP_EOL;
        echo "Command Usage:"  . PHP_EOL;
        echo "  [alive  | a]   <name=>       checks if an animal is alive by name"  . PHP_EOL;
        echo PHP_EOL;
        echo "Examples:"  . PHP_EOL;
        echo "  php Main.php [alive  | a]  name=my_animal_name"  . PHP_EOL;
    }
    
    /**
     * Shows help for the app
     */
    private function help() {
        echo "The PHP Farm - a simple command line animals app" . PHP_EOL;
        echo PHP_EOL;
        echo "Usage:" . PHP_EOL;
        echo "  php Main.php [command]" . PHP_EOL;
        echo PHP_EOL;
        echo "Available Commands:" . PHP_EOL;
        echo "  [list    | l]                      list all available animals" . PHP_EOL;
        echo "  [create  | c]   <name=> <type=>    create a animal with name" . PHP_EOL;
        echo "  [delete  | d]   <name=>            delete a animal" . PHP_EOL;
        echo "  [search  | s]   <name=>            search a animal" . PHP_EOL;
        echo "  [food    | f]   <name=>            give food to a animal" . PHP_EOL;
        echo "  [wash    | w]   <name=>            give a shower to a animal" . PHP_EOL;
        echo "  [alive   | a]   <name=>            show if a animal is alive" . PHP_EOL;
        echo "  [help    | h]                      help about commands" . PHP_EOL;
        echo PHP_EOL;
        echo "Flags:" . PHP_EOL;
        echo "  -v, --version  show the app version" . PHP_EOL;
        echo PHP_EOL;
        echo "Use php Main.php [command] --help for more information about a command." . PHP_EOL;
    }
}

?>
