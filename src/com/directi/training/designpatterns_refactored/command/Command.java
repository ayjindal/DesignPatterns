package com.directi.training.designpatterns_refactored.command;

public interface Command
{
    void rollback();

    void execute();
}
