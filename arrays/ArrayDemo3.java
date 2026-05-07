public class ArrayDemo3 {
    //数组遍历
    public static void main(String[] args) {
        int[] arr={10,20,30,40,50};
        //利用循环遍历数组
        for (int i = 0; i <= 4; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        //如果数组长度是未知
        //利用length获取数组长度
        System.out.println(arr.length);
        //遍历数组
        for (int j =0; j<=arr.length-1;j++)
            System.out.print(arr[j]+" ");

    }
}
