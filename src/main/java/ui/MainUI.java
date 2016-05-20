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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * Class that will manage the whole UI.
 */
public class MainUI extends Application {

    private static final Logger LOGGER = LogManager.getLogger(MainUI.class);
    private static final String APP_TITLE = "Semaphore";
    private static final String IMAGE_NONE = "/images/none.png";
    private static final String IMAGE_RED = "/images/red.png";
    private static final String IMAGE_AMBER = "/images/amber.png";
    private static final String IMAGE_GREEN = "/images/green.png";
    private static final String FXML_PATH = "/fxml/design.fxml";
    private String topic;

    @FXML
    private ImageView imageView;

    /**
     * This method will initialize the middleware and other components.
     */
    public void init() {
        this.topic = getTopic().get(0);
    }

    /**
     * This method will take the topic from the arguments of JavaFX
     *
     * @return topic
     */
    private List<String> getTopic() {
        return this.getParameters().getRaw();
    }

    @FXML
    public void amberAreaClicked(MouseEvent event) {
        LOGGER.info("Sending amber to the middleware in " + topic + ".");
        changeImage(IMAGE_AMBER);
    }

    @FXML
    public void greenAreaClicked(MouseEvent event) {
        LOGGER.info("Sending green to the middleware in " + topic + ".");
        changeImage(IMAGE_GREEN);
    }

    @FXML
    public void redAreaClicked(MouseEvent event) {
        LOGGER.info("Sending red to the middleware in " + topic + ".");
        changeImage(IMAGE_RED);
    }

    private void changeImage(String path) {
        imageView.setImage(new Image(String.valueOf(getClass().getResource(path))));
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent parent = FXMLLoader.load(MainUI.class.getResource(FXML_PATH));
        Scene scene = new Scene(parent);
        primaryStage.setScene(scene);
        primaryStage.setTitle(APP_TITLE);
        primaryStage.show();
    }

}
