package edu.umb.cs680.hw12.apfs;

import java.time.LocalDateTime;
import java.util.*;

public class ApfsDirectory extends ApfsElement{
    public ApfsDirectory(ApfsDirectory parent, String name, int size, LocalDateTime creationTime,
                         String owner_name,LocalDateTime last_modified){
        super(parent, name, size, creationTime, owner_name, last_modified);
    }

    @Override
    public boolean isDirectory() {
        return true;
    }
    public boolean isFile(){return false;}
    private LinkedList<ApfsElement> children = new LinkedList<ApfsElement>();
    public LinkedList<ApfsElement> getChildren(Comparator<ApfsElement> test){
        Collections.sort(children,test);
        return this.children;
    }
    public void appendChild(ApfsElement child){
        children.add(child);
    }

    public int countChildren(){
        return children.size();
    }
    public int getTotalSize(Comparator<ApfsElement> test){
        int totalSize = getSize();
        if (this.children.size() == 0){
            return totalSize;

        }
        else{
            Iterator<ApfsElement> fs = getChildren(test).iterator();
            while (fs.hasNext()){
                ApfsElement next = fs.next();
                if (next.isDirectory()){
                    totalSize += ((ApfsDirectory)next).getTotalSize(test);
                }
                else{
                    totalSize += next.getSize();
                }
            }
            return totalSize;
        }
    }
}
