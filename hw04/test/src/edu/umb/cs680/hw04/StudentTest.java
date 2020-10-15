package edu.umb.cs680.hw04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    Student Alex = new Student(20000, "Alex", 0,"TX",5,
            null, StudentStatus.INSTATE);
    @Test
    void getTuition() {
        float expected = 20000;
        float actual = Alex.getTuition();
        assertEquals(expected, actual);
    }

    @Test
    void getName() {
        String expected = "Alex";
        String actual = Alex.getName();
        assertEquals(expected, actual);
    }

}