import java.util.Scanner;

public class SwitchResultDemo {
    public static void main(String[] args) {
        //键盘录入日期
        System.out.println("输入今天的星期数(1~5)：");
        Scanner sc = new Scanner(System.in);
        int weekday = sc.nextInt();

        //switch可以有运行结果
        String food = switch(weekday){
            case 1,2,3->{
                yield"米饭";
            }
            case 4,5->{
                yield"面条";
            }
            default ->{
                yield"日期输入错误";
            }
        };
        System.out.println(food);
    }
}
