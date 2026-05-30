package train;

public class RemoveDemo1 {
    //给你一个数组nums和一个值val，你需要删除所有数值等于val的元素
    /*
    举例1:
    输入：nums = [3,2,2,3] val = 3;
    输出：nums = [2,2] 剩余2个元素
    举例2：
    输入：nums = [0,1,2,2,3,0,4,2] val = 2
    输出：nums = [0,1,3,0,4] 剩余5个元素
     */
    //方法一：创建新数组，存放数值不等于val的数据
    public static void main(String[] args) {

        //定义原数组
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;

        //统计原数组中有多少数不低于val
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=val){
                count++;
            }
        }
        //定义一个新数组
        int[] arr = new int[count];
        //定义一个索引，用于在新数组中存放数据
        int index =0;
        //移除数值和val相同的数据
        for (int j = 0; j < nums.length; j++) {
            if(nums[j]!=val){
                arr[index]=nums[j];
                index++;
            }
        }
        //遍历打印新数组
        for (int k = 0; k < arr.length; k++) {
            System.out.print(arr[k]+" ");
        }
    }
}
