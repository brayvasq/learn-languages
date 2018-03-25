package animals;

import animals.Animal;
/**
 * @author brayvasq <brayvasq@gmail.com>
 * @version 0.1
 * @since 2018-03-25
 * This is a class that represent a Cow inheriting animal class.
 */
public class Cow extends Animal{
    /**
     * This methods is the constructor of the class and use the parent constructor.
     * @param id is a identifier of the animal.
     * @param name is a name for the animal.
     * @param age is an age that is used to determinate if is alive
     * @param weight 
     * @param price is the simple price of animal
     * the attribute alive is determinate with the param age.
     */
    public Cow(String id,String name,int age, float weight,double price){
        super(id,name,age,weight,price);
        this.setAlive(this.getAge()<=25? true:false);
    }
    /**
     * This is a overwritten method from the parent class.
     * @return final price based on a simple price and the weight of the animal
     */
    @Override
    public double calculatePrice(){
        return this.getPrice() * 3 * this.getWeight();
    }
    /**
     * This is a overwritten method from the parent class.
     * Just show the characteristic sound of the cow.
     */
    @Override
    public void speak(){
        System.out.println("Muuuu!!");
    }
}