package com.directi.training.designpatterns_refactored.strategy;

import com.directi.training.designpatterns_refactored.strategy.Validation.ValidationFailedException;

import org.junit.Before;
import org.junit.Test;

public class EmployeeTest
{
    CompanyMember _employee;

    @Before
    public void initialize()
    {
        _employee = new CompanyMember(new Validations(new AtMost(1000), new AtLeast(1)),
                new AtLeast(0));
    }

    @Test
    public void testShortNamesAreAllowed() throws Exception
    {
        _employee.setName("Max Payne");
    }

    @Test(expected = ValidationFailedException.class)
    public void testNamesAbove50CharsAreNotAllowed() throws Exception
    {
        _employee.setName("pneumonoultramicroscopicsilicovolcanokoniosis smith");
    }

    @Test(expected = ValidationFailedException.class)
    public void testSalaryOf0IsInvalid() throws Exception
    {
        _employee.setSalary(0);
    }

    @Test
    public void testSalaryOf100IsValid() throws Exception
    {
        _employee.setSalary(100);
    }

    @Test(expected = ValidationFailedException.class)
    public void testSalaryOf1001IsInvalid() throws Exception
    {
        _employee.setSalary(1001);
    }

    @Test(expected = ValidationFailedException.class)
    public void testMonthsSpentIsNotNegative() throws Exception
    {
        _employee.setMonthsSpent(-1);
    }

    @Test
    public void testMonthsSpentCanBe1() throws Exception
    {
        _employee.setMonthsSpent(1);
    }

    @Test(expected = ValidationFailedException.class)
    public void testManagerNameIsNotEmpty() throws Exception
    {
        _employee.setManagerName("");
    }
}
