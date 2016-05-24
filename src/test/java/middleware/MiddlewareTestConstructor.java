package middleware;

import org.easymock.TestSubject;
import org.junit.After;
import org.junit.Test;

/**
 * This class will test the constructor of the class Middleware.
 */
public class MiddlewareTestConstructor {

    private Middleware middleware;

    @Test
    public void testConstructor() {
        middleware = new Middleware("127.0.0.1", 6666, "Topic");
    }

    @After
    public void postTest() {
        middleware.disconnect();
        middleware = null;
    }

}
