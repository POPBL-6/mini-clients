package main;

import javafx.application.Application;
import ui.MainUI;

/**
 * MainSemaphore: This project will be a mini client of the middleware to publish data of a semaphore.
 */
public class MainSemaphore {

    private String topic;

    /**
     * Main thread of the semaphore, will initialized the whole system with the parameters of the main.
     * First argument will be used to indicate what is the next parameter. In this case we are expecting this parameters:
     *      - "-t": The topic in which the program will publish data.
     */
    public boolean init(String [] args) {
        boolean error = false;
        if (args == null) {
            error = true;
            // TODO: Log error.
        } else if (args[0] != null) {
            switch (args[0]) {
                case "-t":
                    if (args[1] == null) {
                        error = true;
                        // TODO: Log error.
                    } else if (args[1].equals("")) {
                        error = true;
                        // TODO: Log error.
                    } else {
                        this.topic = args[1];
                    }
                    break;
                default:
                    error = true;
                    // TODO: Log error.
                    break;
            }
        } else {
            error = true;
        }
        return error;
    }

    /**
     * This method will launch JavaFX UI.
     */
    public void launch() {
        Application.launch(MainUI.class);
    }

    public String getTopic() {
        return topic;
    }

    /**
     * The main must receive from command line the topic that will publish info.
     *
     * @param args
     */
    public static void main(String [] args) {
        MainSemaphore mainSemaphore = new MainSemaphore();
        if (!mainSemaphore.init(args)) {
            // TODO: Log initializing program.
            mainSemaphore.launch();
        } else {
            // TODO: Log program finished.
            System.out.println("Program finished.");
        }
    }

}
