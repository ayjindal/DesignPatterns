package com.directi.training.designpatterns_refactored.strategy;

public class Validations implements Validation
{
    private final Validation[] _validations;

    public Validations(Validation... validations)
    {
        _validations = validations;
    }

    @Override
    public void validate(Object val) throws ValidationFailedException
    {
        for (Validation validation : _validations) {
            validation.validate(val);
        }
    }
}
