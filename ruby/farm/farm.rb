class Farm
    attr_accessor :name
    attr_accessor :address
    attr_accessor :animals

    def initialize(name,address="")
        @name = name
        @address = address
        @animals = []
    end

    def get_info
        puts "Name : #{@name}\nAddress : #{@address}"
    end

    def get_number_animals
        return @animals.count
    end

    def get_animals_info
        if not @animals.empty?
            @animals.each { |animal|
                puts "Id : #{animal.id} - Name : #{animal.name}\n"
            }
        else
            puts "List of animals is empty"
        end
    end

    def search_animal(id)
        found = @animals.select{ |a| a.id == id}
        found[0].get_info
        found[0].speak
        return found[0]
    end

    def get_total_price
        price = 0.0
        if not @animals.empty?
            @animals.each { |animal| price += animal.price}
        end
        return price
    end

    def add_animal(animal)
        @animals.push(animal)
    end

    def del_animal(id)
        animal = search_animal(id)
        @animals.delete(animal)
        puts "Animal Deleted!!"
    end

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
    
    def sort_by_age
        animals_sort = @animals
        animals_sort.sort_by{ |a| a.age}
        return animals_sort
    end

end