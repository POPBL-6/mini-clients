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

    @Before
    public void preTest() {
        mainSemaphore = new MainSemaphore();
    }

    @Test
    public void testInitGoodParameters() {
        String [] args = new String[2];
        args[0] = "-t";
        args[1] = "Topic";
        assertEquals(mainSemaphore.init(args), false);
    }

    @Test
    public void testInitNull() {
        assertEquals(mainSemaphore.init(null), true);
    }

    @Test
    public void testInitArrayOutOfBounds() {
        assertEquals(mainSemaphore.init(new String[]{}), true);
    }

    @Test
    public void testInitAllNull() {
        String [] args = new String[2];
        args[0] = null;
        args[1] = null;
        assertEquals(mainSemaphore.init(args), true);
    }

    @Test
    public void testInitFirstNull() {
        String [] args = new String[2];
        args[0] = null;
        args[1] = "Topic";
        assertEquals(mainSemaphore.init(args), true);
    }

    @Test
    public void testInitFirstEmpty() {
        String [] args = new String[2];
        args[0] = "";
        args[1] = "Topic";
        assertEquals(mainSemaphore.init(args), true);
    }

    @Test
    public void testInitTopicNull() {
        String [] args = new String[2];
        args[0] = "-t";
        args[1] = null;
        assertEquals(mainSemaphore.init(args), true);
    }

    @Test
    public void testInitTopicEmpty() {
        String [] args = new String[2];
        args[0] = "-t";
        args[1] = "";
        assertEquals(mainSemaphore.init(args), true);
    }

    @After
    public void postTest() {
        mainSemaphore = null;
    }

}
