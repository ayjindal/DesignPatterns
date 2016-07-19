package com.directi.training.designpatterns_refactored.state;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest
{

    @Test
    public void testCalculator()
    {
        assertDisplay("1", "1");
        assertDisplay("1,2,3", "123");
        assertDisplay("+", "Error");
        assertDisplay("+,2,3,4", "Error");
        assertDisplay("1,2,+,4,5", "45");
        assertDisplay("1,2,+,4,5,=", "57");
        assertDisplay("1,2,-,4,5,=", "-33");
        assertDisplay("1,2,+,4,-", "16");
        assertDisplay("1,2,+,4,-,9,=", "7");
        assertDisplay("1,2,+,-", "Error");
        assertDisplay("1,2,*,=", "Error");
        assertDisplay("1,2,*,=,c", "");
        assertDisplay("1,2,*,=,c,3,/,2,*,4,+,9,=", "13");
        assertDisplay("=", "");
        assertDisplay("1,=", "1");
        assertDisplay("1,=,2,+,5,=", "17");
    }

    private void assertDisplay(final String input, final String output)
    {
        Calculator calculator = new Calculator();
        for (String in : input.split(",")) {
            calculator.input(in.charAt(0));
        }
        assertEquals(output, calculator.getDisplay());
    }

}
