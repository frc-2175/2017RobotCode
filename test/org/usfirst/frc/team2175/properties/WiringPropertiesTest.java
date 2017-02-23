package org.usfirst.frc.team2175.properties;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import org.usfirst.frc.team2175.TestBase;
import org.usfirst.frc.team2175.properties.WiringProperties.MotorInfo;

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

    @Test
    public void testMotorDeviceNumbersAndInverted_Competition()
            throws IllegalArgumentException, IllegalAccessException {
        final String propertyFileDirectory = PROPERTY_FILE_DIR_SRC_COMPETITION;
        BaseProperties.setPropertyFileDir(propertyFileDirectory);
        final WiringProperties sut = new WiringProperties();
        assertDeviceValuesCorrect(sut);
    }

    @Test
    public void testMotorDeviceNumbersAndInverted_Practice()
            throws IllegalArgumentException, IllegalAccessException {
        final String propertyFileDirectory = PROPERTY_FILE_DIR_SRC_PRACTICE;
        BaseProperties.setPropertyFileDir(propertyFileDirectory);
        final WiringProperties sut = new WiringProperties();
        assertDeviceValuesCorrect(sut);
    }

    protected void assertDeviceValuesCorrect(final Object sut)
            throws IllegalArgumentException, IllegalAccessException {
        final HashMap<String, MotorInfo> hashMap =
                getFieldsOfType(MotorInfo.class, sut);

        for (final Map.Entry<String, MotorInfo> entry : hashMap.entrySet()) {
            final String key = entry.getKey();
            final MotorInfo value = entry.getValue();
            final int deviceNumber = value.deviceNumber;
            final boolean isInverted = value.isInverted;

            checkDeviceNumber(deviceNumber, key);
            checkIsInverted(isInverted, key);
        }
    }

    protected void checkDeviceNumber(final int deviceNumber, final String key) {
        final String assertMessage =
                "'" + deviceNumber + "' in ButtonInfo field " + key
                        + " is not a valid Joystick name.";
        assertTrue(assertMessage, deviceNumber > 0 && deviceNumber < 63);
    }

    protected void checkIsInverted(final boolean isInverted, final String key) {
        final String assertMessage =
                "ButtonInfo field " + key + " was not greater than 0.";
        assertTrue(assertMessage, isInverted == true || isInverted == false);
    }
}
