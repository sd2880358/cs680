package edu.umb.cs680.hw10.apfs;

import java.util.LinkedList;

public class ApfsFileCrawlingVisitor implements ApfsVisitor{

    private LinkedList<ApfsFile> files = new LinkedList<ApfsFile>();

    @Override
    public void visit(ApfsFile file) {
        files.add(file);
    }

    @Override
    public void visit(ApfsLink link) {
        return;
    }

    public void visit(ApfsDirectory directory){
        return;
    }

    public LinkedList<ApfsFile> getFiles(){
        return files;
    }
}
