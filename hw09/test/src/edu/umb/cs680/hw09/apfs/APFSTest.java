package edu.umb.cs680.hw09.apfs;

import static org.junit.jupiter.api.Assertions.*;

import edu.umb.cs680.hw09.fs.FSElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class APFSTest {
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
    private String[] fsToString(FSElement f) {
        if (f.isDirectory()) {
            ApfsDirectory target = (ApfsDirectory) f;
            String[] targetInfo = {
                    String.valueOf(target.isDirectory()),
                    target.getName(),
                    Integer.toString(target.getTotalSize()),
                    target.getCreationTime().toString(),
                    null,
                    Integer.toString(target.countChildren())
            };
            if (target.getParent() != null){
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

    private String[] systemToString(APFS system){
        String[] i = {
                system.getRootDir().getName(),
                Integer.toString(system.getID()),
                Integer.toString(system.getUsed()),

        };
        return i;
    }

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
    public void setSystem(){
        APFS exprected = APFS.getSystem();
        APFS actual = system;
        assertSame(exprected, actual);
    }

    @Test void initSystem(){
        ApfsDirectory root = system.initFileSystem("admin", 129000);
        String [] actual = systemToString(system);
        String [] expected = {"root", Integer.toString(root.hashCode()), "0"};
        assertArrayEquals(expected, actual);
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