package main;

/**
 * MainSemaphore: This project will be a mini client of the middleware to publish data of a semaphore.
 */
public class MainSemaphore {
    
    private String topic;

    /**
     * Simple constructor.
     */
    public MainSemaphore() {

    }

    /**
     * Main thread of the semaphore.
     */
    public boolean init(String [] args) {
        boolean error = false;
        if (args[0] == null) {
            error = true;
            // TODO: Log error.
        } else {
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
        }
        return error;
    }

    /**
     * The main must receive from command line the topic that will publish info.
     *
     * @param args
     */
    public static void main(String [] args) {
        MainSemaphore mainSemaphore = new MainSemaphore();
        mainSemaphore.init(args);
    }

}
