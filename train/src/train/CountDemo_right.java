package train;

import java.util.Random;

public class CountDemo_right {
    /*
    修改代码，让代码可以输出票数并列第一的两位候选人
     */
    public static void main(String[] args) {
        //生成随机投票序号
        Random r = new Random();
        //定义一个数组，索引0表示弃票，索引1~5表示每个候选人的得票数
        int[] arr = new int[6];
        //随机生成序号，存入数组
        for (int i = 0; i < 20; i++) {
            int vote = r.nextInt(6);
            arr[vote]++;
        }
        //此时数组中记录的是每一位候选人的得票数
        for (int i = 0; i < arr.length; i++) {
            if(i==0){
                System.out.println("弃票数是"+arr[i]);
                System.out.println("弃票率是"+arr[i]/20.0);//如果不是20.0，则结果就是整数
            }
            else{
                System.out.println("第"+i+"位候选人的得票数是"+arr[i]);
                System.out.println("第"+i+"位候选人的得票率是"+arr[i]/20.0);
            }
        }
        //===========重点，找最高票（支持并列）============
        //第一步，先找到最高票数
        int max = arr[1];
        int index = 1;
        for (int j = 1; j < arr.length; j++) {
            if (max<arr[j]){
                max = arr[j];
                index=j;
            }
        }
        //第二步，把所有票数==max的候选人都找出来
        System.out.println("得票数最多的候选人是：");
        for (int k = 0; k < arr.length; k++) {
            if (arr[k]==max){
                System.out.println(k+"号");
            }
        }
    }
}
