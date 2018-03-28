<?
    namespace App;
    include_once 'Animal.php';
    /**
     * @author brayvasq <brayvasq@gmail.com>
     * @version 0.1
     * @since 2018-03-27
     * This is a class that represent a Cow inheriting animal class.
     */
    class Cow extends Animal{
        /**
         * This methods is the constructor of the class and use the parent constructor.
         * @param id is a identifier of the cow.
         * @param name is a name for the cow.
         * @param age is an age that is used to determinate if is alive
         * @param weight 
         * @param price is the simple price of cow
         * the attribute alive is determinate with the param age.
         */
        function __construct(String $id,String $name,int $age,float $weight,float $price){
            parent::__construct($id,$name,$age,$weight,$price);
            $this->alive = $this->age <= 25 ? true : false;
        }
        /**
         * This is a overwritten method from the parent class.
         * @return final price based on a simple price and the weight of the cow
         */
        public function calculatePrice(){
            return $this->price * 3 * $this->weight;
        }
        /**
         * This is a overwritten method from the parent class.
         * Just show the characteristic sound of the cow.
         */
        public function speak(){
            echo "Muuuu!!";
        }
    }
?>