package com.directi.training.designpatterns_refactored.abstractfactory;

public class IphoneFactory extends PhoneFactory
{
    @Override
    public MotherBoard createMotherBoard()
    {
        return new IphoneMotherBoard();
    }

    @Override
    public Processor createProcessor()
    {
        return new IphoneProcessor();
    }

    @Override
    public Case createCase()
    {
        return new IphoneCase();
    }

    @Override
    public Screen createScreen()
    {
        return new IphoneScreen();
    }
}
