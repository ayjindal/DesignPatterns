package com.directi.training.designpatterns_refactored.strategy;

import com.directi.training.designpatterns_refactored.strategy.Validation.ValidationFailedException;

public class Client
{
    public void manageCompanyMembers() throws ValidationFailedException
    {
        CompanyMember employee = new CompanyMember(
            new Validations(new AtMost(1000), new AtLeast(1)), new AtLeast(0));
        employee.setName("Raj");
        employee.setMonthsSpent(10);
        employee.setManagerName("Bob");
        employee.setSalary(100);

        CompanyMember manager = new CompanyMember(new AtLeast(400), new AtLeast(70));
        manager.setName("Bob");
        manager.setManagerName("Alice");
        manager.setMonthsSpent(75);
        manager.setSalary(1050);

        CompanyMember seniorEmployee = new CompanyMember(
            new Validations(new AtLeast(200), new AtMost(1000)), new AtLeast(60));
        seniorEmployee.setName("Niteesh");
        seniorEmployee.setManagerName("Bob");
        seniorEmployee.setMonthsSpent(65);
        seniorEmployee.setSalary(750);
    }
}
