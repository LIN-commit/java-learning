package example1;

public class Test {
    public static void main(String[] args) {
        Person stu = new Student("张三","zhangsan","123456");
        StudentManager s = new StudentManager();
        s.register(stu);
        Person t = new Teacher("蓝猫学姐","bluecat","456789");
        s.register(t);
    }
}
