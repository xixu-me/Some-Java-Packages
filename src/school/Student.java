package school;

public class Student extends Person {
    private String studentID;

    public Student(String name, int age, String studentID) {
        super(name, age);
        this.studentID = studentID;
    }

    public void speak() {
        System.out.println("I am a student, my name is " + getName() + ", and I am " + getAge()
                + " years old. My student ID is " + studentID + ".");
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }
}