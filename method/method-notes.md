- [方法](#方法)
    - [方法的定义](#方法的定义)
    - [方法的格式](#方法的格式)
        - [简单示例](#简单示例)
    - [三道经典习题](#三道经典习题)
        - [去除重复元素（LeetCode）](#去除重复元素leetcode)
        - [遍历数组](#遍历数组)
        - [打印九九乘法表](#打印九九乘法表)
    - [定义方法的小诀窍](#定义方法的小诀窍)
    - [方法的重载](#方法的重载)
        - [简单示例](#简单示例-1)
    - [习题练习](#习题练习)
        - [习题一 评委打分](#习题一-评委打分)
        - [习题二 计算班级分数](#习题二-计算班级分数)
        - [习题三 计算快递邮费](#习题三-计算快递邮费)
    - [方法的应用场景总结：](#方法的应用场景总结)

# 方法
配套完整代码：GitHub仓库  
<https://github.com/LIN-commit/java-learning>  
代码所在目录：java-learning/method/  
本节对应代码：
- MethodDemo1.java :定义一个方法，求两数之和
- MethodDemo2.java :去除重复元素
- MethodDemo3.java :定义一个方法，遍历数组
- MethodDemo4.java :定义一个方法，打印九九乘法表
- MethodDemo5.java :方法重载的简单示例
- Exercise1.java :练习题，评委打分
- Exercise2.java :练习题，计算班级分数
- Exercise3.java :计算快递邮费
## 方法的定义
- **方法**：程序中的独立功能，也是最小的执行单元
- **使用场景**：经常使用的代码打包，放在方法当中
- **好处**：提高了程序的复用性和可维护性
## 方法的格式
```text
public static 返回值类型 方法名 （参数1，参数2……）{
    方法体；
    return 返回值；
}
```
### 简单示例
```java
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
```
[运行结果]
```text
30
30
```
- `getSum(10,20);`中的`(10,20)`是实参（实际参数）
- `public static int getSum(int a,int b); `中的`(int a,int b)`是形参（形式参数）
- 实参和形参要一一对应，个数对应，类型对应
## 三道经典习题
### 去除重复元素（LeetCode）
**题目：获取10个1~100之间的随机数并存入到数组当中，要求数据是唯一的**  
对应代码：**MethDemo2.java**
```java
import java.util.Random;

public class MethodDemo2 {
    /*
    去除重复元素。
    获取10个1~100之间的随机数并存入到数组当中，要求数据是唯一的
     */
    public static void main(String[] args) {
        //创建数组
        int[] arr = new int[10];
        //生成随机数
        Random r = new Random();
        for (int i = 0; i < arr.length; ) {
            int num = r.nextInt(100)+1;
            //对num进行判断，存在--不存，不存在--存入
            //调用方法
            boolean flag = contains(num,arr);
            if (!flag){
                arr[i]=num;
                i++;
            }
        }
        //遍历打印数组
        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j]+" ");
        }
    }
    //定义一个方法，判断num在数组arr中是否存在
    public static boolean contains (int num,int[] arr){
        for (int i = 0; i < arr.length; i++) {
            if (num==arr[i]){
                //如果遇到符合条件的，直接返回true
                //此时方法结束
                return true;
            }
        }
        return false;
        //如果循环结束了，数组里面所有的元素都判断完毕了，还没有找到一样的数据，直接返回false，表示num在arr中不存在的
    }
}
```
[运行结果]
```text
35 54 3 46 100 36 99 92 51 63 
```
### 遍历数组
**题目：定义一个方法遍历数组**
```java
public class MethodDemo3 {
    //定义一个方法遍历数组
    /*
    遍历格式如下：
    [1,2,3,4,5]
     */
    public static void main(String[] args) {
        int[] arr ={1,2,3,4,5};
        //调用方法遍历数组
        printArr(arr);
    }
    //没有返回值，不需要把结果返回给上面的调用处，只需要打印在控制台，所以返回值类型是void
    public static void printArr(int[] arr){
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
           if (i== arr.length-1)
               System.out.print(arr[i]);
           else{
               System.out.print(arr[i]+", ");
           }
        }
        System.out.println("]");
    }
}
```
[运行结果]
```text
[1, 2, 3, 4, 5]
```
### 打印九九乘法表
**题目：定义一个方法，打印九九乘法表**
对应代码：****
```java
public class MethodDemo4 {
    public static void main(String[] args) {
        printMulTable();
    }
    //定义一个方法，打印九九乘法表
    //没有参数的方法，调用的时候，实参也是空着
    public static void printMulTable(){
        for (int i = 1; i < 9; i++) {
           for (int j = 1; j<=i;j++){
               System.out.print(j+"*"+i+"="+j*i+"\t");
           }
            System.out.println();
        }
    }
}
```
[运行结果]
```text
1*1=1	
1*2=2	2*2=4	
1*3=3	2*3=6	3*3=9	
1*4=4	2*4=8	3*4=12	4*4=16	
1*5=5	2*5=10	3*5=15	4*5=20	5*5=25	
1*6=6	2*6=12	3*6=18	4*6=24	5*6=30	6*6=36	
1*7=7	2*7=14	3*7=21	4*7=28	5*7=35	6*7=42	7*7=49	
1*8=8	2*8=16	3*8=24	4*8=32	5*8=40	6*8=48	7*8=56	8*8=64	
1*9=9	2*9=18	3*9=27	4*9=36	5*9=45	6*9=54	7*9=63	8*9=72	9*9=81	
```
## 定义方法的小诀窍
- 观察在大段代码中，反复使用的独立功能是什么？  
  将这个反复使用的独立功能写为方法
- 这个独立功能，需要什么参数才能完成？  
  设置形式参数
- 方法的调用处，是否需要这个独立功能的结果继续做其他事？  
  如果有返回值的需要，则要写返回值类型；如果没有返回值的需要，则返回值类型为void
## 方法的重载
**方法的重载**：
- 同一个类中，定义了多个同名的方法，这些方法具有类似的功能
- 每个方法具有不同的参数类型和参数个数，这些同名的方法，就构成了重载关系
- 简单理解：同一个类，方法名相同，参数不同的方法，就是重载关系（无需看返回值）
### 简单示例
对应代码：**MethodDemo5.java**
```java
public class MethodDemo5 {
    public static void main(String[] args) {
        //求两个小数的和
        System.out.println(sum(1.2,3.4));
    }

    //求两个整数的和
    public static int sum(int a, int b) {
        return a + b;
    }

    //求三个整数的和
    public static int sum(int a, int b, int c) {
        return a + b + c;
    }

    //求两个小数的和
    public static double sum(double a, double b) {
        return a + b;
    }
}
```
[运行结果]
```text
4.6
```
## 习题练习
### 习题一 评委打分
**题目：跳水比赛有五个评委打分，分数在0~100之间。最终去掉一个最高分，去掉一个最低分，剩余的分数再求平均数，该平均数为选手的最终得分。**
- 利用键盘录入5个整数存入数组当中，如果分数超出范围需要重新录入
- 定义方法分别求数组中的最大值和最小值
- 计算五名评委的总分
- 总分减去最大值减去最小值，求选手最终的平均分
  对应代码：**Exercise1.java**
```java
import java.util.Scanner;

public class Exercise1 {
    //跳水比赛
    public static void main(String[] args) {
        //键盘录入分数，存入数组
        Scanner sc = new Scanner (System.in);
        int[] arr = new int[5];
        int sum =0;
        for (int i = 0; i < 5; ) {
            System.out.println("第"+(i+1)+"位评委请打分：");
            int num = sc.nextInt();
            if (num>=0 && num<=100){
                arr[i]=num;
                sum=sum+num;
                i++;
            }else{
                System.out.println("分数超出范围，请重新打分");
            }
        }
        int max =getMax(arr);
        int min =getMin(arr);
        int score = (sum-max-min)/3;
        System.out.println("选手的最终评分："+score);
    }
    //定义方法，求数组中的最大值
    public static int getMax (int[] arr){
        //定义一个变量，默认为数组的第一个值
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>max)
                max=arr[i];
        }
        return max;
    }
    //定义一个方法，求数组中的最小值
    public static int getMin (int[] arr){
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]<min)
                min=arr[i];
        }
        return min;
    }
}

```
[运行结果]
```text
第1位评委请打分：
30
第2位评委请打分：
40
第3位评委请打分：
60
第4位评委请打分：
20
第5位评委请打分：
10
选手的最终评分：30
```
### 习题二 计算班级分数
**题目：班主任需要统计10名学生的数学成绩（0~100），计算及格率，平均分，并找出最高分**
- 键盘录入10名学生的成绩，存入数据。超出范围，提示“成绩无效，请重新输入”
- 定义方法，求及格人数，根据及格人数，求及格率
- 定义方法求总分，根据总分求平均分
- 定义方法求最大值
  对应代码：**Exercise2.java**
```java
import java.util.Scanner;

public class Exercise2 {
    //计算班级分数
    public static void main(String[] args) {
        //键盘录入10名同学的成绩
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; ) {
            System.out.println("输入第"+(i+1)+"位同学的成绩：");
            int num = sc.nextInt();
            if(num>=0 && num<=100){
                arr[i]=num;
                i++;
            }else{
                System.out.println("成绩无效，请重新输入");
            }
        }
        //根据及格人数求及格率
        double passRate =(double) pass(arr)/arr.length;
        /*
        两个int类型整除得到商，结果不是0就是1；
        即使将paseeRate的类型改为double也不行
        只有将参与计算的其中一个数据的类型改为double
        */
        System.out.println("及格率为"+passRate);
        //根据总分求平均分
        int sum = getSum(arr);
        int average = sum/arr.length;
        System.out.println("平均分为"+average);
        //求最高分
        System.out.println("最高分是"+getMax(arr));
    }
    //定义方法，求及格人数
    public static int pass(int[] arr){
        int pass = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>=60)
                pass++;
        }
        return pass;
    }
    //定义方法求总分
    public static int getSum (int[] arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
        }
        return sum;
    }
    //定义方法求最大值
    public static int getMax(int[] arr){
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>max)
                max = arr[i];
        }
        return max;
    }
}

```
[运行结果]
```text
输入第1位同学的成绩：
10
输入第2位同学的成绩：
20
输入第3位同学的成绩：
30
输入第4位同学的成绩：
40
输入第5位同学的成绩：
50
输入第6位同学的成绩：
60
输入第7位同学的成绩：
70
输入第8位同学的成绩：
80
输入第9位同学的成绩：
90
输入第10位同学的成绩：
100
及格率为0.5
平均分为55
最高分是100
```
### 习题三 计算快递邮费
**题目：某快递公司的运费规则如下（首重1kg，超出部分按kg计算，不足1kg按1kg算）：  
首重1kg：10元；  
超出1-5kg：每kg加2元；  
超出5kg以上：每kg加1.5元；
键盘录入小数，表示用户快递的重量，计算最终的结果**
- 快递重量必须大于0，否则重新输入
- 不同价位的计算，单独定义一个方法   
  对应代码：** **
```java
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

```
[运行结果1]
```text
输入快递重量(kg)：
0.5
邮费10.0元
```
[运行结果2]
```text
输入快递重量(kg)：
3.2
邮费16.0元
```
[运行结果3]
```text
输入快递重量(kg)：
5.1
邮费19.5元
```
[运行结果4]
```text
输入快递重量(kg)：
-1
快递重量必须大于0，重新输入
输入快递重量(kg)：
10
邮费25.5元
```
## 方法的应用场景总结：
- 重复使用的代码块->抽方法
- 复杂业务规则->单独定义一个方法
- 一个方法只做一件事

