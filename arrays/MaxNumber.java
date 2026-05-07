public class MaxNumber {
    //找出数组中的最大值并打印
    public static void main(String[] args) {
        //创建数组
        int[] arr = {33,5,22,44,55};
        //定义一个变量，默认记录第一个值
        int max = arr[0];
        //让后面的数据依次和第一个值进行比较
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]>max)
                max = arr[i];
        }
        System.out.println(max);
    }
}
