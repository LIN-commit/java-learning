package enum_test2;

public class OrderDetail {
    public static void main(String[] args) {
        //values():表示获取本类所有的枚举项

        Order[] arr = Order.values();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        System.out.println("-------------------");

        //valueOf():表示获取一个指定的枚举项
        Order shipped = Order.valueOf("SHIPPED");
        System.out.println(shipped);
    }
}
