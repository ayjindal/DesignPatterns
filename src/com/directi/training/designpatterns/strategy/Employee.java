package com.directi.training.designpatterns.strategy;

public class Employee extends CompanyMember
{
    @Override
    public void setSalary(int salary) throws ValidationFailedException
    {
        atMost(salary, 1000);
        super.setSalary(salary);
    }
}
