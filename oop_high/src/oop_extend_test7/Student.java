package oop_extend_test7;

public class Student {
    String name;
    int age;

    //this()：调用本类中的其他构造方法
    public Student() {
        this("张三",18);
        //这里的this调用的是下面那个构造方法
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
