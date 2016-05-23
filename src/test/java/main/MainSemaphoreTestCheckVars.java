package main;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;

/**
 * Testing init method that initialize the mainSemaphore.
 */
public class MainSemaphoreTestCheckVars {

    private MainSemaphore mainSemaphore;
    private Method method;

    @Before
    public void preTest() throws NoSuchMethodException {
        mainSemaphore = new MainSemaphore();
        method = MainSemaphore.class.getDeclaredMethod("checkVariables");
        method.setAccessible(true);
    }

    @Test
    public void testAllGood() throws InvocationTargetException, IllegalAccessException {
        mainSemaphore.setTopic("Topic");
        mainSemaphore.setAddress("Address");
        mainSemaphore.setPort("Port");
        boolean result = (Boolean) method.invoke(mainSemaphore);
        assertEquals(result, false);
    }

    @Test
    public void testParameterNull() throws InvocationTargetException, IllegalAccessException {
        mainSemaphore.setTopic("Topic");
        mainSemaphore.setAddress(null);
        mainSemaphore.setPort("Port");
        boolean result = (Boolean) method.invoke(mainSemaphore);
        assertEquals(result, true);
    }

    @After
    public void postTest() {
        mainSemaphore = null;
        method = null;
    }

}
