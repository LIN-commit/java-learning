package oop_extend_case2;

public class Chef extends Employee{
    //空参构造
    public Chef() {
    }
    //全参构造
    public Chef(String number, String name, int salary) {
        super(number, name, salary);
    }

    //重写吃饭方法
    @Override
    public void eat() {
        System.out.println("吃米饭");
    }

    //重写工作方法
    @Override
    public void work() {
        System.out.println("厨师的工作是炒菜");
    }
}
