import java.util.Random;

public class OnlyDemo_error {
    //生成随机数并存入数组，要求数据是唯一的
    /*
    思路：
    如果存在，就不存，继续生成下一个随机数
    如果不存在，就存入数组当中
     */
    public static void main(String[] args) {
        int[] arr = new int[10];
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
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
            }
        }
        for (int k = 0; k < arr.length; k++)
            System.out.print(arr[k]+" ");
    }
}
