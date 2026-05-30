package ooptest2;

public class StudentDemo2 {
    /*
    定义一个Javabean类描述学生
    属性：姓名，年龄，性别
     */
    public static void main(String[] args) {

        Student2 s = new Student2();
        System.out.println(s.getName());
        System.out.println(s.getAge());
        System.out.println(s.getGender());

        Student2 ss = new Student2("张三",18,"男");
        System.out.println(ss.getName());
        System.out.println(ss.getAge());
        System.out.println(ss.getGender());

    }
}
