public class SumDemo2 {
    //两数之和
    //输出所有满足要求的情况
    public static void main(String[] args) {
        //定义数组
        int[] arr = {2,7,11,15,1,8};
        int target =9;
        int count =0;
        //用变量定义一个慢指针
        int low = 0;
        while(low<arr.length-1){
            int fast = low+1;
            while(fast<arr.length){
                if(arr[low]+arr[fast]==target){
                    System.out.println(low+","+fast);
                    count++;
                }
                fast++;
            }
            low++;
        }
        if (count==0)
            System.out.println("没有和为"+target+"的索引对");
    }

}
