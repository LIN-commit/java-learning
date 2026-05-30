package oop_extend_test5;

public class Phone extends SmartDevice {
    /*
    方法重写要注意：
    如果父类中的代码，我一行都不想用，就在子类中的方法体重新写一遍完整的代码
    如果父类中的代码我还想用，此时我只是在父类的基础上再加其他的逻辑
    此时可以先通过super关键字调用父类的方法，得到一个结果，再对这个结果进行操作
     */
    @Override
    public double payment() {
        //调用父类中的方法，得到基础价格
        double price = super.payment();
        return price*0.9;
    }
}
