package com.directi.training.designpatterns_refactored.decorator;

public class Registrar
{
    public boolean evaluate(Application theApp, Criteria criteria)
    {
        return criteria.evaluate(theApp);
    }
}
