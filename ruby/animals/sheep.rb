require_relative 'animal'

<<-DOC
    @author brayvasq <brayvasq@gmail.com>
    @version 0.1
    This is a class that represent a Sheep inheriting Animal class.
DOC
class Sheep < Animal

    <<-DOC
        This method is the constructor of the class and use the parent constructor.

        @param id, is a identifier of the sheep.
        @param name, is a name for the shepp.
        @param age, is an age that is used to determinate if is alive.
        @param weight 
        @param price, is the simple price of sheep.

        The attribute alive is determinate with the param age.
    
        @return nothing.
    DOC
    def initialize(id=0,name="",age=0,weight=0.0,price=0.0)
        super
        @alive = if @age <= 15 then true else false end
    end

    <<-DOC
        This is a overwritten method from the parent class.
        @return final price based on a simple price and the age of the animal.
    DOC
    def calculate_price
        return @price * 2 * @age
    end

    <<-DOC
        This is a overwritten method from the parent class.
        This method just show if it is carnivorous or herbivore.
        @return nothing
    DOC
    def eat
        puts "I am a herbivoret"
    end

    <<-DOC
        This is a overwritten method from the parent class.
        Just show the characteristic sound of the sheep.
        @return nothing
    DOC
    def speak
        puts "Meeehh!!"
    end

    <<-DOC
        This is a overwritten method from the parent class.
        This method just show the life expectancy of the animal.
        @return nothing
    DOC
    def get_life_expectancy
        puts "15 years"
    end
end