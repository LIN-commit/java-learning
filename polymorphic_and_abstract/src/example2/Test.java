package example2;

public class Test {
    public static void main(String[] args) {
        Person p = new Fu();
    /*
    此时p的实际类型是Fu
    但是遵循“调用方法：编译看左边，运行看右边”
    所以如果想要调用Fu类中独有而Person类中没有的方法，就要把p强制转为Fu类型
     */
        //p.fushow();
        //报错，因为Person类中没有fushow方法

        //Zi z = (Zi)p;
        //编译不会报错，但运行会报错

        //用instanceof关键字判断p是否是Fu类型
        if(p instanceof Fu){
            Fu f = (Fu)p;
        }else{
            System.out.println("请确定好类型，再进行转换");
        }
    }
}
