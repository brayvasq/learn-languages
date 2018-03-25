<<-DOC
    @author brayvasq <brayvasq@gmail.com>
    @version 0.1
    This is a parent class that represent a general animal.
DOC
class Animal
    attr_accessor :id
    attr_accessor :name
    attr_accessor :age
    attr_accessor :weight
    attr_accessor :price
    attr_accessor :alive
    
    <<-DOC
        This method is the constructor of the class.

        @param id, is a identifier of the animal.
        @param name, is a name for the animal.
        @param age, is an age that is used to determinate if is alive.
        @param weight 
        @param price, is the simple price of animal.

        The attribute alive is determinate in the child classes.
    
        @return nothing.
    DOC
    def initialize(id="",name="",age=0,weight=0.0,price=0.0)
        @id = id
        @name = name
        @age = age
        @weight = weight
        @price = price
        @alive = true
    end

    <<-DOC
        This method just show all information of the animal.
        @return nothing.
    DOC
    def get_info
        response = "Id : #{@id}\n"+
                   "Name : #{@name}\n"+
                   "Age : #{@age}\n"+
                   "Weight : #{@weight}\n"+
                   "Price : #{@price}\n"+
                   "Alive : #{@alive}"
        puts response
    end

    <<-DOC
        The price is calculate in the child classes.
    DOC
    def calculate_price
	    raise NotImplementedError.new("#{self.class.name}#area is an abstract method.")
    end
    
    <<-DOC
        This method just show if it is carnivorous or herbivore.
        Is implemented in the child classes.
    DOC
    def eat
	    raise NotImplementedError.new("#{self.class.name}#area is an abstract method.")
    end
    
    <<-DOC
        This method show the characteristic sound of the animal.
        Is implemented in the child classes.
    DOC
    def speak
	    raise NotImplementedError.new("#{self.class.name}#area is an abstract method.")
    end
    
    <<-DOC
        This method just show the life expectancy of the animal.
        Is implemented in the child classes.
    DOC
    def get_life_expectancy
	    raise NotImplementedError.new("#{self.class.name}#area is an abstract method.")
    end

end