public class TrapezoidDemo2 {
    //通过拼接法打印梯形
    public static void main(String[] args) {
        for(int line = 1; line<=3 ; line++){
            //打印左上角的红色部分，再把*换成空格
            for (int i = line; i<=2;i++)
                System.out.print(" ");
            //打印蓝色的直角三角形部分
            for (int j = 1;j<=line;j++)
                System.out.print("*");
            //打印中间绿色部分
            System.out.print("*");
            //打印蓝色的直角三角形部分
            for (int k = 1;k<=line;k++)
                System.out.print("*");
            //右上角的红色部分是空格，直接忽略
            //换行
            System.out.println();
        }
    }
}
