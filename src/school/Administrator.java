package school;

public class Administrator extends Person {
    private String adminID;

    public Administrator(String name, int age, String adminID) {
        super(name, age);
        this.adminID = adminID;
    }

    public void speak() {
        System.out.println("I am an administrator, my name is " + getName() + ", and I am " + getAge()
                + " years old. My admin ID is " + adminID + ".");
    }

    public String getAdminID() {
        return adminID;
    }

    public void setAdminID(String adminID) {
        this.adminID = adminID;
    }
}