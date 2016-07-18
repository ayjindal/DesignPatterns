package com.directi.training.designpatterns_refactored.builder;

public abstract class AbstractBuilder
{
    public abstract void addHeader();

    public abstract void startPeople(int count);

    public abstract void startPerson();

    public abstract void addId(String id);

    public abstract void addName(String name);

    public abstract void addAddress(String city, String country);

    public abstract void endPerson();

    public abstract void endPeople();

}
