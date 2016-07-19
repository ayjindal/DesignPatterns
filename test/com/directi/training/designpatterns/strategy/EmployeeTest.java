package com.directi.training.designpatterns.strategy;

import org.junit.Test;

public class EmployeeTest
{
    @Test
    public void testShortNamesAreAllowed() throws Exception
    {
        new Employee().setName("Max Payne");
    }

    @Test(expected = ValidationFailedException.class)
    public void testNamesAbove50CharsAreNotAllowed() throws Exception
    {
        new Employee().setName("pneumonoultramicroscopicsilicovolcanokoniosis smith");
    }

    @Test(expected = ValidationFailedException.class)
    public void testSalaryOf0IsInvalid() throws Exception
    {
        new Employee().setSalary(0);
    }

    @Test
    public void testSalaryOf100IsValid() throws Exception
    {
        new Employee().setSalary(100);
    }

    @Test(expected = ValidationFailedException.class)
    public void testSalaryOf1001IsInvalid() throws Exception
    {
        new Employee().setSalary(1001);
    }

    @Test(expected = ValidationFailedException.class)
    public void testMonthsSpentIsNotNegative() throws Exception
    {
        new Employee().setMonthsSpent(-1);
    }

    @Test
    public void testMonthsSpentCanBe1() throws Exception
    {
        new Employee().setMonthsSpent(1);
    }

    @Test(expected = ValidationFailedException.class)
    public void testManagerNameIsNotEmpty() throws Exception
    {
        new Employee().setManagerName("");
    }
}
