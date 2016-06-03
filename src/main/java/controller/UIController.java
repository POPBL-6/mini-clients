package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ui.UI;

import java.io.IOException;

/**
 * This is the controller class of UI.
 */
public class UIController {

    private static final Logger LOGGER = LogManager.getLogger(UIController.class);
    private UI ui;

    @FXML
    private Button startSemaphore;
    @FXML
    private Button startPresenceSensor;
    @FXML
    private Button startLightController;
    @FXML
    private Button startAlertPanel;

    /**
     * Default constructor, needed to initialize the loader.
     */
    public UIController() {}

    /**
     * This constructor takes the UI object to be able to access it.
     * @param ui the UI object.
     */
    public UIController(UI ui) {
        this.ui = ui;
    }

    /**
     * This method loads the controller and returns the AnchorPane.
     * @return node the AnchorPane
     * @throws IOException
     */
    public Node loadController() throws IOException {
        AnchorPane node;
        FXMLLoader loader = new FXMLLoader(UIController.class.getResource("/fxml/mainDesign.fxml"));
        node = loader.load();
        loader.setController(this);
        return node;
    }

    @FXML
    void clickAlert(ActionEvent event) {
        LOGGER.info("Loading Alert Text mini client...");
    }

    @FXML
    void clickLight(ActionEvent event) {
        LOGGER.info("Loading Light Controller mini client...");
    }

    @FXML
    void clickPresence(ActionEvent event) {
        LOGGER.info("Loading Presence Sensot mini client...");
    }

    @FXML
    void clickSemaphore(ActionEvent event) {
        LOGGER.info("Loading Semaphore mini client...");
    }

}
