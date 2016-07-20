package com.directi.training.designpatterns.adapter.thirdparty;

import java.util.HashMap;
import java.util.Map;

public class ThirdPartyLeaveRecord
{
    private Map<Employee, Integer> _employees = new HashMap<Employee, Integer>()
    {
        {
            put(new Employee("Bond, James"), 5);
            put(new Employee("Powers, Austin"), 7);
            put(new Employee("Dhruv, Super Commando"), 10);
        }
    };

    public int getEmployeeAbsences(final Employee employee)
    {
        return _employees.get(employee);
    }

    public Employee getMostAbsentEmployee()
    {
        Employee mostAbsentEmployee = null;
        Integer maxLeaves = Integer.MIN_VALUE;
        for (Employee employee : _employees.keySet()) {
            Integer leavesTaken = _employees.get(employee);
            if (leavesTaken > maxLeaves) {
                maxLeaves = leavesTaken;
                mostAbsentEmployee = employee;
            }
        }
        return mostAbsentEmployee;
    }
}
