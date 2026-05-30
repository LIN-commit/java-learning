package oop_extend_case1;

public class MajorCourseTeacher extends Teacher{
    //专业课老师特有属性：学科
    private String subject;

    //空参构造
    public MajorCourseTeacher() {
    }
    //全参构造
    public MajorCourseTeacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    //get/set方法
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    //重写教书方法
    @Override
    public void teach() {
        System.out.println("专业课老师教授专业课知识");
    }
}
