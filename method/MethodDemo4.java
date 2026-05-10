public class MethodDemo4 {
    public static void main(String[] args) {
        printMulTable();
    }
    //定义一个方法，打印九九乘法表
    //没有参数的方法，调用的时候，实参也是空着
    public static void printMulTable(){
        for (int i = 1; i <=9; i++) {
           for (int j = 1; j<=i;j++){
               System.out.print(j+"*"+i+"="+j*i+"\t");
           }
            System.out.println();
        }
    }
}
