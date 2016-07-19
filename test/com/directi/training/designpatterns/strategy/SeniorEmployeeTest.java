package com.directi.training.designpatterns.strategy;

import org.junit.Test;

public class SeniorEmployeeTest
{
    @Test
    public void testShortNamesAreAllowed() throws Exception
    {
        new SeniorEmployee().setName("Max Payne");
    }

    @Test(expected = ValidationFailedException.class)
    public void testNamesAbove50CharsAreNotAllowed() throws Exception
    {
        new SeniorEmployee().setName("pneumonoultramicroscopicsilicovolcanokoniosis smith");
    }

    @Test(expected = ValidationFailedException.class)
    public void testSalaryOf100IsInValid() throws Exception
    {
        new SeniorEmployee().setSalary(100);
    }

    @Test(expected = ValidationFailedException.class)
    public void testSalaryOf1001IsInvalid() throws Exception
    {
        new SeniorEmployee().setSalary(1001);
    }

    @Test(expected = ValidationFailedException.class)
    public void testMonthsSpentIsNotNegative() throws Exception
    {
        new SeniorEmployee().setMonthsSpent(-1);
    }

    @Test(expected = ValidationFailedException.class)
    public void testMonthsSpentCanNotBeLessThan60() throws Exception
    {
        new SeniorEmployee().setMonthsSpent(59);
    }

    @Test(expected = ValidationFailedException.class)
    public void testManagerNameIsNotEmpty() throws Exception
    {
        new SeniorEmployee().setManagerName("");
    }
}
