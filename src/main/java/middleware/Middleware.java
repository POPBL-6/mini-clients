package middleware;

import api.PSPort;
import api.PSPortTCP;
import data.MessagePublish;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

/**
 * Middleware is the class that will create the connection and publish the message to the broker.
 */
public class Middleware {

    private static final Logger LOGGER = LogManager.getLogger(Middleware.class);
    private String address;
    private int port;
    private PSPort connection;
    private String topic;
    private Object value;

    /**
     * This constructor sets the needed variables to connect and executes "connect()" method.
     *
     * @param address
     * @param port
     * @param topic
     */
    public Middleware(String address, int port, String topic) {
        this.address = address;
        this.port = port;
        this.topic = topic;
        connect();
    }

    /**
     * Connect will try to connect to a broker in a concrete address and port.
     */
    private void connect() {
        try {
            this.connection = new PSPortTCP(address, port);
        } catch (IOException e) {
            LOGGER.fatal("Couldn't create a connection to the broker. Exception: " + e.getMessage());
            LOGGER.info(e);
        }
    }

    /**
     * This method will return the topic of the client.
     *
     * @return topic
     */
    public String getTopic() {
        return topic;
    }

    /**
     * This method will send a object value to the broker.
     *
     * @param value
     */
    public void publish(Object value) {
        MessagePublish message = new MessagePublish();
        this.value = value;
        message.setTopic(topic);
        try {
            message.setDataObject(value);
        } catch (IOException e) {
            LOGGER.fatal("An error has occurred setting a value to a message publication. Exception: " + e.getMessage());
            LOGGER.info(e);
        }
        connection.publish(message);
        LOGGER.info("Message published successfully with topic '" + topic + " and value '" + value.toString() + "'");
    }

    /**
     * This method will close the connection to the broker.
     */
    public void kill() {
        if (connection != null) {
            connection.disconnect();
            LOGGER.info("Closing connection.");
        }
    }

    /**
     * This method will try to reconnect to the broker.
     */
    public void reconnect() {
        connect();
    }

    /**
     * This method returns the object value of the last message sent to the broker.
     * If in this execution there is no last message saved in the program, the method will ask for it to the broker.
     *
     * @return value
     */
    public Object getLastSample() {
        if (value == null) {
            value = connection.getLastSample(topic);
        }
        return value;
    }

}
