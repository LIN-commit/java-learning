package oop_extend_case2;

public class Manager extends Employee{
    //经理特有的属性
    private int bonus;
    //空参构造
    public Manager() {
    }
    //全参构造
    public Manager(String number, String name, int salary, int bonus) {
        super(number, name, salary);
        this.bonus = bonus;
    }

    //get/set方法

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    //重写吃饭方法

    @Override
    public void eat() {
        System.out.println("吃米饭");
    }

    //重写工作方法
    @Override
    public void work() {
        System.out.println("经理的工作是管理其他人");
    }
}
