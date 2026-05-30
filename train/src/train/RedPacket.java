package train;

import java.util.Random;

public class RedPacket {
    /*
    题目：给你两个整数M和N，M表示红包的总额，N表示红包的个数。
    现在有N个人来抽红包，每个红包的金额都是随机的，打印每个人领的红包金额
     要求一：每个人最少一块钱
     要求二：每个人领完红包后，至少预留1*（未抽红包人数）元钱
     要求三：最后一个人那剩余总金额
     */
    public static void main(String[] args) {
        //生成随机数
        Random r = new Random();
        int n = 5;//红包个数
        int m = 100;//红包总金额
        //循环打印红包金额
        for (int i = 1; i <= (n-1); i++) {
            int k = n-i;
            int max = m-k;//每个红包金额不能为0，所以至少为未抽红包的人，每人留下一元
             int money = r.nextInt(max)+1;
             m-=money;
            System.out.println("第"+i+"个红包金额为"+money);
        }
        System.out.println("第"+n+"个红包金额为"+m);
    }
}
