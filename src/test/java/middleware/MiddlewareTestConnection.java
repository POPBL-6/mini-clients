package middleware;

import api.PSPort;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Before;
import org.junit.Test;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertEquals;

/**
 * This class will test the publish method of the Middleware.
 */
public class MiddlewareTestConnection {

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
    public final void testDisconnect() {
        // Record
        connectionMock.disconnect();
        expectLastCall();
        replay(connectionMock);
        // Test
        middleware.connect(connectionMock);
        middleware.disconnect();
        verify();
        assertEquals(middleware.getConnection(), null);
    }

}
