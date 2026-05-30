package enum_test1;

public class OrderTest {
    public static void main(String[] args) {
        /*
        电商项目中，订单状态只有以下6种，请编写代码实现
        待支付 PAYMENT_PENDING
        处理中 PROCAEEING
        已发货 SHIPPED
        配送中 OUT_FOR_DELIVERY
        已送达 DELIVERED
        已取消 CANCELLED
         */
        OrderState o1 = OrderState.PAYMENT_PENDING;
        System.out.println(o1);
        System.out.println(o1.getName());
        System.out.println("---------------");

        //用switch语句匹配合适的订单状态
        switch(o1){
            case PAYMENT_PENDING-> System.out.println("待支付");
            case PROCAEEING-> System.out.println("处理中");
            case SHIPPED-> System.out.println("已发货");
            case OUT_FOR_DELIVERY-> System.out.println("配送中");
            case DELIVERED-> System.out.println("已送达");
            case CANCELLED-> System.out.println("已取消");
        }
    }
}
