package school;

import java.util.ArrayList;
import java.util.List;

public class ManagementSys {
    private static ManagementSys instance = null;
    private List<Person> persons;

    private ManagementSys() {
        persons = new ArrayList<Person>();
    }

    public static ManagementSys getInstance() {
        if (instance == null) {
            instance = new ManagementSys();
        }
        return instance;
    }

    public void addPerson(Person person) {
        persons.add(person);
    }

    public void removePerson(Person person) {
        persons.remove(person);
    }

    public void updatePerson(int index, Person person) {
        persons.set(index, person);
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
}