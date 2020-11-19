package edu.umb.cs680.hw09.fat;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.LinkedList;

public class FatDirectory extends FatElement {
    public FatDirectory(FatDirectory parent, String name, int size, LocalDateTime creationTime,
                        String owner_name, LocalDateTime last_modified){
        super(parent, name, size, creationTime, owner_name, last_modified);
    }

    @Override
    public boolean isDirectory() {
        return true;
    }
    private LinkedList<FatElement> children = new LinkedList<FatElement>();
    public LinkedList<FatElement> getChildren(){
        return this.children;
    }
    public void appendChild(FatElement child){
        children.add(child);
    }

    public int countChildren(){
        return children.size();
    }


    public int getTotalSize(){
        int totalSize = getSize();
        if (this.children.size() == 0){
            return totalSize;

        }
        else{
            Iterator<FatElement> fs = getChildren().iterator();
            while (fs.hasNext()){
                FatElement next = fs.next();
                if (next.isDirectory()){
                    totalSize += ((FatDirectory)next).getTotalSize();
                }
                else{
                    totalSize += next.getSize();
                }
            }
            return totalSize;
        }
    }
}
