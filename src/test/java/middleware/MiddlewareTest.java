package middleware;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Suite of tests for middleware implementation.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({MiddlewareTestConstructor.class, MiddlewareTestPublish.class, MiddlewareTestConnection.class, MiddlewareTestLastSample.class})
public class MiddlewareTest {}
