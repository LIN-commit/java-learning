public class PointerDemo {
    public static void main(String[] args) {
        //定义一个递增有序数组，去除其中重复元素
        int[] arr={1,2,2,2,2,2,3,3,3,3};
        //定义两个指针
        int slow =0;
        int fast =1;
        //利用循环不断的移动快慢指针，找不同元素
        while(fast<arr.length){
            //判断两个指针指向数据是否相同
            if(arr[slow]!=arr[fast]){
                //不同
                slow++;
                arr[slow]=arr[fast];
            }
            fast++;
        }
        //输出结果
        for (int i = 0; i <=slow; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
