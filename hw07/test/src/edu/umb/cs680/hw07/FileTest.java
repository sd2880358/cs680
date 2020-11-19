package edu.umb.cs680.hw07;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class FileTest {

    private static LocalDateTime currentTime = LocalDateTime.now();
    private static Directory root = new Directory(null, "Root", 100, currentTime);
    private static Directory home = new Directory(root, "Home", 100, currentTime);
    private static Directory documents = new Directory(home, "Documents", 50, currentTime);
    private static Directory downloads = new Directory(home, "Downloads", 50, currentTime);
    private static File a = new File(home, "a", 3, currentTime);
    private static File b = new File(documents, "b", 40, currentTime);
    private static File c = new File(downloads, "c", 10, currentTime);
    private String[] fileToStringArray(File d){
        String[] dirInfo = {
                String.valueOf(d.isDirectory()),
                d.getName(),
                Integer.toString(d.getSize()),
                d.getCreationTime().toString(),
                null
        };
        if (d.getParent()!=null){
            dirInfo[4] = d.getParent().getName();
        }
        return dirInfo;
    }
    @BeforeAll
    private static void init(){
        root.appendChild(home);
        home.appendChild(documents);
        home.appendChild(downloads);
        home.appendChild(a);
        documents.appendChild(b);
        downloads.appendChild(c);
    }

    @Test
    public void verifyFileA(){
        String[] expected = {"false", "a", "3", currentTime.toString(), "Home"};
        String[] actual = fileToStringArray(a);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void verifyFileB(){
        String[] expected = {"false", "b", "40", currentTime.toString(), "Documents"};
        String[] actual = fileToStringArray(b);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void verifyFileC(){
        String[] expected = {"false", "c", "10", currentTime.toString(), "Downloads"};
        String[] actual = fileToStringArray(c);
        assertArrayEquals(expected, actual);
    }

}