package main;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Urko on 19/05/2016.
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

    @After
    public void postTest() {
        mainSemaphore = null;
    }

}
