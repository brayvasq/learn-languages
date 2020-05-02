# Factory to create a new animal
class AnimalFactory
    # Class constructor to setup Factory properties
    #
    # @param type [String] The type of the animal to create (default: "cow").
    def initialize(type = "cow")
        @type = type.nil? ? "cow" : type
    end

    # Return a specific instance of an animal.
    #   depending of the type of animal.
    #
    # Examples:
    #   Default animal:
    #     factory = AnimalFactory.new
    #     cow = factory.get_animal("jay")
    #       => #<Cow:0x00.....
    #
    #   Creating a cow:
    #     factory = AnimalFactory.new("cow")
    #     cow = factory.get_animal("jay")
    #       => #<Cow:0x00.....
    #
    #   Creating a pig:
    #     factory = AnimalFactory.new("pig")
    #     pig = factory.get_animal("jay")
    #       => #<Pig:0x00.....
    #
    # @return [Animal] A new specific animal
    def get_animal(name)
        animal = nil

        if @type == "cow"
            animal = Cow.new name
        elsif @type == "pig"
            animal = Pig.new name
        end

        return animal
    end
end
