public class Student {
    // 单例模式
    private static Student instance = null;

    private Student() {
    }

    public static Student getInstance() {
        if (instance == null) {
            instance = new Student();
        }
        return instance;
    }
}
