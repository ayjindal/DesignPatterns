package com.directi.training.designpatterns_refactored.abstractfactory;

public class MotherBoard
{
    private Battery _battery;
    private String _state;
    private Processor _processor;

    public void attachBattery(Battery battery)
    {
        _battery = battery;
    }

    public void attachProcessor(Processor processor)
    {
        if (_battery == null) {
            throw new RuntimeException("Can't attach processor without attaching battery");
        }
        _processor = processor;
        _state = "running";
    }

    public String getState()
    {
        return _state;
    }

    public Processor getProcessor()
    {
        return _processor;
    }

    public Battery getBattery()
    {
        return _battery;
    }
}
