package middleware;

import api.PSPort;
import data.MessagePublish;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertEquals;

/**
 * This class will test the publish method of the Middleware.
 */
public class MiddlewareTestPublish {

    @TestSubject
    private Middleware middleware;

    @Mock
    private PSPort connectionMock;

    @Before
    public final void preTest() {
        middleware = new Middleware("Topic");
        connectionMock = createMock(PSPort.class);
    }

    @Test
    public final void testPublish() throws IOException, ClassNotFoundException {
        Object o = "I'm publishing this";
        // Record
        connectionMock.publish(anyObject());
        expectLastCall();
        replay(connectionMock);
        // Test
        middleware.connect(connectionMock);
        middleware.publish(middleware.createMessage(o));
        verify();
        assertEquals(middleware.getLastSample(), middleware.createMessage(o).getDataObject());
    }

    @Test (expected = NullPointerException.class)
    public final void testPublishNull() {
        middleware.publish(null);
    }

    @Test (expected = ClassCastException.class)
    public final void testPublishSerialization() {
        middleware.publish((MessagePublish) new Object());
    }

}
