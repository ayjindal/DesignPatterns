package com.directi.training.designpatterns_refactored.composite;

public class File implements DirectoryEntry
{
    private final String _name;
    private int _size;
    private Directory _parent;

    public File(String name, int size)
    {
        _name = name;
        _size = size;
    }

    @Override
    public void setParent(Directory parent)
    {
        _parent = parent;
    }

    @Override
    public String getName()
    {
        return _name;
    }

    @Override
    public int getSize()
    {
        return _size;
    }

    @Override
    public void delete()
    {
        _parent.removeEntry(this);
    }

    @Override
    public boolean entryExists(String name, Class objectType)
    {
        return name.equals(_name) && getClass() == objectType;
    }

}
