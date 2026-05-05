import java.util.Scanner;

public class SwitchCasePenetration {
    public static void main(String[] args) {
        //键盘录入日期
        System.out.println("输入今天的星期数(1~5)：");
        Scanner sc = new Scanner(System.in);
        int weekday = sc.nextInt();

        //case穿透
        switch(weekday){
            case 1:
            case 2:
            case 3:
                System.out.println("米饭");
                break;
            case 4:
            case 5:
                System.out.println("面条");
                break;
            default :
                System.out.println("日期输入错误");
                break;
        }
    }
}
