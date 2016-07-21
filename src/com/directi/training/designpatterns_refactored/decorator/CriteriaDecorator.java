package com.directi.training.designpatterns_refactored.decorator;

public abstract class CriteriaDecorator implements Criteria
{
    private Criteria _previousCriteria;

    protected CriteriaDecorator(Criteria previousCriteria)
    {
        _previousCriteria = previousCriteria;
    }

    @Override
    public boolean evaluate(Application theApp)
    {
        return _previousCriteria.evaluate(theApp) && performEvaluate(theApp);
    }

    protected abstract boolean performEvaluate(Application theApp);
}
