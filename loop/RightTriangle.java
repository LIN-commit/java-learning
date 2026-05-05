public class RightTriangle {
    //打印直角三角形
    public static void main(String[] args) {
        for(int line =1;line<=4;line++){
            for (int column =1;column<=line;column++)//内层循环的条件可以依赖外层循环的变量
                System.out.print("*");
            System.out.println();
        }
    }
}
