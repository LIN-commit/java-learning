- [判断语句](#判断语句)
    - [if语句格式](#if语句格式)
        - [例题](#例题)
        - [两个条件进行判断](#两个条件进行判断)
        - [多个条件进行判断](#多个条件进行判断)
        - [例题](#例题-1)
        - [例题](#例题-2)

# 判断语句
配套完整代码：GitHub仓库  
https://github.com/LIN-commit/java-learning  
代码所在目录：java-learning/IfDemo/  
本节对应代码文件：
- AgeDemo.java :if语句示例，判断是否成年
- TriangleDemo.java :判断三条边是否可以构成三角形
- ScannerTriangle.java :键盘录入任意三个大于0的整数，判断它们构成什么三角形
##  if语句格式
```text
if(关系表达式){
    语句体；
}
```
**关系表达式**是用关系运算符（>,<,==,!=,<=,>=）连接起来的式子，结果只能是true或false
关系表达式结果为true,执行语句体
### 例题
对应代码：**AgeDemo.java**
```java
 public static void main(String[] args) {
        int age = 18;
        if (age >= 18){
            System.out.println("已成年");
        }
        else{
            System.out.println("未成年");
        }
    }
```
[运行结果]
```text
已成年
```
### 两个条件进行判断
```text
if(关系表达式){
    语句体A；
}else{
    语句体B；
}  
```
### 多个条件进行判断
```text
if(关系表达式1){
    语句体A;
}else if(关系表达式2){
    语句体B;
}else if(关系表达式3){
    语句体C;
}
……
else{
    语句体D;
}
```
**对于多个条件判断，数据只会进入一个条件，若满足了else if 1的关系表达式,即使输出结果满足else if 2的关系表达式,也不会进入else if 2**
### 例题
**判断a,b,c三条边是否可以构成三角形**  
(原理是任意两边之和大于第三边)  
对应代码：**TriangleDemo.java**
```java
public static void main(String[] args) {
        int a =2;
        int b =4;
        int c =5;
        if (a+b>c && a+c>b && b+c>a){
            System.out.println("这三条边可以构成三角形");
        }else{
            System.out.println("这三条边不能构成三角形");
        }
    }
```
[运行结果]
```text
这三条边可以构成三角形
```
### 例题
**键盘录入任意三个大于0的整数，判断它们构成什么三角形**  
对应代码：**ScannerTriangle.java**
```java
import java.util.Scanner;
public class test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.println("输入第一条边的长：");
        int a = sc.nextInt();
        System.out.println("输入第二条边的长：");
        int b = sc.nextInt();
        System.out.println("输入第三条边的长：");
        int c = sc.nextInt();
        if (a+b>c && a+c>b && b+c>a){
            if (a==b && b==c)
                System.out.println("等边三角形");
            else if (a*a+b*b==c*c || b*b+c*c==a*a || a*a+c*c==b*b)
                System.out.println("直角三角形");
            else if (a==b || b==c || a==c)
                System.out.println("等腰三角形");
            else
                System.out.println("普通三角形");
        }
        else
            System.out.println("不构成三角形");
    }
}
```
[运行结果]  
输入：3,4,5
```text
输入第一条边的长：
3
输入第二条边的长：
4
输入第三条边的长：
5
直角三角形
```
**小贴士**
- 如果语句块只有一条语句，那么可以不写{ }
- 多个条件进行判断，小范围写上面，大范围写下面  
  例如，判断三角形时，先判断等边，再判断直角，接着是等腰，最后才是普通三角形，把最严格的条件放在最前面

**易错点**
- =是赋值，==是判断
- &&是与，||是或
- 判断三边相等，不是`if(a==b==c)`，是`if(a==b&&b==c)`

