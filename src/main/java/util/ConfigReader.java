package util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Class that will be used to read config files.
 * @author Urko
 */
public class ConfigReader {

    private static final Logger LOGGER = LogManager.getLogger(ConfigReader.class);

    /**
     * Method reads a config file from a concrete path.
     * This config method must be of a single line.
     * @param file File name.
     * @return The config file content.
     */
    public static String readConfigFile(String file) {
        Scanner s = null;
        String config = null;
        try {
            s = new Scanner(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            LOGGER.fatal("Can't find the file " + file, e);
        }
        try {
            config = s.nextLine();
            s.close();
        } catch (NullPointerException e) {
            LOGGER.fatal("File " + file + "is null", e);
        }
        return config;
    }

}
