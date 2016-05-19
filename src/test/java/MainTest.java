import main.MainSemaphoreTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import ui.MainUITest;

/**
 * This suite will test everything.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({MainSemaphoreTest.class, MainUITest.class})
public class MainTest {}
