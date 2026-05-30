package train;

import java.util.Random;

public class CountDemo_error {
    /*
    题目：学校选举学生会主席，有5个候选人。全校20名同学参与投票
    （每人一票，可以弃权，或者选1-5号）。
     投票使用Random模拟。
     0：弃权。1~5：给对应的人投票
    要求1：统计每个候选人的得票数和得票率，找出得票最多的候选人？
    要求2：统计弃票数和弃票率是多少？
     */
    /*
    思路：
    生成随机票数，将五个候选人看做一个数组，生成一个的票数序号，就给对应候选人+1
    同时还可以表示弃票，即数组索引为0时
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
        /*求得票最多的候选人，要去除弃票数
        就是先把索引1设为最大值，之后的每一个数再和它比较
         */
        int max = arr[1];
        int index = 1;
        for (int i = 0; i < arr.length; i++) {
            if(i==0){
                System.out.println("弃票数是"+arr[i]);
                System.out.println("弃票率是"+arr[i]/20.0);//如果不是20.0，则结果就是整数
            }
            else{
                System.out.println("第"+i+"位候选人的得票数是"+arr[i]);
                System.out.println("第"+i+"位候选人的得票率是"+arr[i]/20.0);
                if(max<arr[i]){
                    max = arr[i];
                    index = i;
                }
            }
        }
        System.out.println("得票最多的候选人是第"+index+"位候选人");
    }
}
