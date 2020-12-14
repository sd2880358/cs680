package edu.umb.cs680.hw12.apfs;

import java.util.Comparator;

public class ReverseAlphabeticalComparator implements Comparator<ApfsElement> {
    @Override
    public int compare(ApfsElement o1, ApfsElement o2) {
        return o2.getName().compareTo(o1.getName());
    }
}
