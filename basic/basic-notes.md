- [java基础](#java基础)
    - [创建项目](#创建项目)
    - [删除项目](#删除项目)
    - [快捷输入](#快捷输入)
        - [psvm](#psvm)
        - [sout](#sout)
    - [注释](#注释)
        - [单行注释](#单行注释)
        - [多行注释](#多行注释)
    - [关键字](#关键字)
    - [字面量](#字面量)
    - [变量](#变量)
    - [数据类型（内存）](#数据类型内存)
        - [整数](#整数)
        - [小数](#小数)
        - [字符](#字符)
        - [布尔](#布尔)
    - [标识符](#标识符)
    - [键盘录入](#键盘录入)

# java基础
配套完整代码：GitHub仓库  
https://github.com/LIN-commit/java-learning  
代码所在目录：java-learning/basic/  
本节对应代码文件：
- HelloWorld.java  入门主程序，主方法，打印语句
- CommentDemo.java  注释相关代码
- VariableDemo.java  变量，数据类型，标识符
- ScannerDemo.java  键盘录入
## 创建项目
如果在初始界面，点击“new project”;如果是界面是在之前的project，想再创建一个，点击左上角->new->project,弹出页面，输入项目名称name和存储地址location，即可创建成功。
## 删除项目
进入想要删除的项目，点击左上角，找到“Close Project”，回到初始界面，右键点击这个文件，找到“Remove from Recent Projects”,点击后选择“remove”，就可以删除了。
## 快捷输入
**对应代码：HelloWorld.java**
### psvm
输入“psvm”，回车，代码自动生成

```java
 public static void main(String[] args) {

 }
 ```
这是java程序主入口，程序从主入口开始往下执行（固定格式）
### sout
输入“sout”，回车，代码自动生成

  ```java
  System.out.println("hello world");
  ```
这是输出语句/打印语句

## 注释
**对应代码：CommentDemo.java**
### 单行注释
```java
//单行注释
```
### 多行注释
```java
/*多行注释
多行注释*/
```
## 关键字
规则：全部小写，高亮显示
- package  
  在java中创建名为code的包后，会自动生成`package code;`，表示当前的类定义在code这个包下  
  包名一般是公司域名的反写，例如“www.baidu.com”,反写就是“com.baidu.www”，也可以随便起，例如“test”
- class
```java
public class helloworld{

}
```
class表示定义一个类，类是java中最基本的组成单位  
helloworld表示类名，{ }是类的范围

之后会陆续学到更多关键字……
## 字面量
- 字符串类型：`“Hello World”`
- 字符类型：`‘a’`
- 空类型：`null`
- 整数类型
- 小数类型
- 布尔类型
## 变量
**对应代码：VariableDemo.java**  
数据类型  变量名 = 数据值；  
`int a = 3 ;`  
变量名建议使用“小驼峰命名法”：第一个单词首字母小写，后面每个单词首字母大写，例如“myFirstNumber”
## 数据类型（内存）
### 整数
- byte（1）
- short(2)
- int(4)
- long(8)  
  long类型的数据必须以L或l结尾  
  `long a = 10000L;`
### 小数
- float(4)  
  float类型的数据必须以F或f结尾  
  `float b = 1.1f;`
- double(8)
### 字符
- char(2)  
  单个字符，不是字符串
### 布尔
- boolean(1)
## 标识符
（程序员对变量起的名字）
- 由数字、字母、下划线_、美元符$组成
- 不能以数字开头
- 不能是关键字
- 区分大小写


## 键盘录入
**对应代码：ScannerDemo.java**  
1.找到scanner
(1)在程序主入口中输入`scanner`后，回车，代码自动变为`Scanner`，IDEA会自动在文件最上方添加一行`import java.util.Scanner;`
```java
import java.util.Scanner;
public class test {
    public static void main(String[] args) {
        Scanner
    }
}
```
(2)在“Scanner”后继续输入  
` Scanner sc = new Scanner (System.in);`

2.让scanner干活  
（1）接受键盘录入的整数  
`int num1 = sc.nextInt();`  
（1）接受键盘录入的小数  
`double num2 = sc.nextDouble();`  
（1）接受键盘录入的字符串  
`String str = sc.next();`  
**例**
```java
import java.util.Scanner;
public static void main(String[] args) {
        System.out.println("输入你想要打印的数字：");
        Scanner sc =new Scanner (System.in);
        int num = sc.nextInt();
        System.out.println(num);
    }
```
[运行结果]  
输入：6
```text
输入你想要打印的数字：
6
6
```