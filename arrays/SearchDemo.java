import java.util.Scanner;

public class SearchDemo {
    //查找数据
    public static void main(String[] args) {
        //定义数组
        int[] arr = {33,5,22,44,55,33};
        //键盘录入数据
        Scanner sc = new Scanner (System.in);
        System.out.println("请输入一个整数：");
        int num = sc.nextInt();
        //记录数组当中是否存在num false:不存在  true:存在
        boolean flag = false;
        /*
        记录数组中是否存在num还有一种方法
        int count =0;
         */
        for (int i = 0; i < arr.length; i++) {
            if (num==arr[i]){
                System.out.println(i);
                flag = true;
                //count++;
                break;
            }
        }
        //判断数据不存在
        //写法一：用boolean
        if (!flag)//即flag==false
            System.out.println("数据不存在");
        /*写法二：
        if (count==0)
            System.out.println("数据不存在");
         */

    }
}
