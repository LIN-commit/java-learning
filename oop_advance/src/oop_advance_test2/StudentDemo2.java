package oop_advance_test2;

public class StudentDemo2 {
    public static void main(String[] args) {

        final Student2 STU = new Student2("张三",18);


        STU.setName("李四");
        STU.setAge(19);

        System.out.println(STU.getName());
        System.out.println(STU.getAge());
    }
}
