package edu.umb.cs680.hw07;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class DirectoryTest {
    private static LocalDateTime currentTime = LocalDateTime.now();
    private static Directory root = new Directory(null, "Root", 100, currentTime);
    private static Directory home = new Directory(root, "Home", 100, currentTime);
    private static Directory documents = new Directory(home, "Documents", 50, currentTime);
    private static Directory downloads = new Directory(home, "Downloads", 50, currentTime);
    private static File a = new File(home, "a", 3, currentTime);
    private static File b = new File(documents, "b", 40, currentTime);
    private static File c = new File(downloads, "c", 10, currentTime);
    private String[] dirToStringArray(Directory d){
        String[] dirInfo = {
                String.valueOf(d.isDirectory()),
                d.getName(),
                Integer.toString(d.getSize()),
                d.getCreationTime().toString(),
                null,
                Integer.toString(d.countChildren())
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
    public void verifyDiretoryEqualityHome(){
        String[] expected = {"true", "Home", "100", currentTime.toString(), "Root", "3"};
        String[] actual = dirToStringArray(home);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void verifyDiretoryEqualityRoot(){
        String[] expected = {"true", "Root", "100", currentTime.toString(), null, "1"};
        String [] actual = dirToStringArray(root);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void getTotalSize(){
        int expected = 100 + 50 + 50 + 3 + 40 + 10;
        int actual = home.getTotalSize();
        assertEquals(expected, actual);
    }
}