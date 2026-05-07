import java.util.Scanner;

public class ArrayDemo4 {
    //动态初始化
    //键盘录入5个整数，存入数组当中，并进行遍历
    public static void main(String[] args) {
        int[] arr = new int[5];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            System.out.println("请输入一个整数：");
            int num = sc.nextInt();
            //把接收到的数赋值给数组
            arr[i]=num;
        }
        //遍历数组
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
