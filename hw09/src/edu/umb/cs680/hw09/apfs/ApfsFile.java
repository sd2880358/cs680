package edu.umb.cs680.hw09.apfs;

import java.time.LocalDateTime;

public class ApfsFile extends ApfsElement{

    public ApfsFile (ApfsDirectory parent, String name, int size, LocalDateTime creationTime,
                 String ownerName, LocalDateTime lastModified){
        super(parent, name, size, creationTime, ownerName, lastModified);
    }

    public boolean isDirectory(){
        return false;
    }


}

