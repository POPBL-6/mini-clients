package main;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Class used to test the topic method.
 */
public class MainSemaphoreTestTopic {

    private MainSemaphore mainSemaphore;

    @Before
    public void preTest() {
        mainSemaphore = new MainSemaphore();
    }

    @Test
    public void mainTopic() {
        mainSemaphore.init(new String[]{"-t", "Topic"});
        assertEquals(mainSemaphore.getTopic(), "Topic");
    }

    @Test
    public void mainTopicNull() {
        MainSemaphore mainSemaphore = new MainSemaphore();
        assertEquals(mainSemaphore.getTopic(), null);
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
