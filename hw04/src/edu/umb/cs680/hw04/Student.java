package edu.umb.cs680.hw04;
enum StudentStatus {INSTATE, OUTSTATE, INTL}
public class Student {
    private float tuition;
    private String name;
    private int i20num;
    private String usAddr;
    private int yrsInState;
    private String foreignAddr;
    private StudentStatus status;
    private Student(float tuition, String name, int i20num, String usAddr,
                    int yrsInState, String foreignAddr, StudentStatus status){
        this.tuition = tuition;
        this.name = name;
        this.foreignAddr = foreignAddr;
        this.status = status;
        this.i20num = i20num;
        this.usAddr = usAddr;
        this.yrsInState = yrsInState;
    }

    public float getTuition() {
        return tuition;
    }
    public String getName(){
        return name;
    }

    public static class StudentFactory extends Student {
        StudentFactory(float tuition, String name, int i20num, String usAddr, int yrsInState, String foreignAddr,
                       StudentStatus status) {
            super(tuition, name, i20num, usAddr, yrsInState, foreignAddr, status);
        }
    }
    public static StudentFactory createInStateStudent(String name, String usAddr) {
        return new StudentFactory(0, name, 0, usAddr, 0, null, StudentStatus.INSTATE);
    }
    public static StudentFactory createOutStateStudent(String name, String usAddr, int yrsInState){
        return new StudentFactory(0, name, 0, usAddr, yrsInState, null, StudentStatus.OUTSTATE);
    }
    public  static StudentFactory createIntlStudent(String name, String usAddr, int i20num,
                                                    int yrsInState, String foreignAddr){
        return new StudentFactory(0, name, i20num, usAddr, yrsInState, foreignAddr, StudentStatus.INTL);
    }
    public static void main(String[] args) {

    }
}