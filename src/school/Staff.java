package school;

public class Staff extends Person {
    private String staffID;

    public Staff(String name, int age, String staffID) {
        super(name, age);
        this.staffID = staffID;
    }

    public void speak() {
        System.out.println("I am a staff, my name is " + getName() + ", and I am " + getAge()
                + " years old. My staff ID is " + staffID + ".");
    }

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }
}