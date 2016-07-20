package com.directi.training.designpatterns_refactored.adapter;

public interface LeaveRecord
{
    String getMostAbsentEmployeeName();

    int getEmployeeAbsences(String employeeName);
}
