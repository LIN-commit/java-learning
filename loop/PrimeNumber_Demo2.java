import java.util.Scanner;

public class PrimeNumber_Demo2 {
    //判断一个数是否是质数
    //写法二
    public static void main(String[] args) {
        //键盘录入一个大于2的整数
        int num = 0;
        while(true) {
            System.out.println("输入一个大于2的整数：");
            Scanner sc = new Scanner(System.in);
            num = sc.nextInt();
            if (num >=2)
                break;
            else
                System.out.println("当前输入的数字不合法，请重新输入");
        }
        //判断num是否是一个质数
        int count =0;
        for (int i = 2; i <Math.sqrt(num); i++){
            if (num%i==0){
                count++;
                break;
            }
        }
        if (count==0)
            System.out.println(num+"是质数");
        else
            System.out.println(num+"不是质数");
    }
}
