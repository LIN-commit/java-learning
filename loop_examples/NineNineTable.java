public class NineNineTable {
    //打印九九乘法表
    public static void main(String[] args) {
        for (int line =1; line<=9; line++){
            for (int column =1; column<=line; column++)
                System.out.print(column+"*"+line+"="+(column*line)+"\t");
            //\t是制表符，作用是让每一列对齐
            System.out.println();
        }
    }
}
