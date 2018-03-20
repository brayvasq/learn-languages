load "animals/sheep.rb"
load "animals/pig.rb"
load "animals/cow.rb"
load "farm/farm.rb"

if __FILE__ == $0

    puts "The Ruby Farm"
    option = 0
    message = "1.Add Animal\n"+
              "2.Del Animal\n"+
              "3.Get Info Farm\n"+
              "4.Get number of animals\n"+
              "5.Get Info Animals\n"+
              "6.Search Animal\n"+
              "7.Get total Price\n"+
              "8.Sort by price\n"+
              "9.Sort by age\n"+
              "10.Exit\n"
    farm = Farm.new("My Farm","Av 34")
    while option!=10 do
        puts message
        option = gets.chomp.to_i
        if option == 1
            puts "\n\n Create Animal : \n"
            puts "Id : "
            id = gets.chomp
            puts "Name : "
            name = gets.chomp
            puts "Age : "
            age = gets.chomp.to_i
            puts "Weight : "
            weight = gets.chomp.to_f
            puts "Price : "
            price = gets.chomp.to_f
            type_animal = "Enter type of animal : \n"+
                          "1.Sheep\n"+
                          "2.Pig\n"+
                          "3.Cow\n"
            puts type_animal
            option_animal = gets.chomp.to_i
            case option_animal
            when 1
                animal = Sheep.new(id,name,age,weight,price)
                farm.add_animal(animal)
            when 2
                animal = Pig.new(id,name,age,weight,price)
                farm.add_animal(animal)
            when 3
                animal = Cow.new(id,name,age,weight,price)
                farm.add_animal(animal)
            else
                puts "Error type"
            end
        elsif option == 2
            puts "Enter Id of animal to delete"
            id = gets.chomp
            farm.del_animal(id)
        elsif option == 3
            farm.get_info
        elsif option == 4
            puts farm.get_number_animals
        elsif option == 5
            farm.get_animals_info
        elsif option == 6
            puts "Enter Id of animal to search"
            id = gets.chomp
            farm.search_animal(id)
        elsif option == 7
            puts farm.get_total_price
        elsif option == 8
            animal_sort = farm.sort_by_price
            animal_sort.each{|a| puts "#{a.id} - #{a.price}"}
        elsif option == 9
            animal_sort = farm.sort_by_age
            animal_sort.each{|a| puts "#{a.id} - #{a.age}"}
        end
    end

end