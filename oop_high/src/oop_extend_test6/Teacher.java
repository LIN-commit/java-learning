package oop_extend_test6;

public class Teacher extends Person{
    String subject;
    //构造方法快捷键：Alt+Insert
    public Teacher(){
        System.out.println("Teacher的空参构造被调用了");
    }
    public Teacher(String name,int age,String subject){
        super(name,age);
        this.subject = subject;
    }
}
