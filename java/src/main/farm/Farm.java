package farm;

import java.util.LinkedList;

import animals.Animal;

public class Farm{
    private String name;
    private String address;
    private LinkedList<Animal> animals;

    public Farm(String name,String address){
        this.name = name;
        this.address = address;
        this.animals = new LinkedList<>();
    }

    public void getInfo(){
        System.out.println("Name : "+this.name+"\nAddress : "+this.address);
    }

    public void getAnimalsInfo(){
        if(!this.animals.isEmpty()){
            for(Animal i : this.animals){
                System.out.println("Id : "+i.getId()+" - Name : "+i.getName());
            }
        }else{
            System.out.print("List of animals is empty");
        }
    }

    public Animal searchAnimal(String id){
        Animal resp = null;
        for (Animal e : this.animals){
            if (e.getId().equals(id)){
                resp = e;
            }
        }
        return resp;
    }

    public void addAnimal(Animal animal){
        this.animals.add(animal);
    }

    public void delAnimal(String id){
        Animal animal = searchAnimal(id);
        try{
            this.animals.remove(animal);
        }catch(Error e){System.out.println("Error");}
    }

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