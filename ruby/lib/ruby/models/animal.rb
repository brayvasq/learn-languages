#  A parent class representing a general Animal.
class Animal
    attr_accessor :last_wash
    attr_accessor :last_food
    attr_reader   :name
    attr_reader   :age
    attr_reader   :kind

    # Class constructor to setup all Animal properties
    #
    # @param name [String] the name of the animal
    def initialize(name = "")
        @name = name
        @age  = 0
        @last_wash = Time.now
        @last_food = Time.now
        @alive = true
        @limit_wash = 0
        @limit_food = 0
        @kind = ""
    end

    # Returns the Animal info.
    #   Joins the Animal attributes into an string
    #
    # @return [String] the full Animal info
    def get_info
        character = get_character()
        animal = "#"*50 + "\n"
        animal += character + "\n"
        animal += "Name:  #{@name}\n"
        animal += "Alive: #{is_alive?}\n"
        animal += "Sound: #{speak}\n"
        animal += "Wash time limit: #{@limit_wash - Dates.get_diff_in_minutes(@last_wash)}\n"
        animal += "Food time limit: #{@limit_food - Dates.get_diff_in_minutes(@last_food)}\n"
        animal += "#"*50 + "\n"
    end

    # Gives food to the animal. 
    # It changes the last_food attribute and assign the actual date
    def eat
        @last_food = Time.now
    end

    # Gives the animal a shower. 
    # It changes the last_food attribute and assign the actual date
    def wash
        @last_wash = Time.now
    end

    # Calculates if the animal is still alive. Uses the util Date to determinate the
    # difference in minutes between the last_wash and last_food attributes and their
    # respective limits
    #
    # @return [Boolean] false if one of the limits was exceeded
    def is_alive?
        @alive = false if Dates.is_greatter(@last_wash, @limit_wash)
        @alive = false if Dates.is_greatter(@last_food, @limit_food)
        return @alive
    end

    # Abstract method, it return the animal sound.
    #  it's implemented in the child classes
    #
    # @return [String] The characteristic Animal sound
    def speak
	    raise NotImplementedError.new("#{self.class.name}#speak is an abstract method.")
    end

    # Abstract method, it return the animal character.
    #  it's implemented in the child classes
    #
    # @return [Sting] The Animal character
    def get_character
	    raise NotImplementedError.new("#{self.class.name}#get_character is an abstract method.")
    end

    # Creates a hash with the most revelvant attributes of the object.
    #   Is needed to save it into a file using a json format.
    #
    # @return [Hash] the most revelant attributes
    def to_hash
        {
            name: @name,
            age: @age,
            last_wash: @last_wash,
            last_food: @last_food,
            alive: @alive,
            kind: @kind
        }
    end

    # Uses the get_info() method to obtain a string to represent the object
    #
    # @return [String] the Animal in string format
    def to_s
        return self.get_info()
    end
end
