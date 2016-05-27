package all;

import middleware.MiddlewareTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import ui.UITest;
import util.ConfigReaderTest;

/**
 * This suite will test everything.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({UITest.class, MiddlewareTest.class, ConfigReaderTest.class})
public class MainTest {}
