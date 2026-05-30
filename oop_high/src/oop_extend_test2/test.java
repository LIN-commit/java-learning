package oop_extend_test2;

public class test {
    public static void main(String[] args) {
        Android p1 = new Android();
        p1.brand ="安卓";
        p1.price =1999 ;
        System.out.println(p1.brand+","+p1.price);
        p1.call();
        p1.information();
        p1.nfc();
        System.out.println("-------------");
        Apple p2 = new Apple();
        p2.brand = "苹果";
        p2.price = 5999;
        System.out.println(p2.brand+","+p2.price);
        p2.call();
        p2.information();
        System.out.println("-------------");
        Laptop l = new Laptop();
        l.brand = "拯救者";
        l.price =10000 ;
        System.out.println(l.brand+","+l.price);
        l.code();
    }
}
