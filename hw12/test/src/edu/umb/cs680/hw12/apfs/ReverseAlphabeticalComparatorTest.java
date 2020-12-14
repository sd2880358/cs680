package edu.umb.cs680.hw12.apfs;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class ReverseAlphabeticalComparatorTest {
    private static LocalDateTime time = LocalDateTime.now();
    private static String owner = "test";
    private static APFS system = APFS.getSystem();
    private static ApfsDirectory root =
            new ApfsDirectory(null,"root",0, time, owner, time);
    private static ApfsDirectory applications =
            new ApfsDirectory(root, "applications", 0, time, owner, time);
    private static ApfsDirectory home =
            new ApfsDirectory(root, "home", 0, time, owner, time);
    private static ApfsFile a =
            new ApfsFile(applications, "a", 20, time, owner, time);
    private static ApfsFile b =
            new ApfsFile(applications, "b", 20, time, owner, time);
    private static ApfsLink x =
            new ApfsLink(home, "x", 0, time, owner , time,  applications);
    private static ApfsFile c =
            new ApfsFile(home, "c", 20, time, owner, time);
    private static ApfsFile d =
            new ApfsFile(home, "d", 20, time, owner, time);
    private static ApfsDirectory code =
            new ApfsDirectory(home, "code", 0, time, owner, time);
    private static ApfsLink y =
            new ApfsLink(code, "y", 0, time, owner, time, b);
    private static ApfsFile e =
            new ApfsFile(code, "e", 20, time, owner, time);
    private static ApfsFile f =
            new ApfsFile(code, "f", 20, time, owner, time);

    @BeforeAll
    public static void initalization(){
        system.setRoot(root);
        root.appendChild(home);
        root.appendChild(applications);
        applications.appendChild(a);
        applications.appendChild(b);
        home.appendChild(x);
        home.appendChild(c);
        home.appendChild(d);
        home.appendChild(code);
        code.appendChild(y);
        code.appendChild(e);
        code.appendChild(f);
    }

    @Test
    public void reAlphabeticalTestRoot(){
        ReverseAlphabeticalComparator test = new ReverseAlphabeticalComparator();
        LinkedList<ApfsElement> children = root.getChildren(test);
        ApfsElement[] expected = {home, applications};
        ApfsElement[] actual = children.toArray(new ApfsElement[children.size()]);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void reAlphabeticalTestHome(){
        ReverseAlphabeticalComparator test = new ReverseAlphabeticalComparator();
        LinkedList<ApfsElement> children = home.getChildren(test);
        ApfsElement[] expected = {x, d, code, c};
        ApfsElement[] actual = children.toArray(new ApfsElement[children.size()]);
        assertArrayEquals(expected, actual);
    }

}