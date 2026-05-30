package uitl;

public class ArrayTest {
    /*
    需求：
    1.提供一个方法printArr，用于遍历数组
    格式如下：
    [10,20,50,34,100]
    2.提供一个方法getAverage，用于返回平均值（只考虑整数数组）
     */
    public static void main(String[] args) {
        int[] arr = {10, 20, 50, 34, 100};
        //调用工具类
        //第一种遍历数组的方法的调用
        /*
        ArrayUitl.printArr(arr);
         */

        //第二种遍历数组的方法的调用
        String res = ArrayUitl.printArr(arr);
        System.out.println(res);

        //单击方法，按ctrl+alt+v，自动生成变量名
        double average = ArrayUitl.getAverage(arr);
        System.out.println(average);
    }
}
