package com.directi.training.designpatterns.templatemethod;

public class Screen
{
    private String _msg = "";

    public void show(String msg)
    {
        _msg += msg;
        _msg += "\n";
    }

    public String getScreenMsg()
    {
        return _msg;
    }
}
