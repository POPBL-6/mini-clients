package middleware;

import api.PSPort;
import data.MessagePublish;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

/**
 * Middleware is the class that will create the connection and publish the message to the broker.
 * @author Urko
 */
public class Middleware {

    private static final Logger LOGGER = LogManager.getLogger(Middleware.class);
    private PSPort connection;
    private String topic;
    private Object value;

    /**
     * This constructor sets the needed variables to connect and executes "connect()" method.
     * @param newTopic The topic will publish on.
     */
    public Middleware(String newTopic) {
        topic = newTopic;
    }

    /**
     * Give the connection to the class.
     */
    public final void connect(PSPort newConnection) {
        connection = newConnection;
    }

    /**
     * Close the connection to the broker.
     */
    public final void disconnect() {
        if (connection != null) {
            connection.disconnect();
            connection = null;
            LOGGER.info("Closing connection.");
        }
    }

    /**
     * Send a message to the broker.
     * @param message A MessagePublish object.
     */
    public final void publish(MessagePublish message) {
        connection.publish(message);
        try {
            this.value = message.getDataObject();
        } catch (ClassNotFoundException | IOException e) {
            LOGGER.fatal("Can't save last sample.", e);
        }
        LOGGER.info("Message published successfully with topic '" + topic + " and value '" + value.toString() + "'");
    }

    /**
     * Create a MessagePublish object.
     * @param newValue Object value that will use to create the new Message.
     * @return The new MessagePublish object.
     */
    public final MessagePublish createMessage(Object newValue) {
        MessagePublish message = new MessagePublish();
        message.setTopic(topic);
        try {
            message.setDataObject(newValue);
        } catch (IOException e) {
            LOGGER.fatal("An error has occurred setting a value to a message publication.", e);
        }
        return message;
    }

    /**
     * Object value of the last message sent to the broker.
     * If in this execution there is no last message saved in the program, the method will ask for it to the broker.
     * @return value
     */
    public final Object getLastSample() {
        if (value == null) {
            value = connection.getLastSample(topic);
        }
        return value;
    }

    /**
     * Topic of the client.
     * @return topic
     */
    public final String getTopic() {
        return topic;
    }

    /**
     * Connection to the middleware.
     * @return connection
     */
    public final PSPort getConnection() {
        return connection;
    }

}
