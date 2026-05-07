public class PreDemo {
    //前置练习：交换两个变量的值
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        //借助第三方变量
        int temp = a;
        a = b;
        b = temp;
        System.out.println(a);
        System.out.println(b);
    }
}
