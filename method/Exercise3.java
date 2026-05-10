import java.util.Scanner;

public class Exercise3 {
    //计算快递邮费
    public static void main(String[] args) {
        //录入快递重量
        Scanner sc = new Scanner(System.in);
        boolean flag =true;
        double weigh =0;
        while(flag){
            System.out.println("输入快递重量(kg)：");
            weigh = sc.nextDouble();
            if (weigh>0){
                flag = false;
            }
            else
                System.out.println("快递重量必须大于0，重新输入");
        }
        System.out.println("邮费"+getPrice(weigh)+"元");
    }
    //定义方法计算邮费
    public static double getPrice(double weigh){
        double price=0;
        int weight =(int) Math.ceil(weigh);//Math.ceil(double a)的作用是向上取整
        if(weight<=1){
            price =10;
        }else if (weight<=5){
            price = 10+(weight-1)*2;
        }else
            price = 18+(weight-5)*1.5;
        return price;
    }
}
