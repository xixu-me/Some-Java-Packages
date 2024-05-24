package library;

public class Test {
    public static void main(String[] args) {
        Administrator adm = new Administrator(1, "John");
        adm.getLib().add(new Book("123", "Book1", 1));
        adm.getLib().add(new Book("124", "Book2", 1));
        adm.getLib().add(new Book("125", "Book3", 1));
        Student st = new Student(1, "Alice");
        st.getBg().add(new Book("123", "Book1", 1));
        st.getBg().add(new Book("124", "Book2", 1));
        st.getBg().add(new Book("125", "Book3", 1));
        adm.register(st);
    }
}