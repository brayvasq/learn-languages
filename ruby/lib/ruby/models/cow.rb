# A child class, representing a Cow.
#   It extends from Animal class
class Cow < Animal
    # Class constructor, setup the specific Cow properties
    #
    # @param name [String] the name of the cow
    def initialize(name = "")
        super(name)
        @limit_food = 3
        @limit_wash = 10
        @kind = "cow"
    end

    # Returns the Cow character.
    #   depending on the isAlive() method
    #
    # @return [String] The Cow character
    def get_character
        character =  "  (....)  \n"
        character += is_alive? ? "（0 .. 0）" : "（X .. X）"
    end

    # Returns the Cow sound.
    #
    # @return The Cow sound
    def speak
        "Muuu Muuu!!!"
    end
end
