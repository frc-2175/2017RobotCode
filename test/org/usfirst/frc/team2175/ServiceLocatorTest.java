package org.usfirst.frc.team2175;

import static org.junit.Assert.assertSame;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ServiceLocatorTest {

    private static class Foo {
    }

    @Before
    @After
    public void clearServiceLocator() {
        ServiceLocator.clear();
    }

    @Test
    public void testCorrectInstance() {
        Foo foo = new Foo();
        ServiceLocator.register(foo);
        Foo locatedFoo = ServiceLocator.get(Foo.class);

        assertSame(foo, locatedFoo);
    }

    @Test(expected = IllegalStateException.class)
    public void testExceptionOnMiss() {
        ServiceLocator.get(Foo.class);
    }

}
