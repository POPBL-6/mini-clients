package middleware;

import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * This class will test the constructor of the class Middleware.
 */
public class MiddlewareTestConstructor {

    private Middleware middleware;

    @Test
    public void testConstructor() {
        middleware = new Middleware("Topic");
        assertEquals(middleware.getTopic(), "Topic");
    }

    @After
    public void postTest() {
        middleware.disconnect();
        middleware = null;
    }

}
