package org.usfirst.frc.team2175.properties;

import org.junit.Ignore;
import org.junit.Test;
import org.usfirst.frc.team2175.TestBase;

public class WiringPropertiesTest extends TestBase {
    @Test
    public void testWiringProperties_Competition()
            throws IllegalArgumentException, IllegalAccessException {
        BaseProperties.setPropertyFileDir(PROPERTY_FILE_DIR_SRC_COMPETITION);
        WiringProperties sut = new WiringProperties();
        assertInstanceVariablesNotNull(sut);
        assertArraysNotZeroLength(sut);
    }

    @Test
    public void testWiringProperties_Practice()
            throws IllegalArgumentException, IllegalAccessException {
        BaseProperties.setPropertyFileDir(PROPERTY_FILE_DIR_SRC_PRACTICE);
        WiringProperties sut = new WiringProperties();
        assertInstanceVariablesNotNull(sut);
        assertArraysNotZeroLength(sut);
    }

    @Test
    public void testWiringProperties_UniquePropertiesSequence_Motor_Competition() {
        String propertyRegex = ".*[.]motor[.].*";
        String propertyFileDirectory = PROPERTY_FILE_DIR_SRC_COMPETITION;

        commonTestUniqueProperties(propertyFileDirectory, propertyRegex);
    }

    @Test
    public void testWiringProperties_UniquePropertiesSequence_Motor_Practice() {
        String propertyRegex = ".*[.]motor[.].*";
        String propertyFileDirectory = PROPERTY_FILE_DIR_SRC_PRACTICE;

        commonTestUniqueProperties(propertyFileDirectory, propertyRegex);
    }

    @Test
    @Ignore
    public void testWiringProperties_UniquePropertiesSequence_Digital_Competition() {
        String propertyRegex = ".*[.]digital[.].*port.*";
        String propertyFileDirectory = PROPERTY_FILE_DIR_SRC_COMPETITION;

        commonTestUniqueProperties(propertyFileDirectory, propertyRegex);
    }

    @Test
    @Ignore
    public void testWiringProperties_UniquePropertiesSequence_Digital_Practice() {
        String propertyRegex = ".*[.]digital[.].*port.*";
        String propertyFileDirectory = PROPERTY_FILE_DIR_SRC_PRACTICE;

        commonTestUniqueProperties(propertyFileDirectory, propertyRegex);
    }

    @Test
    public void testWiringProperties_UniquePropertiesSequence_Solenoid_Competition() {
        String propertyRegex = ".*[.]solenoid[.].*";
        String propertyFileDirectory = PROPERTY_FILE_DIR_SRC_COMPETITION;

        commonTestUniqueProperties(propertyFileDirectory, propertyRegex);
    }

    @Test
    public void testWiringProperties_UniquePropertiesSequence_Solenoid_Practice() {
        String propertyRegex = ".*[.]solenoid[.].*";
        String propertyFileDirectory = PROPERTY_FILE_DIR_SRC_PRACTICE;

        commonTestUniqueProperties(propertyFileDirectory, propertyRegex);
    }

    private void commonTestUniqueProperties(String propertyFileDirectory,
            String propertyRegex) {
        BaseProperties.setPropertyFileDir(propertyFileDirectory);
        BaseProperties baseProperties = new WiringProperties();

        assertNoDuplicatePropertyValues(propertyRegex, baseProperties);
    }
}
