package ui;

import api.PSPortFactory;
import controller.UIController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
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
    private static final String APP_TITLE = "Mini Clients";
    private static final String CONFIG_PATH = "config.dat";
    private static final String TOPIC_PATH = "topic.dat";
    private Middleware middleware;
    private StackPane pane;
    private Node node;

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

    /**
     * This method will remove the node.
     */
    public void close() {
        pane.getChildren().remove(node);
    }

    /**
     * This method will reopen the main menu.
     */
    public void reopen() {
        pane.getChildren().add(node);
    }

    public Middleware getMiddleware() {
        return middleware;
    }

    public StackPane getPane() {
        return pane;
    }

    /**
     * This is the start method of the JavaFX UI, executed at "launch(args);"
     * @param stage the initial stage of the JavaFX UI.
     */
    @Override
    public void start(Stage stage) {
        if (middleware != null) {
            UIUtils.showAlert(Alert.AlertType.ERROR, "Fatal error", "Can't establish a connection to the middleware",
                             "The middleware seems to be down or there could\nbe a error in the configuration file.");
            LOGGER.info("Middleware is down, aborting...");
        } else {
            pane = load(stage);
        }
    }

    /**
     * This method will load the scene into the stage and will show it.
     * @param stage the initial stage of the JavaFX UI.
     */
    public StackPane load(Stage stage) {
        LOGGER.info("Loading UI...");
        StackPane pane = new StackPane();
        try {
            UIController uiController = new UIController(this);
            node = uiController.loadController();
            pane.getChildren().add(node);
            LOGGER.info("Pane loaded correctly.");
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.fatal("Can't find FXML file.", e);
        }
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setTitle(APP_TITLE);
        stage.setResizable(false);
        stage.show();
        LOGGER.info("UI started successfully.");
        return pane;
    }

    /**
     * Main class of the mini-clients project, will load the JavaFX UI.
     * @param args arguments from command line.
     */
    public static void main(String ... args) {
        launch(args);
    }

}
