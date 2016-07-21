package com.directi.training.designpatterns_refactored.decorator;

public class GREEval extends CriteriaDecorator
{
    protected GREEval(Criteria previousCriteria)
    {
        super(previousCriteria);
    }

    @Override
    protected boolean performEvaluate(Application theApp)
    {
        System.out.println("GREEval called");
        return theApp.getGre() >= 1500;
    }
}
