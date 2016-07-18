package com.directi.training.designpatterns_refactored.builder;

public class Person
{
    private String _name;
    private int _id;
    private String _city;
    private String _country;

    public Person(String name, int id, String city, String country)
    {
        _name = name;
        _id = id;
        _city = city;
        _country = country;
    }

    public String getName()
    {
        return _name;
    }

    public int getId()
    {
        return _id;
    }

    public String getCity()
    {
        return _city;
    }

    public String getCountry()
    {
        return _country;
    }
}
