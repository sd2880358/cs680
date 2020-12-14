package edu.umb.cs680.hw12.apfs;

import java.util.Comparator;

public class ElementKindBasedComparator implements Comparator<ApfsElement> {
    @Override
    public int compare(ApfsElement o1, ApfsElement o2) {
        return getWeight(o1) - getWeight(o2);
    }

    public int getWeight(ApfsElement test){
        int weight;
        if (test.isDirectory()){
            weight = 1;
        }else if(test.isFile()){
            weight = 2;
        }else{
            weight = 3;
        }
        return weight;
    }
}
