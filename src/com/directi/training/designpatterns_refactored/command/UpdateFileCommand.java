package com.directi.training.designpatterns_refactored.command;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class UpdateFileCommand implements Command
{
    private final String _fileName;
    private final String _newContent;
    private String _oldContent = "";

    public UpdateFileCommand(String fileName, String newContent)
    {
        _fileName = fileName;
        _newContent = newContent;
    }

    @Override
    public void execute()
    {
        File file = new File(_fileName);
        if (!file.exists()) {
            throw new RuntimeException("File: " + _fileName + " does not exist");
        }
        try {

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String aLine;
            while ((aLine = reader.readLine()) != null) {
                _oldContent += aLine;
            }
            reader.close();
            PrintWriter writer = new PrintWriter(file);
            writer.write(_newContent);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void rollback()
    {
        File file = new File(_fileName);
        PrintWriter writer;
        try {
            writer = new PrintWriter(file);
            writer.write(_oldContent);
            writer.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
