<?
    namespace App;
    include_once 'Animal.php';
    /**
     * @author brayvasq <brayvasq@gmail.com>
     * @version 0.1
     * @since 2018-03-27
     * This is a class that represent a Sheep inheriting animal class.
     */
    class Sheep extends Animal{
        /**
         * This methods is the constructor of the class and use the parent constructor.
         * @param id is a identifier of the sheep.
         * @param name is a name for the sheep.
         * @param age is an age that is used to determinate if is alive
         * @param weight 
         * @param price is the simple price of sheep
         * the attribute alive is determinate with the param age.
         */
        function __construct(String $id,String $name,int $age,float $weight,float $price){
            parent::__construct($id,$name,$age,$weight,$price);
            $this->alive = $this->age <= 15 ? true : false;
        }
        /**
         * This is a overwritten method from the parent class.
         * @return final price based on a simple price and the age of the sheep
         */
        public function calculatePrice(){
            return $this->price * 2 * $this->age;
        }
        /**
         * This is a overwritten method from the parent class.
         * Just show the characteristic sound of the sheep.
         */
        public function speak(){
            echo "Meeehh!!";
        }
    }
?>