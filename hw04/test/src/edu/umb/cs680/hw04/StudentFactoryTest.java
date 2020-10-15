package edu.umb.cs680.hw04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentFactoryTest {

    Student Alex = StudentFactory.createInStateStudent("Alex", "Boston",18000);
    @Test
    void getTuition() {
        float expected = Alex.getTuition();
        float actual = Alex.getTuition();
        assertEquals(expected,actual);
    }

    @Test
    void getName() {
        String expected = "Alex";
        assertEquals(expected, Alex.getName());
    }

    @Test
    void getStatus() {
        StudentStatus expected = StudentStatus.INSTATE;
        assertEquals(expected, Alex.getStatus());
    }

    @Test
    void createInStateStudent() {
        Student Lyn = StudentFactory.createInStateStudent("Lyn", "MA", 20000);
        StudentStatus expected = StudentStatus.INSTATE;
        assertEquals(expected, Lyn.getStatus());
    }

    @Test
    void createOutStateStudent() {
        Student Lyn = StudentFactory.createOutStateStudent("Lyn", "MA", 3,20000);
        StudentStatus expected = StudentStatus.OUTSTATE;
        assertEquals(expected, Lyn.getStatus());
    }

    @Test
    void createIntlStudent() {
        Student Lyn = StudentFactory.createIntlStudent("Lyn", "MA", 201240,
                "China",40000);
        StudentStatus expected = StudentStatus.INTL;
        assertEquals(expected, Lyn.getStatus());
    }

}