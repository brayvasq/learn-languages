class Animal
    attr_accessor :id
    attr_accessor :name
    attr_accessor :age
    attr_accessor :weight
    attr_accessor :price
    attr_accessor :alive
    
    def initialize(id="",name="",age=0,weight=0.0,price=0.0)
        @id = id
        @name = name
        @age = age
        @weight = weight
        @price = price
        @alive = true
    end

    def get_info
        response = "Id : #{@id}\n"+
                   "Name : #{@name}\n"+
                   "Age : #{@age}\n"+
                   "Weight : #{@weight}\n"+
                   "Price : #{@price}\n"+
                   "Alive : #{@alive}"
        puts response
    end

    def calculate_price
	    raise NotImplementedError.new("#{self.class.name}#area is an abstract method.")
    end
    
    def eat
	    raise NotImplementedError.new("#{self.class.name}#area is an abstract method.")
    end
    
    def speak
	    raise NotImplementedError.new("#{self.class.name}#area is an abstract method.")
    end
    
    def get_life_expectancy
	    raise NotImplementedError.new("#{self.class.name}#area is an abstract method.")
    end

end