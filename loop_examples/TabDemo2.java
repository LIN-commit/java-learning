public class TabDemo2 {
    //制表符补空格的示例
    public static void main(String[] args) {
        //制表符会把在自己前面的字符和补的空格看做一个整体，这个整体的长度必须是4的倍数
        System.out.println("***\t***");//制表符会补一个空格
        System.out.println("**\t**");//制表符会补两个空格
        System.out.println("****\t**");//制表符会补四个空格
    }
}
