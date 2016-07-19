package com.directi.training.designpatterns_refactored.state;

import java.util.ArrayList;
import java.util.List;

public abstract class State
{
    protected StringBuilder _display;
    protected State _next;
    private List<Character> _operators = new ArrayList<Character>()
    {
        {
            add('+');
            add('-');
            add('*');
            add('/');
        }
    };

    public State(String display)
    {
        _display = new StringBuilder(display);
    }

    public String display()
    {
        return _display.toString();
    }

    public State next()
    {
        return _next;
    }

    public boolean shouldTransition()
    {
        return _next != null;
    }

    public void input(Character c)
    {
        if (isDigit(c)) {
            inputDigit(c);
        }
        if (c.equals('c')) {
            inputClear();
        }
        if (_operators.contains(c)) {
            inputOperator(c);
        }
        if (c.equals('=')) {
            inputEqualsOperator(c);
        }
    }

    private static boolean isDigit(Character c)
    {
        return c >= 48 && c <= 57;
    }

    private void inputClear()
    {
        _next = new ClearState();
    }

    protected void inputEqualsOperator(Character c)
    {
    }

    protected void inputOperator(Character c)
    {
    }

    protected void inputDigit(Character c)
    {
    }

}
