package all;

import main.MainSemaphoreTest;
import middleware.MiddlewareTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import ui.UITest;
import util.ConfigReaderTest;

/**
 * This suite will test everything.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({MainSemaphoreTest.class, UITest.class, MiddlewareTest.class, ConfigReaderTest.class})
public class MainTest {}
