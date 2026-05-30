package oop_extend_case1;

public class GeneralEducationTeacher extends Teacher{
    //空参构造
    public GeneralEducationTeacher() {
    }
    //全参构造
    public GeneralEducationTeacher(String name, int age) {
        super(name, age);
    }
    //重写教书方法
    @Override
    public void teach() {
        System.out.println("通识课老师教授通识课知识");
    }
}
