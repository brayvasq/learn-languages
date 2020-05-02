# A class that works as a kind of controller.
class Farm
    # Class constructor. 
    # Setups the store class and load the saved animals
    def initialize
        @store = Store.new
        @store.load()
    end

    # List all the animals stored. Also, it can filter the animals by animal
    # type and age
    #
    # Examples:
    #   list_animals()
    #   list_animals(0)
    #   list_animals(0, "cow")
    #
    # @param age [Integer] The value to filter animals by age (default: null).
    # @param type [String] The value to filter animals by animal type (default: null).
    def list_animals(age = nil, animal_type = nil)
        animal_list = @store.animals

        animal_list = animal_list.select { |a| a.age == age } if age
        animal_list = animal_list.select { |a| a.kind == animal_type } if animal_type

        animal_list.each do |animal|
            puts animal
        end
    end

    # Uses the AnimalFactory to create a new animal
    #
    # @param name [String] The name of the animal
    # @param type [String] The animal type
    #
    # @return [Boolean] true if the animal was created successfully
    def create_animal(name, animal_type)
        created = false
        animal = AnimalFactory.new(animal_type).get_animal(name)

        if animal
            @store.add animal
            created = true
        end

        return created
    end

    # Deletes a animal by name
    #
    # @param name [String] The name of the animal
    #
    # @return [Boolean] true if the animal was deleted successfully
    def delete_animal(name)
        @store.remove name
    end

    # Search a animal by name and prints the animal info
    #
    # @param name [String] the name of the animal
    def search(name)
        animal = @store.find name

        if animal
            puts animal
        else
            puts "Animal not found"
        end
    end

    # Gives food to an animal
    #
    # @param name [String] the name of the animal
    def food(name)
        animal = @store.find name

        if animal
            animal.eat
            @store.save
        end
    end

    # Gives a shower to an animal
    #
    # @param name [String] the name of the animal
    def wash(name)
        animal = @store.find name

        if animal
            animal.wash
            @store.save
        end
    end

    # Prints if an animal is alive
    #
    # @param name [String] the name of the animal
    def alive(name)
        animal = @store.find name

        puts animal.is_alive? if animal
    end
end
