package oop_extend_case2;

public class Test {
    public static void main(String[] args) {
        Manager m = new Manager("010203","张三",6000,2000);
        System.out.println(m.getNumber()+","+m.getName()+",工资是"+m.getSalary()+",管理奖金是"+m.getBonus());
        m.eat();
        m.work();
        System.out.println("----------");
        Chef c = new Chef("040506","李四",5000);
        System.out.println(c.getNumber()+","+c.getName()+",工资是"+c.getSalary());
        c.eat();
        c.work();
    }
}
