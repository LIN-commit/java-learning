public class MergeArray {
    //合并有序数组
    public static void main(String[] args) {
        //定义两个数组
        int[] arr1 = {1,3,5,7,9};
        int[] arr2 = {2,4,6,8,10};
        //定义一个动态初始化数组
        int[] arr3 = new int[arr1.length+arr2.length];
       int i = 0;//arr3的指针
       int p1 = 0;//arr1的指针
       int p2 = 0;//arr2的指针
        //合并两个有序数组
        while(p1 < arr1.length && p2 < arr2.length){
            if (arr1[p1] <= arr2[p2]){
                arr3[i]=arr1[p1];
                p1++;
            }else{
                arr3[i] = arr2[p2];
                p2++;
            }
            i++;
        }
        //如果arr1和arr2的长度不一样，那么要么p1会有剩余，要么p2会有剩余
        //处理arr1中剩余的元素
        while (p1 < arr1.length){
            arr3[i]=arr1[p1];
            p1++;
            i++;
        }
        //处理arr2中剩余的元素
        while (p2 < arr2.length){
            arr3[i]=arr2[p2];
            p2++;
            i++;
        }
        for (int j = 0;  j< arr3.length; j++) {
            System.out.print(arr3[j]+" ");
        }
    }
}
