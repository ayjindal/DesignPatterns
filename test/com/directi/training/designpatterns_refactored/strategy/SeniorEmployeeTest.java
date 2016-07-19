package com.directi.training.designpatterns_refactored.strategy;

import com.directi.training.designpatterns_refactored.strategy.Validation.ValidationFailedException;

import org.junit.Before;
import org.junit.Test;

public class SeniorEmployeeTest
{
    CompanyMember _seniorEmployee;

    @Before
    public void initialize()
    {
        _seniorEmployee = new CompanyMember(new Validations(new AtLeast(200), new AtMost(1000)),
                new AtLeast(60));
    }

    @Test
    public void testShortNamesAreAllowed() throws Exception
    {
        _seniorEmployee.setName("Max Payne");
    }

    @Test(expected = ValidationFailedException.class)
    public void testNamesAbove50CharsAreNotAllowed() throws Exception
    {
        _seniorEmployee.setName("pneumonoultramicroscopicsilicovolcanokoniosis smith");
    }

    @Test(expected = ValidationFailedException.class)
    public void testSalaryOf100IsInValid() throws Exception
    {
        _seniorEmployee.setSalary(100);
    }

    @Test(expected = ValidationFailedException.class)
    public void testSalaryOf1001IsInvalid() throws Exception
    {
        _seniorEmployee.setSalary(1001);
    }

    @Test(expected = ValidationFailedException.class)
    public void testMonthsSpentIsNotNegative() throws Exception
    {
        _seniorEmployee.setMonthsSpent(-1);
    }

    @Test(expected = ValidationFailedException.class)
    public void testMonthsSpentCanNotBeLessThan60() throws Exception
    {
        _seniorEmployee.setMonthsSpent(59);
    }

    @Test(expected = ValidationFailedException.class)
    public void testManagerNameIsNotEmpty() throws Exception
    {
        _seniorEmployee.setManagerName("");
    }
}
