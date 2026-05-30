package oop_extend_test6;

public class Person {
    String name;
    int age;
    public Person(){
        System.out.println("Person空参构造被调用了");
    }
    public Person(String name,int age){
        this.name = name;
        this.age = age;
        System.out.println("父类的带参构造执行了");
    }
}
