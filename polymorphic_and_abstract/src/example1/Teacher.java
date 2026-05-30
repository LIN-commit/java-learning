package example1;

public class Teacher extends Person{
    public Teacher() {
    }

    public Teacher(String name, String number, String password) {
        super(name, number, password);
    }

    @Override
    public void work() {
        System.out.println("老师的工作是教书");
    }
}
