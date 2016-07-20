package com.directi.training.designpatterns_refactored.adapter;

public class SalaryDisburser
{
    private static final int SALARY = 15000;
    private LeaveRecord _leaveRecord;

    public SalaryDisburser(LeaveRecord leaveRecord)
    {
        _leaveRecord = leaveRecord;
    }

    public int getSalary(String employeeName)
    {
        return SALARY - _leaveRecord.getEmployeeAbsences(employeeName) * 1000;
    }
}
