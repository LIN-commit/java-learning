package final_test2;

public class CircleDemo {
    public static void main(String[] args) {
        //创建负数半径对象，触发校验
        Circle c2 = new Circle(-1);
        System.out.println("当前默认修正后的半径为"+c2.getR());
        System.out.println("-----------------------");
        //计算r等于2时的周长和半径
        c2.setR(2);
        System.out.println("当前半径为"+c2.getR());
        System.out.println("半径为2时的面积是"+c2.circleArea());
        System.out.println("半径为2时的周长是"+c2.circlePerimeter());
        System.out.println("-----------------------");

        //计算r等于4时的周长和半径
        c2.setR(4);
        System.out.println("当前半径为"+c2.getR());
        System.out.println("半径为4时的面积是"+c2.circleArea());
        System.out.println("半径为4时的周长是"+c2.circlePerimeter());

    }

}
