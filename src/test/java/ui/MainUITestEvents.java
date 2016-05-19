package ui;

import javafx.event.ActionEvent;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This class tests the startup of the JavaFX UI.
 */
public class MainUITestEvents {

    private MainUI mainUI;

    @Before
    public void preTest() {
        mainUI = new MainUI();
    }

    @Test
    public void testEventGreen() {
        mainUI.setGreen(new ActionEvent());
    }

    @Test
    public void testEventRed() {
        mainUI.setRed(new ActionEvent());
    }

    @After
    public void postTest() {
        mainUI = null;
    }

}
