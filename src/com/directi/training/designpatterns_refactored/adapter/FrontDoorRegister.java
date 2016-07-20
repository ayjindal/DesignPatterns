package com.directi.training.designpatterns_refactored.adapter;

public class FrontDoorRegister
{
    private LeaveRecord _leaveRecord;

    public FrontDoorRegister(LeaveRecord leaveRecord)
    {
        _leaveRecord = leaveRecord;
    }

    public String getDisplayWallOfShame()
    {
        String name;
        name = _leaveRecord.getMostAbsentEmployeeName();
        return name + " has been the most absent employee, shame!";
    }
}
