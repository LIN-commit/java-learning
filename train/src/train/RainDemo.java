package train;

public class RainDemo {
    //接雨水
    public static void main(String[] args) {
        //1.定义数组
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        //2.求右边有柱子时，雨水和柱子的总面积
        //2.1 定义数组
        int[] leftMax = new int[arr.length];
        //2.2 比较最高的柱子
        int temp = arr[0];
        //3.遍历数组
        for (int i = 1; i < arr.length; i++) {
            if (temp < arr[i]){
                leftMax[i] = arr[i];
                temp = arr[i];
            }else{
                leftMax[i] = temp;
            }
        }
        //3.求左边有柱子时，雨水和柱子的总面积
        int[] rightMax = new int[arr.length];
        temp = arr[arr.length-1];
        for (int j = arr.length-1; j >=0; j--) {
            if (temp < arr[j]){
                rightMax[j]=arr[j];
                temp = arr[j];
            }
            else{
                rightMax[j]=temp;
            }
        }
        //4.求交集
        int[] result = new int[arr.length];
        for (int k = 0; k < arr.length; k++) {
            if (leftMax[k]<rightMax[k])
                result[k]=leftMax[k];
            else
                result[k]=rightMax[k];
        }
        //求雨水和柱子的总面积
        int sum =0;
        for (int i = 0; i < result.length; i++) {
            sum += result[i];
        }
        //雨水面积=总面积-柱子面积
        for (int i = 0; i < arr.length; i++) {
            sum = sum - arr[i];
        }
        System.out.println(sum);

    }
}
