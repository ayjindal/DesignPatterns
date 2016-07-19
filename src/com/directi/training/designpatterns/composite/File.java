package com.directi.training.designpatterns.composite;

public class File
{
    private final String _name;
    private int _size;
    private Directory _parent;

    public File(String name, int size)
    {
        _name = name;
        _size = size;
    }

    public void setParent(Directory parent)
    {
        _parent = parent;
    }

    public String getName()
    {
        return _name;
    }

    public int getSize()
    {
        return _size;
    }

    public Directory getParent()
    {
        return _parent;
    }
}
