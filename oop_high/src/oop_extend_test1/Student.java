package oop_extend_test1;

public class Student extends Person{
    //学生特有的属性
    String grade;

    //学生特有的行为
    public void study(){
        System.out.println("学生在学习");
    }
}
