package animals;

import animals.Animal;

public class Sheep extends Animal{
    public Sheep(String id,String name,int age, float weight,double price){
        super(id,name,age,weight,price);
        this.setAlive(this.getAge()<=15? true:false);
    }

    @Override
    public double calculatePrice(){
        return this.getPrice() * 2 * this.getAge();
    }

    @Override
    public void speak(){
        System.out.println("Meeehh!!");
    }

}