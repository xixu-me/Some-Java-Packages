package school;

public class Test {
    public static void main(String[] args) {
        ManagementSys sys = ManagementSys.getInstance();

        Student std = new Student("John", 20, "S2201110101");
        sys.addPerson(std);

        Teacher tch = new Teacher("Tom", 30, "T2201110101");
        sys.addPerson(tch);

        Staff stf = new Staff("Jerry", 40, "S2201110101");
        sys.addPerson(stf);

        Administrator adm = new Administrator("Jack", 50, "A2201110101");
        sys.addPerson(adm);

        Manager mgr = Manager.getInstance("Marry", 60);
        sys.addPerson(mgr);

        for (Person person : sys.getPersons()) {
            person.speak();
        }

        sys.removePerson(std);
        System.out.println("After removing John");
        for (Person person : sys.getPersons()) {
            person.speak();
        }

        sys.updatePerson(0, new Teacher("Tom", 30, "T2201110102"));
        System.out.println("After updating Tom");
        for (Person person : sys.getPersons()) {
            person.speak();
        }
    }
}