package com.directi.training.designpatterns.adapter.thirdparty;

public class Employee
{
    private String _name;

    public Employee(String name)
    {
        _name = name;
    }

    public String getName()
    {
        return _name;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Employee employee = (Employee) o;

        return !(_name != null ? !_name.equals(employee._name) : employee._name != null);
    }

    @Override
    public int hashCode()
    {
        return _name != null ? _name.hashCode() : 0;
    }
}
