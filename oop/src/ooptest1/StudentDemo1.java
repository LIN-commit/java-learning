package ooptest1;

public class StudentDemo1 {
    /*
    在校学生有属性：姓名，年龄，身高，体重
    行为：学习
    要求1：大一学生，张三，18岁，183cm，60kg，刚进大学努力学习
    要求2：大二期间张三体重增加了10kg
    要求3：大三期间张三身高增加2cm，体重减少3kg
    要求4：打印大学毕业之后，张三的所有信息
     */
    public static void main(String[] args) {
        Student1 s = new Student1();
        s.setName("张三");
        s.setAge(18);
        s.setHeight(183);
        s.setWeight(60);
        //大一
        System.out.println("大一学生，"+s.getName()+"，"+s.getAge()+"岁，"+s.getHeight()+"cm，"+s.getWeight()+"kg");
        System.out.print("刚进大学，");
        s.study();
        //大二
        //隐藏条件，年龄长一岁
        s.setAge(s.getAge()+1);
        s.setWeight(s.getWeight()+10);
        System.out.println("大二学生，"+s.getName()+"，"+s.getAge()+"岁，"+s.getHeight()+"cm，"+s.getWeight()+"kg");

        //大三
        s.setAge(s.getAge()+1);
        s.setHeight(s.getHeight()+2);
        s.setWeight(s.getWeight()-3);
        System.out.println("大三学生，"+s.getName()+"，"+s.getAge()+"岁，"+s.getHeight()+"cm，"+s.getWeight()+"kg");

        //刚上大四
        s.setAge(s.getAge()+1);
        System.out.println("大四学生，"+s.getName()+"，"+s.getAge()+"岁，"+s.getHeight()+"cm，"+s.getWeight()+"kg");
        //毕业
        s.setAge(s.getAge()+1);
        System.out.println("毕业，"+s.getName()+"，"+s.getAge()+"岁，"+s.getHeight()+"cm，"+s.getWeight()+"kg");

    }
}
