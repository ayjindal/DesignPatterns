package com.directi.training.designpatterns_refactored.state;

public class NumberInputState extends State
{

    public NumberInputState(Character c)
    {
        super(c.toString());
    }

    @Override
    protected void inputOperator(Character c)
    {
        _next = new OperatorEnteredState(Integer.parseInt(_display.toString()), c);
    }

    @Override
    protected void inputDigit(Character c)
    {
        _display.append(c);
    }
}
