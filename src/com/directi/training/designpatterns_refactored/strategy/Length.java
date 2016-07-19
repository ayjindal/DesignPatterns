package com.directi.training.designpatterns_refactored.strategy;

public class Length implements Validation
{
    private int _allowedLength;

    public Length(int allowedLength)
    {
        _allowedLength = allowedLength;
    }

    @Override
    public void validate(Object val) throws ValidationFailedException
    {
        if (((String) val).length() > _allowedLength) {
            throw new ValidationFailedException("Invalid length:" + _allowedLength);
        }
    }
}
