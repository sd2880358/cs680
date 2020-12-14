package edu.umb.cs680.hw15.apfs;

import edu.umb.cs680.hw15.fs.FSElement;
import edu.umb.cs680.hw15.fs.FileSystem;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.LinkedList;

public class APFS extends FileSystem {
    private APFS(){};
    private static APFS system = null;
    private LinkedList<ApfsDirectory> rootDir = new LinkedList<ApfsDirectory>();
    protected ApfsDirectory root;

    public static APFS getSystem() {
        if (system == null){
            system = new APFS();
        }
        return system;
    }
    public ApfsDirectory initFileSystem(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        FSElement root = createDefaultRoot();
        if (root.isDirectory() && capacity >= root.getSize()) {
            setRoot(root);
            this.id = root.hashCode();
            this.root = (ApfsDirectory)root;
            return (ApfsDirectory) root;
        } else {
            return null;
        }
    }
    protected FSElement createDefaultRoot(){
        LocalDateTime now = LocalDateTime.now();
        FSElement root = new ApfsDirectory(null, "root", 0, now, "admin", now);
        return root;
    }

    public FSElement getRootDir(){
        return this.root;
    }
    public int getID(){
        return this.id;
    }

    protected void setRoot(FSElement root){
        rootDir.add((ApfsDirectory)root);
    }

    @Override
    public int getUsed() {
        return root.getTotalSize(Comparator.comparing(ApfsElement::getName));
    }
}
