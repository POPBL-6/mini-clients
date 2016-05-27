package util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConfigReaderTest {

    @Test
    public final void testConfigFile()  {
        assertEquals(new ConfigReader().readConfigFile("test.dat"), "Prueba");
    }

    @Test (expected = NullPointerException.class)
    public final void testConfigNotFile()  {
        assertEquals(new ConfigReader().readConfigFile("a.dat"), "Prueba");
    }

    @Test (expected = NullPointerException.class)
    public final void testConfigFileNull() {
        assertEquals(new ConfigReader().readConfigFile(null), null);
    }

}
