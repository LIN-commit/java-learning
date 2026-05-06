public class ParallelogramDemo2 {
    //通过拼接法打印平行四边形
    public static void main(String[] args) {
        for(int line =1;line<=3;line++){
            //先打印左上角的红色部分，把*换成空格
            for(int i =line;i<=2;i++)
                System.out.print(" ");
            //再打印绿色的直角三角形
            for(int j =1;j<=line;j++)
                System.out.print("*");
            //接着打印蓝色的正方形部分
            for(int k =1;k<=3;k++)
                System.out.print("*");
            //最后打印青色部分的三角形,和开始的红色部分一样
            for(int i =line;i<=2;i++)
                System.out.print("*");
            System.out.println();
        }
    }
}
