package com.directi.training.designpatterns.composite;

import java.util.List;

public class Directory
{
    private final String _name;
    private final List<File> _files;
    private final List<Directory> _directories;
    private Directory _parent;

    public Directory(String name, List<File> files, List<Directory> directories)
    {
        _name = name;
        _files = files;
        _directories = directories;

        for (Directory directory : directories) {
            directory.setParent(this);
        }

        for (File file : files) {
            file.setParent(this);
        }
    }

    public String getName()
    {
        return _name;
    }

    public int getSize(Directory directoryToSize)
    {
        int sum = 0;

        for (File file : directoryToSize.getFiles()) {
            sum += file.getSize();
        }

        for (Directory directory : directoryToSize.getDirectories()) {
            sum += getSize(directory);
        }

        return sum;
    }

    public int getSize()
    {
        return getSize(this);
    }

    public void delete(Directory directoryToDelete)
    {
        while (directoryToDelete.getFiles().size() > 0) {
            File file = directoryToDelete.getFiles().get(0);
            file.getParent().removeEntry(file);
        }

        while (directoryToDelete.getDirectories().size() > 0) {
            Directory directory = directoryToDelete.getDirectories().get(0);
            delete(directory);
        }

        directoryToDelete.getParent().removeEntry(directoryToDelete);
    }

    public void delete()
    {
        delete(this);
    }

    public void removeEntry(File file)
    {
        _files.remove(file);
    }

    public void removeEntry(Directory directory)
    {
        _directories.remove(directory);
    }

    public void add(Directory directory)
    {
        _directories.add(directory);
    }

    private boolean fileExists(String name, Directory directoryToSearch)
    {
        for (File file : directoryToSearch.getFiles()) {
            if (file.getName().equals(name)) {
                return true;
            }
        }

        for (Directory directory : directoryToSearch.getDirectories()) {
            if (fileExists(name, directory)) {
                return true;
            }
        }

        return false;
    }

    public boolean fileExists(String name)
    {
        return fileExists(name, this);
    }

    public boolean directoryExists(String name)
    {
        return directoryExists(name, this);
    }

    private boolean directoryExists(String name, Directory directoryToSearch)
    {
        if (directoryToSearch.getName().equals(name)) {
            return true;
        }

        for (Directory directory : directoryToSearch.getDirectories()) {
            if (directory.getName().equals(name)) {
                return true;
            }
        }

        for (Directory directory : _directories) {
            if (directory.fileExists(name)) {
                return true;
            }
        }

        return false;
    }

    public List<File> getFiles()
    {
        return _files;
    }

    public List<Directory> getDirectories()
    {
        return _directories;
    }

    public Directory getParent()
    {
        return _parent;
    }

    public void setParent(Directory directory)
    {
        _parent = directory;
    }
}
