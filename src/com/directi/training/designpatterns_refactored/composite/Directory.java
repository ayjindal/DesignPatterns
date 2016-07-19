package com.directi.training.designpatterns_refactored.composite;

import java.util.List;

public class Directory implements DirectoryEntry
{
    private final String _name;
    private final List<DirectoryEntry> _fileObjects;
    private Directory _parent;

    public Directory(String name, List<DirectoryEntry> fileObjects)
    {
        _name = name;
        _fileObjects = fileObjects;

        for (DirectoryEntry fileObject : fileObjects) {
            fileObject.setParent(this);
        }
    }

    @Override
    public String getName()
    {
        return _name;
    }

    @Override
    public int getSize()
    {
        int sum = 0;

        for (DirectoryEntry fileObject : _fileObjects) {
            sum += fileObject.getSize();
        }

        return sum;
    }

    @Override
    public void setParent(Directory directory)
    {
        _parent = directory;
    }

    @Override
    public void delete()
    {
        while (_fileObjects.size() > 0) {
            _fileObjects.get(0).delete();
        }
        _parent.removeEntry(this);
    }

    public void removeEntry(DirectoryEntry fileObject)
    {
        _fileObjects.remove(fileObject);
    }

    @Override
    public boolean entryExists(String name, Class objectType)
    {
        if (_name.equals(name) && getClass() == objectType) {
            return true;
        }

        for (DirectoryEntry fileObject : _fileObjects) {
            if (fileObject.entryExists(name, objectType)) {
                return true;
            }
        }

        return false;
    }

}