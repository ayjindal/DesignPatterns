package com.directi.training.designpatterns.adapter;

public interface LeaveRecord
{
    String getMostAbsentEmployeeName();

    int getEmployeeAbsences(String employeeName);
}
