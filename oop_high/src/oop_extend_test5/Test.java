package oop_extend_test5;

public class Test {
    public static void main(String[] args) {
        //创建子类对象，并查看结果
        Phone p = new Phone();
        p.name = "小米";
        p.price = 4999;
        double payment = p.payment();
        System.out.println(payment);
        System.out.println("---------------");
        Laptop lt = new Laptop();
        lt.name = "联想";
        lt.price = 10000;
        System.out.println(lt.payment());
    }
}
