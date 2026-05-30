package oop_extend_test4;

public class ThirdGeneration extends SecondGeneration{
    //按住Alt+Insert,选择override,选择要重写的方法
    /*
    注释/注解：都是对代码的解释说明
    注释：给程序员看的（文字性的内容）
    注解：给虚拟机看的
     */
    //@Override就是注解，让虚拟机检查我们重写的方法是否和原方法的格式相同
    @Override
    public void call() {
        System.out.println("开启视频");
        System.out.println("用手机打视频通话");
    }

    public void game(){
        System.out.println("利用手机打游戏");
    }
}
