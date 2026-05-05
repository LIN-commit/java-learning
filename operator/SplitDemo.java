import java.util.Scanner;

public class SplitDemo {
    //键盘录入一个三位数，拆分个位十位百位，并打印在控制台
    public static void main(String[] args) {
        //键盘录入一个三位数
        Scanner sc = new Scanner(System.in);
        System.out.println("输入一个三位数：");
        int num = sc.nextInt();
        //拆分个位
        int ge = num % 10 ;
        //拆分十位
        int shi = num /10 %10;
        //拆分百位
        int bai = num /100;
        //打印
        System.out.println("个位是"+ge+",十位是"+shi+"，百位是"+
                bai);
    }
}
