package oop_extend_test7;

public class Test {
    public static void main(String[] args) {
        Student stu = new Student();
        //这里调用的是空参构造，而空参构造调用了全参构造并给成员变量赋值了
        System.out.println(stu.name+", "+stu.age);
    }
}
