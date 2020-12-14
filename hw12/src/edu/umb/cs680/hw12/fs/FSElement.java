package edu.umb.cs680.hw12.fs;

import java.time.LocalDateTime;

public abstract class FSElement{
    private String name;
    private int size;
    private LocalDateTime creationTime;
    private FSElement parent;

    public FSElement(FSElement parent, String name, int size, LocalDateTime creationTime){
        this.parent = parent;
        this.name = name;
        this.size = size;
        this.creationTime = creationTime;
    }
    public FSElement getParent(){
        return this.parent;
    }
    public int getSize(){
        return this.size;
    }
    public String getName(){ return this.name; }
    public LocalDateTime getCreationTime(){return creationTime;}

    public abstract boolean isDirectory();
    public abstract boolean isFile();
}