package animals
/**
 * @author brayvasq <brayvasq@gmail.com>
 * @version 0.1
 * @since 2018-03-29
 * This is a abstract class that represent a general animal.
 */
 abstract class Animal(var id:String,var name:String,var age:Int,var weight:Double,var price:Double){

    var alive:Boolean = false
    /**
     * This methods is the constructor of the class.
     * @param id is a identifier of the animal.
     * @param name is a name for the animal.
     * @param age is an age that is used to determinate if is alive
     * @param weight 
     * @param price is the simple price of animal
     * the attribute alive is determinate in the child classes
     */
    init{
        //alive = false
    }
    /**
     * This method just show all information of the animal
     */
    fun getInfo(){
        val response:String = "Id : ${this.id}\n"+
                          "Name : ${this.name}\n"+
                          "Age : ${this.age}\n"+
                          "Weight : ${this.weight}\n"+
                          "Price : ${this.price}\n"+
                          "Alive : ${this.alive}\n";
        println(response);
    }

    /**
     * The price is calculate in the child classes
     */
    abstract fun calculatePrice() : Double
    /**
     * This method just show if it is carnivorous or herbivore.
     * Is implemented in the child classes.
     */
    abstract fun speak()
    /**
     * This method show the characteristic sound of the animal.
     * Is implemented in the child classes.
     */
    abstract fun eat()
    /**
     * This method just show the life expectancy of the animal.
     * Is implemented in the child classes.
     */
    abstract fun getLifeExpectancy()
 }