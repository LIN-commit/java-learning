import java.util.Random;
import java.util.Scanner;

public class NumberGuess {
    //猜数字经典例题
    public static void main(String[] args) {
        //生成一个在1~10之间的随机数
        Random r = new Random();
        int num = r.nextInt(1,11);
        //循环猜数，直到猜中为止
        int guessNumber =0;//变量命名的规则，第一个单词首字母小写，之后的单词首字母全部大写
        while (true){
            System.out.println("输入你猜的数：");
            Scanner sc =new Scanner(System.in);
            guessNumber =sc.nextInt();
            //提示猜的数偏大还是偏小
            if(guessNumber<num)
                System.out.println("猜的数偏小");
            else if(guessNumber>num)
                System.out.println("猜的数偏大");
            else{
                System.out.println("猜对了");
                break;
            }
        }
    }
}
