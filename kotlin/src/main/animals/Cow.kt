package animals

import animals.Animal

/**
 * @author brayvasq <brayvasq@gmail.com>
 * @version 0.1
 * @since 2018-03-29
 * This is a class that represent a Cow inheriting animal class.
 */
class Cow(id:String,name:String,age:Int,weight:Double,price:Double) : Animal(id,name,age,weight,price){
    
    /**
     * This methods is the constructor of the class and use the parent constructor.
     * @param id is a identifier of the animal.
     * @param name is a name for the animal.
     * @param age is an age that is used to determinate if is alive
     * @param weight 
     * @param price is the simple price of animal
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
     * @return final price based on a simple price and the weight of the animal
     */
    override fun calculatePrice() : Double{
        return price * 3 * weight
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
     * Just show the characteristic sound of the cow.
     * @return nothing
     */
    override fun speak(){
        println("Muuuu!!")
    }

    /**
     * This is a overwritten method from the parent class.
     * This method just show the life expectancy of the animal.
     * @return nothing
     */
    override fun getLifeExpectancy(){
        println("25 - 30 years")
    }
}