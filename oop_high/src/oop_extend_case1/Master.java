package oop_extend_case1;

public class Master extends Student{
    //空参构造
    public Master() {
    }
    //全参构造
    public Master(String name, int age, String grade) {
        super(name, age, grade);
    }

    //重写方法

    @Override
    public void sleep() {
        super.sleep();
        System.out.println("过了一段时间，研究生住宿条件升级，在豪华版学生公寓睡觉");
    }

    //重写学习方法
    @Override
    public void study() {
        System.out.println("研究生攻读硕士学位");
    }
}
