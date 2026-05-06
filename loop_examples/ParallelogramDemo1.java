public class ParallelogramDemo1 {
    //打印平行四边形，运用内循环和外循环之间的规律
    public static void main(String[] args) {
        for (int line =1;line<=3;line++){
            for (int blank =line;blank<=2;blank++)
                System.out.print(" ");//先打印每一行开始的空格

            for (int column =1;column<=6;column++)
                System.out.print("*");//在空格后打图案

            System.out.println();//换行
        }
    }
}
