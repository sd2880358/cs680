package edu.umb.cs680.hw10.apfs;

import java.io.File;
import java.util.LinkedList;

public class FileSearchVisitor implements ApfsVisitor{

    private String fileName;
    private LinkedList<ApfsFile> foundFile = new LinkedList<ApfsFile>();
    public FileSearchVisitor(String fileName){
        this.fileName = fileName;
    }
    @Override
    public void visit(ApfsLink link) {
        return;
    }

    @Override
    public void visit(ApfsFile file) {
        if (file.getName().equals(fileName)){
            foundFile.add(file);
        }
    }

    @Override
    public void visit(ApfsDirectory directory) {
        return;
    }

    public LinkedList<ApfsFile> getFoundFile() {
        return foundFile;
    }
}
