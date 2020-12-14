package edu.umb.cs680.hw10.fat;
import edu.umb.cs680.hw10.fs.FSElement;

import java.time.LocalDateTime;


public abstract class FatElement extends FSElement {
    private String owner_name;
    private LocalDateTime last_modified;
    public FatElement(FatDirectory parent, String name, int size, LocalDateTime creationTime,
                      String owner_name, LocalDateTime last_modified){
        super(parent, name, size, creationTime);
        this.owner_name = owner_name;
        this.last_modified = last_modified;
    }
}
