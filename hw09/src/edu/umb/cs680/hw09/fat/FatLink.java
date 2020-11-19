package edu.umb.cs680.hw09.fat;

import java.time.LocalDateTime;


public class FatLink extends FatElement {
    private FatElement target;
    public FatLink(FatDirectory parent, String name, int size, LocalDateTime creationTime,
                   String ownerName, LocalDateTime lastModified, FatElement target){
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

    public void setTarget(FatElement target){
        this.target = target;
    }

    public FatElement getTarget(){
        return this.target;
    }

}
