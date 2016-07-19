package com.directi.training.designpatterns_refactored.templatemethod;

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