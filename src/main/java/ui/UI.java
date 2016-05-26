package ui;

import api.PSPortFactory;
import api.PSPortSSL;
import api.PSPortTCP;
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
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

/**
 * Class that will manage the whole UI.
 */
public class UI extends Application {

    private static final Logger LOGGER = LogManager.getLogger(UI.class);
    private static final String APP_TITLE = "Semaphore";
    private static final String IMAGE_RED = "/images/red.png";
    private static final String IMAGE_AMBER = "/images/amber.png";
    private static final String IMAGE_GREEN = "/images/green.png";
    private static final String FXML_PATH = "/fxml/design.fxml";
    private static final String SSL_TYPE = "SSL";
    private static final String TCP_TYPE = "TCP";
    private static final int SSL_CODE = 1;
    private static final int TCP_CODE = 0;
    private static final int ERROR_CODE = -1;
    private static final int ADDRESS_INDEX = 1;
    private static final int PORT_INDEX = 2;
    private static final int TOPIC_INDEX = 0;
    private static final int CONN_INDEX = 3;
    private Middleware middleware;

    @FXML
    private ImageView imageView;

    /**
     * This method will initialize the middleware and other components.
     */
    @Override
    public final void init() throws IOException {
        middleware = new Middleware(getTopic());
        if (getConnection() == SSL_CODE) {
            try {
                // TODO: Key store, trusted store and key store password.
                middleware.connect(PSPortFactory.getPort("PSPortSSL -a " + getAddress() + " -p " + getPort()));
            } catch (Throwable e) {
                // TODO: Catch exception.
            }
        } else if (getConnection() == TCP_CODE) {
            middleware.connect(new PSPortTCP(getAddress(), Integer.parseInt(getPort())));
        } else {
            // TODO: Kill.
        }
    }

    /**
     * This method will take the topic from the arguments of JavaFX.
     *
     * @return topic
     */
    private String getTopic() {
        return getParameterAt(TOPIC_INDEX);
    }

    /**
     * This method will take the address from the arguments of JavaFX
     *
     * @return address
     */
    private String getAddress() {
        return getParameterAt(ADDRESS_INDEX);
    }

    /**
     * This method will take the port from the arguments of JavaFX
     *
     * @return address
     */
    private String getPort() {
        return getParameterAt(PORT_INDEX);
    }

    /**
     * This method will take the connection of the arguments.
     *
     * @return connectionType
     */
    private int getConnection() {
        String type = getParameterAt(CONN_INDEX);
        if ((SSL_TYPE).equals(type)) {
            LOGGER.info("Stabilising a SSL socket.");
            return SSL_CODE;
        } else if ((TCP_TYPE).equals(type)) {
            LOGGER.info("Stabilising a TCP socket.");
            return TCP_CODE;
        } else {
            LOGGER.fatal("Can't start a " + type + " connection.");
            return ERROR_CODE;
        }
    }

    private String getParameterAt(int index) {
        return this.getParameters().getRaw().get(index);
    }

    /**
     * When the amber area is touched, this event will be thrown.
     *
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
     *
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
     *
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
     *
     * @param path
     */
    private void changeImage(String path) {
        imageView.setImage(new Image(String.valueOf(getClass().getResource(path))));
    }

    /**
     * This method will start the JavaFX UI.
     *
     * @param primaryStage
     */
    @Override
    public final void start(Stage primaryStage) {
        Parent parent = null;
        try {
            parent = FXMLLoader.load(UI.class.getResource(FXML_PATH));
        } catch (IOException e) {
            LOGGER.fatal("Can't find FXML file.");
            LOGGER.info(e);
        }
        Scene scene = new Scene(parent);
        primaryStage.setScene(scene);
        primaryStage.setTitle(APP_TITLE);
        primaryStage.show();
        LOGGER.info("UI started successfully.");
    }

}
