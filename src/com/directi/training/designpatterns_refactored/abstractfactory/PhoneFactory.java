package com.directi.training.designpatterns_refactored.abstractfactory;

public abstract class PhoneFactory
{
    public abstract MotherBoard createMotherBoard();

    public abstract Processor createProcessor();

    public abstract Case createCase();

    public abstract Screen createScreen();
}
