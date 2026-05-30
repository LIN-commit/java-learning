package final_test2;

public class Circle {
    //属性
    //私有成员变量
    private int r;
    //常量圆周率，final修饰不可修改
    private final double PI = 3.14;

    //空参构造方法，Javabean强制要求
    public Circle() {
    }
    //带参构造方法，（调用set校验数据）
    public Circle(int r) {
        setR(r);
    }

    public void setR(int r) {
        if(r>0){
            this.r = r;
        }else{
            System.out.println("错误提示：半径不能小于等于0");
            //非法值默认赋值合法值，避免计算出错
            this.r= 1;
        }
    }

    public int getR() {
        return r;
    }

    //行为
    //面积
    public double circleArea(){
        double area = PI*r*r;
        return area;
    }
    //周长
    public double circlePerimeter(){
        double perimeter = 2*PI*r;
        return perimeter;
    }
}
