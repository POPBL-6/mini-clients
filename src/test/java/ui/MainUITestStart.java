package ui;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This class tests the startup of the JavaFX UI.
 */
public class MainUITestStart {

    private UI UI;

    @Before
    public void preTest() {
        UI = new UI();
    }

    @Test (expected = Exception.class)
    public void testStart() throws Exception {
        UI.start(null);
    }

    @After
    public void postTest() {
        UI = null;
    }

}
