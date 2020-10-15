package edu.umb.cs680.hw04;

public class StudentFactory extends Student {
    StudentFactory(float tuition, String name, int i20num, String usAddr, int yrsInState, String foreignAddr,
                   StudentStatus status) {
        super(tuition, name, i20num, usAddr, yrsInState, foreignAddr, status);
    }

    public static StudentFactory createInStateStudent(String name, String usAddr,float tuition) {
        return new StudentFactory(tuition, name, 0, usAddr, 0, null, StudentStatus.INSTATE);
    }

    public static StudentFactory createOutStateStudent(String name, String usAddr, int yrsInState,float tuition) {
        return new StudentFactory(tuition, name, 0, usAddr, yrsInState, null, StudentStatus.OUTSTATE);
    }

    public static StudentFactory createIntlStudent(String name, String usAddr, int i20num,
                                                   String foreignAddr, float tuition) {
        return new StudentFactory(tuition, name, i20num, usAddr, 0, foreignAddr, StudentStatus.INTL);
    }
    public static void main(String[] args) {
        Student wang = StudentFactory.createIntlStudent("Wang", "Boston", 4102,
                "China",20000);
        System.out.println(wang.getName());
        System.out.println((wang.getTuition()));
        System.out.println((wang.getStatus()));
    }
}