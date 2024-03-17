public class Test {
    public static void main(String[] args) {
        Student student1 = Student.getInstance();
        Student student2 = Student.getInstance();
        System.out.println(student1 == student2);
    }
}
