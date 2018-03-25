package animals;
/**
 * @author brayvasq <brayvasq@gmail.com>
 * @version 0.1
 * @since 2018-03-25
 * This is a abstract class that represent a general animal.
 */
public abstract class Animal{
    private String id;
    private String name;
    private int age;
    private float weight;
    private double price;
    private boolean alive;
    /**
     * This methods is the constructor of the class.
     * @param id is a identifier of the animal.
     * @param name is a name for the animal.
     * @param age is an age that is used to determinate if is alive
     * @param weight 
     * @param price is the simple price of animal
     * the attribute alive is determinate in the child classes
     */
    public Animal(String id,String name,int age, float weight,double price){
        this.id = id;
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.price = price;
        this.alive = true;
    }
    /**
     * The price is calculate in the child classes
     */
    public abstract double calculatePrice();
    /**
     * This method show the characteristic sound of the animal.
     * Is implemented in the child classes.
     */
    public abstract void speak();
    /**
     * This method just show all information of the animal
     */
    public void getInfo(){
        String response = "Id : "+this.id+"\n"+
                          "Name : "+this.name+"\n"+
                          "Age : "+this.age+"\n"+
                          "Weight : "+this.weight+"\n"+
                          "Price : "+this.price+"\n"+
                          "Alive : "+this.alive+"\n";
        System.out.println(response);
    }
    /**
     * this method change the value of the variable alive.
     */
    public void setAlive(boolean alive){
        this.alive = alive;
    }
    /**
     * @return id, get the id of the animal
     */
    public String getId(){
        return this.id;
    }
    /**
     * @return name, get the name of the animal
     */
    public String getName(){
        return this.name;
    }
    /**
     * @return age, get the age of the animal
     */
    public int getAge(){
        return this.age;
    }
    /**
     * @return weight, get the weight of the animal
     */
    public float getWeight(){
        return this.weight;
    }
    /**
     * @return price, get the price of the animal
     */
    public double getPrice(){
        return this.price;
    }
}