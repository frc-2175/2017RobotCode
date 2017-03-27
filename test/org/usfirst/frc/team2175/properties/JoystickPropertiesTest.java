package org.usfirst.frc.team2175.properties;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;
import org.usfirst.frc.team2175.TestBase;
import org.usfirst.frc.team2175.properties.JoystickProperties.ButtonInfo;

public class JoystickPropertiesTest extends TestBase {
    protected static JoystickProperties sut;

    @BeforeClass
    public static void createJoystickProperties() {
        BaseProperties.setPropertyFileDir(PROPERTY_FILE_DIR_SRC);
        sut = new JoystickProperties();
    }

    @Test
    public void testJoystickProperties()
            throws IllegalArgumentException, IllegalAccessException {
        assertInstanceVariablesNotNull(sut);
        assertArraysNotZeroLength(sut);
    }

    @Test
    public void testJoystickProperties_UniquePropertiesSequence_Motor() {
        final String propertyRegex = "button[.].*";

        assertNoDuplicatePropertyValues(propertyRegex, sut);
    }

    @Test
    public void testGetJoystickName() {
        final String assertMessage =
                "getJoystickName() does not correctly give Joystick Name.";
        assertNotNull(assertMessage, sut.getJoystickName("button.shift"));
    }

    @Test
    public void testGetButtonNumber() {
        final String assertMessage =
                "getButtonNumber() does not correctly give Button Number.";
        final int buttonNumber = sut.getButtonNumber("button.shift");
        assertNotNull(assertMessage, buttonNumber);
        assertNotEquals(assertMessage, 0, buttonNumber);
    }

    @Test
    public void testJoystickNamesAndValues()
            throws IllegalArgumentException, IllegalAccessException {
        assertJoystickValuesCorrect(sut);
    }

    protected void assertJoystickValuesCorrect(final Object sut)
            throws IllegalArgumentException, IllegalAccessException {
        final HashMap<String, ButtonInfo> hashMap =
                getFieldsOfType(ButtonInfo.class, sut);

        for (final Map.Entry<String, ButtonInfo> entry : hashMap.entrySet()) {
            final String key = entry.getKey();
            final ButtonInfo value = entry.getValue();
            final String joystickName = value.joystickName.trim();
            final int buttonValue = value.buttonNumber;

            checkJoystickName(joystickName, key);
            checkButtonNumberAboveZero(buttonValue, key);
        }
    }

    protected void checkJoystickName(final String joystickName,
            final String key) {
        final String assertMessage =
                "'" + joystickName + "' in ButtonInfo field " + key
                        + " is not a valid Joystick name.";
        assertTrue(assertMessage,
                joystickName.equals("left") || joystickName.equals("right")
                        || joystickName.equals("gamepad"));
    }

    protected void checkButtonNumberAboveZero(final int buttonValue,
            final String key) {
        final String assertMessage =
                "ButtonInfo field " + key + " was not greater than 0.";
        assertTrue(assertMessage, buttonValue > 0);
    }

}
