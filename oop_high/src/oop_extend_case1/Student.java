package oop_extend_case1;

public class Student extends Person{
    //学生特有属性：年级
    private String grade;
    //空参构造
    public Student() {
    }
    //全参构造
    public Student(String name, int age, String grade) {
        super(name, age);
        this.grade = grade;
    }

    //get/set方法
    //父类中的public方法，子类继承后可以直接调用
    //这里只需要写grade的get/set方法
    public String getGrade() {
        return grade;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }

    //学生共同行为：学习
    public void study(){
        System.out.println("学生学习");
    }
}
