package com.directi.training.designpatterns_refactored.state;

public class ClearState extends State
{

    public ClearState()
    {
        super("");
    }

    @Override
    protected void inputOperator(Character c)
    {
        _next = new ErrorState();
    }

    @Override
    protected void inputDigit(Character c)
    {
        _next = new NumberInputState(c);
    }

}
