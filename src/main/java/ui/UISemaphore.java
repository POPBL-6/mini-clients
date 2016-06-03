package ui;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import middleware.Middleware;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

/**
 * Class that will manage the whole UISemaphore.
 */
public class UISemaphore extends Application {

    private static final Logger LOGGER = LogManager.getLogger(UISemaphore.class);
    private static final String APP_TITLE = "Semaphore";
    private static final String IMAGE_RED = "/images/red.png";
    private static final String IMAGE_AMBER = "/images/amber.png";
    private static final String IMAGE_GREEN = "/images/green.png";
    private static final String FXML_PATH = "/fxml/design.fxml";
    private Middleware middleware;

    @FXML
    private ImageView imageView;

    /**
     * When the amber area is touched, this event will be thrown.
     * @param event
     */
    @FXML
    public final void amberAreaClicked(MouseEvent event) {
        LOGGER.info("Sending amber to the middleware in " + middleware.getTopic() + ".");
        middleware.publish(middleware.createMessage("AMBER"));
        changeImage(IMAGE_AMBER);
    }

    /**
     * When the green area is touched, this event will be thrown.
     * @param event
     */
    @FXML
    public final void greenAreaClicked(MouseEvent event) {
        LOGGER.info("Sending green to the middleware in " + middleware.getTopic() + ".");
        middleware.publish(middleware.createMessage("GREEN"));
        changeImage(IMAGE_GREEN);
    }

    /**
     * When the red area is touched, this event will be thrown.
     * @param event
     */
    @FXML
    public final void redAreaClicked(MouseEvent event) {
        LOGGER.info("Sending red to the middleware in " + middleware.getTopic() + ".");
        middleware.publish(middleware.createMessage("RED"));
        changeImage(IMAGE_RED);
    }

    /**
     * This method is used to change the viewing image.
     * @param path
     */
    private void changeImage(String path) {
        imageView.setImage(new Image(String.valueOf(getClass().getResource(path))));
    }

    /**
     * This method will set the connection from the middleware initialized in the class UI.
     * @param middleware connection to the middleware
     */
    public void setConnection(Middleware middleware) {
        this.middleware = middleware;
    }

    /**
     * This method will start the JavaFX UISemaphore.
     * @param primaryStage
     */
    @Override
    public final void start(Stage primaryStage) {
        FXMLLoader loader = new FXMLLoader(UISemaphore.class.getResource(FXML_PATH));
        Parent parent = null;
        try {
            parent = loader.load();
            loader.setController(this);
        } catch (IOException e) {
            LOGGER.fatal("Can't find FXML file.", e);
        }
        Scene scene = new Scene(parent);
        primaryStage.setScene(scene);
        primaryStage.setTitle(APP_TITLE);
        primaryStage.show();
        LOGGER.info("UI started successfully.");
    }

    /**
     * Main thread of the program
     * @param args
     */
    public static void main(String ... args) {
        launch(args);
    }

}
