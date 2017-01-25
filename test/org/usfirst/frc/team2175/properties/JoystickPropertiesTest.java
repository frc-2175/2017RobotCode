package org.usfirst.frc.team2175.properties;

import org.junit.Test;
import org.usfirst.frc.team2175.TestBase;

public class JoystickPropertiesTest extends TestBase {

    @Test
    public void testJoystickProperties_Competition()
            throws IllegalArgumentException, IllegalAccessException {
        commonTestJoystickProperties(PROPERTY_FILE_DIR_SRC_COMPETITION);
    }

    @Test
    public void testJoystickProperties_Practice()
            throws IllegalArgumentException, IllegalAccessException {
        commonTestJoystickProperties(PROPERTY_FILE_DIR_SRC_PRACTICE);
    }

    public void commonTestJoystickProperties(final String propertyFileDirectory)
            throws IllegalArgumentException, IllegalAccessException {
        BaseProperties.setPropertyFileDir(propertyFileDirectory);
        final JoystickProperties sut = new JoystickProperties();
        assertInstanceVariablesNotNull(sut);
        assertArraysNotZeroLength(sut);
    }

    @Test
    public void testJoystickProperties_UniquePropertiesSequence_Motor_Competition() {
        final String propertyRegex = "button[.].*";
        final String propertyFileDirectory = PROPERTY_FILE_DIR_SRC_COMPETITION;

        commonTestUniqueProperties(propertyFileDirectory, propertyRegex);
    }

    @Test
    public void testJoystickProperties_UniquePropertiesSequence_Motor_Practice() {
        final String propertyRegex = "button[.].*";
        final String propertyFileDirectory = PROPERTY_FILE_DIR_SRC_PRACTICE;

        commonTestUniqueProperties(propertyFileDirectory, propertyRegex);
    }

    private void commonTestUniqueProperties(final String propertyFileDirectory,
            final String propertyRegex) {
        BaseProperties.setPropertyFileDir(propertyFileDirectory);
        final BaseProperties baseProperties = new JoystickProperties();

        assertNoDuplicatePropertyValues(propertyRegex, baseProperties);
    }
}
