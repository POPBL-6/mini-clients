package ui;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This class tests the startup of the JavaFX UI.
 */
public class MainUITestStart {

    private MainUI mainUI;

    @Before
    public void preTest() {
        mainUI = new MainUI();
    }

    @Test (expected = Exception.class)
    public void testStart() throws Exception {
        mainUI.start(null);
    }

    @After
    public void postTest() {
        mainUI = null;
    }

}
