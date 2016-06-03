package ui;

import api.PSPortFactory;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import middleware.Middleware;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import util.ConfigReader;

import java.io.IOException;

/**
 * This class will initialize the UI to choose what type of client the user wants to start.
 */
public class UI extends Application {

    private static final Logger LOGGER = LogManager.getLogger(UI.class);
    private static final String FXML_PATH = "/fxml/mainDesign.fxml";
    private static final String APP_TITLE = "Mini Clients";
    private static final String CONFIG_PATH = "config.dat";
    private static final String TOPIC_PATH = "topic.dat";
    private Stage stage;
    private Middleware middleware;

    @FXML
    private Button startSemaphore;
    @FXML
    private Button startPresenceSensor;
    @FXML
    private Button startLightController;
    @FXML
    private Button startAlertPanel;

    /**
     * This method will initialize the middleware and other components.
     */
    @Override
    public final void init() throws IOException {
        middleware = new Middleware(ConfigReader.readConfigFile(TOPIC_PATH));
        try {
            middleware.connect(PSPortFactory.getPort("file " + CONFIG_PATH));
        } catch (Throwable throwable) {
            LOGGER.fatal("Can't create PSPort.", throwable);
            middleware = null;
        }
    }

    @FXML
    public void clickAlert(ActionEvent event) {
        LOGGER.info("Opening Alert Text client...");
        // TODO: Open semaphore client.
    }

    @FXML
    public void clickLight(ActionEvent event) {
        LOGGER.info("Opening Light Controller client...");
        // TODO: Open semaphore client.
    }

    @FXML
    public void clickPresence(ActionEvent event) {
        LOGGER.info("Opening Presence Sensor client...");
        // TODO: Open semaphore client.
    }

    @FXML
    public void clickSemaphore(ActionEvent event) {
        LOGGER.info("Opening Semaphore client...");
        // TODO: Open semaphore client.
    }

    /**
     * This method will show an alert based on the parameters.
     * @param type will specify the type of the alert.
     * @param title will set the title of the window.
     * @param header will set the text of the header.
     * @param text will set the content.
     */
    private void showAlert(Alert.AlertType type, String title, String header, String text) {
        Alert a = new Alert(type);
        a.setTitle(title);
        a.setHeaderText(header);
        a.setResizable(true);
        String version = System.getProperty("java.version");
        String content = String.format(text, version);
        a.setContentText(content);
        a.showAndWait();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        if (middleware == null) {
            showAlert(Alert.AlertType.ERROR, "Fatal error", "Can't establish a connection to the middleware",
                      "The middleware seems to be down or there could\nbe a error in the configuration file.");
            LOGGER.info("Middleware is down, aborting...");
        } else {
            FXMLLoader loader = new FXMLLoader(UI.class.getResource(FXML_PATH));
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
            stage = primaryStage;
            LOGGER.info("UI started successfully.");
        }
    }

    public static void main(String ... args) {
        launch(args);
    }

}
