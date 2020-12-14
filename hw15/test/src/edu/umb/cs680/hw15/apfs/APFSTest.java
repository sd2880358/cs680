package edu.umb.cs680.hw15.apfs;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class APFSTest {
    private static LocalDateTime time = LocalDateTime.now();
    private static String owner = "test";
    private static APFS system = APFS.getSystem();
    private static ApfsDirectory root =
            new ApfsDirectory(null,"root",0, LocalDateTime.now(), owner, time);
    private static ApfsDirectory applications =
            new ApfsDirectory(root, "applications", 0, LocalDateTime.now(), owner, time);
    private static ApfsDirectory home =
            new ApfsDirectory(root, "home", 0, LocalDateTime.now(), owner, time);
    private static ApfsFile a =
            new ApfsFile(applications, "a", 20, LocalDateTime.now(), owner, time);
    private static ApfsFile b =
            new ApfsFile(applications, "b", 20, LocalDateTime.now(), owner, time);
    private static ApfsLink x =
            new ApfsLink(home, "x", 0, LocalDateTime.now(), owner , time,  applications);
    private static ApfsFile c =
            new ApfsFile(home, "c", 20, LocalDateTime.now(), owner, time);
    private static ApfsFile d =
            new ApfsFile(home, "d", 20, LocalDateTime.now(), owner, time);
    private static ApfsDirectory code =
            new ApfsDirectory(home, "code", 0, LocalDateTime.now(), owner, time);
    private static ApfsLink y =
            new ApfsLink(code, "y", 0, LocalDateTime.now(), owner, time, b);
    private static ApfsFile e =
            new ApfsFile(code, "e", 20, LocalDateTime.now(), owner, time);
    private static ApfsFile f =
            new ApfsFile(code, "f", 20, LocalDateTime.now(), owner, time);

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
    public void alphabeticalRoot(){
        LinkedList<ApfsElement> children = root.getChildren(
                Comparator.comparing(ApfsElement :: getName));
        ApfsElement[] expected = {applications, home};
        ApfsElement[] actual = children.toArray(new ApfsElement[children.size()]);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void alphabeticalHome(){
        LinkedList<ApfsElement> children = home.getChildren(
                Comparator.comparing(ApfsElement :: getName));
        ApfsElement[] expected = {c, code, d, x};
        ApfsElement[] actual = children.toArray(new ApfsElement[children.size()]);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void reverseAlphaRoot(){
        LinkedList<ApfsElement> children = root.getChildren(
                Comparator.comparing(ApfsElement :: getName,
                        Comparator.reverseOrder()));
        ApfsElement[] expected = {home, applications};
        ApfsElement[] actual = children.toArray(new ApfsElement[children.size()]);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void reverseAlphabeticalHome(){
        LinkedList<ApfsElement> children = home.getChildren(
                Comparator.comparing(ApfsElement :: getName,
                        Comparator.reverseOrder()));
        ApfsElement[] expected = {x, d, code, c};
        ApfsElement[] actual = children.toArray(new ApfsElement[children.size()]);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void timeStampHome(){
        LinkedList<ApfsElement> children = home.getChildren(
                Comparator.comparing(ApfsElement :: getCreationTime));
        ApfsElement[] expected = {x, c, d, code};
        ApfsElement[] actual = children.toArray(new ApfsElement[children.size()]);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void timeStampRoot(){
        LinkedList<ApfsElement> children = root.getChildren(
                Comparator.comparing(ApfsElement :: getCreationTime));
        ApfsElement[] expected = {applications, home};
        ApfsElement[] actual = children.toArray(new ApfsElement[children.size()]);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void elementBasedHome(){
        LinkedList<ApfsElement> children = home.getChildren(
                Comparator.comparing(ApfsElement->{
                    if (ApfsElement.isDirectory()){
                        return 1;
                    }else if (ApfsElement.isFile()){
                        return 2;
                    }else{
                        return 3;
                    }
                }));
        ApfsElement[] expected = {code, c, d, x};
        ApfsElement[] actual = children.toArray(new ApfsElement[children.size()]);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void elementBasedX(){
        ApfsElement xTarget = x.getTarget();
        LinkedList<ApfsElement> children = ((ApfsDirectory)xTarget).getChildren(
                Comparator.comparing(ApfsElement->{
                    if (ApfsElement.isDirectory()){
                        return 1;
                    }else if (ApfsElement.isFile()){
                        return 2;
                    }else{
                        return 3;
                    }
                }));
        ApfsElement[] expected = {a,b};
        ApfsElement[] actual = children.toArray(new ApfsElement[children.size()]);
        assertArrayEquals(expected, actual);
    }
}