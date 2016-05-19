package ui;

import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
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
        mainUI.greenAreaClicked(null);
    }

    @Test
    public void testEventRed() {
        mainUI.redAreaClicked(null);
    }

    @Test
    public void testEventYellow() {
        mainUI.amberAreaClicked(null);
    }

    @After
    public void postTest() {
        mainUI = null;
    }

}
