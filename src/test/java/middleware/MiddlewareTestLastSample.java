package middleware;

import api.PSPort;
import data.MessagePublish;
import org.easymock.EasyMock;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Before;
import org.junit.Test;

import static org.easymock.EasyMock.*;

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
        middleware = new Middleware("127.0.0.1", 6666, "Topic");
        connectionMock = createMock(PSPort.class);
    }

    @Test (expected = NullPointerException.class)
    public void testObjectNull() {
        middleware.getLastSample();
    }

}
