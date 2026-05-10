public class MethodDemo1 {
    //定义一个方法，求两个数的和
    /*
    方法的定义格式：
    public static 返回值类型 方法名 （参数1，参数2……）{
                方法体；
                return 返回值；
    }
  方法的调用格式：
      方法名（参数1，参数2……）；
     */

    public static void main(String[] args) {
        int add = getSum (10,20);
        System.out.println(add);//可以将方法的结果赋值给变量
        System.out.println(getSum(10,20));//也可以直接打印这个方法的结果
    }
    public static int getSum (int a,int b){
        int sum = a + b;
        return sum;
        //return的作用：（1）结束方法的运行（2）把结果返回给方法的调用处
    }
}
 /*注意：
      1.方法和方法之间是平级关系，不能互相嵌套
      2.方法是不会主动运行的，需要被调用才可以
      3.小括号中的参数需要一一对应（个数，类型）
*/