package com.directi.training.designpatterns_refactored.builder;

import java.util.List;

public class PeopleRepresentation
{
    private final AbstractBuilder _builder;

    public PeopleRepresentation(AbstractBuilder builder)
    {
        _builder = builder;
    }

    public void constructRepresentation(List<Person> people)
    {
        _builder.addHeader();
        _builder.startPeople(people.size());
        for (Person person : people) {
            _builder.startPerson();
            _builder.addId(person.getId() + "");
            _builder.addName(person.getName());
            _builder.addAddress(person.getCity(), person.getCountry());
            _builder.endPerson();
        }
        _builder.endPeople();
    }
}
