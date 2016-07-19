package com.directi.training.designpatterns.strategy;

public class Manager extends CompanyMember
{
    @Override
    public void setSalary(int salary) throws ValidationFailedException
    {
        atLeast(salary, 400);
        super.setSalary(salary);
    }

    @Override
    public void setMonthsSpent(int months) throws ValidationFailedException
    {
        atLeast(months, 70);
        super.setMonthsSpent(months);
    }
}
