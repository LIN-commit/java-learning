package oop_extend_test4;

public class Test {
    /*
    第一代手机：
    功能：打电话
    第二代手机：
    功能：打电话，发短信
    第三代手机：
    功能：打电话升级为视频通话，发短信，玩游戏
     */
    public static void main(String[] args) {
        //创建第一代手机的对象
        FirstGeneration phone1 = new FirstGeneration();
        phone1.call();
        System.out.println("-----------------");
        //创建第二代手机的对象
        SecondGeneration phone2 = new SecondGeneration();
        phone2.call();
        phone2.sendMessage();
        System.out.println("-------------------");
        //创建第三代手机的对象
        ThirdGeneration phone3 = new ThirdGeneration();
        phone3.call();
        phone3.sendMessage();
        phone3.game();
    }
}
