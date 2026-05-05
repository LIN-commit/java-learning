- [循环语句](#循环语句)
    - [for循环](#for循环)
        - [例](#例)
    - [while循环](#while循环)
        - [例](#例-1)
    - [在写代码时，选择for循环还是while循环](#在写代码时选择for循环还是while循环)
    - [do...while循环](#dowhile循环)
    - [无限循环](#无限循环)
        - [例](#例-2)
    - [循环控制](#循环控制)
        - [break](#break)
        - [例题](#例题)
        - [continue](#continue)
        - [例题](#例题-1)
        - [小结](#小结)
    - [猜数字（经典算法题）](#猜数字经典算法题)
        - [生成随机数](#生成随机数)
        - [猜数字代码](#猜数字代码)
    - [循环嵌套](#循环嵌套)
        - [例题1](#例题1)
        - [例题2](#例题2)

# 循环语句
配套完整代码：GitHub仓库  
<https://github.com/LIN-commit/java-learning>  
代码所在目录：java-learning/loop/  
本节对应代码：
- ForDemo.java : for循环简单示例
- WhileDemo.java :while循环简单示例
- InfiniteLoop.java :无限循环
- InfiniteLoop_error.txt :无限循环错误示例
- BreakDemo.java :break使用示例
- PrimeNumber_Demo1 ；判断一个数是否是质数的写法一
- PrimeNumber_Demo2 ：判断一个数是否是质数的写法二
- ContinueDemo.java :continue使用示例
- NumberGuess.java :猜数字经典例题
- PrintPattern.java :打印一个4行5列的图形
- RightTriangle.java :打印一个直角三角形
## for循环
**for循环格式**
```text
for(初始化语句;条件判断语句;条件控制语句){
    循环体语句;
}
```
### 例
**打印1~5**  
对应代码：**ForDemo.java**
```java
 public static void main(String[] args) {
       for (int i = 1;i <=5;i++){
           System.out.println(i);
       }
    }
```
[运行结果]
```text
1
2
3
4
5
```
## while循环
**while循环格式**
```text
初始化语句
while(条件判断语句){
    循环体语句;
    条件控制语句;
}
```
### 例
**题目：利用while循环，实现游戏中连续跳跃五次，用输出语句模拟跳跃逻辑。**  
对应代码：**WhileDemo.java**
```java
 public static void main(String[] args) {
        int i =1;
       while(i<=5){
           System.out.println("游戏人物第"+i+"次跳跃");
           i++;
       }
    }
```
[运行结果]
```text
游戏人物第1次跳跃
游戏人物第2次跳跃
游戏人物第3次跳跃
游戏人物第4次跳跃
游戏人物第5次跳跃
```
## 在写代码时，选择for循环还是while循环
- **for循环**：知道**循环次数**或者**循环范围**
- **while循环**：不知道循环次数和范围，只知道**循环结束条件**
## do...while循环
**do...while循环语句格式**
```text
初始化语句;
do{
    循环体语句;
    条件控制语句;
}while(条件判断语句)；
```
**小贴士：do...while循环语句是先执行后判断**
## 无限循环
### 例
对应代码：**InfiniteLoop.java**
```java
 public static void main(String[] args) {
       while(true){
           System.out.println("hello world");
       }
    }
```
[运行结果]：无限输出hello world
```text
hello world
hello world
hello world
......
```
- **在无限循环的代码块下方，不能写任何代码**  
  对应代码：**InfiniteLoop_error.text**
```java
public static void main(String[] args) {
       while(true){
           System.out.println("hello world");
       }
        System.out.println("ok");
    }
```
[运行结果]
```text
java: 无法访问的语句
//代码报错，因为永远无法访问到输出“OK”的那条语句
```
**无限循环通常配合break来结束**
## 循环控制
### break
只能写在switch或循环中，表示结束，不能单独书写  
**例**  
对应代码：**BreakDemo.java**
```java
 public static void main(String[] args) {
      for (int i =1;i<=10;i++){
          System.out.println(i);
          if(i==5)
              break;
      }
    }
```
[运行结果]
```text
1
2
3
4
5
```
**小贴士：循环的快速生成方式：次数.fori+回车**
### 例题
**键盘录入一个大于2的整数，判断是否为质数**
- **写法一**  
  对应代码：**PrimeNumber_Demo1.java**
```java
   public static void main(String[] args) {
        //键盘录入一个大于2的整数
        int num = 0;
        while(true) {
            System.out.println("输入一个大于2的整数：");
            Scanner sc = new Scanner(System.in);
            num = sc.nextInt();
           if (num >=2)
               break;
           else
               System.out.println("当前输入的数字不合法，请重新输入");
        }
        //判断num是否是一个质数
        int count =0;
        for (int i = 2; i <num; i++){
            if (num%i==0){
                count++;
                break;
                //只要找到一个数字能被num整除，那num就不是质数，后面的数字就没必要判断了
            }
        }
        if (count==0)
            System.out.println(num+"是质数");
        else
            System.out.println(num+"不是质数");
    }
```  
**小贴士**：在循环里定义的变量只能用于循环，一旦出了循环，就会被销毁，而代码中的num变量，出了while循环之后还会用到，所以要在循环外定义变量。**这里我的建议是，在写代码时，尽量不要在循环内定义变量，减少报错的几率。**
- **写法二**  
  对应代码：**PrimeNumber_Demo2**
  要证明一个数字是不是质数，就是看它有没有除了1和它本身的因数，且因数都是成对出现的，一个数字大于等于平方根，一个数字小于等于平方根的，所以只需要判断在1到平方根之间有没有数能整除num即可  
  **num的平方根的代码写法是'Math.sqrt(num)'**
```java
 //判断num是否是一个质数
        int count =0;
        for (int i = 2; i <Math.sqrt(num); i++){
            if (num%i==0){
                count++;
                break;
            }
        }
```
### continue
continue表示结束本次循环，继续下次循环，且只能写在循环中（用法类似于跳过），不能单独书写
### 例题
**循环打印1~5，跳过3**  
对应代码：**ContinueDemo.java**
```java
 public static void main(String[] args) {
        for(int i =1;i<=5;i++){
            if(i==3)
                continue;
            System.out.println(i);
        }
    }
```
[运行结果]
```text
1
2
4
5
```  
### 小结
- break:不能单独书写，只能写在switch或循环中，表示结束，跳出的意思
- continue:不能单独书写，只能写在循环中，结束本次循环，继续下次循环
## 猜数字（经典算法题）
**生成一个1~10之间的随机数，利用键盘录入模拟猜的动作，一直猜，直到猜中为止**
### 生成随机数
写法类似于键盘录入
1.找到Random  
(1)在主入口内输入random后回车,变为Random,且在主入口外出现`import java.util.Random;`这行是确定Random的位置。  
(2)在Random后继续输入` Random r = new Random();`  
2.让Random干活  
生成不同类型的随机数  
`int num = r.nextInt();`
- 如果（）里是空的，默认在int的取值范围内取数
- 如果在（）里写数字（B），表示随机数的最大值，但不包含B
- 如果在（）里写数字（A,B），表示取值范围是A~B，包含A,不包含B    
  注意：`r.nextInt(B)`这个写法是Java 17 引入的写法，如果你的JDK版本低于17，请用`r.nextInt(B)+1`

**例**
```java
import java.util.Random;
public class test1 {
    public static void main(String[] args) {
        Random r = new Random();
        int num = r.nextInt();
        System.out.println(num);
    }
}
```
[运行结果1]
```text
16129913
```  
[运行结果2]
```text
-378128417
```  
### 猜数字代码
对应代码：**NumberGuess.java**
```java
import java.util.Random;
import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        //生成一个在1~10之间的随机数
        Random r = new Random();
        int num = r.nextInt(1,11);
        //循环猜数，直到猜中为止
        int guessNumber =0;//变量命名的规则，第一个单词首字母小写，之后的单词首字母全部大写
        while (true){
            System.out.println("输入你猜的数：");
            Scanner sc =new Scanner(System.in);
            guessNumber =sc.nextInt();
             //提示猜的数偏大还是偏小
            if(guessNumber<num)
                System.out.println("猜的数偏小");
            else if(guessNumber>num)
                System.out.println("猜的数偏大");
            else{
                System.out.println("猜对了");
                break;
            }
        }
    }
}
```
[运行结果]
```text
输入你猜的数：
5
猜的数偏大
输入你猜的数：
2
猜的数偏小
输入你猜的数：
3
猜的数偏小
输入你猜的数：
4
猜对了
```  
## 循环嵌套
### 例题1
**打印4行5列的图案**  
\*****  
\*****  
\*****  
\*****
- `System.out.println();`表示先打印，再换行
- `System.out.print();`去掉ln，表示只打印，不换行  
  对应代码：**PrintPattern.java**
```java
 public static void main(String[] args) {
        for (int line =1;line<=4;line++){
            for (int column =1;column<=5;column++){
                System.out.print("*");
            }
            System.out.println();//换行
        }
    }
```
[运行结果]
```text
*****
*****
*****
*****
```
### 例题2
**打印直角三角形**  
\*  
\**  
\***  
\****  
对应代码：**RightTriangle.java**
```java
public static void main(String[] args) {
        for(int line =1;line<=4;line++){
            for (int column =1;column<=line;column++)//内层循环的条件可以依赖外层循环的变量
                System.out.print("*");
            System.out.println();
        }
    }
```  
[运行结果]
```text
*
**
***
****
```