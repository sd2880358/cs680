package edu.umb.cs680.hw08;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class StructureTest {
    private static LocalDateTime time = LocalDateTime.now();
    private static Directory root = new Directory(null, "root", 0, time);
    private static Directory applications = new Directory(root, "applications", 0, time);
    private static Directory home = new Directory(root, "home", 0, time);
    private static File a = new File(applications, "a", 20, time);
    private static File b = new File(applications, "b", 20, time);
    private static Link x = new Link(home, "x", 0, time, applications);
    private static File c = new File(home, "c", 20, time);
    private static File d = new File(home, "d", 20, time);
    private static Directory code = new Directory(home, "code", 0, time);
    private static Link y = new Link(code, "y", 0, time, b);
    private static File e = new File(code, "e", 20, time);
    private static File f = new File(code, "f", 20, time);
    private String[] fsToString(FSElement f) {
        if (f.isDirectory()) {
            Directory target = (Directory) f;
            String[] targetInfo = {
                    String.valueOf(target.isDirectory()),
                    target.getName(),
                    Integer.toString(target.getTotalSize()),
                    target.getCreationTime().toString(),
                    null,
                    Integer.toString(target.countChildren())
            };
            if (target.getParent() != null) {
                targetInfo[4] = target.getParent().getName();
            }
            return targetInfo;
        } else {
            String[] targetInfo = {
                    String.valueOf(f.isDirectory()),
                    f.getName(),
                    Integer.toString(f.getSize()),
                    f.getCreationTime().toString(),
                    null
            };
            if (f.getParent() != null) {
                targetInfo[4] = f.getParent().getName();
            }
            return targetInfo;

        }
    }

    @BeforeAll
    public static void initalization(){
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
    public void linkX(){
        String[] expected = {"true", "applications", "40", time.toString(), "root", "2"};
        String [] actual = fsToString(x.getTarget());
        assertArrayEquals(expected, actual);
    }

    @Test
    public void linkY(){
        String[] expected= {"false", "b", "20", time.toString(), "applications"};
        String [] actual = fsToString(y.getTarget());
        assertArrayEquals(expected, actual);
    }

    @Test
    public void diretoryEqualHome(){
        String[] expected = {"true", "home", "80", time.toString(), "root", "4"};
        String[] actual = fsToString(home);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void setTarget(){
        y.setTarget(root);
        String[] expected = {"true", "root", "120", time.toString(), null, "2"};
        String[] actual = fsToString(y.getTarget());
        assertArrayEquals(expected, actual);
    }
}