package org.usfirst.frc.team2175.properties;

/**
 * Class for testing with properties classes.
 *
 * @author jjensen
 */
public class GenericTestProperties extends BaseProperties {
    private static String propertiesFileName = "is not set";

    @Override
    protected String getPropertyFileName() {
        return propertiesFileName;
    }

    @Override
    protected void populate() {
    }

    public static void setPropertiesFileName(final String fileName) {
        propertiesFileName = fileName;
    }
}
