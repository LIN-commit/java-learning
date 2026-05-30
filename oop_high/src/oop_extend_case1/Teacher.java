package oop_extend_case1;

public class Teacher extends Person{
    //空参构造
    public Teacher() {
    }
    //全参构造
    public Teacher(String name, int age) {
        super(name, age);
    }

    //老师共同行为：教书
    public void teach(){
        System.out.println("教书");
    }
}
