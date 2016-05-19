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

/**
 * Class that will manage the whole UI.
 */
public class MainUI extends Application {

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
        this.topic = getTopic();
        System.out.println(topic);
    }

    /**
     * This method will take the topic from the arguments of JavaFX
     *
     * @return topic
     */
    private String getTopic() {
        return null;
    }

    @FXML
    void amberAreaClicked(MouseEvent event) {
        System.out.println("Sending amber to the middleware in " + topic);
        imageView.setImage(new Image(String.valueOf(getClass().getResource(IMAGE_AMBER))));
    }

    @FXML
    void greenAreaClicked(MouseEvent event) {
        System.out.println("Sending green to the middleware in " + topic);
        imageView.setImage(new Image(String.valueOf(getClass().getResource(IMAGE_GREEN))));
    }

    @FXML
    void redAreaClicked(MouseEvent event) {
        System.out.println("Sending red to the middleware in " + topic);
        imageView.setImage(new Image(String.valueOf(getClass().getResource(IMAGE_RED))));
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
