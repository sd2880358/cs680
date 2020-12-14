package edu.umb.cs680.hw12.fs;

import java.util.LinkedList;

public abstract class FileSystem {
    protected String name;
    protected int capacity;
    protected int id;
    protected LinkedList<FSElement> rootDirs = new LinkedList<FSElement>();

    protected abstract FSElement createDefaultRoot();
    public FSElement initFileSystem(String name, int capacity){
        this.name = name;
        this.capacity = capacity;
        FSElement root = createDefaultRoot();
        if (root.isDirectory() && capacity >= root.getSize()){
            setRoot(root);
            this.id = root.hashCode();
            return root;
        }
        else {
            return null;
        }
    }

    protected abstract void setRoot(FSElement root);


    public int getCapacity(){
        return this.capacity;
    }

    public abstract int getUsed();

}
