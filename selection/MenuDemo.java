import java.util.Scanner;

public class MenuDemo {
    public static void main(String[] args) {
        //键盘录入日期
        System.out.println("输入今天的星期数(1~5)：");
        Scanner sc = new Scanner(System.in);
        int weekday = sc.nextInt();

        //选择语句
        switch(weekday){
            case 1:
                System.out.println("红烧排骨");
                break;
            case 2:
                System.out.println("辣椒炒肉");
                break;
            case 3:
                System.out.println("清蒸鱼");
                break;
            case 4:
                System.out.println("可乐鸡翅");
                break;
            case 5:
                System.out.println("牛肉火锅");
                break;
            default :
                System.out.println("日期输入错误");
                break;
        }
        /*一定要考虑输入错误这种特殊情况，某些严重情况可能会导致程序卡住或者数据溢出*/
      }

}
