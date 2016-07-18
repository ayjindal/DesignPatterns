package com.directi.training.designpatterns_refactored.builder;

public class JsonBuilder extends AbstractBuilder
{
    private String _representation = "";

    @Override
    public void addHeader()
    {

    }

    @Override
    public void startPeople(int count)
    {
        _representation += "people:[";
    }

    @Override
    public void startPerson()
    {
        _representation += "{";
    }

    @Override
    public void addId(String id)
    {
        _representation += "\"id\":" + id + ",";
    }

    @Override
    public void addName(String name)
    {
        _representation += "\"name\":\"" + name + "\",";
    }

    @Override
    public void addAddress(String city, String country)
    {
        _representation += "\"address\":{" + "\"city\":\"" + city + "\",\"country\":\"" +
                           country + "\"},";
    }

    @Override
    public void endPerson()
    {
        _representation = _representation.substring(0, _representation.length() - 1);
        _representation += "},";
    }

    @Override
    public void endPeople()
    {
        _representation = _representation.substring(0, _representation.length() - 1);
        _representation += "]";
    }

    public String getRepresentation()
    {
        return _representation;
    }
}
