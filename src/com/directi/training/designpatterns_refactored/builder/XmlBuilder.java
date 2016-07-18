package com.directi.training.designpatterns_refactored.builder;

public class XmlBuilder extends AbstractBuilder
{
    private String _representation = "";

    @Override
    public void addHeader()
    {
        _representation = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + _representation;
    }

    @Override
    public void startPeople(int count)
    {
        _representation += "<people number=" + count + ">";
    }

    @Override
    public void startPerson()
    {
        _representation += "<person>";
    }

    @Override
    public void addId(String id)
    {
        _representation += "<id>" + id + "</id>";
    }

    @Override
    public void addName(String name)
    {
        _representation += "<name>" + name + "</name>";
    }

    @Override
    public void addAddress(String city, String country)
    {
        _representation += "<address><city>" + city + "</city><country>" + country +
                           "</country></address>";
    }

    @Override
    public void endPerson()
    {
        _representation += "</person>";
    }

    @Override
    public void endPeople()
    {
        _representation += "</people>";
    }

    public String getRepresentation()
    {
        return _representation;
    }
}
