package oop_extend_test2;

public class Phone extends Facility{
    //两个手机的共同行为
    public void call(){
        System.out.println("利用手机打电话");
    }
    public void information(){
        System.out.println("利用手机发短信");
    }
}
