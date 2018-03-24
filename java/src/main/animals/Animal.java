package animals;

public abstract class Animal{
    private String id;
    private String name;
    private int age;
    private float weight;
    private double price;
    private boolean alive;

    public Animal(String id,String name,int age, float weight,double price){
        this.id = id;
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.price = price;
        this.alive = true;
    }

    public abstract double calculatePrice();

    public abstract void speak();

    public void getInfo(){
        String response = "Id : "+this.id+"\n"+
                          "Name : "+this.name+"\n"+
                          "Age : "+this.age+"\n"+
                          "Weight : "+this.weight+"\n"+
                          "Price : "+this.price+"\n"+
                          "Alive : "+this.alive+"\n";
        System.out.println(response);
    }

    public void setAlive(boolean alive){
        this.alive = alive;
    }

    public String getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

    public float getWeight(){
        return this.weight;
    }

    public double getPrice(){
        return this.price;
    }
}