<?
    namespace App;
    require_once './Animals/Animal.php';
    /**
     * @author brayvasq <brayvasq@gmail.com>
     * @version 0.1
     * @since 2018-03-27
     * This is a abstract class that represent a general animal.
     */
    class Farm{
        private $name;
        private $address;
        private $animals;
        /**
         * This methods is the constructor of the class.
         * @param name is a identifier of the farm.
         * @param address is a simple phisical direction of the farm.
         * the attribute animals contains all animals of the farm.
         */
        function __construct(String $name,String $address){
            $this->name = $name;
            $this->address = $address;
            $this->animals = array();
        }
        /**
         * This Method just show the information of the farm
         */
        public function getInfo(){
            echo "Name : ",$this->name,"\nAddress : ",$this->address,"\n";
        }
        /**
         * This method iterate the list of animals and show basic info of each animal
         */
        public function getAnimalsInfo(){
            if(!empty($this->animals)){
                foreach ($this->animals as $i) {
                    echo "Id : ",$i->getId()," - Name : ",$i->getName(),"\n";
                }
            }
        }
        /**
         * This method iterate the list of animals for search a specific animal
         * @param id is the identifier of the animal to search
         * @return resp, contain the animal with the searched id
         */
        public function searchAnimal(String $id){
            $resp = null;
            foreach ($this->animals as $i) {
                if($i->getId()==$id){
                    $resp = $i;
                }
            }
            return $resp;
        }
        /**
         * This method just add a new animal to the list of animals
         * @param animal is a object that will be added to the list
         */
        public function addAnimal(Animal $animal){
            array_push($this->animals,$animal);
        }
        /**
         * This method delete a specific animal based on a id
         * @param id the id of animal to search and delete
         */
        public function delAnimal(String $id){
            try{
                $j = 0;
                foreach ($this->animals as $i) {
                    if($i->getId()==$id){
                        unset($this->animals[$j]);
                    }
                    $j=$j+1;
                }
            }catch(Exception $e){echo "Error\n";}
        }
        /**
         * This method implements the algorithm bubble sort
         * to sort the list of animals based on his price
         * @return response, is a list with the animals sorted by price
         */
        public function sortByPrice(){
            $response = $this->animals;
            $limit = count($response)-1;
            if($limit>1){
                for($i=0;$i<$limit;$i++){
                    for($j=0;$j<($limit-$i);$j++){
                        if($response[$j]->getPrice() > $response[$j+1]->getPrice()){
                            $aux = $response[$j];
                            $response[$j] = $response[$j+1];
                            $response[$j+1] = $aux;
                        }
                    }
                }
            }
            return $response;
        }
    }
?>