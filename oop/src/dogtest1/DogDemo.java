package dogtest1;

public class DogDemo {
    public static void main(String[] args) {
        //1.记录第一只小狗的信息
        //创建对象
        Dog d1 = new Dog();
        //赋值
        d1.name = "小白";
        d1.age = 2;
        d1.weight = 3.5;
        d1.color = "白色";
        //获取第一只小狗的信息
        System.out.println(d1.name);
        System.out.println(d1.age);
        System.out.println(d1.weight);
        System.out.println(d1.color);

        System.out.println();

        //2.记录第二只小狗的信息
        Dog d2 = new Dog();
        d2.name = "大黄";
        d2.age = 3;
        d2.weight = 5.5;
        d2.color = "黄色";
        //获取第二只小狗的信息
        System.out.println(d2.name);
        System.out.println(d2.age);
        System.out.println(d2.weight);
        System.out.println(d2.color);
    }
}
