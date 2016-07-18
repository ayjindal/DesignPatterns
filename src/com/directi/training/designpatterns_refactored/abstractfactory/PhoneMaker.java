package com.directi.training.designpatterns_refactored.abstractfactory;

public class PhoneMaker
{
    public Case buildPhone(PhoneFactory factory)
    {
        Case phoneCase = factory.createCase();
        phoneCase.attachMotherBoard(setupMotherBoard(factory));
        phoneCase.attachScreen(factory.createScreen());
        return phoneCase;
    }

    private MotherBoard setupMotherBoard(PhoneFactory factory)
    {
        MotherBoard motherBoard = factory.createMotherBoard();
        motherBoard.attachBattery(new Battery());
        motherBoard.attachProcessor(factory.createProcessor());
        return motherBoard;
    }
}
