package edu.umb.cs680.hw15.apfs;
import edu.umb.cs680.hw15.fs.FSElement;

import java.time.LocalDateTime;


public abstract class ApfsElement extends FSElement {
    private String owner_name;
    private LocalDateTime last_modified;
    public ApfsElement(ApfsDirectory parent, String name, int size, LocalDateTime creationTime,
                       String owner_name, LocalDateTime last_modified){
        super(parent, name, size, creationTime);
        this.owner_name = owner_name;
        this.last_modified = last_modified;
    }
}
