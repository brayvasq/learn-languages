package com.brayvasq.farm;

/**
 * Main file. It will executes the app
 *
 * @author brayvasq
 * @version 0.2
 */
public class App {

    public static void main(String[] args) {
        Commands cmd = new Commands(args);
        cmd.process();
    }
}
