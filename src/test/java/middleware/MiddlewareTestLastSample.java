package middleware;

import org.junit.Before;
import org.junit.Test;

/**
 * This class will test the publish method of the Middleware.
 */
public class MiddlewareTestLastSample {

    private Middleware middleware;

    @Before
    public final void preTest() {
        middleware = new Middleware("Topic");
    }

    @Test (expected = NullPointerException.class)
    public final void testObjectNull() {
        middleware.getLastSample();
    }

}
