package train;

import java.util.Random;
import java.util.Scanner;

public class LotteryDemo {
    //用random生成中奖号码
    //用scanner键盘录入抽奖号码
    public static void main(String[] args) {
        //调用方法，生成中奖号码
       int[] lotterNumber= lotteryNumber();
        System.out.print("彩票号码是");
       print(lotterNumber);
       //调用方法，录入抽奖号码
        int[] buyNumber= buyNumber();
        System.out.print("抽奖号码是");
        print(buyNumber);
        //调用方法，判断中了几等奖
        getWinningNumber(lotterNumber,buyNumber);
    }

    //随机生成中奖号码
    public static int[] lotteryNumber(){
        Random r = new Random();
        int[] arr = new int[7];
        //生成前区号码，1~35中选5个，唯一
        for (int i = 0; i < 5; ) {
            int num = r.nextInt(1,36);
            boolean flag = contains(num,arr,0,4);
            if (!flag){
                arr[i]=num;
                i++;
            }
        }
       //生成后区号码，1~12中选2个，唯一
        for (int i = 0; i < 2; ) {
            int num = r.nextInt(1,13);
            boolean flag = contains(num,arr,5,6);
            if (!flag){
                arr[i+5]=num;
                i++;
            }
        }
        return arr;
    }
    //判断生成的号码是否唯一
    public static boolean contains (int num,int[] arr,int start,int end){
        for (int i = start; i <= end; i++) {
            if (arr[i]==num){
                return true;
            }
        }
        return false;
    }

    //键盘录入模拟抽奖
    public static int[] buyNumber(){
        Scanner sc = new Scanner (System.in);
        int[] arr = new int[7];
        //输入前区的5个抽奖号码
        for (int i = 0; i < 5; ) {
            System.out.print("请输入第"+(i+1)+"个彩票号码：");
            int num = sc.nextInt();
            //判断范围
            if (num<1||num>35){
                System.out.println("当前输入的数字不在范围当中，请重新输入");
                continue;
            }
            //判断唯一
            boolean flag = contains(num,arr,0,4);
            if(flag){
                System.out.println("当前输入的数字已存在，请重新输入");
                continue;
            }
            arr[i]=num;
            i++;
        }
        //输入后区两个抽奖号码
        for (int i = 0; i < 2; ) {
            System.out.print("请输入第"+(i+6)+"个彩票号码：");
            int num = sc.nextInt();
            //判断范围
            if (num<1||num>12){
                System.out.println("当前输入的数字不在范围当中，请重新输入");
                continue;
            }
            //判断唯一
            boolean flag = contains(num,arr,5,6);
            if (flag){
                System.out.println("当前输入的数字已存在，请重新输入");
                continue;
            }
            arr[i+5]=num;
            i++;
        }
        return arr;
    }

    //打印数组
    public static void print(int[] arr){
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if(i==arr.length-1){
                System.out.print(arr[i]);
            }else {
                System.out.print(arr[i]+",");
            }
        }
        System.out.println("]");
    }

    //判断中了几等奖
    public static void getWinningNumber(int[] arr1,int[] arr2){
        int count1 = getCount(arr1,arr2,0,4);
        int count2 = getCount(arr1,arr2,5,6);
        if (count1==5 && count2==2)
            System.out.println("中了一等奖");
        else if(count1==5 && count2==1)
            System.out.println("中了二等奖");
        else if((count1==5 && count2==0) || (count1==4 && count2==2))
            System.out.println("中了三等奖");
        else if((count1==4&&count2==1)||(count1==3&&count2==2))
            System.out.println("中了四等奖");
        else if ((count1==4 && count2==0)||(count1==3 && count2==1)||(count1==2 && count2==2))
            System.out.println("中了五等奖");
        else if ((count1==3 && count2==0)||(count1==1 && count2==2)||(count1==2 && count2==1)||(count1==0 && count2==2))
            System.out.println("中了六等奖");
        else
            System.out.println("没中奖");
    }
    //判断前区或后区中了几个球
    public static int getCount(int[] arr1,int[] arr2,int start,int end){
        int count = 0;
        for (int i = start;i<=end;i++){
            boolean flag = contains(arr2[i],arr1,start,end);
            if(flag){
                count++;
            }
        }
        return count;
    }


}
