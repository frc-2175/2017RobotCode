package org.usfirst.frc.team2175.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PropertiesLoader {
    private final Logger log = Logger.getLogger(getClass().getName());

    private static final String CAN_T_CONTINUE_MSG = "; can't continue";

    /**
     * Load the properties from the specified file name.
     *
     * @param fileName
     *            The file name, including any desired path (absolute or
     *            relative).
     * @return Properties instance loaded with the properties in the file.
     */
    public Properties loadProperties(String fileName) {
        File file = new File(fileName);
        return loadProperties(file);
    }

    private Properties loadProperties(File file) {
        InputStream inputStream = openPropertiesFile(file);
        Properties prop = loadPropertiesFromFile(file, inputStream);

        if (prop.isEmpty()) {
            final String msg =
                    "No properties were loaded from file=" + file
                            + CAN_T_CONTINUE_MSG;
            throw new IllegalStateException(msg);
        }

        return prop;
    }

    private InputStream openPropertiesFile(File file) {
        InputStream inputStream;
        try {
            inputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            final String msg =
                    "Error finding properties file=" + file + CAN_T_CONTINUE_MSG;
            log.log(Level.SEVERE, msg, e);
            throw new IllegalStateException(msg, e);
        }
        return inputStream;
    }

    private Properties loadPropertiesFromFile(File file, InputStream inputStream) {
        Properties prop = new Properties();
        try {
            prop.load(inputStream);
        } catch (IOException e) {
            final String msg =
                    "Error reading properties file=" + file + CAN_T_CONTINUE_MSG;
            log.log(Level.SEVERE, msg, e);
            throw new IllegalStateException(msg, e);
        }
        return prop;
    }
}
