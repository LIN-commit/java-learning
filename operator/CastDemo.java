public class CastDemo {
    //强制类型转换
    public static void main(String[] args) {
        byte a =10;
        byte b =20;
        /*byte c =(byte)a+b;
        只强转了a，此时a是byte类型，b是int类型
         */
        byte c =(byte)(a+b);
    }
}
