package com.directi.training.designpatterns_refactored.abstractfactory;

public class AndroidFactory extends PhoneFactory
{
    @Override
    public MotherBoard createMotherBoard()
    {
        return new AndroidMotherBoard();
    }

    @Override
    public Processor createProcessor()
    {
        return new AndroidProcessor();
    }

    @Override
    public Case createCase()
    {
        return new AndroidCase();
    }

    @Override
    public Screen createScreen()
    {
        return new AndroidScreen();
    }
}
