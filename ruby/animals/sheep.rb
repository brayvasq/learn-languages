require_relative 'animal'

class Sheep < Animal
    def initialize(id=0,name="",age=0,weight=0.0,price=0.0)
        super
        @alive = if @age <= 15 then true else false end
    end

    def calculate_price
        return @price * 2 * @age
    end

    def eat
        puts "I am a herbivoret"
    end

    def speak
        puts "Meeehh!!"
    end

    def get_life_expectancy
        puts "15 years"
    end
end