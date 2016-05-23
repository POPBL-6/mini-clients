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
    private PSPort middleware;
    private String topic;
    private Object value;

    /**
     * This constructor
     *
     * @param address
     * @param port
     * @param topic
     */
    public Middleware(String address, int port, String topic) {
        this.topic = topic;
        try {
            this.middleware = new PSPortTCP(address, port);
        } catch (IOException e) {
            LOGGER.fatal("Couldn't create a connection to the broker.");
        }
    }

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
            LOGGER.fatal("An error has occurred setting a value to a message publication.");
        }
        middleware.publish(message);
        LOGGER.info("Message published successfully with topic '" + topic + " and value '" + value.toString() + "'");
    }

}
