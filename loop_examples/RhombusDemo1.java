public class RhombusDemo1 {
    //找到内循环与外循环之间的联系，打印菱形
    public static void main(String[] args) {
        //图案分为上半部分和下半部分
        //上半部分
        for (int line1=1;line1<=4;line1++) {
            for (int blank1 = 1; blank1 <= 4 - line1; blank1++)
                System.out.print(" ");//空格
            for (int column1 = 1; column1 <= line1 * 2 - 1; column1++)
                System.out.print("*");//图案
            System.out.println();//换行
        }
        //下半部分
        for (int line2 = 1; line2 <= 3; line2++) {
            for (int blank2 = 1; blank2 <= line2; blank2++)
                System.out.print(" ");
            for (int column2 = 1; column2 <= 7 - line2*2; column2++)
                System.out.print("*");
            System.out.println();
        }
    }
}
