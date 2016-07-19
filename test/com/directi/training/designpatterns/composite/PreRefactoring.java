package com.directi.training.designpatterns.composite;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.*;

public class PreRefactoring
{
    @Test
    public void testBasicStuffWorks()
    {
        List<File> files = new ArrayList();

        files.add(new File("file1", 10));
        files.add(new File("file2", 10));
        files.add(new File("File3", 10));

        List<Directory> directories = new ArrayList();
        Directory dataDir = new Directory("data", files, new ArrayList());
        directories.add(dataDir);

        Directory src = new Directory("src", new ArrayList(), directories);
        assertEquals("Size should be 30.", 30, src.getSize());

        assertTrue("File file1 should exist.", src.fileExists("file1"));
        assertTrue("Directory data should exist.", src.directoryExists("data"));
        assertTrue("Directory src should exist.", src.directoryExists("src"));

        dataDir.delete();

        assertFalse("File file1 should not exist.", src.fileExists("file1"));
        assertFalse("Directory data should not exist.", src.directoryExists("data"));
    }
}
