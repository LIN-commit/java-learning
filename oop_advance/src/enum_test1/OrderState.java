package enum_test1;

public enum OrderState {
    PAYMENT_PENDING("待支付"),
    PROCAEEING("处理中"),
    SHIPPED("已发货"),
    OUT_FOR_DELIVERY("配送中"),
    DELIVERED("已送达"),
    CANCELLED("已取消");
    //在枚举类的第一行，把所有的对象都罗列出来

    private String name;
    private OrderState(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
