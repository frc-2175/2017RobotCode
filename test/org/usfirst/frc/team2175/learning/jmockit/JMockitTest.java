package org.usfirst.frc.team2175.learning.jmockit;

import static org.junit.Assert.assertNotNull;

import java.awt.ActiveEvent;
import java.awt.Point;

import org.junit.Ignore;
import org.junit.Test;

import mockit.Injectable;
import mockit.Mocked;
import mockit.Tested;

/**
 * Demonstrating some JMockit features.
 *
 * @author jjensen
 */
public class JMockitTest {
    // JMockit mocks this and injects it on @Tested objects
    @Injectable
    private Point pointConstructorArg;

    // JMockit mocks this and injects it on @Tested objects
    @Injectable
    private ActiveEvent activeEventInstanceVar;

    // JMockit mocks this and uses the mock anywhere it is needed
    // Note: this is the parent class of TestClass, and therefore it replaces it
    @Mocked
    private ParentTestClass parentTestClass;

    // JMockit instantiates this class and injects all it finds
    @Tested
    private TestClass sut;

    @Ignore("Test disabled for build; locally remove this line to run the test")
    @Test
    public void testIt() {
        System.out.println("NOTICE: constructorArg's toString() result"
                + " is Object's, not Point's; it's instantiated by JMockit");
        System.out.println(sut);

        final Point constructorArg = sut.getConstructorArg();
        final Point instanceVariable = sut.getInstanceVariable();
        final ActiveEvent activeEvent2 = sut.getActiveEvent();

        System.out.println("constructorArg class=" + constructorArg.getClass());
        System.out.println(
                "instanceVariable class=" + instanceVariable.getClass());
        System.out.println(
                "activeEvent class (ActiveEvent is an interface; JMockit made a class for it)="
                        + activeEvent2.getClass());

        System.out
                .println("pointConstructorArg.X=" + pointConstructorArg.getX());
        System.out
                .println("pointConstructorArg.Y=" + pointConstructorArg.getY());
        System.out.println(
                "instanceVariable.X=" + sut.getInstanceVariable().getX());
        System.out.println(
                "instanceVariable.Y=" + sut.getInstanceVariable().getY());
    }

    public static class TestClass extends ParentTestClass {
        /** Passed in from constructor. */
        private final Point constructorArg;

        /** Hardcoded here. */
        private final Point instanceVariable = new Point(1, 1);

        /**
         * Not set anywhere; JMockit automatically sets it with the @Injectable
         * on @Tested.
         */
        private ActiveEvent activeEvent;

        public TestClass(final Point point) {
            this.constructorArg = point;

            assertNotNull("constructorArg is null.", constructorArg);
            assertNotNull("instanceVariable is null.", instanceVariable);
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();

            sb.append("constructorArg=");
            sb.append(constructorArg.toString());
            sb.append(", ");
            sb.append("instanceVariable=");
            sb.append(instanceVariable.toString());
            sb.append(", ");
            sb.append("activeEvent=");
            sb.append(activeEvent.toString());

            return sb.toString();
        }

        public ActiveEvent getActiveEvent() {
            return activeEvent;
        }

        public Point getConstructorArg() {
            return constructorArg;
        }

        public Point getInstanceVariable() {
            return instanceVariable;
        }
    }

    /**
     * This class deliberately throws exception on instantiation, so we need to
     * mock it in tests of the subclass.
     */
    public static class ParentTestClass {
        public ParentTestClass() {
            throw new IllegalStateException("Need to mock this constructor!!");
        }
    }
}
