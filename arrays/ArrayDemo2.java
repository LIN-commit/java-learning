public class ArrayDemo2 {
    //数组中的元素访问：获取、修改
    public static void main(String[] args) {
        //利用静态初始化创建数组
        int[] arr = {10,20,30,40,50};
        //获取数组中的元素
        int num = arr[0];
        System.out.println(num);
        System.out.println(arr[0]);
        //修改数组中的元素
        arr[1]=100;
        System.out.println(arr[1]);
    }
}
