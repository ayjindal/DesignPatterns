package com.directi.training.designpatterns_refactored.state;

public class Calculator
{
    private State _state;

    public Calculator()
    {
        _state = new ClearState();
    }

    public String getDisplay()
    {
        return _state.display();
    }

    public void input(Character c)
    {
        _state.input(c);
        if (_state.shouldTransition()) {
            _state = _state.next();
        }
    }
}
