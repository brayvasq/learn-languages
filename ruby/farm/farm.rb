<<-DOC
    @author brayvasq <brayvasq@gmail.com>
    @version 0.1
    This class just simulate a Farm.
DOC
class Farm
    attr_accessor :name
    attr_accessor :address
    attr_accessor :animals
    
    <<-DOC
        This method is the constructor of the class.

        @param name is a identifier of the farm.
        @param address is a simple phisical direction of the farm.
                       the default value is a empty string.
        
        The attribute animals contains all animals of the farm.
        
        @return nothing.
    DOC
    def initialize(name,address="")
        @name = name
        @address = address
        @animals = []
    end

    <<-DOC
        This Method just show the information of the farm.
        @return nothing.
    DOC
    def get_info
        puts "Name : #{@name}\nAddress : #{@address}"
    end

    <<-DOC
        This method get the number of animals in the list of animals.
        @return lenght of the list of animals.
    DOC
    def get_number_animals
        return @animals.count
    end

    <<-DOC
        This method iterate the list of animals and show basic info of each animal.
        @return nothing.
    DOC
    def get_animals_info
        if not @animals.empty?
            @animals.each { |animal|
                puts "Id : #{animal.id} - Name : #{animal.name}\n"
            }
        else
            puts "List of animals is empty"
        end
    end

    <<-DOC
        This method iterate the list of animals for search a specific animal.
        @param id is the identifier of the animal to search.
        @return found[0], contain the animal with the searched id
    DOC
    def search_animal(id)
        found = @animals.select{ |a| a.id == id}
        found[0].get_info
        found[0].speak
        return found[0]
    end

    <<-DOC
        This method get the sum of the price of the all animals in the list
        @return price, is the total price.
    DOC
    def get_total_price
        price = 0.0
        if not @animals.empty?
            @animals.each { |animal| price += animal.price}
        end
        return price
    end

    <<-DOC
        This method just add a new animal to the list of animals.
        @param animal is a object that will be added to the list.
        @return nothing.
    DOC
    def add_animal(animal)
        @animals.push(animal)
    end

    <<-DOC
        This method delete a specific animal based on a id.
        @param id the id of animal to search and delete.
        @return nothing.
    DOC
    def del_animal(id)
        animal = search_animal(id)
        @animals.delete(animal)
        puts "Animal Deleted!!"
    end

    <<-DOC
        This method implements the algorithm bubble sort.
        Sort the list of animals based on his price.
        @return animals_sort, is a list with the animals sorted by price.
    DOC
    def sort_by_price
        animals_sort = @animals
        limit = @animals.count-1
        if limit > 1
            for i in 1..limit
                for j in 0..limit-i
                    if animals_sort[j].price > animals_sort[j+1].price
                        aux = animals_sort[j]
                        animals_sort[j] = animals_sort[j+1]
                        animals_sort[j+1] = aux
                    end
                end
            end
        end
        return animals_sort
    end
    
    <<-DOC
        This method sort the list of animals based on his age.
        @return list of animals sort by age.
    DOC
    def sort_by_age
        animals_sort = @animals
        animals_sort.sort_by{ |a| a.age}
        return animals_sort
    end

end