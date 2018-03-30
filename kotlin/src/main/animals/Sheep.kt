package animals

import animals.Animal

/**
 * @author brayvasq <brayvasq@gmail.com>
 * @version 0.1
 * @since 2018-03-29
 * This is a class that represent a Sheep inheriting animal class.
 */
class Sheep(id:String,name:String,age:Int,weight:Double,price:Double) : Animal(id,name,age,weight,price){
    
    /**
     * This methods is the constructor of the class and use the parent constructor.
     * @param id is a identifier of the Sheep.
     * @param name is a name for the Sheep.
     * @param age is an age that is used to determinate if is alive
     * @param weight 
     * @param price is the simple price of Sheep
     * the attribute alive is determinate with the param age.
     */
    init{
        alive = when {
            
            age <= 25 -> true

            else -> false
        
        }
    }

    /**
     * This is a overwritten method from the parent class.
     * @return final price based on a simple price and the age of the Sheep
     */
    override fun calculatePrice():Double{
        return price * 2 * age
    }

    /**
     * This is a overwritten method from the parent class.
     * This method just show if it is carnivorous or herbivore.
     * @return nothing
     */
    override fun eat(){
        println("I am a herbivoret")
    }

    /**
     * This is a overwritten method from the parent class.
     * Just show the characteristic sound of the Sheep.
     * @return nothing
     */
    override fun speak(){
        println("Meeehh!!")
    }
    
    /**
     * This is a overwritten method from the parent class.
     * This method just show the life expectancy of the Sheep.
     * @return nothing
     */
    override fun getLifeExpectancy(){
        println("15 years")
    }
}