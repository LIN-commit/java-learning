package oop_extend_case1;

public class Undergraduate extends Student{
    //空参构造
    public Undergraduate() {
    }
    //全参构造
    public Undergraduate(String name, int age, String grade) {
        super(name, age, grade);
    }

    //重写学习方法
    @Override
    public void study() {
        System.out.println("本科学生攻读学士学位");
    }
}
