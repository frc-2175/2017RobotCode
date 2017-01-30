package org.usfirst.frc.team2175.properties;

import org.junit.Test;
import org.usfirst.frc.team2175.TestBase;

public class BehaviorPropertiesTest extends TestBase {
    public void commonTestBehaviorProperties(final String propertyFileDir)
            throws IllegalArgumentException, IllegalAccessException {
        BaseProperties.setPropertyFileDir(propertyFileDir);
        final BehaviorProperties sut = new BehaviorProperties();
        assertInstanceVariablesNotNull(sut);
    }

    @Test
    public void testBehaviorProperties_Competition()
            throws IllegalArgumentException, IllegalAccessException {
        commonTestBehaviorProperties(PROPERTY_FILE_DIR_SRC_COMPETITION);
    }

    @Test
    public void testBehaviorProperties_Practice()
            throws IllegalArgumentException, IllegalAccessException {
        commonTestBehaviorProperties(PROPERTY_FILE_DIR_SRC_PRACTICE);
    }
}
