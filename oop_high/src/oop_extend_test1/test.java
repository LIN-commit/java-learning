package oop_extend_test1;

public class test {
    public static void main(String[] args) {
        //创建对象
        Student s = new Student();
        s.name = "小明";
        s.age = 8;
        s.grade = "二年级";
        System.out.println(s.name+"，"+s.age+"岁，"+s.grade);
        s.eat();
        s.study();

        System.out.println("-----------------");

        //创建老师的对象
        Teacher t = new Teacher();
        t.name = "蓝猫老师";
        t.age = 20;
        t.subject = "计算机学科";
        System.out.println(t.name+"，"+t.age+"岁，"+t.subject);
        t.eat();
        t.teach();

    }
}
