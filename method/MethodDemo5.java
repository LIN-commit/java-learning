public class MethodDemo5 {
    public static void main(String[] args) {
        //求两个小数的和
        System.out.println(sum(1.2,3.4));
    }

    //求两个整数的和
    public static int sum(int a, int b) {
        return a + b;
    }

    //求三个整数的和
    public static int sum(int a, int b, int c) {
        return a + b + c;
    }

    //求两个小数的和
    public static double sum(double a, double b) {
        return a + b;
    }
}