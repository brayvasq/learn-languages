import animals.Animal;
import animals.Cow;
import animals.Sheep;
import farm.Farm;
import java.util.Scanner;
import java.util.LinkedList;
/**
 * @author brayvasq <brayvasq@gmail.com>
 * @version 0.1
 * @since 2018-03-25
 * This is the principal in to program. 
 * This class interact with the user through a inputs.
 */
public class Main{
    public static void main(String[] args){
        System.out.println("The Java Farm");

        int option = 0;
        Scanner reader = new Scanner(System.in);
        String message = "\n\n1.Add Animal\n"+
                "2.Del Animal\n"+
                "3.Get Info Farm\n"+
                "4.Get Info Animals\n"+
                "5.Search Animal\n"+
                "6.Sort by price\n"+
                "7.Exit\n";
        
        Farm farm = new Farm("My Farm","Av 34");
        while (option!=7) {
            System.out.println(message);
            option = reader.nextInt();
            if(option==1){
                System.out.println("\n\n Create Animal : \n");
                System.out.print("Id : ");
                String id = reader.next();
                System.out.print("Name : ");
                String name = reader.next();
                System.out.print("Age : ");
                int age = reader.nextInt();
                System.out.print("Weight : ");
                float weight = reader.nextFloat();
                System.out.print("Price : ");
                double price = reader.nextDouble();

                System.out.print("Type : 1.Sheep - 2.Cow : ");
                int type_animal = reader.nextInt();
                Animal animal = null;
                switch (type_animal) {
                    case 1:
                        animal = new Sheep(id,name,age,weight,price);
                        break;
                    case 2:
                        animal = new Cow(id,name,age,weight,price);                    
                        break;
                    default:
                        System.out.println("Error in type");
                        break;
                }
                farm.addAnimal(animal);
            }else if(option==2){
                String id = reader.next();
                farm.delAnimal(id);
            }else if(option==3){
                farm.getInfo();
            }else if(option==4){
                farm.getAnimalsInfo();
            }else if(option==5){
                String id = reader.next();
                Animal a = farm.searchAnimal(id.trim());
                a.getInfo();
            }else if(option==6){
                LinkedList<Animal> animals = farm.sortByPrice();
                for(Animal a:animals){
                    System.out.println("Id : "+a.getId()+" - Age : "+a.getAge());
                }
            }
        }
    }
}