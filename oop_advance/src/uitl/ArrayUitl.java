package uitl;

public class ArrayUitl {
    //私有化构造方法，目的：不让外界创建对象
    private ArrayUitl(){}
    //遍历数组
    //遍历数组
    //第一种写法
        /*
    public static void printArr(int[] arr){

        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i==arr.length-1){
                System.out.println(arr[i]+"]");
            }else{
                System.out.print(arr[i]+", ");
            }
        }
    }
    */

     //第二种写法
    public static String printArr(int[] arr){
        String result = "[";
            for (int i = 0; i < arr.length; i++) {
                if (i==arr.length-1){
                    result = result +arr[i]+"]";
                }else{
                    result = result+arr[i]+", ";
                }
            }
            return result ;
        }

    //求平均值
    public static double getAverage(int[] arr){
        double sum = 0.0;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
        }
        return sum/arr.length;
    }

}
