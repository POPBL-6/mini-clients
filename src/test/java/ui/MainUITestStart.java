package ui;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This class tests the startup of the JavaFX ui.
 */
public class MainUITestStart {

    private UI ui;

    @Before
    public final void preTest() {
        ui = new UI();
    }

    @Test (expected = Exception.class)
    public final void testStart() {
        ui.start(null);
    }

    @After
    public final void postTest() {
        ui = null;
    }

}
