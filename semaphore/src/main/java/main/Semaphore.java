package main;

/**
 * Semaphore: This project will be a mini client of the middleware to publish data of a semaphore.
 */
public class Semaphore {

    private String topic;

    /**
     * Constructor, must have a topic to init the semaphore.
     *
     * @param topic
     */
    public Semaphore(String topic) {
        this.topic = topic;
    }

    /**
     * Main thread of the semaphore.
     */
    public void init() {

    }

    /**
     * The main must receive from command line the topic that will publish info.
     *
     * @param args
     */
    public static void main(String [] args) {
        Semaphore semaphore = null;
        if (args[0] == null) {
            // TODO: Log error.
        } else {
            switch (args[0]) {
                case "-t":
                    if (args[1] == null) {
                        // TODO: Log error.
                    } else {
                        semaphore = new Semaphore(args[1]);
                    }
                    break;
                default: // TODO: Log error.
                    break;
            }
        }
        if (semaphore == null) {
            // TODO: Log error.
        } else {
            semaphore.init();
        }
    }

}
