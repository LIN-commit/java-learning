public class TriangleDemo {
    public static void main(String[] args) {
        int a =2;
        int b =4;
        int c =5;
        if (a+b>c && a+c>b && b+c>a){
            System.out.println("这三条边可以构成三角形");
        }else{
            System.out.println("这三条边不能构成三角形");
        }
    }
}
