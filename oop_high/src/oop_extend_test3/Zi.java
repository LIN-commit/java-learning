package oop_extend_test3;

public class Zi extends Fu{
    String name = "Zi";
    public void show(){
        String name = "ziShow";
        System.out.println(name);//局部变量
        System.out.println(this.name);//本类中的成员变量
        System.out.println(super.name);//父类中的变量
    }
}
