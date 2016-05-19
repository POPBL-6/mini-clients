package main;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Class used to test the main method.
 */
public class MainSemaphoreTestMain {

    private MainSemaphore mainSemaphore;

    @Before
    public void preTest() {
        mainSemaphore = new MainSemaphore();
    }

    @Test
    public void mainTest() {
        mainSemaphore.main(new String[] {"-t", "Topic"});
    }

    @Test
    public void mainTestError() {
        mainSemaphore.main(null);
    }

    @After
    public void postTest() {
        mainSemaphore = null;
    }

}
