package com.directi.training.designpatterns_refactored.strategy;

public interface Validation
{
    void validate(Object val) throws ValidationFailedException;

    class ValidationFailedException extends Exception
    {
        public ValidationFailedException(String message)
        {
            super(message);
        }
    }
}
