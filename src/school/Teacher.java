package school;

public class Teacher extends Person {
    private String teacherID;

    public Teacher(String name, int age, String teacherID) {
        super(name, age);
        this.teacherID = teacherID;
    }

    public void speak() {
        System.out.println("I am a teacher, my name is " + getName() + ", and I am " + getAge()
                + " years old. My teacher ID is " + teacherID + ".");
    }

    public String getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
    }
}
