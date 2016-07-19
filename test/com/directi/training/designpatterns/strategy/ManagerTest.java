package com.directi.training.designpatterns.strategy;

import org.junit.Test;

public class ManagerTest
{
    @Test
    public void testShortNamesAreAllowed() throws Exception
    {
        new Manager().setName("Max Payne");
    }

    @Test(expected = ValidationFailedException.class)
    public void testNamesAbove50CharsAreNotAllowed() throws Exception
    {
        new Manager().setName("pneumonoultramicroscopicsilicovolcanokoniosis smith");
    }

    @Test(expected = ValidationFailedException.class)
    public void testSalaryOf200IsInvalid() throws Exception
    {
        new Manager().setSalary(200);
    }

    @Test
    public void testSalaryOf1001IsValid() throws Exception
    {
        new Manager().setSalary(1001);
    }

    @Test(expected = ValidationFailedException.class)
    public void testMonthsSpentCanNotBe65() throws Exception
    {
        new Manager().setMonthsSpent(65);
    }
}
