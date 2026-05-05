public class PrintPattern {
    //打印一个4行5列的图形
    public static void main(String[] args) {
        for (int line =1;line<=4;line++){
            for (int column =1;column<=5;column++){
                System.out.print("*");
            }
            System.out.println();//换行
        }
    }
}
