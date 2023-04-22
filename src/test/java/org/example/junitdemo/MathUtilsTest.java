package org.example.junitdemo;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MathUtilsTest {

    MathUtils mathUtils;

    @BeforeAll
    void init() {
        mathUtils = new MathUtils();
    }

    @Test
    @DisplayName("Testing Add method")
    public void testAdd() {
        int expected = 2;
        int actual = mathUtils.add(1, 1);
        assertEquals(expected, actual, "The add method didnot work as expected");
    }

    @Test
    @DisplayName("Testing Divide method")
    public void testDivide() {
        assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0), "Divide by zero error");
    }

    @Test
    @DisplayName("Testing Radius calculation method")
    public void testCalculateRadius() {
        double expected = Math.PI;
        double actual = mathUtils.calculateRadius(1);
        assertEquals(expected, actual, "Should return the correct radius");
    }

    @Test
    @Disabled
    public void testFailureMethod() {
        fail("Deliberately failing the test");
    }

    @Test
    @DisplayName("To check AssertAll functionality")
    public void testMultiply() {
        assertAll(
            () -> assertEquals(4, mathUtils.multiply(2, 2)),
            () -> assertEquals(1, mathUtils.multiply(1, 1)),
            () -> assertEquals(0, mathUtils.multiply(1, 0))
        );
    }
}