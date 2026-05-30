package oop_extend_test6;

public class Test {
    public static void main(String[] args) {
        Student stu = new Student("张三",16,"高一");
        //如果忘记了赋值的变量，点击括号，按住ctrl+p，就会显示了
        System.out.println(stu.name+", "+stu.age+", "+stu.grade);
        System.out.println("--------------");
        Teacher t = new Teacher();

    }
}
