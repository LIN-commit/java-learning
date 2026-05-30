package example1;

public class Student extends Person{
    public Student() {
    }

    public Student(String name, String number, String password) {
        super(name, number, password);
    }

    @Override
    public void work() {
        System.out.println("学生的工作是学习");
    }
}
