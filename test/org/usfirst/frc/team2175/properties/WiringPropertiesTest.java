package org.usfirst.frc.team2175.properties;

import org.junit.Ignore;
import org.junit.Test;
import org.usfirst.frc.team2175.TestBase;

public class WiringPropertiesTest extends TestBase {
    @Test
    public void testWiringProperties_Competition()
            throws IllegalArgumentException, IllegalAccessException {
        commonTestWiringProperties(PROPERTY_FILE_DIR_SRC_COMPETITION);
    }

    @Test
    public void testWiringProperties_Practice()
            throws IllegalArgumentException, IllegalAccessException {
        commonTestWiringProperties(PROPERTY_FILE_DIR_SRC_PRACTICE);
    }

    public void commonTestWiringProperties(final String propertyFileDirectory)
            throws IllegalArgumentException, IllegalAccessException {
        BaseProperties.setPropertyFileDir(propertyFileDirectory);
        final WiringProperties sut = new WiringProperties();
        assertInstanceVariablesNotNull(sut);
        assertArraysNotZeroLength(sut);
    }

    @Test
    public void testWiringProperties_UniquePropertiesSequence_Motor_Competition() {
        final String propertyRegex = ".*[.]motor[.].*";
        final String propertyFileDirectory = PROPERTY_FILE_DIR_SRC_COMPETITION;

        commonTestUniqueProperties(propertyFileDirectory, propertyRegex);
    }

    @Test
    public void testWiringProperties_UniquePropertiesSequence_Motor_Practice() {
        final String propertyRegex = ".*[.]motor[.].*";
        final String propertyFileDirectory = PROPERTY_FILE_DIR_SRC_PRACTICE;

        commonTestUniqueProperties(propertyFileDirectory, propertyRegex);
    }

    @Test
    @Ignore
    public void testWiringProperties_UniquePropertiesSequence_Digital_Competition() {
        final String propertyRegex = ".*[.]digital[.].*port.*";
        final String propertyFileDirectory = PROPERTY_FILE_DIR_SRC_COMPETITION;

        commonTestUniqueProperties(propertyFileDirectory, propertyRegex);
    }

    @Test
    @Ignore
    public void testWiringProperties_UniquePropertiesSequence_Digital_Practice() {
        final String propertyRegex = ".*[.]digital[.].*port.*";
        final String propertyFileDirectory = PROPERTY_FILE_DIR_SRC_PRACTICE;

        commonTestUniqueProperties(propertyFileDirectory, propertyRegex);
    }

    @Test
    public void testWiringProperties_UniquePropertiesSequence_Solenoid_Competition() {
        final String propertyRegex = ".*[.]solenoid[.].*";
        final String propertyFileDirectory = PROPERTY_FILE_DIR_SRC_COMPETITION;

        commonTestUniqueProperties(propertyFileDirectory, propertyRegex);
    }

    @Test
    public void testWiringProperties_UniquePropertiesSequence_Solenoid_Practice() {
        final String propertyRegex = ".*[.]solenoid[.].*";
        final String propertyFileDirectory = PROPERTY_FILE_DIR_SRC_PRACTICE;

        commonTestUniqueProperties(propertyFileDirectory, propertyRegex);
    }

    private void commonTestUniqueProperties(final String propertyFileDirectory,
            final String propertyRegex) {
        BaseProperties.setPropertyFileDir(propertyFileDirectory);
        final BaseProperties baseProperties = new WiringProperties();

        assertNoDuplicatePropertyValues(propertyRegex, baseProperties);
    }
}
