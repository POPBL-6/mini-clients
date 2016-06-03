package ui;

import javafx.scene.control.Alert;

/**
 * JavaFX Utils used in the UI.
 */
public class UIUtils {

    /**
     * This method will show an alert based on the parameters.
     * @param type will specify the type of the alert.
     * @param title will set the title of the window.
     * @param header will set the text of the header.
     * @param text will set the content.
     */
    public static void showAlert(Alert.AlertType type, String title, String header, String text) {
        Alert a = new Alert(type);
        a.setTitle(title);
        a.setHeaderText(header);
        a.setResizable(true);
        String version = System.getProperty("java.version");
        String content = String.format(text, version);
        a.setContentText(content);
        a.showAndWait();
    }

}
