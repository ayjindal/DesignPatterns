package com.directi.training.designpatterns.state;

import java.util.ArrayList;
import java.util.List;

public class Calculator
{
    private StringBuilder _display;
    private Character _lastChar;

    private List<Character> _operators = new ArrayList<Character>()
    {
        {
            add('+');
            add('-');
            add('*');
            add('/');
        }
    };
    private Integer _currentValue;
    private Character _currentOperator;

    public Calculator()
    {
        _lastChar = null;
        _display = new StringBuilder();
    }

    public String getDisplay()
    {
        return _display.toString();
    }

    public boolean isDigit(Character c)
    {
        return c >= 48 && c <= 57;
    }

    public boolean isOperator(Character c)
    {
        return _operators.contains(c);
    }

    public boolean isClear(Character c)
    {
        return c != null && c.equals('c');
    }

    public boolean isError()
    {
        return "Error".equals(_display.toString());
    }

    public boolean isEqualsOperator(Character c)
    {
        return c != null && c.equals('=');
    }

    public void input(Character c)
    {
        if (isClear(c)) {
            _lastChar = null;
            clearState();
            return;
        }

        if (isError()) {
            return;
        }

        if (isEqualsOperator(_lastChar)) {
            return;
        }

        if (isDigit(c)) {
            if (isOperator(_lastChar)) {
                _display = new StringBuilder();
            }
            _lastChar = c;
            _display.append(c);
            return;
        }
        if (isOperator(c)) {
            if ((_lastChar == null) || isOperator(_lastChar)) {
                _display = new StringBuilder("Error");
                return;
            }

            if (isDigit(_lastChar)) {
                updateCurrentValue(Integer.parseInt(_display.toString()));
                updateCurrentOperator(c);
                _lastChar = c;
            }
        }
        if (isEqualsOperator(c)) {
            if (_lastChar == null) {
                return;
            }

            if (isOperator(_lastChar)) {
                _display = new StringBuilder("Error");
                return;
            }
            if (isDigit(_lastChar) && _currentValue != null) {
                updateCurrentValue(Integer.parseInt(_display.toString()));
            }
        }
    }

    public void updateCurrentValue(Integer val)
    {
        _currentValue = _currentValue != null ? operate(_currentValue, val) : val;
        _display = new StringBuilder(_currentValue.toString());
    }

    public void updateCurrentOperator(Character op)
    {
        _currentOperator = op;
    }

    public void clearState()
    {
        _currentOperator = null;
        _currentValue = null;
        _display = new StringBuilder();
    }

    public Integer operate(Integer i1, Integer i2)
    {
        switch (_currentOperator) {
        case '+':
            return i1 + i2;
        case '-':
            return i1 - i2;
        case '*':
            return i1 * i2;
        case '/':
            return i1 / i2;
        }
        throw new RuntimeException("Invalid operator");
    }
}