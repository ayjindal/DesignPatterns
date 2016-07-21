package com.directi.training.designpatterns_refactored.decorator;

public class GPAEval implements Criteria
{
    @Override
    public boolean evaluate(Application theApp)
    {
        System.out.println("GPAEval called");
        return theApp.getGpa() > 8;
    }
}
