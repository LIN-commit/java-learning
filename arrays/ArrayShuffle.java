import java.util.Random;

public class ArrayShuffle {
    //已知数组为{1,2,3,4,5,6,7,8,9,10}，打乱数组的数据
    /*
    思路：
    第一步：0索引上的数据，跟随机位置上的数据进行交换
    第二步：1索引上的数据，跟随机位置上的数据进行交换
    重复上面过程
     */
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        Random r = new Random();
        //遍历数组
        for (int i = 0; i < arr.length; i++) {
            //获取一个随机索引
            int randomIndex = r.nextInt(arr.length);
            //拿索引i的元素，和随机索引上的数据交换
            int temp = arr[i];
            arr[i]=arr[randomIndex];
            arr[randomIndex]=temp;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
