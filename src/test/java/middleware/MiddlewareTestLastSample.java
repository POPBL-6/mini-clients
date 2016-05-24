package middleware;

import api.PSPort;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Before;
import org.junit.Test;

import static org.easymock.EasyMock.createMock;

/**
 * This class will test the publish method of the Middleware.
 */
public class MiddlewareTestLastSample {

    @TestSubject
    private Middleware middleware;

    @Mock
    private PSPort connectionMock;

    @Before
    public void preTest() {
        middleware = new Middleware("Topic");
        connectionMock = createMock(PSPort.class);
    }

    @Test (expected = NullPointerException.class)
    public void testObjectNull() {
        middleware.getLastSample();
    }

}
