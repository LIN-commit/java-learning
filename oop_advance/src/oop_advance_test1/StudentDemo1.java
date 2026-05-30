package oop_advance_test1;

public class StudentDemo1 {
    /*
    学生有属性：姓名，年龄，老师。
  一个班级中，所有学生都共享同一个老师。
  第一个学生：小诗，19岁
  第二个学生：小丹，20岁
  最初是小雯老师上课，有一天小丹申请换老师，换成了小林老师。
  利用static模拟上述效果
     */
    public static void main(String[] args) {
        Student1 s = new Student1();
        s.name = "小诗";
        s.age = 19;

        //调用静态变量teacher
        //方式一：类名调用
        Student1.teacher = "小雯老师";
        //方式二：对象名调用
        s.teacher = "小雯老师";

        //创建第二个学生
        Student1 ss= new Student1();
        ss.name = "小丹";
        ss.age = 20;
        //打印
        System.out.println(s.name+","+s.age+","+s.teacher);
        System.out.println(ss.name+","+ss.age+","+ss.teacher);

        System.out.println();

        //更换老师
        Student1.teacher = "小林老师";
        //打印
        System.out.println(s.name+","+s.age+","+s.teacher);
        System.out.println(ss.name+","+ss.age+","+ss.teacher);

    }
}
