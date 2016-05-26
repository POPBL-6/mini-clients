package main;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Testing init method that initialize the mainSemaphore.
 */
public class MainSemaphoreTestInit {

    private MainSemaphore mainSemaphore;
    private static final String TOPIC_C = "-t";
    private static final String TOPIC_NAME = "Topic";
    private static final String ADDRESS_C = "-a";
    private static final String ADDRESS_DIR = "127.0.0.1";
    private static final String PORT_C = "-p";
    private static final String PORT_NUM = "6666";

    @Before
    public final void preTest() {
        mainSemaphore = new MainSemaphore();
    }

    @Test
    public final void testInitGoodParameters() {
        String [] args = new String[]{TOPIC_C, TOPIC_NAME, ADDRESS_C, ADDRESS_DIR, PORT_C, PORT_NUM};
        assertEquals(mainSemaphore.init(args), false);
    }

    @Test
    public final void testInitGoodParametersTopic() {
        String [] args = new String[]{TOPIC_C, TOPIC_NAME};
        assertEquals(mainSemaphore.init(args), true);
    }

    @Test
    public final void testInitGoodParametersAddress() {
        String [] args = new String[]{ADDRESS_C, ADDRESS_DIR};
        assertEquals(mainSemaphore.init(args), true);
    }

    @Test
    public final void testInitGoodParametersPort() {
        String [] args = new String[]{PORT_C, PORT_NUM};
        assertEquals(mainSemaphore.init(args), true);
    }

    @Test
    public final void testInitIncompatibleParameter() {
        String [] args = new String[]{"-z", "ABC"};
        assertEquals(mainSemaphore.init(args), true);
    }

    @Test
    public final void testInitNull() {
        assertEquals(mainSemaphore.init(null), true);
    }

    @Test
    public final void testInitArrayOutOfBounds() {
        assertEquals(mainSemaphore.init(new String[]{}), true);
    }

    @Test
    public final void testInitAllNull() {
        String [] args = new String[]{null, null};
        assertEquals(mainSemaphore.init(args), true);
    }

    @Test
    public final void testInitFirstNull() {
        String [] args = new String[]{null, TOPIC_NAME};
        assertEquals(mainSemaphore.init(args), true);
    }

    @Test
    public final void testInitFirstEmpty() {
        String [] args = new String[]{"", TOPIC_NAME};
        assertEquals(mainSemaphore.init(args), true);
    }

    @Test
    public final void testInitTopicNull() {
        String [] args = new String[]{TOPIC_C, null};
        assertEquals(mainSemaphore.init(args), true);
    }

    @Test
    public final void testInitTopicEmpty() {
        String [] args = new String[]{TOPIC_C, ""};
        assertEquals(mainSemaphore.init(args), true);
    }

    @After
    public final void postTest() {
        mainSemaphore = null;
    }

}
