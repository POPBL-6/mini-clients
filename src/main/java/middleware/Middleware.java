package middleware;

import api.PSPort;
import data.MessagePublish;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

/**
 * Middleware is the class that will create the connection and publish the message to the broker.
 */
public class Middleware {

    private static final Logger LOGGER = LogManager.getLogger(Middleware.class);
    private PSPort connection;
    private String topic;
    private Object value;

    /**
     * This constructor sets the needed variables to connect and executes "connect()" method.
     *
     * @param newTtopic
     */
    public Middleware(String newTtopic) {
        topic = newTtopic;
    }

    /**
     * Connect will try to connect to a broker in a concrete address and port using TCP.
     */
    public final void connect(PSPort newConnection) {
        connection = newConnection;
    }

    /**
     * This method will close the connection to the broker.
     */
    public final void disconnect() {
        if (connection != null) {
            connection.disconnect();
            connection = null;
            LOGGER.info("Closing connection.");
        }
    }

    /**
     * This method will send a message to the broker.
     *
     * @param message
     */
    public final void publish(MessagePublish message) {
        connection.publish(message);
        try {
            this.value = message.getDataObject();
        } catch (ClassNotFoundException | IOException e) {
            LOGGER.fatal("Can't save last sample.");
            LOGGER.info(e);
        }
        LOGGER.info("Message published successfully with topic '" + topic + " and value '" + value.toString() + "'");
    }

    /**
     * This class wil create a MessagePublish object.
     *
     * @param newValue
     * @return
     */
    public final MessagePublish createMessage(Object newValue) {
        MessagePublish message = new MessagePublish();
        message.setTopic(topic);
        try {
            message.setDataObject(newValue);
        } catch (IOException e) {
            LOGGER.fatal("An error has occurred setting a value to a message publication. Exception: " + e.getMessage());
            LOGGER.info(e);
        }
        return message;
    }

    /**
     * This method returns the object value of the last message sent to the broker.
     * If in this execution there is no last message saved in the program, the method will ask for it to the broker.
     *
     * @return value
     */
    public final Object getLastSample() {
        if (value == null) {
            value = connection.getLastSample(topic);
        }
        return value;
    }

    /**
     * This method will return the topic of the client.
     *
     * @return topic
     */
    public final String getTopic() {
        return topic;
    }

    /**
     * This method will return the connection of the middleware.
     *
     * @return connection
     */
    public final PSPort getConnection() {
        return connection;
    }

}
