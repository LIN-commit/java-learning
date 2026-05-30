package train;

public class RemoveDemo2 {
    //给你一个数组nums和一个值val，你需要删除所有数值等于val的元素
    /*
    举例1:
    输入：nums = [3,2,2,3] val = 3;
    输出：nums = [2,2] 剩余2个元素
    举例2：
    输入：nums = [0,1,2,2,3,0,4,2] val = 2
    输出：nums = [0,1,3,0,4] 剩余5个元素
     */
    //方法二：创建两个指针，在数组上直接修改
    public static void main(String[] args) {
        //定义数组
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        //定义两个数组
        int fast = 0;//用于遍历整个数组
        int slow = 0;//用于存入数据
        //遍历数组
        for ( fast = 0; fast < nums.length; fast++) {
            if(nums[fast]!=val){
                nums[slow]=nums[fast];
                slow++;
            }
        }
        for (int i = 0; i < slow; i++) {
            System.out.print(nums[i]+" ");
        }
    }
}
