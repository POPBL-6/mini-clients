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
    private static final String METHOD_NAME = "checkArgs";

    @Before
    public final void preTest() {
        mainSemaphore = new MainSemaphore();
    }

    @Test
    public final void testInitNull() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Class [] array = new Class []{String[].class};
        Method method = MainSemaphore.class.getDeclaredMethod(METHOD_NAME, array);
        method.setAccessible(true);
        boolean result = (Boolean) method.invoke(mainSemaphore, new Object[]{null});
        assertEquals(result, true);
    }

    @Test
    public final void testInitArrayOutOfBounds() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Class [] array = new Class []{String[].class};
        Method method = MainSemaphore.class.getDeclaredMethod(METHOD_NAME, array);
        method.setAccessible(true);
        boolean result = (Boolean) method.invoke(mainSemaphore, new Object[]{new String[]{}});
        assertEquals(result, true);
    }

    @Test
    public final void testInitAllNull() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        String [] args = new String[2];
        args[0] = null;
        args[1] = null;
        Class [] array = new Class []{String[].class};
        Method method = MainSemaphore.class.getDeclaredMethod(METHOD_NAME, array);
        method.setAccessible(true);
        boolean result = (Boolean) method.invoke(mainSemaphore, new Object[]{args});
        assertEquals(result, true);
    }

    @Test
    public final void testInitFirstNull() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        String [] args = new String[2];
        args[0] = null;
        args[1] = "Topic";
        Class [] array = new Class []{String[].class};
        Method method = MainSemaphore.class.getDeclaredMethod(METHOD_NAME, array);
        method.setAccessible(true);
        boolean result = (Boolean) method.invoke(mainSemaphore, new Object[]{args});
        assertEquals(result, true);
    }

    @Test
    public final void testInitFirstEmpty() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        String [] args = new String[2];
        args[0] = "";
        args[1] = "Topic";
        Class [] array = new Class []{String[].class};
        Method method = MainSemaphore.class.getDeclaredMethod(METHOD_NAME, array);
        method.setAccessible(true);
        boolean result = (Boolean) method.invoke(mainSemaphore, new Object[]{args});
        assertEquals(result, true);
    }

    @Test
    public final void testInitTopicNull() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        String [] args = new String[2];
        args[0] = "-t";
        args[1] = null;
        Class [] array = new Class []{String[].class};
        Method method = MainSemaphore.class.getDeclaredMethod(METHOD_NAME, array);
        method.setAccessible(true);
        boolean result = (Boolean) method.invoke(mainSemaphore, new Object[]{args});
        assertEquals(result, true);
    }

    @Test
    public final void testInitTopicEmpty() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        String [] args = new String[2];
        args[0] = "-t";
        args[1] = "";
        Class [] array = new Class []{String[].class};
        Method method = MainSemaphore.class.getDeclaredMethod(METHOD_NAME, array);
        method.setAccessible(true);
        boolean result = (Boolean) method.invoke(mainSemaphore, new Object[]{args});
        assertEquals(result, true);
    }

    @After
    public final void postTest() {
        mainSemaphore = null;
    }

}
