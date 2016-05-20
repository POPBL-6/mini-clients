package main;

import javafx.application.Application;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ui.MainUI;

/**
 * MainSemaphore: This project will be a mini client of the middleware to publish data of a semaphore.
 */
public class MainSemaphore {

    private static final Logger LOGGER = LogManager.getRootLogger();
    private String topic;

    /**
     * Main thread of the semaphore, will initialized the whole system with the parameters of the main.
     * First argument will be used to indicate what is the next parameter. In this case we are expecting this parameters:
     *      - "-t": The topic in which the program will publish data.
     */
    public boolean init(String [] args) {
        boolean error = false;
        if ((args == null) || (args.length < 1)) {
            error = true;
            LOGGER.fatal("No arguments or necessary arguments passed.");
        } else if (args[0] != null) {
            switch (args[0]) {
                case "-t":
                    if (args[1] == null) {
                        error = true;
                        LOGGER.error("Topic name argument is null.");
                    } else if (args[1].equals("")) {
                        error = true;
                        LOGGER.error("Topic name argument is empty.");
                    } else {
                        this.topic = args[1];
                    }
                    break;
                default:
                    error = true;
                    LOGGER.fatal("Incompatible argument detected.");
                    break;
            }
        } else {
            error = true;
            LOGGER.fatal("First argument is null.");
        }
        return error;
    }

    /**
     * This method will launch JavaFX UI.
     */
    public void launch() {
        Application.launch(MainUI.class, topic);
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
            LOGGER.info("Program initialized.");
            mainSemaphore.launch();
        } else {
            LOGGER.fatal("Program has encountered issues in the initialization, aborting.");
        }
    }

}
