package train;

public class MiddleNumber {
    /*题目：给定两个正序数组arr1和arr2，
    请先合并数组，并找出合并之后数组的中位数
    示例：
    1 2 3 4 5 6 7 8 9 中位数：5
    1 2 3 4 5 6 中位数：3.5
     */
    public static void main(String[] args) {
        //定义数组
        int[] arr1 = {3,4,5,6};
        int[] arr2 = {1,2};
        //定义一个新数组，用于存放合并后的数据
        int[] newArr = new int[arr1.length+arr2.length];
        //定义两个指针,用于比较两个数组的值
        int p1 = 0;
        int p2 = 0;
        //定义新数组的索引
        int index = 0;
        while(p1<arr1.length && p2<arr2.length){
            if (arr1[p1]<arr2[p2]){
                newArr[index]=arr1[p1];
                p1++;
            }else{
                newArr[index]=arr2[p2];
                p2++;
            }
            index++;
        }
        //处理arr1剩余的数据
        while(p1<arr1.length){
            newArr[index]=arr1[p1];
            p1++;
            index++;
        }
        //处理arr2剩余的数据
        while(p2<arr2.length){
            newArr[index]=arr2[p2];
            p2++;
            index++;
        }
        //打印合并后的数组
        for (int i = 0; i < newArr.length; i++) {
            System.out.print(newArr[i]+" ");
        }
        if(newArr.length%2==0){
            double num = (newArr[newArr.length/2-1]+newArr[newArr.length/2])/2.0;
            /*如果只是把num数据类型改为double，结果变为3.0
            在计算过程中出现小数，结果才是3.5
            所以把2改为2.0
             */
            System.out.println("中位数是"+num);
        }else{
            System.out.println("中位数是"+newArr[(newArr.length-1)/2]);
        }
    }
}
