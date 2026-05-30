package dogtest2;

public class DogDemo2 {
    public static void main(String[] args) {
        /*
        小狗有属性：姓名、年龄
        行为：吃骨头
        要求1：小狗的年龄：0~15岁
        要求2：打印小狗所有的信息：小白，2岁
        要求3：调用吃骨头的方法，打印效果：2岁的小白，正在吃骨头
         */

        //创建对象
        Dog2 d = new Dog2();
        //赋值
        d.setName("小白");
        d.setAge(2);
        //打印小狗的信息
        System.out.println(d.getName()+","+d.getAge()+"岁");
        //打印小狗的行为
        d.eat();
    }

}
