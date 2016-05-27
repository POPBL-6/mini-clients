package util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConfigReaderTest {

    @Test
    public final void testConfigFile()  {
        assertEquals(ConfigReader.readConfigFile("test.dat"), "Prueba");
    }

    @Test
    public final void testConfigNotFile()  {
        assertEquals(ConfigReader.readConfigFile("a.dat"), null);
    }

    @Test (expected = NullPointerException.class)
    public final void testConfigFileNull() {
        assertEquals(ConfigReader.readConfigFile(null), null);
    }

}
