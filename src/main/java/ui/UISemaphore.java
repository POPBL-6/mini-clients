package ui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import middleware.Middleware;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

/**
 * Class that will manage the whole UISemaphore.
 */
public class UISemaphore {

    private static final Logger LOGGER = LogManager.getLogger(UISemaphore.class);
    private static final String APP_TITLE = "Semaphore";
    private static final String IMAGE_RED = "/images/red.png";
    private static final String IMAGE_AMBER = "/images/amber.png";
    private static final String IMAGE_GREEN = "/images/green.png";
    private static final String FXML_PATH = "/fxml/semaphoreDesign.fxml";
    private StackPane pane;
    private Middleware middleware;

    @FXML
    private ImageView imageView;

    public UISemaphore(StackPane pane, Middleware middleware) {
        FXMLLoader loader = new FXMLLoader(UISemaphore.class.getResource(FXML_PATH));
        Parent parent = null;
        try {
            parent = loader.load();
            loader.setController(this);
        } catch (IOException e) {
            LOGGER.fatal("Can't find FXML file.", e);
        }
        pane.getChildren().add(parent);
        this.pane = pane;
    }

    /**
     * When the amber area is touched, this event will be thrown.
     * @param event
     */
    @FXML
    public void amberAreaClicked(MouseEvent event) {
        LOGGER.info("Sending amber to the middleware in " + middleware.getTopic() + ".");
        middleware.publish(middleware.createMessage("AMBER"));
        changeImage(IMAGE_AMBER);
    }

    /**
     * When the green area is touched, this event will be thrown.
     * @param event
     */
    @FXML
    public void greenAreaClicked(MouseEvent event) {
        LOGGER.info("Sending green to the middleware in " + middleware.getTopic() + ".");
        middleware.publish(middleware.createMessage("GREEN"));
        changeImage(IMAGE_GREEN);
    }

    /**
     * When the red area is touched, this event will be thrown.
     * @param event
     */
    @FXML
    public void redAreaClicked(MouseEvent event) {
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

}
