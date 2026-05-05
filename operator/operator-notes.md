- [各类运算符](#各类运算符)
    - [算术运算符](#算术运算符)
        - [数值拆分（经典例题）](#数值拆分经典例题)
    - [小贴士：AI快捷键](#小贴士ai快捷键)
    - [数字运算](#数字运算)
        - [隐式转换](#隐式转换)
        - [强制转换](#强制转换)
        - [电脑自带计算器](#电脑自带计算器)
    - [字符运算](#字符运算)
        - [例题](#例题)
    - [字符串运算](#字符串运算)
    - [自增自减运算符](#自增自减运算符)
    - [赋值运算符](#赋值运算符)
    - [关系运算符](#关系运算符)
    - [逻辑运算符](#逻辑运算符)
    - [短路逻辑运算符](#短路逻辑运算符)
    - [逻辑运算符和短路逻辑运算符的区别](#逻辑运算符和短路逻辑运算符的区别)
    - [三元运算符](#三元运算符)
        - [例题](#例题-1)
    - [运算符的优先级](#运算符的优先级)

# 各类运算符
配套完整代码：GitHub仓库  
https://github.com/LIN-commit/java-learning  
代码所在目录：java-learning/operator/  
本节对应代码文件：
- ArithmeticDemo.java :小数直接参与运算，结果可能不准确
- SplitDemo.java :数值拆分经典例题
- CastDemo.java :强制转换易错点
- CharCovertDemo.java :大写字母转换小写字母，经典例题
- StringDemo.java :字符串拼接操作
- TernaryDemo.java :三元运算符实例
## 算术运算符
- **\+**
- **\-**
- **\***
- **/**
- **%(取余)**  
  计算时一般用int，如果用double，小数直接参与运算，结果可能是不精确的  
  对应代码：**ArithmeticDemo.java**
```java
public static void main(String[] args) {
        double a =1.1;
        double b =1.01;
        System.out.println(a+b);
    }
```
[运行结果]
```text
2.1100000000000003
```
### 数值拆分（经典例题）
**题目：键盘录入一个三位数，将其拆分为个位十位百位后，打印在控制台**  
对应代码：**SplitDemo.java**
```java
import java.util.Scanner;

public class SplitDemo {
    //键盘录入一个三位数，拆分个位十位百位，并打印在控制台
    public static void main(String[] args) {
        //键盘录入一个三位数
        Scanner sc = new Scanner(System.in);
        System.out.println("输入一个三位数：");
        int num = sc.nextInt();
        //拆分个位
        int ge = num % 10 ;
        //拆分十位
        int shi = num /10 %10;
        //拆分百位
        int bai = num /100;
        //打印
        System.out.println("个位是"+ge+",十位是"+shi+"，百位是"+
                bai);
    }
}
```
[运行结果]
```text
输入一个三位数：
152
个位是2,十位是5，百位是1
```
**公式总结**
- 个位：数值 %10
- 十位：数值 /10%10
- 百位：数值 /100%10
- 千位：数值 /1000%10  
  ……
## 小贴士：AI快捷键
**Alt+p** 强制AI生成代码  
**Esc**  消除AI生成的代码
## 数字运算
**类型不一样不能运算，需要转换成同类型的才能计算**
```java
int a =1;
byte b =5;
```
代码不会报错，因为不同类型的数据进行计算，java会自动**隐式转换**（本质上还是转换为同类型的数据在计算）
### 隐式转换
**小转大**，小内存的数据类型转换为大内存的数据类型  
例如byte转换为short,在数据前补0即可。  
**转换步骤**  
1.如有byte,short类型，先提升为int类型  
2.提升取值范围，转为其他类型
### 强制转换
**大转小**，去掉不要的0（可能会精度丢失，数值溢出）  
**强制转换需要手写代码**
```java
int a = 1;
byte b = (byte)a;
```
**易错点**  
对应代码：**CastDemo.java**
```java
byte a =10;
byte b =20;
byte c =(byte)a+b;
```
[运行结果]
```text
java: 不兼容的类型: 从int转换到byte可能会有损失
```
只强转了a，此时a是byte，b是int，报错  
（java的隐式转换，遇到byte类型就提升为int类型）
```java
byte a =10;
byte b =20;
byte c =(byte)(a+b);
```
[运行结果]
```text
运行成功
```
### 电脑自带计算器
打开电脑自带的计算器，点击左上角，选择“程序员”，就可以计算不同进制之间的数值转换
- BIN 二进制
- OCT 八进制
- DEC 十进制
- HEX 十六进制

## 字符运算
在ASCII表中  
A-65，a-97  
B-66，b-98
……
大小写字母固定相差32
### 例题
**大写字母转化为小写字母**  
对应代码：**CharCovertDemo.java**
```java
 public static void main(String[] args) {
       char c = 'A';
       char cc = (char)(c+32);
        System.out.println(cc);
    }
```
[运行结果]
```text
a
```
## 字符串运算
对应代码：**StringDemo.java**  
字符串只有 **+** 操作，任意数据+字符串都是拼接操作，形成新字符串
1.
```java
System.out.println(123+"abc");
```
[运行结果]
```text
123abc
```
2.
```java
System.out.println(10+8+"岁");
```
[运行结果]
```text
18岁
```
**注意：代码运行会从左到右依次计算**
3.
```java
System.out.println(10+8+"岁"+1+2);
```
[运行结果]
```text
18岁12
```
## 自增自减运算符
**++** 变量值+1  
**- -** 变量值-1  
**注意：a++，++a都表示a=a+1**
## 赋值运算符
- **=**  
  直接赋值
- **+=**  
  a+=b 表示a=a+b
- **-=**  
  a-=b 表示a=a-b
- ***=**  
  a*=b 表示a=a*b
- **/=**  
  a/=b 表示a=a/b
- **%=**  
  a%=b 表示a/b的余数赋值给a
## 关系运算符
- **==**
- **!=(不等)**
- **>**
- **<**
- **>=**
- **<=**
## 逻辑运算符
- **&**  与
- **|**  或
- **！** 非
## 短路逻辑运算符
- **&&**  
  短路与，若左边为false,右边不执行
- **||**  
  短路或，左边为true,右边不执行
## 逻辑运算符和短路逻辑运算符的区别
&左右都必须执行，&&则提高了效率
## 三元运算符
格式：**关系表达式？表达式1：表达式2；**  
执行逻辑：**关系表达式成立，则执行表达式1；关系表达式不成立，则执行表达式2**
### 例题
**输出两个数中较大的那个数**  
对应代码：**TernaryDemo.java**
```java
public static void main(String[] args) {
        int a = 2;
        int b = 3;
        System.out.println(a>b?a:b);
    }
```
[运行结果]
```text
3
```
## 运算符的优先级
小括号（ ）优于所有，想先算哪个扩起来就行 