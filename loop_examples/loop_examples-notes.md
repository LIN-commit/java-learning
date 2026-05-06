# 经典循环例题
配套完整代码：GitHub仓库  
<https://github.com/LIN-commit/java-learning>  
代码所在目录：java-learning/loop_example  
本节对应代码：
- parallelogram.java :打印平行四边形
- trapezoid.java :打印梯形
- rhombus.java :打印菱形
- hollow_rhombus.java :打印空心菱形
- NineNineTable.java :打印九九乘法表
- TabDemo1.java :制表符的简单示例
- TabDemo2.java :制表符补空格的规则示例
## 打印多个复杂图形
### 打印平行四边形
![平行四边形图](https://raw.githubusercontent.com/LIN-commit/java-learning/refs/heads/master/images/%E5%B1%8F%E5%B9%95%E6%88%AA%E5%9B%BE%202026-05-04%20131008.png)

**写法一**  
先打印每一行开始的空格，在打印后面的*  
对应代码：**ParallelogramDemo1.java**
```java
public class ParallelogramDemo1 {
    public static void main(String[] args) {
       for (int line =1;line<=3;line++){
           for (int blank =line;blank<=2;blank++)
               System.out.print(" ");//先打印每一行开始的空格

           for (int column =1;column<=6;column++)
               System.out.print("*");//在空格后打图案

           System.out.println();//换行
       }
    }
}
```
[运行结果]
```text
  ******
 ******
******
```  
**写法二**  
拼接拆分图形，拼接为一个长方形（或者三角形），再拆分为三角形和长方形  
<img src="https://raw.githubusercontent.com/LIN-commit/java-learning/refs/heads/master/images/%E5%B1%8F%E5%B9%95%E6%88%AA%E5%9B%BE%202026-05-04%20230935.png" width="200">

对应代码：**ParallelogramDemo2.java**
```java
public class ParallelogramDemo2 {
    public static void main(String[] args) {
        for(int line =1;line<=3;line++){
            //先打印左上角的红色部分，把*换成空格
            for(int i =line;i<=2;i++)
                System.out.print(" ");
            //再打印绿色的直角三角形
            for(int j =1;j<=line;j++)
                System.out.print("*");
            //接着打印蓝色的正方形部分
            for(int k =1;k<=3;k++)
                System.out.print("*");
            //最后打印青色部分的三角形,和开始的红色部分一样
            for(int i =line;i<=2;i++)
                System.out.print("*");
            System.out.println();
        }
    }
}
```
[运行结果]
```text
  ******
 ******
******
```  
**小结**
- 写法一：代码较少，但需要找到内循环与外循环之间的规律，需要扎实的数学知识
- 写法二：代码较多，但逻辑简单易懂
- 综上，推荐代码二

### 打印梯形
<img src="https://raw.githubusercontent.com/LIN-commit/java-learning/refs/heads/master/images/%E5%B1%8F%E5%B9%95%E6%88%AA%E5%9B%BE%202026-05-04%20132429.png" width="200">  

**写法一**：
对应代码：**
```java
public class TrapezoidDemo1 {
    public static void main(String[] args) {
        for (int line =1;line<=3;line++){
            for (int blank =line;blank<=2;blank++)
                System.out.print(" ");//先打印每一行开始的空格
            
            for (int column =1;column<=2*line+1;column++)
                System.out.print("*");//再打印图案
            System.out.println();//换行
        }
    }
}
```
[运行结果]
```text
  ***
 *****
*******
```  
**写法二**：  
<img src="https://raw.githubusercontent.com/LIN-commit/java-learning/refs/heads/master/images/%E5%B1%8F%E5%B9%95%E6%88%AA%E5%9B%BE%202026-05-06%20095356.png" width="150">

对应代码：**TrapezoidDemo2.java**
```java
public class TrapezoidDemo2 {
    //通过拼接法打印梯形
    public static void main(String[] args) {
        for(int line = 1; line<=3 ; line++){
            //打印左上角的红色部分，再把*换成空格
            for (int i = line; i<=2;i++)
                System.out.print(" ");
            //打印蓝色的直角三角形部分
            for (int j = 1;j<=line;j++)
                System.out.print("*");
            //打印中间绿色部分
            System.out.print("*");
            //打印蓝色的直角三角形部分
            for (int k = 1;k<=line;k++)
                System.out.print("*");
            //右上角的红色部分是空格，直接忽略
            //换行
            System.out.println();
        }
    }
}
```
[运行结果]
```text
  ***
 *****
*******
```
### 打印菱形
<img src="https://raw.githubusercontent.com/LIN-commit/java-learning/refs/heads/master/images/%E5%B1%8F%E5%B9%95%E6%88%AA%E5%9B%BE%202026-05-04%20132437.png" width="150">  

**写法一**：  
对应代码：**RhombusDemo1.java**
```java
public class rhombus {
    public static void main(String[] args) {
        //图案分为上半部分和下半部分
        //上半部分
        for (int line1=1;line1<=4;line1++) {
            for (int blank1 = 1; blank1 <= 4 - line1; blank1++)
                System.out.print(" ");//空格
            for (int column1 = 1; column1 <= line1 * 2 - 1; column1++)
                System.out.print("*");//图案
            System.out.println();//换行
        }
            //下半部分
            for (int line2 = 1; line2 <= 3; line2++) {
                for (int blank2 = 1; blank2 <= line2; blank2++)
                    System.out.print(" ");
                for (int column2 = 1; column2 <= 7 - line2*2; column2++)
                    System.out.print("*");
                System.out.println();
            }
    }
}
```
[运行结果]
```text
   *
  ***
 *****
*******
 *****
  ***
   *
```  
**写法二**：  
<img src="https://raw.githubusercontent.com/LIN-commit/java-learning/refs/heads/master/images/%E5%B1%8F%E5%B9%95%E6%88%AA%E5%9B%BE%202026-05-06%20103442.png" width="100">

对应代码：**RhombusDemo2.java**
```java
public class RhombusDemo2 {
    //运用拼接法打印菱形
    //将菱形分为上半部分4行，下半部分3行
    public static void main(String[] args) {
        //上半部分
        for (int line1 = 1;line1 <=4;line1++) {
            //打印左上角红色部分，再把*换成空格
            for (int i =line1;i<=3;i++)
                System.out.print(" ");
            //打印蓝色直角三角形部分
            for (int j = 1;j<=line1;j++)
                System.out.print("*");
            //打印绿色直角三角形部分
            for (int k =1;k<=line1-1;k++)
                System.out.print("*");
            //换行
            System.out.println();
        }
        //下半部分
        for(int line2 = 1;line2<=3;line2++){
            //打印左下角红色部分
            for (int m =1;m<=line2;m++)
                System.out.print(" ");
            //打印蓝色倒直角三角形部分
            for (int n =line2;n<=3;n++)
                System.out.print("*");
            //打印黄色倒直角三角形部分
            for (int p =line2;p<=2;p++)
                System.out.print("*");
            //换行
            System.out.println();
        }
    }
}
```
[运行结果]
```text
   *
  ***
 *****
*******
 *****
  ***
   *
```
### 打印空心菱形
<img src="https://raw.githubusercontent.com/LIN-commit/java-learning/refs/heads/master/images/%E5%B1%8F%E5%B9%95%E6%88%AA%E5%9B%BE%202026-05-04%20132457.png" width="100">


用拼接法构造这个图形  
<img src="https://raw.githubusercontent.com/LIN-commit/java-learning/refs/heads/master/images/%E5%B1%8F%E5%B9%95%E6%88%AA%E5%9B%BE%202026-05-06%20125315.png" width="100">

对应代码：**hollow_rhombus.java**
```java
public class hollow_rhombus {
    //运用拼接法打印空心菱形
    public static void main(String[] args) {
        //图形分为上下两部分，上半部分4行，下半部分3行
        //上半部分
        for (int line1 =1;line1<=4;line1++){
            //打印左上角的红色部分
            for (int i =line1; i<=3; i++)
                System.out.print(" ");
            //打印黑色左边部分
            System.out.print("*");
            //打印绿色部分
            for (int j =1;j<=line1-1;j++)
                System.out.print(" ");
            //打印黄色部分
            for (int k =1;k<=line1-2;k++)
                System.out.print(" ");
            //打印黑色右边部分
            if (line1!=1)//用判断语句跳过第一行的打印
                System.out.print("*");
            //换行
            System.out.println();
        }
        //下半部分
        for (int line2 =1; line2<=3; line2++){
            //打印左下角的红色部分
            for (int m = 1; m<=line2; m++)
                System.out.print(" ");
            //打印左边黑色部分
            System.out.print("*");
            //打印蓝色倒三角形
            for (int n =line2; n<=2; n++)
                System.out.print(" ");
            //打印灰色部分
            if (line2==1)
                System.out.print(" ");
            //打印右边黑色部分
            if (line2!=3)
                System.out.print("*");
            //换行
            System.out.println();
        }
    }
}
```
[运行结果]
```text
   *
  * *
 *   *
*     *
 *   *
  * *
   *
```
## 打印九九乘法表
对应代码：**NineNineTable.java**
```java
public class NineNineTable {
    //打印九九乘法表
    public static void main(String[] args) {
        for (int line =1; line<=9; line++){
            for (int column =1; column<=line; column++)
                System.out.print(column+"*"+line+"="+(column*line)+"\t");
                //\t是制表符，作用是让每一列对齐
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
### 制表符
- **简单理解**：`\t`是长度可变的大空格，打印表格类数据的时候，可以让上下对齐  
  **例**  
  对应代码：**TabDemo1.java**
```java
public class TabDemo1 {
    //打印同学的姓名、年龄、性别
    public static void main(String[] args) {
        System.out.println("name\t\tage\t\tgender");
        System.out.println("zhangsan\tage\t\tmale");
        System.out.println("lisi\t\tage\t\tmale");
    }
}
```
[运行结果]
```text
name		age		gender
zhangsan	age		male
lisi		age		male
```
- **真正含义**：在前面的字符后面补1-4个空格，让这个整体长度凑成4的倍数（这个整体是指前面的字符加制表符）  
  如果前面的字符本是就已经是4的倍数了，那么制表符还会补4个空格（不会补0个空格）  
  **例**  
  对应代码：**TabDemo2.java**
```java
public class TabDemo2 {
    //制表符补空格的示例
    public static void main(String[] args) {
        //制表符会把在自己前面的字符和补的空格看做一个整体，这个整体的长度必须是4的倍数
        System.out.println("***\t***");//制表符会补一个空格
        System.out.println("**\t**");//制表符会补两个空格
        System.out.println("****\t**");//制表符会补四个空格
    }
}
```
[运行结果]
```text
***	***
**	**
****	**
```