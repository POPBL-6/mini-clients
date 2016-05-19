package ui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Class that will manage the whole UI.
 */
public class MainUI extends Application {

    @FXML
    public void setGreen(ActionEvent event) {
        System.out.println("Sending green event...");
    }

    @FXML
    public void setRed(ActionEvent event) {
        System.out.println("Sending green event...");
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent parent = FXMLLoader.load(MainUI.class.getResource("/fxml/design.fxml"));
        Scene scene = new Scene(parent);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Semaphore");
        primaryStage.show();
    }

}
