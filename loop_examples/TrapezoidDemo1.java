public class TrapezoidDemo1 {
    //找到外循环和内循环之间的规律，打印梯形
    public static void main(String[] args) {
        for (int line =1;line<=3;line++){
            for (int blank =line;blank<=2;blank++)
                System.out.print(" ");//先打印每一行开始的空格

            for (int column =1;column<=2*line+1;column++)
                System.out.print("*");//再打印图案
            System.out.println();//换行
        }
    }
}
