package com.directi.training.designpatterns_refactored.composite;

public interface DirectoryEntry
{
    int getSize();

    void delete();

    void setParent(Directory directory);

    String getName();

    boolean entryExists(String name, Class objectType);
}
