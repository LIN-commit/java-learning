public class LeetSearch {
    //查找元素
    /*
    思路：遍历数组，找到第一个nums[i]>=target的值
    如果该位置的值==target，返回该位置（找到了）
    如果该位置的值>target，返回该位置（插入位置）
    如果遍历完都没找到，说明target最大，插入到末尾
     */
    public static void main(String[] args) {
        //定义数组
        int[] nums = {1,3,5,6};
        int target = 2;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>=target){
                System.out.println(i);
                return;//如果找到了直接退出主入口
            }
        }
        //遍历完都没找到，说明target比所有元素都大，插入末尾
        System.out.println(nums.length);
    }
}
