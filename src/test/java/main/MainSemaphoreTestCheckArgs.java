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
public class MainSemaphoreTestCheckArgs {

    private MainSemaphore mainSemaphore;

    @Before
    public void preTest() {
        mainSemaphore = new MainSemaphore();
    }

    @Test
    public void testInitNull() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Class [] array = new Class []{String[].class};
        Method method = MainSemaphore.class.getDeclaredMethod("checkArgs", array);
        method.setAccessible(true);
        boolean result = (Boolean) method.invoke(mainSemaphore, new Object[]{null});
        assertEquals(result, true);
    }

    @Test
    public void testInitArrayOutOfBounds() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Class [] array = new Class []{String[].class};
        Method method = MainSemaphore.class.getDeclaredMethod("checkArgs", array);
        method.setAccessible(true);
        boolean result = (Boolean) method.invoke(mainSemaphore, new Object[]{new String[]{}});
        assertEquals(result, true);
    }

    @Test
    public void testInitAllNull() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        String [] args = new String[2];
        args[0] = null;
        args[1] = null;
        Class [] array = new Class []{String[].class};
        Method method = MainSemaphore.class.getDeclaredMethod("checkArgs", array);
        method.setAccessible(true);
        boolean result = (Boolean) method.invoke(mainSemaphore, new Object[]{args});
        assertEquals(result, true);
    }

    @Test
    public void testInitFirstNull() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        String [] args = new String[2];
        args[0] = null;
        args[1] = "Topic";
        Class [] array = new Class []{String[].class};
        Method method = MainSemaphore.class.getDeclaredMethod("checkArgs", array);
        method.setAccessible(true);
        boolean result = (Boolean) method.invoke(mainSemaphore, new Object[]{args});
        assertEquals(result, true);
    }

    @Test
    public void testInitFirstEmpty() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        String [] args = new String[2];
        args[0] = "";
        args[1] = "Topic";
        Class [] array = new Class []{String[].class};
        Method method = MainSemaphore.class.getDeclaredMethod("checkArgs", array);
        method.setAccessible(true);
        boolean result = (Boolean) method.invoke(mainSemaphore, new Object[]{args});
        assertEquals(result, true);
    }

    @Test
    public void testInitTopicNull() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        String [] args = new String[2];
        args[0] = "-t";
        args[1] = null;
        Class [] array = new Class []{String[].class};
        Method method = MainSemaphore.class.getDeclaredMethod("checkArgs", array);
        method.setAccessible(true);
        boolean result = (Boolean) method.invoke(mainSemaphore, new Object[]{args});
        assertEquals(result, true);
    }

    @Test
    public void testInitTopicEmpty() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        String [] args = new String[2];
        args[0] = "-t";
        args[1] = "";
        Class [] array = new Class []{String[].class};
        Method method = MainSemaphore.class.getDeclaredMethod("checkArgs", array);
        method.setAccessible(true);
        boolean result = (Boolean) method.invoke(mainSemaphore, new Object[]{args});
        assertEquals(result, true);
    }

    @After
    public void postTest() {
        mainSemaphore = null;
    }

}
