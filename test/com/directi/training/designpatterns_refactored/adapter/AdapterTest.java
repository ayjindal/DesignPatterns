package com.directi.training.designpatterns_refactored.adapter;

import com.directi.training.designpatterns_refactored.adapter.thirdparty.ThirdPartyLeaveRecord;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AdapterTest
{
    @Test
    public void testGetDisplayWallOfShame_Clazz()
    {
        FrontDoorRegister frontDoorRegister = new FrontDoorRegister(
            new com.directi.training.designpatterns_refactored.adapter.clazz.LeaveRecordAdapter());
        assertEquals("Super Commando Dhruv has been the most absent employee, shame!",
            frontDoorRegister.getDisplayWallOfShame());
    }

    @Test
    public void testSalaryDisbursement_Clazz()
    {
        SalaryDisburser salaryDisburser = new SalaryDisburser(
            new com.directi.training.designpatterns_refactored.adapter.clazz.LeaveRecordAdapter());
        assertEquals(10000, salaryDisburser.getSalary("James Bond"));
        assertEquals(8000, salaryDisburser.getSalary("Austin Powers"));
        assertEquals(5000, salaryDisburser.getSalary("Super Commando Dhruv"));
    }

    @Test
    public void testGetDisplayWallOfShame_Object()
    {
        FrontDoorRegister frontDoorRegister = new FrontDoorRegister(
            new com.directi.training.designpatterns_refactored.adapter.object.LeaveRecordAdapter(
                new ThirdPartyLeaveRecord()));
        assertEquals("Super Commando Dhruv has been the most absent employee, shame!",
            frontDoorRegister.getDisplayWallOfShame());
    }

    @Test
    public void testSalaryDisbursement_Object()
    {
        SalaryDisburser salaryDisburser = new SalaryDisburser(
            new com.directi.training.designpatterns_refactored.adapter.object.LeaveRecordAdapter(
                new ThirdPartyLeaveRecord()));
        assertEquals(10000, salaryDisburser.getSalary("James Bond"));
        assertEquals(8000, salaryDisburser.getSalary("Austin Powers"));
        assertEquals(5000, salaryDisburser.getSalary("Super Commando Dhruv"));
    }
}
