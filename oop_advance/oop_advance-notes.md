- [面向对象原理](#面向对象原理)
    - [Java中对象的内存分配](#java中对象的内存分配)
    - [对象在方法中进行传递](#对象在方法中进行传递)
    - [this的本质](#this的本质)
- [面向对象进阶](#面向对象进阶)
    - [static修饰成员变量](#static修饰成员变量)
        - [特点](#特点)
        - [调用方式](#调用方式)
        - [示例](#示例)
        - [static静态变量的内存](#static静态变量的内存)
    - [工具类](#工具类)
        - [工具类的定义](#工具类的定义)
        - [小贴士：](#小贴士)
        - [工具类的书写方式](#工具类的书写方式)
    - [static修饰成员方法](#static修饰成员方法)
        - [特点](#特点-1)
        - [调用方法](#调用方法)
        - [练习](#练习)
        - [静态的注意事项](#静态的注意事项)
    - [final关键字](#final关键字)
        - [final修饰变量](#final修饰变量)
        - [细节](#细节)
        - [示例1](#示例1)
        - [示例2](#示例2)
        - [示例3](#示例3)
        - [练习](#练习-1)
    - [枚举](#枚举)
        - [什么是枚举](#什么是枚举)
        - [枚举的定义格式](#枚举的定义格式)
        - [练习](#练习-2)
        - [枚举的注意事项](#枚举的注意事项)
        - [示例](#示例-1)

配套完整代码：GitHub仓库  
<https://github.com/LIN-commit/java-learning>  
代码所在目录：java-learning/oop_advance/
# 面向对象原理
## Java中对象的内存分配
- **创建对象的七步**  
  `Student stu = new Student();`  
  1.加载class字节码文件  
  2.申明等号左边的局部变量  
  3.在堆里面开辟一个空间（对象）  
  4.给对象中的属性进行默认初始化  
  5.给对象中的属性进行显示初始化  
  6.给对象中的属性利用构造方法进行初始化  
  7.把对象的内存地址赋值给等号左边的变量
- **方法出栈之后，方法里面的变量全部消失**
- **如果没有任何地方使用堆里面的对象，那么对象也会从堆里面消失**
- **方法区里面的字节码信息一般不会消失，除非关闭虚拟机**
## 对象在方法中进行传递
- 把一个对象传递给方法，实际传递的是什么？  
  **传递的是对象的内存地址**
- 当多个变量指向同一个对象的时候，会发生什么？  
  **只要有一个变量修改了对象中的属性，其他变量再次访问就是修改之后的结果了**
## this的本质
this的本质是**代表所在方法调用者的内存地址**
# 面向对象进阶
## static修饰成员变量
### 特点
**叫作静态变量，被该类所有对象共享**
### 调用方式
方式一：**类名调用**（推荐使用方式一）  
方式二：**对象名调用**
### 示例
**题目：学生有属性：姓名，年龄，老师。  
一个班级中，所有学生都共享同一个老师。  
第一个学生：小诗，19岁  
第二个学生：小丹，20岁  
最初是小雯老师上课，有一天小丹申请换老师，换成了小林老师。  
利用static模拟上述效果**  
对应package: **oop_advance_test1**
对应代码：
- **Student1.java**
- **StudentDemo1.java**

**Javabean类**
  ```java
  package oop_advance_test1;

public class Student1 {
    //属性
    //加static的特点是这个变量是共享的
    String name;
    int age;
    static String teacher;
}
  ```
**测试类**
  ```java
package oop_advance_test1;

public class StudentDemo1 {
    /*
    学生有属性：姓名，年龄，老师。
  一个班级中，所有学生都共享同一个老师。
  第一个学生：小诗，19岁
  第二个学生：小丹，20岁
  最初是小雯老师上课，有一天小丹申请换老师，换成了小林老师。
  利用static模拟上述效果
     */
    public static void main(String[] args) {
        Student1 s = new Student1();
        s.name = "小诗";
        s.age = 19;

        //调用静态变量teacher
        //方式一：类名调用
        Student1.teacher = "小雯老师";
        //方式二：对象名调用
        s.teacher = "小雯老师";

        //创建第二个学生
        Student1 ss= new Student1();
        ss.name = "小丹";
        ss.age = 20;
        //打印
        System.out.println(s.name+","+s.age+","+s.teacher);
        System.out.println(ss.name+","+ss.age+","+ss.teacher);

        System.out.println();

        //更换老师
        Student1.teacher = "小林老师";
        //打印
        System.out.println(s.name+","+s.age+","+s.teacher);
        System.out.println(ss.name+","+ss.age+","+ss.teacher);

    }
}

  ```
[运行结果]
```text
小诗,19,小雯老师
小丹,20,小雯老师

小诗,19,小林老师
小丹,20,小林老师
```
### static静态变量的内存
**在内存中，静态变量是随着类的加载而加载，优先于对象而存在**
## 工具类
### 工具类的定义
不是用来描述一类事物的，也没有main方法，而是帮我们做一些事情的类  
**举例**：  
我们之前写过创建一个数组，然后“遍历数组，求最大值，求最小值”，为了代码方便我们就把这些提取为方法，写在main方法外。但是如果在其他类中也想调用这些方法呢？所以我们可以把这些方法“遍历数组，求最大值，求最小值”提取出来，放到工具类中，让其他类也可以调用
```java
public class Test{
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5};
    }
    遍历数组
    求最大值
    求最小值
}
```
将这些方法提取到工具类
```java
public class ArrTest{
    遍历数组
    求最大值
    求最小值
}
```
### 小贴士：
目前我们学过三种类
- **Javabean类**：用来描述一类事物，比如之前写过的Dog类，Student类
- **测试类**：用来测试我们写的Javabean类
- **工具类**：不是用来描述一类事物的，也没有main方法，而是帮我们做一些事情的类
### 工具类的书写方式
1.类名，要见名知意  
2.私有化构造方法  
3.方法定义为静态

## static修饰成员方法
### 特点
static修饰的方法叫作静态方法，该方法多用在**测试类**和**工具类**中，Javabean类中很少用到
### 调用方法
方式一：**类名调用**  
方式二：**对象名调用**
### 练习
**题目：定义数组工具类**  
对应package：**uitl**  
对应代码：
- **ArrayUitl.java**
- **ArrayTest.java**

**工具类**
```java
package uitl;

public class ArrayUitl {
    //私有化构造方法，目的：不让外界创建对象
    private ArrayUitl(){}
    //遍历数组
    //遍历数组
    //第一种写法
        /*
    public static void printArr(int[] arr){

        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i==arr.length-1){
                System.out.println(arr[i]+"]");
            }else{
                System.out.print(arr[i]+", ");
            }
        }
    }
    */

     //第二种写法
    public static String printArr(int[] arr){
        String result = "[";
            for (int i = 0; i < arr.length; i++) {
                if (i==arr.length-1){
                    result = result +arr[i]+"]";
                }else{
                    result = result+arr[i]+", ";
                }
            }
            return result ;
        }

    //求平均值
    public static double getAverage(int[] arr){
        double sum = 0.0;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
        }
        return sum/arr.length;
    }

}

```
**测试类**
```java
package uitl;

public class ArrayTest {
    /*
    需求：
    1.提供一个方法printArr，用于遍历数组
    格式如下：
    [10,20,50,34,100]
    2.提供一个方法getAverage，用于返回平均值（只考虑整数数组）
     */
    public static void main(String[] args) {
        int[] arr = {10, 20, 50, 34, 100};
        //调用工具类
        //第一种遍历数组的方法的调用
        /*
        ArrayUitl.printArr(arr);
         */

        //第二种遍历数组的方法的调用
        String res = ArrayUitl.printArr(arr);
        System.out.println(res);

        //单击方法，按ctrl+alt+v，自动生成变量名
        double average = ArrayUitl.getAverage(arr);
        System.out.println(average);
    }
}

```
[运行结果]
```text
[10, 20, 50, 34, 100]
42.8
```
### 静态的注意事项
- 静态方法只能访问**静态变量**和其他的静态方法**
```java
public class Student{
    String a;
    static String b;
    public void showA(){...}
    public static void methodA(){...}

    public static void methodB(){
        sout(a);//报错
        showA();//报错
        sout(b);
        methodA();
    }
}
```
- 非静态方法可以访问**静态变量**或**静态方法**，也可以访问**非静态的成员变量**和**非静态的成员方法**
- 静态方法中**没有this**关键字
- **总结**：静态只能调用静态，非静态可以调用所有，静态方法无this
## final关键字
- final：表示**最终，不可变**。可以修饰变量，类，方法
### final修饰变量
final修饰的变量是**常量**
特点：
- 只能赋值一次，数据不可变
- 名字大写，多个单词下划线隔开
```java
public static void main(String[] args){
    //1.定义一个常量
    final int NUMBER = 100;
    //2.使用常量
    System.out.println(NUMBER+100);
    //3.常量是不能修改的
    NUMBER = 200;//报错
}
```
### 细节
- 基本数据类型
  byte short int long float double char boolean   
  变量里记录的都是真实的数据  
  `final int a = 10;`  
  此时变量里面记录的数据无法发生改变
- 引用数据类型  
  除了上面的四类八种，其他所有的数据类型都是引用类型  
  int[] Student Teacher...  
  `final Student stu = new Student();`  
  stu里面的记录对象是内存地址，不可改变的是stu记录的内存地址，而对象里面的属性值，是可以发生改变的
### 示例1
对应package:**oop_advance_test2**  
对应代码：
- **Student2.java**
- **StudentDemo2.java**
  Javabean类
```java
package oop_advance_test2;

public class Student2 {
    private String name;
    private int age;

    public Student2() {
    }

    public Student2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

```
测试类
```java
package oop_advance_test2;

public class StudentDemo2 {
    public static void main(String[] args) {

        final Student2 STU = new Student2("张三",18);

        STU.setName("李四");
        STU.setAge(19);

        System.out.println(STU.getName());
        System.out.println(STU.getAge());
    }
}

```
[运行结果]
```text
李四
19
```
- 如果不想让name改变，也可以在private后String前加上final  
  `private final String name;`  
  这样name就只能赋值一次，且setName会报错
### 示例2
```java
package oop_advance_test2;

public class Student2 {
    private final String NAME;//报错
    private final int AGE;//报错


    public Student2() {
    }

    public Student2(String name, int age) {
        this.NAME = NAME;
        this.AGE = AGE;
    }

    public String getName() {
        return NAEM;
    }

    public int getAge() {
        return AGE;
    }


}
```
这段代码中我已经删掉了set方法，但代码`private final String NAME`以及`private final int AGE`依然会报错，问题并不在有全部参数的方法那里，因为即使是用final定义的变量，依然有一次赋值的机会  
问题在空参方法那里，空参方法相当于给变量NAME和变量AGE赋值了，所有NAME和AGE已经是默认初始值了。只要删掉空参方法，报错就会消失。我们就可以用全参方法，在测试类中给变量赋值
### 示例3
对应package：**final_test1**  
对应代码：
- **Student3.java**
- **StudentDemo3.java**
  Javabean类
```java
package final_test1;

public class Student3 {
    private final String NAME;
    private final int AGE;

    public Student3(String name, int age) {
        this.NAME = name;
        this.AGE = age;
    }

    public String getName() {
        return NAME;
    }

    public int getAge() {
        return AGE;
    }
}

```
测试类
```java
package final_test1;

public class StudentDemo3 {
    public static void main(String[] args) {

        final Student3 STU = new Student3("张三",18);


        System.out.println(STU.getName());
        System.out.println(STU.getAge());
    }
}

```
[运行结果]
```text
张三
18
```  
### 练习
**题目：定义一个Javabean类描述圆**  
属性：半径和圆周率  
行为：计算圆的面积和周长  
对应package：**final_test2**  
对应代码：
- **Circle.java**
- **CircleDemo.java**
  Javabean类
```java
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

```
测试类
```java
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

```
[运行结果]
```text
错误提示：半径不能小于等于0
当前默认修正后的半径为1
-----------------------
当前半径为2
半径为2时的面积是12.56
半径为2时的周长是12.56
-----------------------
当前半径为4
半径为4时的面积是50.24
半径为4时的周长是25.12
```
## 枚举
**注意**：对象的个数是有限个，就不能用以前的Javabean的形式
### 什么是枚举
- 枚举是一个特殊的Javabean类，这个类的对象是有限个
- 使用场景：订单的状态，月份，星期，会议室的预约状态……
### 枚举的定义格式
```text
public enum 枚举类名{
    枚举项1，枚举项2，枚举项3……；
    属性
    行为
}
```
在写枚举类的时候，我们会直接创建好所有枚举项，对象的个数有多少个，就创建多少个枚举项

在测试类中调用的时候
```text
//使用枚举对象，不要自己创建
//直接调用即可
枚举类名.枚举项；
```
### 练习
**题目：电商订单中，订单状态只有6种，请编写代码实现**  
对应package:**enum_test1**  
对应代码：
- **OrderState.java**
- **OrderTest.java**
  枚举类
```java
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
```
测试类
```java
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

```
[运行结果]
```text
PAYMENT_PENDING
待支付
---------------
待支付
```
### 枚举的注意事项
- 每一个枚举项，都是该枚举类的对象
- 枚举项在底层其实是常量，默认用public static final 修饰
- 枚举类的第一行上必须是枚举项，枚举项之间用逗号隔开，以分号作为结尾
- 枚举类的构造方法必须是private修饰，不让外界创建本类的对象
- 编译器会给枚举类新增两个默认存在的方法：values()，valueOf()
### 示例
对应package:**enum_test2**  
对应代码：
- **enum_test2.java**
- **OrderDetail.java**
  枚举类
```java
package enum_test2;

public enum enum_test2 {
    PAYMENT_PENDING("待支付"),
    PROCAEEING("处理中"),
    SHIPPED("已发货"),
    OUT_FOR_DELIVERY("配送中"),
    DELIVERED("已送达"),
    CANCELLED("已取消");
    //在枚举类的第一行，把所有的对象都罗列出来

    private String name;
    private Order(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

```
测试类
```java
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

```
[运行结果]
```text
PAYMENT_PENDING
PROCAEEING
SHIPPED
OUT_FOR_DELIVERY
DELIVERED
CANCELLED
-------------------
SHIPPED
```
