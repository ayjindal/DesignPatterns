package com.directi.training.designpatterns_refactored.strategy;

import com.directi.training.designpatterns_refactored.strategy.Validation.ValidationFailedException;

public class CompanyMember
{
    protected int _monthsSpent;
    protected String _mgrName;
    protected int _salary;
    private String _name;
    private Validation _mgrNameValidation;
    private Validation _nameValidation;
    private Validation _salaryValidation;
    private Validation _monthsSpentValidation;

    public CompanyMember(Validation salaryValidation, Validation monthsSpentValidation)
    {
        _nameValidation = new Validations(new NotEmpty(), new Length(50));
        _mgrNameValidation = new Validations(new NotEmpty(), new Length(50));
        _salaryValidation = salaryValidation;
        _monthsSpentValidation = monthsSpentValidation;
    }

    public void setName(String name) throws ValidationFailedException
    {
        _nameValidation.validate(name);
        _name = name;
    }

    public void setManagerName(String mgrName) throws ValidationFailedException
    {
        _mgrNameValidation.validate(mgrName);
        _mgrName = mgrName;
    }

    public void setSalary(int salary) throws ValidationFailedException
    {
        _salaryValidation.validate(salary);
        _salary = salary;
    }

    public void setMonthsSpent(int monthsSpent) throws ValidationFailedException
    {
        _monthsSpentValidation.validate(monthsSpent);
        _monthsSpent = monthsSpent;
    }
}
