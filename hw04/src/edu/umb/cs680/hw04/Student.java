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

    protected Student(float tuition, String name, int i20num, String usAddr,
                    int yrsInState, String foreignAddr, StudentStatus status) {
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

    public String getName() {
        return name;
    }
    public StudentStatus getStatus(){
        return this.status;
    }
}
    
























