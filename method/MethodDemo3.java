public class MethodDemo3 {
    //定义一个方法遍历数组
    /*
    遍历格式如下：
    [1,2,3,4,5]
     */
    public static void main(String[] args) {
        int[] arr ={1,2,3,4,5};
        //调用方法遍历数组
        printArr(arr);
    }
    //没有返回值，不需要把结果返回给上面的调用处，只需要打印在控制台，所以返回值类型是void
    public static void printArr(int[] arr){
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
           if (i== arr.length-1)
               System.out.print(arr[i]);
           else{
               System.out.print(arr[i]+", ");
           }
        }
        System.out.println("]");
    }
}
