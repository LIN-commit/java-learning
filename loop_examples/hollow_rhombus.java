public class hollow_rhombus {
    //运用拼接法打印空心菱形
    public static void main(String[] args) {
        //图形分为上下两部分，上半部分4行，下半部分3行
        //上半部分
        for (int line1 =1;line1<=4;line1++){
            //打印左上角的红色部分
            for (int i =line1; i<=3; i++)
                System.out.print(" ");
            //打印黑色左边部分
            System.out.print("*");
            //打印绿色部分
            for (int j =1;j<=line1-1;j++)
                System.out.print(" ");
            //打印黄色部分
            for (int k =1;k<=line1-2;k++)
                System.out.print(" ");
            //打印黑色右边部分
            if (line1!=1)//用判断语句跳过第一行的打印
                System.out.print("*");
            //换行
            System.out.println();
        }
        //下半部分
        for (int line2 =1; line2<=3; line2++){
            //打印左下角的红色部分
            for (int m = 1; m<=line2; m++)
                System.out.print(" ");
            //打印左边黑色部分
            System.out.print("*");
            //打印蓝色倒三角形
            for (int n =line2; n<=2; n++)
                System.out.print(" ");
            //打印灰色部分
            if (line2==1)
                System.out.print(" ");
            //打印右边黑色部分
            if (line2!=3)
                System.out.print("*");
            //换行
            System.out.println();
        }
    }
}
