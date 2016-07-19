package com.directi.training.designpatterns_refactored.state;

public class EqualToState extends State
{
    public EqualToState(Integer value)
    {
        super(value.toString());
    }
}
