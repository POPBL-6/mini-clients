package ui;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This class tests the startup of the JavaFX MainUISemaphoreTestStart.
 */
public class MainUITestStart {

    private UISemaphore MainUISemaphoreTestStart;

    @Before
    public final void preTest() {
        MainUISemaphoreTestStart = new UISemaphore();
    }

    @Test (expected = Exception.class)
    public final void testStart() {
        MainUISemaphoreTestStart.start(null);
    }

    @After
    public final void postTest() {
        MainUISemaphoreTestStart = null;
    }

}
