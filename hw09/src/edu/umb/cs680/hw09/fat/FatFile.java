package edu.umb.cs680.hw09.fat;

import java.time.LocalDateTime;

public class FatFile extends FatElement {

    public FatFile(FatDirectory parent, String name, int size, LocalDateTime creationTime,
                   String ownerName, LocalDateTime lastModified){
        super(parent, name, size, creationTime, ownerName, lastModified);
    }

    public boolean isDirectory(){
        return false;
    }


}

