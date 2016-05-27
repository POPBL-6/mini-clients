package util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Urko on 27/05/2016.
 */
public class ConfigReader {

    private static final Logger LOGGER = LogManager.getLogger(ConfigReader.class);

    /**
     * Method reads a config file from a concrete path.
     * This config method must be of a single line.
     * @param file File name.
     * @return The config file content.
     */
    public final String readConfigFile(String file) {
        Scanner s = null;
        try {
            s = new Scanner(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            LOGGER.fatal("Can't find the file " + file, e);
        }
        String config = s.nextLine();
        s.close();
        return config;
    }

}
