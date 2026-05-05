import java.util.Scanner;

public class ArrowDemo3 {
    public static void main(String[] args) {
        //键盘录入日期
        System.out.println("输入今天的星期数(1~5)：");
        Scanner sc = new Scanner(System.in);
        int weekday = sc.nextInt();

        //case箭头标签
        switch(weekday){
            case 1,2,3-> System.out.println("米饭");
            case 4,5-> System.out.println("面条");
            default -> System.out.println("日期输入错误");
        }
    }
}
