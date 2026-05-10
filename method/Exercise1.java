import java.util.Scanner;

public class Exercise1 {
    //跳水比赛
    public static void main(String[] args) {
        //键盘录入分数，存入数组
        Scanner sc = new Scanner (System.in);
        int[] arr = new int[5];
        int sum =0;
        for (int i = 0; i < 5; ) {
            System.out.println("第"+(i+1)+"位评委请打分：");
            int num = sc.nextInt();
            if (num>=0 && num<=100){
                arr[i]=num;
                sum=sum+num;
                i++;
            }else{
                System.out.println("分数超出范围，请重新打分");
            }
        }
        int max =getMax(arr);
        int min =getMin(arr);
        int score = (sum-max-min)/3;
        System.out.println("选手的最终评分："+score);
    }
    //定义方法，求数组中的最大值
    public static int getMax (int[] arr){
        //定义一个变量，默认为数组的第一个值
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>max)
                max=arr[i];
        }
        return max;
    }
    //定义一个方法，求数组中的最小值
    public static int getMin (int[] arr){
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]<min)
                min=arr[i];
        }
        return min;
    }
}
