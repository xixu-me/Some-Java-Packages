package school;

public class Manager extends Person {
    private static Manager instance = null;

    private Manager(String name, int age) {
        super(name, age);
    }

    public static Manager getInstance(String name, int age) {
        if (instance == null) {
            instance = new Manager(name, age);
        }
        return instance;
    }

    public void manage() {
        System.out.println("I am the administrator and I am responsible for managing everyone.");
    }

    public void speak() {
        System.out.println("I am the manager, my name is " + getName() + ", and I am " + getAge() + " years old.");
    }
}