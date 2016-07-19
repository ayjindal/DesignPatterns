package com.directi.training.designpatterns.strategy;

public abstract class CompanyMember
{
    protected String _mgrName;
    protected int _salary;
    protected int _monthsSpent;
    private String _name;

    protected void validateLength(String val, int allowedLength) throws ValidationFailedException
    {
        if (val.length() > allowedLength) {
            throw new ValidationFailedException("Invalid length:" + allowedLength);
        }
    }

    protected void notEmpty(String val) throws ValidationFailedException
    {
        if (val == null || val.length() == 0) {
            throw new ValidationFailedException("not empty check failed for value:" + val);
        }
    }

    protected void atLeast(int val, int min) throws ValidationFailedException
    {
        if (val < min) {
            throw new ValidationFailedException("at least check failed:" + val);
        }
    }

    protected void atMost(int val, int max) throws ValidationFailedException
    {
        if (val > max) {
            throw new ValidationFailedException("at least check failed:" + val);
        }
    }

    public void setName(String name) throws ValidationFailedException
    {
        validateLength(name, 50);
        notEmpty(name);
        _name = name;
    }

    public void setSalary(int salary) throws ValidationFailedException
    {
        atLeast(salary, 1);
        _salary = salary;
    }

    public void setManagerName(String name) throws ValidationFailedException
    {
        notEmpty(name);
        validateLength(name, 50);
        _mgrName = name;
    }

    public void setMonthsSpent(int months) throws ValidationFailedException
    {
        atLeast(months, 0);
        _monthsSpent = months;
    }
}
