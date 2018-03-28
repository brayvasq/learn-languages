<?
    namespace App;
    /**
     * @author brayvasq <brayvasq@gmail.com>
     * @version 0.1
     * @since 2018-03-27
     * This is a abstract class that represent a general animal.
     */
    abstract class Animal{
        protected $id;
        protected $name;
        protected $age;
        protected $weight;
        protected $price;
        protected $alive;
        /**
         * This methods is the constructor of the class.
         * @param id is a identifier of the animal.
         * @param age is a name for the animal.
         * @param weight
         * @param price is the simple price of animal
         * the attribute alive is determinate in the child classes
         */
        function __construct(String $id,String $name,int $age,float $weight,float $price){
            $this->id = $id;
            $this->name = $name;
            $this->age = $age;
            $this->weight = $weight;
            $this->price = $price;
        }
        /**
         * The price is calculate in the child classes
         */
        public abstract function calculatePrice();
        /**
         * This method show the characteristic sound of the animal.
         * Is implemented in the child classes.
         */
        public abstract function speak();
        /**
         * This method just show all information of the animal
         */
        public function getInfo(){
            $response = "Id : {$this->id}\n".
                        "Name :{$this->name}\n".
                        "Age : {$this->age}\n".
                        "Weight :{$this->weight}\n".
                        "Price : {$this->price}\n".
                        "Alive : {$this->alive}\n";
            echo $response;
        }

        function __destruct(){

        }

        /**
         * @return id, get the id of the animal
         */
        public function getId() : String{
            return $this->id;
        }
        /**
         * @return name, get the name of the animal
         */
        public function getName() : String{
            return $this->name;
        }
        /**
         * @return price, get the price of the animal
         */
        public function getPrice() : float{
            return $this->price;
        }
    }
?>