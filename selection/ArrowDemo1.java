import java.util.Scanner;

public class ArrowDemo1 {
    public static void main(String[] args) {
        //键盘录入日期
        System.out.println("输入今天的星期数(1~5)：");
        Scanner sc = new Scanner(System.in);
        int weekday = sc.nextInt();

        //case箭头标签
        switch(weekday) {
            case 1 -> System.out.println("红烧排骨");
            case 2 -> System.out.println("辣椒炒肉");
            case 3 -> System.out.println("清蒸鱼");
            case 4 -> System.out.println("可乐鸡翅");
            case 5 -> System.out.println("牛肉火锅");
            default ->System.out.println("日期输入错误");
        }
    }
}
