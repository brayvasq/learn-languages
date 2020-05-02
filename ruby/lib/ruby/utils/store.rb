# A util class to operate with files
#  It help us with the data persistence
class Store
    attr_reader :animals

    DEFAULT_FILE_LOC = "animals.json"

    # Class constructor, setup using a given path
    #
    # @param file [String] file path to save the animals data
    def initialize(file = DEFAULT_FILE_LOC)
        @file = file
        @animals = []
    end

    # Read the animals file and calls the read_animals() method to store the
    # animals in a list
    #
    # @return [Boolean] true if the data was loaded
    def load
        animals_file = File.open(@file).read
        data = JSON.parse animals_file, symbolize_names: true

        read_animals(data) if data
    rescue StandardError => e
        puts "Data couldn't be loaded"
    end

    # Creates the animals from the data parsed.
    #
    # @param animals [Hash] parsed from file
    def read_animals(data)
        data.each do |item|
            animal = AnimalFactory.new(item[:kind]).get_animal(item[:name])
            animal.last_wash = Time.parse item[:last_wash]
            animal.last_food = Time.parse item[:last_food]
            animal.is_alive?
            @animals << animal
        end
    end

    # Search a animal in the list of animal by name
    #
    # @param name [String] the name of the animal
    #
    # @return [Animal] The equivalent animal object to the given name
    def find(name)
        @animals.find { |item| item.name == name }
    end

    # Add a new animal object
    #
    # @param animal [Animal] the animal object to add
    #
    # @return [Boolean] true if the animal was saved successfully
    def add(animal)
        @animals.push(animal)
        return save()
    end

    # Delete an animal by name
    #
    # @param name [String] the name of the animal
    #
    # @return [Boolean] true if the animal was deleted successfully
    def remove(name)
        animal = find(name)
        deleted = false

        if animal
            @animals.delete(animal)
            deleted = save()
        end

        return deleted
    end

    # Parse the animal list into json data and store in a file
    #
    # @return [Boolean] true if the data was saved successfully
    def save
        json_data = @animals.map { |item| item.to_hash }.to_json

        File.open(@file, "w") do |file|
            file.write json_data
        end

        return true
    rescue StandardError => e
        binding.pry
        return false
    end
end
