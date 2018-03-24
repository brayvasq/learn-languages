package animals;

import animals.Animal;

public class Cow extends Animal{
    public Cow(String id,String name,int age, float weight,double price){
        super(id,name,age,weight,price);
        this.setAlive(this.getAge()<=25? true:false);
    }

    @Override
    public double calculatePrice(){
        return this.getPrice() * 3 * this.getWeight();
    }

    @Override
    public void speak(){
        System.out.println("Muuuu!!");
    }

}