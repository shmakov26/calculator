package ru.ac.uniyar.eshmakov;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import ru.ac.uniyar.eshmakov.entit.RPNCalculator;

public class TestMain {
    @Test
    void testAdd () {
        Fraction resalt = RPNCalculator.calculate("2 + 3");
        assertEquals("5", resalt.toString());
    }

    @Test
    void testMultiplay () {
        Fraction resalt = RPNCalculator.calculate("2 * 3");
        assertEquals("6", resalt.toString());
    }

    @Test
    void testSubtract () {
        Fraction resalt = RPNCalculator.calculate("2 - 3");
        assertEquals("-1", resalt.toString());
    }

    @Test
    void testDivide () {
        Fraction resalt = RPNCalculator.calculate("81 / 9");
        assertEquals("9", resalt.toString());
    }

    @Test
    void testPriority1 () {
        Fraction resalt = RPNCalculator.calculate("2 + 3 * 2");
        assertEquals("8", resalt.toString());
    }

    @Test
    void testPriority2 () {
        Fraction resalt = RPNCalculator.calculate("2 - 3 / 3");
        assertEquals("1", resalt.toString());
    }

    @Test
    void testPriority3 () {
        Fraction resalt = RPNCalculator.calculate("(2 + 3) * 2");
        assertEquals("10", resalt.toString());
    }

    @Test
    void testPriority4 () {
        Fraction resalt = RPNCalculator.calculate("((2 + 3) * 2) / 5");
        assertEquals("2", resalt.toString());
    }

    @Test
    void testExample1 () {
        Fraction resalt = RPNCalculator.calculate("((5 + 4) / 3) * ((-12 + 4) * -1)");
        assertEquals("24", resalt.toString());
    }

    @Test
    void testExample2 () {
        Fraction resalt = RPNCalculator.calculate("21 + (5 * 4 + (5 - 4) * 3 + (6 - 8))");
        assertEquals("42", resalt.toString());
    }
}
