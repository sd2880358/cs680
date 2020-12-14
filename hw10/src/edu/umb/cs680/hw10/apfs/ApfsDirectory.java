package edu.umb.cs680.hw10.apfs;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.LinkedList;

public class ApfsDirectory extends ApfsElement{
    public ApfsDirectory(ApfsDirectory parent, String name, int size, LocalDateTime creationTime,
                         String owner_name,LocalDateTime last_modified){
        super(parent, name, size, creationTime, owner_name, last_modified);
    }

    @Override
    public boolean isDirectory() {
        return true;
    }
    private LinkedList<ApfsElement> children = new LinkedList<ApfsElement>();
    public LinkedList<ApfsElement> getChildren(){
        return this.children;
    }
    public void appendChild(ApfsElement child){
        children.add(child);
    }

    public int countChildren(){
        return children.size();
    }

    @Override
    public void accept(ApfsVisitor aVisitor) {
        aVisitor.visit(this);
        for (ApfsElement e: children){
            e.accept(aVisitor);
        }
    }

    public int getTotalSize(){
        int totalSize = getSize();
        if (this.children.size() == 0){
            return totalSize;

        }
        else{
            Iterator<ApfsElement> fs = getChildren().iterator();
            while (fs.hasNext()){
                ApfsElement next = fs.next();
                if (next.isDirectory()){
                    totalSize += ((ApfsDirectory)next).getTotalSize();
                }
                else{
                    totalSize += next.getSize();
                }
            }
            return totalSize;
        }
    }
}
