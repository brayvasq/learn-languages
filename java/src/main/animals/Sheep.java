package animals;

import animals.Animal;
/**
 * @author brayvasq <brayvasq@gmail.com>
 * @version 0.1
 * @since 2018-03-25
 * This is a class that represent a Sheep inheriting animal class.
 */
public class Sheep extends Animal{
    /**
     * This methods is the constructor of the class and use the parent constructor.
     * @param id is a identifier of the animal.
     * @param name is a name for the animal.
     * @param age is an age that is used to determinate if is alive
     * @param weight 
     * @param price is the simple price of animal
     * the attribute alive is determinate with the param age.
     */
    public Sheep(String id,String name,int age, float weight,double price){
        super(id,name,age,weight,price);
        this.setAlive(this.getAge()<=15? true:false);
    }
    /**
     * This is a overwritten method from the parent class.
     * @return final price based on a simple price and the age of the animal
     */
    @Override
    public double calculatePrice(){
        return this.getPrice() * 2 * this.getAge();
    }
    /**
     * This is a overwritten method from the parent class.
     * Just show the characteristic sound of the sheep.
     */
    @Override
    public void speak(){
        System.out.println("Meeehh!!");
    }
}