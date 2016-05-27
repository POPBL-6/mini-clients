package main;

import javafx.application.Application;
import ui.UI;

/**
 * This project will be a mini client of the middleware to publish data of a semaphore.
 * @author Urko
 */
public class MainSemaphore {

    /**
     * Launch JavaFX UI.
     * @param args The arguments from the main.
     */
    public final void launch(String ... args) {
        Application.launch(UI.class, args);
    }

    /**
     * Main thread of the program
     * @param args
     */
    public static void main(String ... args) {
        MainSemaphore mainSemaphore = new MainSemaphore();
        mainSemaphore.launch(args);
    }

}
