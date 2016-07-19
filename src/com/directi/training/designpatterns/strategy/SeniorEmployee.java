package com.directi.training.designpatterns.strategy;

public class SeniorEmployee extends Employee
{
    @Override
    public void setSalary(int salary) throws ValidationFailedException
    {
        atLeast(salary, 200);
        super.setSalary(salary);
    }

    @Override
    public void setMonthsSpent(int months) throws ValidationFailedException
    {
        atLeast(months, 60);
        super.setMonthsSpent(months);
    }
}
