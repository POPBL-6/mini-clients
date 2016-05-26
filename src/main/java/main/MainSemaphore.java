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
    private String connection;

    /**
     * Main thread of the semaphore, will initialized the whole system with the parameters of the main.
     * First argument will be used to indicate what is the next parameter. In this case we are expecting this parameters:
     *      - "-t": The topic in which the program will publish data.
     *      - "-a": The address of the broker.
     *      - "-p": The port of the broker.
     *      - "-c": Type of connection ("TCP" or "SSL")
     */
    public final boolean init(String ... args) {
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
                    case "-c": this.connection = args[i + 1];
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
    private boolean checkArgs(String ... args) {
        boolean error = false;
        if ((args == null) || (args.length == 0)) {
            error = true;
            LOGGER.fatal("No arguments or necessary arguments passed.");
        } else {
            for (String arg : args) {
                if ((arg == null) || (("").equals(arg))) {
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

    /**
     * This method sets the topic of the client.
     *
     * @param newTopic
     */
    public final void setTopic(String newTopic) {
        topic = newTopic;
    }

    /**
     * This method sets the address of the broker to connect.
     *
     * @param newAddress
     */
    public final void setAddress(String newAddress) {
        address = newAddress;
    }

    /**
     * This method sets the port of the broker to connect.
     *
     * @param newPort
     */
    public final void setPort(String newPort) {
        port = newPort;
    }

    /**
     * This method will launch JavaFX UI.
     */
    public final void launch() {
        String [] args = new String[]{topic, address, port, connection};
        Application.launch(UI.class, args);
    }

    /**
     * The main must receive from command line the topic that will publish info.
     *
     * @param args
     */
    public static void main(String ... args) {
        MainSemaphore mainSemaphore = new MainSemaphore();
        if (!mainSemaphore.init(args)) {
            LOGGER.info("Program initialized.");
            mainSemaphore.launch();
        } else {
            LOGGER.fatal("Program has encountered issues in the initialization, aborting.");
        }
    }

}
