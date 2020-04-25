package com.brayvasq.farm

/**
 * Class that works as a kind of UI
 *
 * @author brayvasq
 */
class Commands(val data : Array<String>){
    val farm : Farm = Farm()

    /**
     * Obtain the command and process the input data
     */
    fun process(){
        var command : String? = this.getCommand()

        if(command != null) {
            this.verifyCommand(command)
        }else{
            this.help()
        }
    }

    /**
     * Returns the command
     *
     * @return The first item in the input array, if it's given
     */
    private fun getCommand() : String? {
        return when { data.size > 0 -> data[0] else -> null }
    }

    /**
     * Identify the specific action to execute and call the respective action
     *
     * @param command Command obtained from getCommand() method
     */
    private fun verifyCommand(command : String) {
        if(arrayOf("list", "l").contains(command)){
            this.listCommand()
        } else if (arrayOf("create", "c").contains(command)){
            if(this.createCommand()){
                this.listCommand()
            }
        } else if(arrayOf("delete", "d").contains(command)){
            if(this.deleteCommand()){
                this.listCommand()
            }
        } else if (arrayOf("search", "s").contains(command)){
            this.searchCommand()
        } else if (arrayOf("food", "f").contains(command)){
            this.foodCommand()
        } else if (arrayOf("wash", "w").contains(command)) {
            this.washCommand()
        } else if (arrayOf("alive", "a").contains(command)) {
            this.aliveCommand()
        } else if (arrayOf("help", "h").contains(command)) {
            this.help()
        } else {
            this.help()
        }
    }

    /**
     * Process the [list | l] command
     */
    private fun listCommand(){
        val age : String? = this.getParam("age=", "(\\d+)")
        val type : String? = this.getParam("type=", "([a-zA-Z]+)")

        this.farm.listAnimals(age, type)
    }

    /**
     * Process the [create | c] command
     *
     * @return true, if the animal was created
     */
    private fun createCommand() : Boolean{
        val name : String? = this.getParam("name=", "([a-zA-Z]+)")
        val type : String? = this.getParam("type=", "([a-zA-Z]+)")

        var created = false

        if(name != null && !name.isEmpty()){
            created = this.farm.createAnimal(name, type)
        } else {
            println("Error!: A name is required to create an animal")
            this.createCommandHelp()
        }

        return created
    }

    /**
     * Process the [delete | c] command
     *
     * @return true if the animal was deleted
     */
    private fun deleteCommand() : Boolean {
        val name : String? = this.getParam("name=", "([a-zA-Z]+)")

        var deleted = false

        if(name != null && !name.isEmpty()){
            deleted = this.farm.deleteAnimal(name)
        }else{
            println("Error!: A name is required to delete a animal");
            this.deleteCommandHelp();
        }
        return deleted
    }

    /**
     * Process the [search | s] command
     */
    private fun searchCommand(){
        val name : String? = this.getParam("name=", "([a-zA-Z]+)")

        if(name != null){
            this.farm.search(name)
        } else {
            println("Error!: A name is required to search a animal");
            this.searchCommandHelp();
        }
    }

    /**
     * Process the [food | f] command
     */
    private fun foodCommand() {
        val name : String? = this.getParam("name=", "([a-zA-Z]+)")

        if(name != null){
            this.farm.food(name)
        }else{
            println("Error!: A name is required to give food to a animal");
            this.foodCommandHelp();
        }
    }

    /**
     * Process the [wash | w] command
     */
    private fun washCommand(){
        val name : String? = this.getParam("name=", "([a-zA-Z]+)")

        if(name != null) {
            this.farm.wash(name)
        }else{
            println("Error!: A name is required to give a shower to a animal");
            this.washCommandHelp();
        }
    }

    /**
     * Process the [alive | a] command
     */
    private fun aliveCommand(){
        val name : String? = this.getParam("name=", "([a-zA-Z]+)")

        if (name != null) {
            this.farm.alive(name);
        } else {
            println("Error!: A name is required to show if a animal is alive");
            this.aliveCommandHelp();
        }
    }

    /**
     * Returns the queried param using regex
     *
     * @param value variable name to search
     * @param dataType variable pattern equivalent
     * @return param, the param value if a match occurs
     */
    private fun getParam(value : String, dataPattern : String) : String? {
        var param : String? = null

        if(this.data.size > 1) {
            var dataStr = this.data.joinToString(";")
            var pattern = "$value$dataPattern".toRegex()
            val match = pattern.find(dataStr)
            param = match?.value?.replace(value, "")
        }

        return param
    }

    /**
     * Shows help for the [create | c] command
     */
    private fun createCommandHelp(){
        println("The Kotlin Farm - a simple command line animals app");
        println();
        println("Command Usage:");
        println("  [create  | c]   <name=> <type=>    creates a animal with name");
        println("");
        println("Examples:");
        println("  ./gradlew run --args='[create  | c] name=my_animal_name' -q");
        println("  ./gradlew run --args='[create  | c] name=my_animal_name type=pig' -q");
    }

    /**
     * Shows help for the [delete | c] command
     */
    private fun deleteCommandHelp(){
        println("The Kotlin Farm - a simple command line animals app");
        println();
        println("Command Usage:");
        println("  [delete  | d]   <name=>        deletes a animal by name");
        println("");
        println("Examples:");
        println("  ./gradlew run --args='[delete  | d] name=my_animal_name' -q");
    }

    /**
     * Shows help for the [search | s] command
     */
    private fun searchCommandHelp(){
        println("The Kotlin Farm - a simple command line animals app");
        println();
        println("Command Usage:");
        println("  [search  | s]   <name=>       searchs a animal by name");
        println("");
        println("Examples:");
        println("  ./gradlew run --args='[search  | s] name=my_animal_name' -q");
    }

    /**
     * Shows help for the [food | f] command
     */
    private fun foodCommandHelp(){
        println("The Kotlin Farm - a simple command line animals app");
        println();
        println("Command Usage:");
        println("  [food  | f]   <name=>       gives food to a animal by name");
        println("");
        println("Examples:");
        println("  ./gradlew run --args='[food  | f] name=my_animal_name' -q");
    }

    /**
     * Shows help for the [wash | w] command
     */
    private fun washCommandHelp(){
        println("The Kotlin Farm - a simple command line animals app");
        println();
        println("Command Usage:");
        println("  [wash  | w]   <name=>       gives a shower to a animal by name");
        println("");
        println("Examples:");
        println("  ./gradlew run --args='[wash  | w] name=my_animal_name' -q");
    }

    /**
     * Shows help for the [alive | a] command
     */
    private fun aliveCommandHelp() {
        println("The Kotlin Farm - a simple command line animals app");
        println();
        println("Command Usage:");
        println("  [alive  | a]   <name=>       checks if an animal is alive by name");
        println("");
        println("Examples:");
        println("  ./gradlew run --args='[alive  | a] name=my_animal_name' -q");
    }

    /**
     * Shows help for the app
     */
    private fun help() {
        println("The Kotlin Farm - a simple command line animals app");
        println("");
        println("Usage:");
        println("  ./gradlew run --args='[command]' -q");
        println("");
        println("Available Commands:");
        println("  [list    | l]   <age=>  <type=>    list all available animals");
        println("  [create  | c]   <name=> <type=>    create a animal with name");
        println("  [delete  | d]   <name=>            delete a animal");
        println("  [search  | s]   <name=>            search a animal");
        println("  [food    | f]   <name=>            give food to a animal");
        println("  [wash    | w]   <name=>            give a shower to a animal");
        println("  [alive   | a]   <name=>            show if a animal is alive");
        println("  [help    | h]                      help about commands");
        println("");
        println("Flags:");
        println("Use ./gradlew run --args='help' -q for more information about a command.");
    }
}
