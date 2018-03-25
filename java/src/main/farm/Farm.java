package farm;

import java.util.LinkedList;
import animals.Animal;
/**
 * @author brayvasq <brayvasq@gmail.com>
 * @version 0.1
 * @since 2018-03-25
 * This class just simulate a Farm.
 */
public class Farm{
    private String name;
    private String address;
    private LinkedList<Animal> animals;

    /**
     * This methods is the constructor of the class.
     * @param name is a identifier of the farm.
     * @param address is a simple phisical direction of the farm.
     * the attribute animals contains all animals of the farm.
     */
    public Farm(String name,String address){
        this.name = name;
        this.address = address;
        this.animals = new LinkedList<>();
    }
    /**
     * This Method just show the information of the farm
     */
    public void getInfo(){
        System.out.println("Name : "+this.name+"\nAddress : "+this.address);
    }
    /**
     * This method iterate the list of animals and show basic info of each animal
     */
    public void getAnimalsInfo(){
        if(!this.animals.isEmpty()){
            for(Animal i : this.animals){
                System.out.println("Id : "+i.getId()+" - Name : "+i.getName());
            }
        }else{
            System.out.print("List of animals is empty");
        }
    }
    /**
     * This method iterate the list of animals for search a specific animal
     * @param id is the identifier of the animal to search
     * @return resp, contain the animal with the searched id
     */
    public Animal searchAnimal(String id){
        Animal resp = null;
        for (Animal e : this.animals){
            if (e.getId().equals(id)){
                resp = e;
            }
        }
        return resp;
    }
    /**
     * This method just add a new animal to the list of animals
     * @param animal is a object that will be added to the list
     */
    public void addAnimal(Animal animal){
        this.animals.add(animal);
    }
    /**
     * This method delete a specific animal based on a id
     * @param id the id of animal to search and delete
     */
    public void delAnimal(String id){
        Animal animal = searchAnimal(id);
        try{
            this.animals.remove(animal);
        }catch(Error e){System.out.println("Error");}
    }
    /**
     * This method implements the algorithm bubble sort
     * to sort the list of animals based on his price
     * @return response, is a list with the animals sorted by price
     */
    public LinkedList<Animal> sortByPrice(){
        LinkedList<Animal> response = this.animals;
        int limit = response.size();
        if(limit>1){
            for(int i=1;i<limit;i++){
                for(int j=0;j<(limit-i);j++){
                    if(response.get(j).getPrice() > response.get(j+1).getPrice()){
                        Animal aux = response.get(j);
                        response.set(j,response.get(j+1));
                        response.set(j+1,aux);
                    }
                }
            }
        }
        return response;
    }
}