/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brayvasq.farm;

import java.util.Arrays;
import java.util.regex.*;

/**
 * Class that works as a kind of UI
 *
 * @author brayvasq
 */
public class Commands {

    private Farm farm;
    private String[] data;
    private int dataLength;

    /**
     * Class constructor
     *
     * @param data The input array
     */
    public Commands(String[] data) {
        this.farm = new Farm();
        this.data = data;
        this.dataLength = data.length;
    }

    /**
     * Obtain the command and process the input data
     */
    public void process() {
        String command = this.getCommand();
        if (command != null) {
            this.verifyCommand(command);
        } else {
            this.help();
        }
    }

    /**
     * Returns the command
     *
     * @return The first item in the input array, if it's given
     */
    private String getCommand() {
        return data.length > 0 ? data[0] : null;
    }

    /**
     * Identify the specific action to execute and call the respective action
     *
     * @param command Command obtained from getCommand() method
     */
    private void verifyCommand(String command) {
        if (contains(new String[]{"list", "l"}, command)) {
            this.listCommand();
        } else if (contains(new String[]{"create", "c"}, command)) {
            if (this.createCommand()) {
                this.listCommand();
            }
        } else if (contains(new String[]{"delete", "d"}, command)) {
            if (this.deleteCommand()) {
                this.listCommand();
            }
        } else if (contains(new String[]{"search", "s"}, command)) {
            this.searchCommand();
        } else if (contains(new String[]{"food", "f"}, command)) {
            this.foodCommand();
        } else if (contains(new String[]{"wash", "w"}, command)) {
            this.washCommand();
        } else if (contains(new String[]{"alive", "a"}, command)) {
            this.aliveCommand();
        } else if (contains(new String[]{"help", "h"}, command)) {
            this.help();
        } else {
            this.help();
        }
    }

    /**
     * Process the [list | l] command
     */
    private void listCommand() {
        String age = this.getParam("age=", "(\\d+)");
        String type = this.getParam("type=", "([a-zA-Z]+)");

        this.farm.listAnimals(age, type);
    }

    /**
     * Process the [create | c] command
     *
     * @return true, if the animal was created
     */
    private boolean createCommand() {
        String name = this.getParam("name=", "([a-zA-Z]+)");
        String type = this.getParam("type=", "([a-zA-Z]+)");

        boolean created = false;

        if (name != null && !name.isEmpty()) {
            created = this.farm.createAnimal(name, type);
        } else {
            System.out.println("Error!: A name is required to create an animal");
            this.createCommandHelp();
        }

        return created;
    }

    /**
     * Process the [delete | c] command
     *
     * @return true if the animal was deleted
     */
    private boolean deleteCommand() {
        String name = this.getParam("name=", "([a-zA-Z]+)");

        boolean deleted = false;

        if (name != null && !name.isEmpty()) {
            deleted = this.farm.deleteAnimal(name);
        } else {
            System.out.println("Error!: A name is required to delete a animal");
            this.deleteCommandHelp();
        }

        return deleted;
    }

    /**
     * Process the [search | s] command
     */
    private void searchCommand() {
        String name = this.getParam("name=", "([a-zA-Z]+)");

        if (name != null) {
            this.farm.search(name);
        } else {
            System.out.println("Error!: A name is required to search a animal");
            this.searchCommandHelp();
        }
    }

    /**
     * Process the [food | f] command
     */
    private void foodCommand() {
        String name = this.getParam("name=", "([a-zA-Z]+)");

        if (name != null) {
            this.farm.food(name);
        } else {
            System.out.println("Error!: A name is required to give food to a animal");
            this.foodCommandHelp();
        }
    }

    /**
     * Process the [wash | w] command
     */
    private void washCommand() {
        String name = this.getParam("name=", "([a-zA-Z]+)");

        if (name != null) {
            this.farm.wash(name);
        } else {
            System.out.println("Error!: A name is required to give a shower to a animal");
            this.washCommandHelp();
        }
    }

    /**
     * Process the [alive | a] command
     */
    private void aliveCommand() {
        String name = this.getParam("name=", "([a-zA-Z]+)");

        if (name != null) {
            this.farm.alive(name);
        } else {
            System.out.println("Error!: A name is required to show if a animal is alive");
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
    private String getParam(String value, String dataType) {
        String param = null;

        if (this.data.length > 1) {
            String dataString = String.join(";", Arrays.copyOfRange(this.data, 1, this.data.length));
            Pattern p = Pattern.compile(value + dataType);
            Matcher matcher = p.matcher(dataString);
            if (matcher.find()) {
                param = matcher.group().replace(value, "");
            }

        }

        return param;
    }

    /**
     * Shows help for the [create | c] command
     */
    private void createCommandHelp() {
        System.out.println("The Java Farm - a simple command line animals app");
        System.out.println();
        System.out.println("Command Usage:");
        System.out.println("  [create  | c]   <name=> <type=>    creates a animal with name");
        System.out.println("");
        System.out.println("Examples:");
        System.out.println("  ./mvnw exec:java -Dexec.args='[create  | c] name=my_animal_name' -q");
        System.out.println("  ./mvnw exec:java -Dexec.args='[create  | c] name=my_animal_name type=pig' -q");
    }

    /**
     * Shows help for the [delete | c] command
     */
    private void deleteCommandHelp() {
        System.out.println("The Java Farm - a simple command line animals app");
        System.out.println();
        System.out.println("Command Usage:");
        System.out.println("  [delete  | d]   <name=>        deletes a animal by name");
        System.out.println("");
        System.out.println("Examples:");
        System.out.println("  ./mvnw exec:java -Dexec.args='[delete  | d] name=my_animal_name' -q");
    }

    /**
     * Shows help for the [search | s] command
     */
    private void searchCommandHelp() {
        System.out.println("The Java Farm - a simple command line animals app");
        System.out.println();
        System.out.println("Command Usage:");
        System.out.println("  [search  | s]   <name=>       searchs a animal by name");
        System.out.println("");
        System.out.println("Examples:");
        System.out.println("  ./mvnw exec:java -Dexec.args='[search  | s] name=my_animal_name' -q");
    }

    /**
     * Shows help for the [food | f] command
     */
    private void foodCommandHelp() {
        System.out.println("The Java Farm - a simple command line animals app");
        System.out.println();
        System.out.println("Command Usage:");
        System.out.println("  [food  | f]   <name=>       gives food to a animal by name");
        System.out.println("");
        System.out.println("Examples:");
        System.out.println("  ./mvnw exec:java -Dexec.args='[food  | f] name=my_animal_name' -q");
    }

    /**
     * Shows help for the [wash | w] command
     */
    private void washCommandHelp() {
        System.out.println("The Java Farm - a simple command line animals app");
        System.out.println();
        System.out.println("Command Usage:");
        System.out.println("  [wash  | w]   <name=>       gives a shower to a animal by name");
        System.out.println("");
        System.out.println("Examples:");
        System.out.println("  ./mvnw exec:java -Dexec.args='[wash  | w] name=my_animal_name' -q");
    }

    /**
     * Shows help for the [alive | a] command
     */
    private void aliveCommandHelp() {
        System.out.println("The Java Farm - a simple command line animals app");
        System.out.println();
        System.out.println("Command Usage:");
        System.out.println("  [alive  | a]   <name=>       checks if an animal is alive by name");
        System.out.println("");
        System.out.println("Examples:");
        System.out.println("  ./mvnw exec:java -Dexec.args='[alive  | a] name=my_animal_name' -q");
    }

    /**
     * Shows help for the app
     */
    private void help() {
        System.out.println("The Java Farm - a simple command line animals app");
        System.out.println("");
        System.out.println("Usage:");
        System.out.println("  ./mvnw exec:java -Dexec.args='[command]' -q");
        System.out.println("");
        System.out.println("Available Commands:");
        System.out.println("  [list    | l]   <age=>  <type=>    list all available animals");
        System.out.println("  [create  | c]   <name=> <type=>    create a animal with name");
        System.out.println("  [delete  | d]   <name=>            delete a animal");
        System.out.println("  [search  | s]   <name=>            search a animal");
        System.out.println("  [food    | f]   <name=>            give food to a animal");
        System.out.println("  [wash    | w]   <name=>            give a shower to a animal");
        System.out.println("  [alive   | a]   <name=>            show if a animal is alive");
        System.out.println("  [help    | h]                      help about commands");
        System.out.println("");
        System.out.println("Flags:");
        System.out.println("Use ./mvnw exec:java -Dexec.args='help' -q for more information about a command.");
    }

    /**
     * Determine if an array of string contains a specific element
     *
     * @param arr String array to check if contains an element
     * @param targetValue element to search
     * @return true if the array contains the element
     */
    private boolean contains(String[] arr, String targetValue) {
        return Arrays.asList(arr).contains(targetValue);
    }
}
