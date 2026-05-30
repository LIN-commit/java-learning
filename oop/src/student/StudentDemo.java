package student;

public class StudentDemo {
    public static void main(String[] args) {
        //记录第一个学生的信息
        Student s1 = new Student();
        s1.name = "良玉";
        s1.age = 25;
        s1.gender = '女';
        s1.height = 1.86;
        System.out.println(s1.name);
        System.out.println(s1.age);
        System.out.println(s1.gender);
        System.out.println(s1.height);

        System.out.println();

        //记录第二个学生的信息
        Student s2 = new Student();
        s2.name = "荀灌";
        s2.age = 13;
        s2.gender = '女';
        s2.height = 1.8;
        System.out.println(s2.name);
        System.out.println(s2.age);
        System.out.println(s2.gender);
        System.out.println(s2.height);
    }
}
