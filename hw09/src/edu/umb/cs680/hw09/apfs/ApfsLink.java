package edu.umb.cs680.hw09.apfs;

import java.time.LocalDateTime;


public class ApfsLink extends ApfsElement{
    private ApfsElement target;
    public ApfsLink(ApfsDirectory parent, String name, int size, LocalDateTime creationTime,
                    String ownerName, LocalDateTime lastModified, ApfsElement target){
        super(parent, name, size, creationTime, ownerName, lastModified);
        this.target = target;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public boolean isDirectory() {
        return false;
    }

    public void setTarget(ApfsElement target){
        this.target = target;
    }

    public ApfsElement getTarget(){
        return this.target;
    }

}
