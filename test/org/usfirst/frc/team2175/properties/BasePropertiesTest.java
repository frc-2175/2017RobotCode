package org.usfirst.frc.team2175.properties;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
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

    private BasePropertiesImplementation sut =
            new BasePropertiesImplementation();

    @BeforeClass
    public static void setUp() {
        BaseProperties.setPropertyFileDir(PROPERTY_FILE_DIR_SRC_TESTS);
    }

    private void assertIntArrayMatches(final int[] expected,
            final int[] actual) {
        final String lengthMsg = "Actual array had length " + actual.length
                + ", expected " + expected.length;
        assertEquals(lengthMsg, expected.length, actual.length);

        for (int i = 0; i < expected.length; i++) {
            final String valueMsg = "Actual array had value " + actual[i]
                    + ", expected " + expected[i];
            assertEquals(valueMsg, expected[i], actual[i]);
        }
    }

    @Test
    public void testGetIntArrayPropertyValue() {
        final int[] testArray = { 1, 2, 3 };

        final int[] resultWithBrackets =
                sut.getIntArrayPropertyValue(KEY_WITH_BRACKETS_WITH_SPACES);
        assertIntArrayMatches(testArray, resultWithBrackets);

        final int[] resultWithoutSpacesWithBrackets =
                sut.getIntArrayPropertyValue(KEY_WITH_BRACKETS_WITHOUT_SPACES);
        assertIntArrayMatches(testArray, resultWithoutSpacesWithBrackets);

        final int[] resultWithoutBrackets =
                sut.getIntArrayPropertyValue(KEY_WITHOUT_BRACKETS_WITH_SPACES);
        assertIntArrayMatches(testArray, resultWithoutBrackets);

        final int[] resultWithoutSpacesWithoutBrackets = sut
                .getIntArrayPropertyValue(KEY_WITHOUT_BRACKETS_WITHOUT_SPACES);
        assertIntArrayMatches(testArray, resultWithoutSpacesWithoutBrackets);

        final int[] testArrayLonger = { 0, 2, 4, 6, 8, 10 };

        final int[] resultLonger = sut
                .getIntArrayPropertyValue(KEY_WITH_BRACKETS_WITH_SPACES_LONGER);
        assertIntArrayMatches(testArrayLonger, resultLonger);
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
