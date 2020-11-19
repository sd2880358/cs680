package edu.umb.cs680.hw09.fat;
import edu.umb.cs680.hw09.fs.FileSystem;
import edu.umb.cs680.hw09.fs.FSElement;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class FAT extends FileSystem {
    private FAT(){};
    private static FAT system = null;
    private LinkedList<FatDirectory> rootDir = new LinkedList<FatDirectory>();
    protected FatDirectory root;

    public static FAT getSystem() {
        if (system == null){
            system = new FAT();
        }
        return system;
    }
    public FatDirectory initFileSystem(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        FSElement root = createDefaultRoot();
        if (root.isDirectory() && capacity >= root.getSize()) {
            setRoot(root);
            this.id = root.hashCode();
            this.root = (FatDirectory)root;
            return (FatDirectory) root;
        } else {
            return null;
        }
    }
    protected FSElement createDefaultRoot(){
        LocalDateTime now = LocalDateTime.now();
        FSElement root = new FatDirectory(null, "root", 0, now, "admin", now);
        return root;
    }

    public int getID(){
        return this.id;
    }
    public FatDirectory getRootDir(){
        return this.root;
    }

    protected void setRoot(FSElement root){
        rootDir.add((FatDirectory)root);
    }

    @Override
    public int getUsed() {
        return root.getTotalSize();
    }
}
