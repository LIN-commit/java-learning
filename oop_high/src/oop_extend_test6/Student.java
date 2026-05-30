package oop_extend_test6;

public class Student extends Person{
    String grade;
    //构造方法
    //1.空参构造
    public Student(){
        System.out.println("子类Student的空参构造执行了");
    }
    //2.带全部参数构造
    //父类中的属性：通过super（参数）的形式传递给父类的构造方法，用来赋值
    //子类中的属性：自己赋值
    public Student(String name,int age,String grade) {
        super(name, age);
        this.grade = grade;
        System.out.println("子类的带参构造执行了");
    }
}
