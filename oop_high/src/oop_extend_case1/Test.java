package oop_extend_case1;

public class Test {
    public static void main(String[] args) {
        Undergraduate s1 = new Undergraduate("张三",18,"大一");
        System.out.println(s1.getName()+","+s1.getAge()+","+s1.getGrade());
        s1.eat();
        s1.sleep();
        s1.study();
        System.out.println("---------");
        Master s2 = new Master("李四",23,"研一");
        System.out.println(s2.getName()+","+s2.getAge()+","+s2.getGrade());
        s2.eat();
        s2.sleep();
        s2.study();
        System.out.println("-----------");
        MajorCourseTeacher t1 = new MajorCourseTeacher("蓝猫老师",20,"计算机");
        System.out.println(t1.getName()+","+t1.getAge()+","+t1.getSubject());
        t1.eat();
        t1.sleep();
        t1.teach();
        System.out.println("----------------");
        GeneralEducationTeacher t2 = new GeneralEducationTeacher("王老师",30);
        System.out.println(t2.getName()+","+t2.getAge());
        t2.eat();
        t2.sleep();
        t2.teach();

    }
}
