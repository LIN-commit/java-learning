import java.util.Random;

public class MethodDemo2 {
    /*
    去除重复元素。
    获取10个1~100之间的随机数并存入到数组当中，要求数据是唯一的
     */
    public static void main(String[] args) {
        //创建数组
        int[] arr = new int[10];
        //生成随机数
        Random r = new Random();
        for (int i = 0; i < arr.length; ) {
            int num = r.nextInt(100)+1;
            //对num进行判断，存在--不存，不存在--存入
            //调用方法
            boolean flag = contains(num,arr);
            if (!flag){
                arr[i]=num;
                i++;
            }
        }
        //遍历打印数组
        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j]+" ");
        }
    }
    //定义一个方法，判断num在数组arr中是否存在
    public static boolean contains (int num,int[] arr){
        for (int i = 0; i < arr.length; i++) {
            if (num==arr[i]){
                //如果遇到符合条件的，直接返回true
                //此时方法结束
                return true;
            }
        }
        return false;
        //如果循环结束了，数组里面所有的元素都判断完毕了，还没有找到一样的数据，直接返回false，表示num在arr中不存在的
    }
}
