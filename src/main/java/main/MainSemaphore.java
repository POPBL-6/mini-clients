package main;

import javafx.application.Application;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ui.UI;

/**
 * MainSemaphore: This project will be a mini client of the middleware to publish data of a semaphore.
 */
public class MainSemaphore {

    private static final Logger LOGGER = LogManager.getRootLogger();
    private String topic;
    private String address;
    private String port;

    /**
     * Main thread of the semaphore, will initialized the whole system with the parameters of the main.
     * First argument will be used to indicate what is the next parameter. In this case we are expecting this parameters:
     *      - "-t": The topic in which the program will publish data.
     *      - "-a": The address of the broker.
     *      - "-p": The port of the broker.
     */
    public boolean init(String [] args) {
        boolean error = false;
        if (!checkArgs(args)) {
            for (int i = 0; i < args.length; i += 2) {
                switch (args[i]) {
                    case "-t": this.topic = args[i + 1];
                        break;
                    case "-a": this.address = args[i + 1];
                        break;
                    case "-p": this.port = args[i + 1];
                        break;
                    default: LOGGER.fatal("Incompatible argument detected.");
                        error = true;
                        break;
                }
            }
        }
        if (!error) {
            error = checkVariables();
        }
        return error;
    }

    /**
     * This method will check the arguments received from command line.
     *
     * @param args
     * @return state
     */
    private boolean checkArgs(String [] args) {
        boolean error = false;
        if (args == null) {
            error = true;
            LOGGER.fatal("No arguments or necessary arguments passed.");
        } else {
            for (String arg : args) {
                if ((arg == null) || (arg.equals(""))) {
                    error = true;
                    LOGGER.fatal("Some arguments are null.");
                    break;
                }
            }
        }
        return error;
    }

    /**
     * This method will check if all needed variables are filled.
     *
     * @return state
     */
    private boolean checkVariables() {
        if ((topic == null) || (address == null) || (port == null)) {
            LOGGER.fatal("Some variables are missing.");
            return true;
        } else {
            return false;
        }
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPort(String port) {
        this.port = port;
    }

    /**
     * This method will launch JavaFX UI.
     */
    public void launch() {
        String [] args = new String[]{topic, address, port};
        Application.launch(UI.class, args);
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
