package org.usfirst.frc.team2175.properties;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.usfirst.frc.team2175.TestBase;

public class BasePropertiesTest extends TestBase {
    private static final String KEY_WITH_BRACKETS_WITH_SPACES =
            "with.brackets.with.spaces";
    private static final String KEY_WITH_BRACKETS_WITHOUT_SPACES =
            "with.brackets.without.spaces";
    private static final String KEY_WITHOUT_BRACKETS_WITH_SPACES =
            "without.brackets.with.spaces";
    private static final String KEY_WITHOUT_BRACKETS_WITHOUT_SPACES =
            "without.brackets.without.spaces";
    private static final String KEY_WITH_BRACKETS_WITH_SPACES_LONGER =
            "with.brackets.with.spaces.longer";

    private static final String STRING_KEY_WITH_BRACKETS_WITH_SPACES =
            "string.with.brackets.with.spaces";
    private static final String STRING_KEY_WITH_BRACKETS_WITHOUT_SPACES =
            "string.with.brackets.without.spaces";
    private static final String STRING_KEY_WITHOUT_BRACKETS_WITH_SPACES =
            "string.without.brackets.with.spaces";
    private static final String STRING_KEY_WITHOUT_BRACKETS_WITHOUT_SPACES =
            "string.without.brackets.without.spaces";
    private static final String STRING_KEY_WITH_BRACKETS_WITH_SPACES_LONGER =
            "string.with.brackets.with.spaces.longer";

    private BasePropertiesImplementation sut =
            new BasePropertiesImplementation();

    private void assertIntArrayMatches(final int[] expected,
            final int[] actual) {
        final String lengthFailMsg = "Actual array had length " + actual.length
                + ", expected " + expected.length;
        assertEquals(lengthFailMsg, expected.length, actual.length);

        for (int i = 0; i < expected.length; i++) {
            final String valueFailMsg = "Actual array had value " + actual[i]
                    + ", expected " + expected[i];
            assertEquals(valueFailMsg, expected[i], actual[i]);
        }
    }

    @Test
    public void testGetIntArrayPropertyValue() {
        final int[] expectedArray = { 1, 2, 3 };

        final int[] actualWithBrackets =
                sut.getIntArrayPropertyValue(KEY_WITH_BRACKETS_WITH_SPACES);
        assertIntArrayMatches(expectedArray, actualWithBrackets);

        final int[] actualWithoutSpacesWithBrackets =
                sut.getIntArrayPropertyValue(KEY_WITH_BRACKETS_WITHOUT_SPACES);
        assertIntArrayMatches(expectedArray, actualWithoutSpacesWithBrackets);

        final int[] actualWithoutBrackets =
                sut.getIntArrayPropertyValue(KEY_WITHOUT_BRACKETS_WITH_SPACES);
        assertIntArrayMatches(expectedArray, actualWithoutBrackets);

        final int[] actualWithoutSpacesWithoutBrackets = sut
                .getIntArrayPropertyValue(KEY_WITHOUT_BRACKETS_WITHOUT_SPACES);
        assertIntArrayMatches(expectedArray,
                actualWithoutSpacesWithoutBrackets);

        final int[] expectedArrayLonger = { 0, 2, 4, 6, 8, 10 };

        final int[] actualLonger = sut
                .getIntArrayPropertyValue(KEY_WITH_BRACKETS_WITH_SPACES_LONGER);
        assertIntArrayMatches(expectedArrayLonger, actualLonger);
    }

    private void assertStringArrayMatches(final String[] expected,
            final String[] actual) {
        final String lengthFailMsg = "Actual array had length " + actual.length
                + ", expected " + expected.length;
        assertEquals(lengthFailMsg, expected.length, actual.length);

        for (int i = 0; i < expected.length; i++) {
            final String valueFailMsg = "Actual array had value " + actual[i]
                    + ", expected " + expected[i];
            assertEquals(valueFailMsg, expected[i], actual[i]);
        }
    }

    @Test
    public void testGetStringArrayPropertyValue() {
        final String[] expectedArray = { "one", "two", "three" };

        final String[] actualWithBrackets = sut.getStringArrayPropertyValue(
                STRING_KEY_WITH_BRACKETS_WITH_SPACES);
        assertStringArrayMatches(expectedArray, actualWithBrackets);

        final String[] actualWithoutSpacesWithBrackets =
                sut.getStringArrayPropertyValue(
                        STRING_KEY_WITH_BRACKETS_WITHOUT_SPACES);
        assertStringArrayMatches(expectedArray,
                actualWithoutSpacesWithBrackets);

        final String[] actualWithoutBrackets = sut.getStringArrayPropertyValue(
                STRING_KEY_WITHOUT_BRACKETS_WITH_SPACES);
        assertStringArrayMatches(expectedArray, actualWithoutBrackets);

        final String[] actualWithoutSpacesWithoutBrackets =
                sut.getStringArrayPropertyValue(
                        STRING_KEY_WITHOUT_BRACKETS_WITHOUT_SPACES);
        assertStringArrayMatches(expectedArray,
                actualWithoutSpacesWithoutBrackets);

        final String[] expectedArrayLonger =
                { "zero", "two", "four", "six", "eight", "ten" };

        final String[] actualLonger = sut.getStringArrayPropertyValue(
                STRING_KEY_WITH_BRACKETS_WITH_SPACES_LONGER);
        assertStringArrayMatches(expectedArrayLonger, actualLonger);
    }

    private class BasePropertiesImplementation extends BaseProperties {
        @Override
        protected String getPropertyFileName() {
            return "basePropertiesTest.properties"; // Anything that works
        }

        @Override
        protected void populate() {
        }
    }
}
