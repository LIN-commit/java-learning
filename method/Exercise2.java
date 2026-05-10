import java.util.Scanner;

public class Exercise2 {
    //计算班级分数
    public static void main(String[] args) {
        //键盘录入10名同学的成绩
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; ) {
            System.out.println("输入第"+(i+1)+"位同学的成绩：");
            int num = sc.nextInt();
            if(num>=0 && num<=100){
                arr[i]=num;
                i++;
            }else{
                System.out.println("成绩无效，请重新输入");
            }
        }
        //根据及格人数求及格率
        double passRate =(double) pass(arr)/arr.length;
        /*
        两个int类型整除得到商，结果不是0就是1；
        即使将paseeRate的类型改为double也不行
        只有将参与计算的其中一个数据的类型改为double
        */
        System.out.println("及格率为"+passRate);
        //根据总分求平均分
        int sum = getSum(arr);
        int average = sum/arr.length;
        System.out.println("平均分为"+average);
        //求最高分
        System.out.println("最高分是"+getMax(arr));
    }
    //定义方法，求及格人数
    public static int pass(int[] arr){
        int pass = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>=60)
                pass++;
        }
        return pass;
    }
    //定义方法求总分
    public static int getSum (int[] arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
        }
        return sum;
    }
    //定义方法求最大值
    public static int getMax(int[] arr){
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>max)
                max = arr[i];
        }
        return max;
    }
}
