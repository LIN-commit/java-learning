import java.util.Random;

public class OnlyDemo_right {
    //生成随机数并存入数组，要求数据是唯一的
   /*之前的代码OnlyDemo_error.java中
   出现重复数据，数组会填入默认值0，这是不符合题目需求的
    */
    public static void main(String[] args) {
        int arr[] = new int[10];
        Random r = new Random();
        for (int i = 0; i < arr.length; )//java中的for循环语句非常灵活，三部分都可以省略
        {
            int num = r.nextInt(100)+1;//范围是1~100
            //对num进行判断，存在--不存，不存在--存入
            int count =0;
            for (int j = 0;  j< arr.length; j++) {
                if (num==arr[j]){
                    count++;
                    break;
                }
            }
            if (count==0) {
                arr[i] = num;
                i++;//for循环的条件控制语句写在这里，只有存入数据i才会加1
            }
        }
        for (int k = 0; k < arr.length; k++)
            System.out.print(arr[k]+" ");
    }
}
