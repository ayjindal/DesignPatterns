package com.directi.training.designpatterns.adapter;

public class SalaryDisburser
{
    private static final int SALARY = 15000;
    private LeaveRecord _leaveRecord;

    public SalaryDisburser(LeaveRecord leaveRecord)
    {
        _leaveRecord = leaveRecord;
    }

    public int salary(String employeeName)
    {
        return SALARY - _leaveRecord.getEmployeeAbsences(employeeName) * 1000;
    }

}
