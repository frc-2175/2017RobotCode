package org.usfirst.frc.team2175.learning.jmockit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import mockit.Mock;
import mockit.MockUp;

/**
 * Demonstrating how to partially mock a class instead of a full mock.
 *
 * @author jjensen
 */
public class JMockitPartialMockTest {
    private static final String ADDED_METHOD_MSG = "added method";
    private static final String MOCKED_METHOD_MSG = "mocked method";

    /** Partial mocking using concrete class named "NormalClass". */
    @Test
    public void testPartialMock_UsingMockedClass() {
        final MockedClass mockedClass = new MockedClass();
        final String methodToMockFromMocked = mockedClass.methodToMock();
        final String methodOnlyInMockUp = mockedClass.methodOnlyInMockUp();

        // it's mocked on this class
        assertThat("Incorrect message for mocked method from mocked.",
                methodToMockFromMocked, equalTo(MOCKED_METHOD_MSG));
        assertThat("Incorrect message for added method.", methodOnlyInMockUp,
                equalTo(ADDED_METHOD_MSG));

        // it's mocked on this class too
        final NormalClass mockInstance = mockedClass.getMockInstance();
        final String methodToMockFromInstance = mockInstance.methodToMock();
        // the added method is not in the mock instance
        // String methodOnlyInMock = mockInstance.methodOnlyInMock();

        assertThat("Incorrect message for mocked method from instance.",
                methodToMockFromInstance, equalTo(MOCKED_METHOD_MSG));
    }

    /** Partial mocking using anonymous class; notice reduced method access. */
    @Test
    public void testPartialMock_UsingAnonymousClass() {
        final MockUp<NormalClass> mockedClass = new MockUp<NormalClass>() {
            @Mock
            public String methodToMock() {
                return MOCKED_METHOD_MSG;
            }

            public String methodOnlyInMockUp() {
                return ADDED_METHOD_MSG;
            }
        };

        // can't call it directly, not accessible
        // String methodToMockFromMocked = mockedClass.methodToMock();
        // can't call it directly, not accessible
        // String methodOnlyInMockUp = mockedClass.methodOnlyInMockUp();

        // it's mocked on this class but can't directly call it
        // assertThat("Incorrect message for mocked method from mocked.",
        // methodToMockFromMocked, equalTo(MOCKED_METHOD_MSG));

        final NormalClass mockInstance = mockedClass.getMockInstance();

        // it's mocked on this class too and directly callable
        final String methodToMockFromInstance = mockInstance.methodToMock();
        // the added method is not in the mock instance
        // String methodOnlyInMock = mockInstance.methodOnlyInMock();

        assertThat("Incorrect message for mocked method from instance.",
                methodToMockFromInstance, equalTo(MOCKED_METHOD_MSG));
    }

    public static class NormalClass {
        public String methodToMock() {
            throw new IllegalStateException("Need to mock this method!!");
        }
    }

    public static class MockedClass extends MockUp<NormalClass> {
        // if needed, add constructor and call a MockUp constructor with an
        // initialized mock

        // To remove the mocking, remove @Mock and see the exception from
        // NormalClass
        @Mock
        public String methodToMock() {
            return MOCKED_METHOD_MSG;
        }

        public String methodOnlyInMockUp() {
            return ADDED_METHOD_MSG;
        }
    }
}
