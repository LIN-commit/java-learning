import java.util.Scanner;
public class ScannerTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.println("输入第一条边的长：");
        int a = sc.nextInt();
        System.out.println("输入第二条边的长：");
        int b = sc.nextInt();
        System.out.println("输入第三条边的长：");
        int c = sc.nextInt();
        if (a+b>c && a+c>b && b+c>a){
            if (a==b && b==c)
                System.out.println("等边三角形");
            else if (a*a+b*b==c*c || b*b+c*c==a*a || a*a+c*c==b*b)
                System.out.println("直角三角形");
            else if (a==b || b==c || a==c)
                System.out.println("等腰三角形");
            else
                System.out.println("普通三角形");
        }
        else
            System.out.println("不构成三角形");
    }
}
