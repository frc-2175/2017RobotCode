package org.usfirst.frc.team2175.config;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class BaseConfig {
    private final Logger log = Logger.getLogger(getClass().getName());

    private static final String PROPERTY_FILE_DIR_DEFAULT = "/home/lvuser/";
    private static String propertyFileDir = PROPERTY_FILE_DIR_DEFAULT;

    private final Properties properties;

    public BaseConfig() {
        log.info("Configuring class `" + getClass() + "`");

        final String propertyFileFullPath =
                propertyFileDir + getPropertyFileName();
        properties = new PropertiesLoader().loadProperties(propertyFileFullPath);

        try {
            configure();
        } catch (Throwable e) {
            String msg =
                    "ERROR during configuration of class `" + getClass() + "`";
            log.log(Level.SEVERE, msg, e);
            throw e;
        }
    }

    /** @return The property file name to load for this config. */
    protected abstract String getPropertyFileName();

    protected abstract void configure();

    public static void setPropertyFileDir(String directory) {
        propertyFileDir = directory;
    }

    protected boolean getBooleanPropertyValue(String propertyName) {
        final String propertyValue = getStringPropertyValue(propertyName);
        return Boolean.parseBoolean(propertyValue);
    }

    protected int getIntPropertyValue(String propertyName) {
        final String propertyValue = getStringPropertyValue(propertyName);
        return Integer.parseInt(propertyValue);
    }

    protected double getDoublePropertyValue(String propertyName) {
        final String propertyValue = getStringPropertyValue(propertyName);
        return Double.parseDouble(propertyValue);
    }

    protected String getStringPropertyValue(String propertyName) {
        final String value = properties.getProperty(propertyName);
        if (value == null) {
            String msg =
                    "Property `" + propertyName + "` not found in property file";
            throw new IllegalStateException(msg);
        }

        return value;
    }

    protected int[] getIntArrayPropertyValue(String propertyName) {
        final String propertyValue = getStringPropertyValue(propertyName);
        String rawValues = propertyValue;
        rawValues = rawValues.replace("[", "");
        rawValues = rawValues.replace("]", "");
        final String[] splitValues = rawValues.split(",");

        int[] returnValues = new int[splitValues.length];
        for (int i = 0; i < splitValues.length; i++) {
            returnValues[i] = Integer.parseInt(splitValues[i].trim());
        }

        return returnValues;
    }
}
