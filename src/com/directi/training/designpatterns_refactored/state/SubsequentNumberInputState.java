package com.directi.training.designpatterns_refactored.state;

public class SubsequentNumberInputState extends State
{
    private Integer _currentValue;
    private Character _currentOperator;

    public SubsequentNumberInputState(Integer currentValue, Character currentOperator, Character c)
    {
        super(c.toString());
        _currentValue = currentValue;
        _currentOperator = currentOperator;
    }

    @Override
    protected void inputEqualsOperator(Character c)
    {
        _next = new EqualToState(operate(Integer.parseInt(_display.toString())));
    }

    @Override
    protected void inputOperator(Character c)
    {
        _next = new OperatorEnteredState(operate(Integer.parseInt(_display.toString())), c);
    }

    @Override
    protected void inputDigit(Character c)
    {
        _display.append(c);
    }

    private Integer operate(Integer newValue)
    {
        switch (_currentOperator) {
        case '+':
            return _currentValue + newValue;
        case '-':
            return _currentValue - newValue;
        case '*':
            return _currentValue * newValue;
        case '/':
            return _currentValue / newValue;
        }
        throw new RuntimeException("Invalid operator");
    }
}
