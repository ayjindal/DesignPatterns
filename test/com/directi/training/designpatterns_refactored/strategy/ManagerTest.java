package com.directi.training.designpatterns_refactored.strategy;

import com.directi.training.designpatterns_refactored.strategy.Validation.ValidationFailedException;

import org.junit.Before;
import org.junit.Test;

public class ManagerTest
{
    CompanyMember _manager;

    @Before
    public void initialize()
    {
        _manager = new CompanyMember(new AtLeast(400), new AtLeast(70));
    }

    @Test
    public void testShortNamesAreAllowed() throws Exception
    {
        _manager.setName("Max Payne");
    }

    @Test(expected = ValidationFailedException.class)
    public void testNamesAbove50CharsAreNotAllowed() throws Exception
    {
        _manager.setName("pneumonoultramicroscopicsilicovolcanokoniosis smith");
    }

    @Test(expected = ValidationFailedException.class)
    public void testSalaryOf200IsInvalid() throws Exception
    {
        _manager.setSalary(200);
    }

    @Test
    public void testSalaryOf1001IsValid() throws Exception
    {
        _manager.setSalary(1001);
    }

    @Test(expected = ValidationFailedException.class)
    public void testMonthsSpentCanNotBe65() throws Exception
    {
        _manager.setMonthsSpent(65);
    }
}
