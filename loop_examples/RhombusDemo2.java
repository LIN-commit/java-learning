public class RhombusDemo2 {
    //运用拼接法打印菱形
    //将菱形分为上半部分4行，下半部分3行
    public static void main(String[] args) {
        //上半部分
        for (int line1 = 1;line1 <=4;line1++) {
            //打印左上角红色部分，再把*换成空格
            for (int i =line1;i<=3;i++)
                System.out.print(" ");
            //打印蓝色直角三角形部分
            for (int j = 1;j<=line1;j++)
                System.out.print("*");
            //打印绿色直角三角形部分
            for (int k =1;k<=line1-1;k++)
                System.out.print("*");
            //换行
            System.out.println();
        }
        //下半部分
        for(int line2 = 1;line2<=3;line2++){
            //打印左下角红色部分
            for (int m =1;m<=line2;m++)
                System.out.print(" ");
            //打印蓝色倒直角三角形部分
            for (int n =line2;n<=3;n++)
                System.out.print("*");
            //打印黄色倒直角三角形部分
            for (int p =line2;p<=2;p++)
                System.out.print("*");
            //换行
            System.out.println();
        }
    }
}
