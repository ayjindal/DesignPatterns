package com.directi.training.designpatterns_refactored.abstractfactory;

import java.util.Objects;

public class Case
{
    private MotherBoard _motherBoard;
    private Screen _screen;

    public void attachMotherBoard(MotherBoard motherBoard)
    {
        if (!Objects.equals(motherBoard.getState(), "running")) {
            throw new RuntimeException("Motherboard not functional");
        }
        _motherBoard = motherBoard;
    }

    public void attachScreen(Screen screen)
    {
        _screen = screen;
    }

    public Screen getScreen()
    {
        return _screen;
    }

    public MotherBoard getMotherBoard()
    {
        return _motherBoard;
    }

    public Processor getProcessor()
    {
        return _motherBoard.getProcessor();
    }

    public Battery getBattery()
    {
        return _motherBoard.getBattery();
    }
}
