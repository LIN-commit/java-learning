package oop_extend_case1;

public class Person {
    //共同属性：姓名，年龄
    private String name;
    private int age;
    //空参构造
    public Person() {
    }
    //全参构造
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //get/set方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    //共同的行为：吃饭，睡觉
    public void eat(){
        System.out.println("吃饭");
    }
    public void sleep(){
        System.out.println("睡觉");
    }
}
