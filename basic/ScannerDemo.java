import java.util.Scanner;

public class ScannerDemo{
    public static void main(String[] args) {
        //键盘录入演示
        System.out.println("输入你想要打印的数字：");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(num);
    }
}