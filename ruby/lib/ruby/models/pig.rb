# A child class, representing a Pig.
#   It extends from Animal class
class Pig < Animal
    # Class constructor, setup the specific Pig properties
    #
    # @param name [String] the name of the pig
    def initialize(name = "")
        super(name)
        @limit_food = 2
        @limit_wash = 5
        @kind = "pig"
    end

    # Returns the Pig character.
    #   depending on the isAlive() method
    #
    # @return [String] The Pig character
    def get_character
        is_alive? ? "（`（●●）´）" : "（x（●●）x）"
    end

    # Returns the Cow sound.
    #
    # @return The Cow sound
    def speak
        "Oink Oink!!!"
    end
end
