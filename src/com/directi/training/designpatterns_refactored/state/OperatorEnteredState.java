package com.directi.training.designpatterns_refactored.state;

public class OperatorEnteredState extends State
{
    private Integer _currentValue;
    private Character _currentOperator;

    public OperatorEnteredState(Integer currentValue, Character currentOperator)
    {
        super(currentValue.toString());
        _currentValue = currentValue;
        _currentOperator = currentOperator;
    }

    @Override
    protected void inputEqualsOperator(Character c)
    {
        _next = new ErrorState();
    }

    @Override
    protected void inputOperator(Character c)
    {
        _next = new ErrorState();
    }

    @Override
    protected void inputDigit(Character c)
    {
        _next = new SubsequentNumberInputState(_currentValue, _currentOperator, c);
    }
}
