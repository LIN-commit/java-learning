package teacher;

public class TeacherDemo {
    public static void main(String[] args) {
        //创建对象
        Teacher t = new Teacher();
        //赋值
        t.name = "张桂梅";
        t.age = 69;
        //获取老师的信息并打印在控制台
        System.out.println(t.name);
        System.out.println(t.age);
        //行为
        t.teach();
        t.eat();
        t.sleep();
    }

}
