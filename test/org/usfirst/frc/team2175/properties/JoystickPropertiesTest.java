package org.usfirst.frc.team2175.properties;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.usfirst.frc.team2175.TestBase;
import org.usfirst.frc.team2175.properties.JoystickProperties.ButtonInfo;

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

    @Test
    public void testJoystickNames_Competition()
            throws IllegalArgumentException, IllegalAccessException {
        final String propertyFileDirectory = PROPERTY_FILE_DIR_SRC_COMPETITION;
        commonTestJoystickNames(propertyFileDirectory);
    }

    @Test
    public void testJoystickNames_Practice()
            throws IllegalArgumentException, IllegalAccessException {
        final String propertyFileDirectory = PROPERTY_FILE_DIR_SRC_PRACTICE;
        commonTestJoystickNames(propertyFileDirectory);
    }

    @Test
    public void testJoystickPropertyValues_AboveZero_Competition()
            throws IllegalArgumentException, IllegalAccessException {
        final String propertyFileDirectory = PROPERTY_FILE_DIR_SRC_COMPETITION;
        commonTestPositiveProperties(propertyFileDirectory);
    }

    @Test
    public void testJoystickPropertyValues_AboveZero_Practice()
            throws IllegalArgumentException, IllegalAccessException {
        final String propertyFileDirectory = PROPERTY_FILE_DIR_SRC_PRACTICE;
        commonTestPositiveProperties(propertyFileDirectory);
    }

    protected void assertJoystickNameCorrect(final Object sut)
            throws IllegalArgumentException, IllegalAccessException {
        HashMap<String, ButtonInfo> hashMap =
                getFieldsOfType(ButtonInfo.class, sut);

        for (Map.Entry<String, ButtonInfo> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            ButtonInfo value = entry.getValue();
            String joystickName = value.joystickName.trim();
            final String assertMessage =
                    "'" + joystickName + "' in ButtonInfo field " + key
                            + " is not a valid Joystick name.";
            assertTrue(assertMessage,
                    joystickName.equals("left") || joystickName.equals("right")
                            || joystickName.equals("gamepad"));
        }
    }

    protected void assertButtonNumbersGreaterThanZero(final Object sut)
            throws IllegalArgumentException, IllegalAccessException {
        HashMap<String, ButtonInfo> hashMap =
                getFieldsOfType(ButtonInfo.class, sut);

        for (Map.Entry<String, ButtonInfo> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            ButtonInfo value = entry.getValue();
            final String assertMessage =
                    "ButtonInfo field " + key + " was not greater than 0.";
            assertTrue(assertMessage, value.buttonNumber > 0);
        }
    }

    protected void commonTestJoystickNames(final String propertyFileDirectory)
            throws IllegalArgumentException, IllegalAccessException {
        BaseProperties.setPropertyFileDir(propertyFileDirectory);
        final BaseProperties baseProperties = new JoystickProperties();

        assertJoystickNameCorrect(baseProperties);
    }

    private void commonTestPositiveProperties(
            final String propertyFileDirectory)
            throws IllegalArgumentException, IllegalAccessException {
        BaseProperties.setPropertyFileDir(propertyFileDirectory);
        final BaseProperties baseProperties = new JoystickProperties();

        assertButtonNumbersGreaterThanZero(baseProperties);
    }

    private void commonTestUniqueProperties(final String propertyFileDirectory,
            final String propertyRegex) {
        BaseProperties.setPropertyFileDir(propertyFileDirectory);
        final BaseProperties baseProperties = new JoystickProperties();

        assertNoDuplicatePropertyValues(propertyRegex, baseProperties);
    }
}
