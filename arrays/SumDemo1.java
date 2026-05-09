public class SumDemo1 {
    //两数之和
    //只要输出第一对满足要求的情况
    public static void main(String[] args) {
        //定义数组
        int[] arr={2,7,11,15};
        int target = 9;
        //定义一个变量作为慢指针
        int low =0;
       while(low<arr.length-1){
           int fast = low+1;//fast在每一轮都要重置
        while(fast<arr.length) {
            if (arr[low] + arr[fast] == target) {
                System.out.println(low+","+fast);
                return;//找到第一对满足条件的结果后，直接结束整个main
            }
                fast++;
        }
        low++;
       }
        System.out.println("没有和为"+target+"的索引对");
    }
}
