package oop_extend_test1;

public class Teacher extends Person{
    //老师特有的属性
    String subject;

    //老师特有的行为
    public void teach(){
        System.out.println("老师在教书");
    }
}
