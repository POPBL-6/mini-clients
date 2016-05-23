import main.MainSemaphoreTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import ui.UITest;

/**
 * This suite will test everything.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({MainSemaphoreTest.class, UITest.class})
public class MainTest {}
