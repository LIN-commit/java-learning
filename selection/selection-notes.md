- [选择语句](#选择语句)
    - [switch语句格式](#switch语句格式)
        - [例题](#例题)
    - [case穿透](#case穿透)
        - [例题](#例题-1)
    - [箭头标签](#箭头标签)
        - [例](#例)
        - [例](#例-1)
        - [例](#例-2)
        - [例](#例-3)
    - [switch可以有运行结果](#switch可以有运行结果)
        - [例](#例-4)
    - [yield关键字](#yield关键字)
        - [例](#例-5)

# 选择语句
配套完整代码：GitHub仓库  
<https://github.com/LIN-commit/java-learning>
代码所在目录：java-learning/selection/  
本节对应代码：
- DoubleDemo_error.txt :switch表达式结果不能是小数或者long类型
- MenuDemo.java ：switch简单示例
- SwitchCasePenetration.java :case穿透示例
- SwitchArrowLabel.java :case箭头标签示例
- ArrowDemo1.java :只有一条语句时，case箭头的写法
- ArrowDemo2.java :case箭头示例
- ArrowDemo3.java :case箭头示例
- SwitchResultDemo.java :switch可以有运行结果,以及yield关键字
## switch语句格式
```text
switch(表达式){
    case1:
          语句;
          break;
    case2:
          语句;
          break;
    ……
    default:
          语句;
          break;
}
```
**1.首先计算表达式的值**  
**2.依次与case后面的值进行比较：**  
如果有对应的值，就执行语句，遇到break就跳出Switch语句；  
如果没有对应的值，就执行default  
**3.表达式的结果：** 字符/整数/枚举/字符串 **(不能是小数，long类型)**  
[错误实例]  
对应代码：**DoubleDemo_error.txt**
```java
 double weekday1 = 1.5;
        switch(weekday1) {
            case 1.5 :
                System.out.println("红烧排骨");
                break;
        }
```
[运行结果]
```text
java: selector type double is not allowed
//代码报错，表达式结果不能是小数
```
**4.case后是真实数据或字符串，不能重复**  
**5.default通常写在最后，表示所有case都不匹配时执行的代码。也可以写在前面，但一般不会那样做**
### 例题
**假设一个菜单  
周一是红烧排骨，  
周二是辣椒炒肉，  
周三是清蒸鱼，  
周四是可乐鸡翅，  
周五是牛肉火锅，  
键盘录入日期，查看那天的菜单**  
对应的代码：**MenuDemo.java**
```java
public static void main(String[] args) {

        //键盘录入日期
        System.out.println("输入今天的星期数(1~5)：");
        Scanner sc = new Scanner(System.in);
        int weekday = sc.nextInt();

        //选择语句
        switch(weekday){
            case 1:
                System.out.println("红烧排骨");
                break;
            case 2:
                System.out.println("辣椒炒肉");
                break;
            case 3:
                System.out.println("清蒸鱼");
                break;
            case 4:
                System.out.println("可乐鸡翅");
                break;
            case 5:
                System.out.println("牛肉火锅");
                break;
            default :
                System.out.println("日期输入错误");
                break;
        }
        /*一定要考虑输入错误这种特殊情况，某些严重情况可能会导致程序卡住或者数据溢出*/
    }
```
[运行结果1]
```text
输入今天的星期数(1~5)：
8
日期输入错误
```
[运行结果2]
```text
输入今天的星期数(1~5)：
4
可乐鸡翅
```
## case穿透
```java
case 1:
case 2:
case 3:
    语句；
    break;
```
**表达式结果为1/2/3，都执行语句**
### 例题
**假设周一周二周三的主食都是米饭，周四周五的主食都是面条，键盘录入日期，查看当天的主食**  
对应代码：**SwitchCasePenetration.java**
```java
public static void main(String[] args) {

        //键盘录入日期
        System.out.println("输入今天的星期数(1~5)：");
        Scanner sc = new Scanner(System.in);
        int weekday = sc.nextInt();

        //case穿透
        switch(weekday){
            case 1:
            case 2:
            case 3:
                System.out.println("米饭");
                break;
            case 4:
            case 5:
                System.out.println("面条");
                break;
            default :
                System.out.println("日期输入错误");
                break;
        }
    }
```
[运行结果1]
```text
输入今天的星期数(1~5)：
1
米饭

```
[运行结果2]
```text
输入今天的星期数(1~5)：
2
米饭
```
## 箭头标签
```java
case 1 :
    语句；
    break;
```
可以写成
```java
case 1 ->{
    语句；//注意没有break
}
```
### 例
对应代码：**SwitchArrowLabel.java**
```java
        switch(weekday) {
            case 1 -> {
                System.out.println("红烧排骨");
            }
            case 2 -> {
                System.out.println("辣椒炒肉");
            }
            case 3 -> {
                System.out.println("清蒸鱼");
            }
            case 4 -> {
                System.out.println("可乐鸡翅");
            }
            case 5 -> {
                System.out.println("牛肉火锅");
            }
            default ->{
                System.out.println("日期输入错误");
            }
        }
```
在语句只有一条的情况下，还可以写成
```java
case 1 ->语句；
```
### 例
对应代码：**ArrowDemo1.java**
```java
switch(weekday) {
            case 1 -> System.out.println("红烧排骨");
            case 2 -> System.out.println("辣椒炒肉");
            case 3 -> System.out.println("清蒸鱼");
            case 4 -> System.out.println("可乐鸡翅");
            case 5 -> System.out.println("牛肉火锅");
            default ->System.out.println("日期输入错误");
        }
```
case后面可以写多个值
```java
case 1,2,3 -> {
    语句;
}
```
### 例
对应代码：**ArrowDemo2.java**
```java
switch(weekday){
            case 1,2,3->{
                System.out.println("米饭");
            }
            case 4,5->{
                System.out.println("面条");
            }
            default ->{
                System.out.println("日期输入错误");
            }
        }
```
或者
```java
case 1,2,3 ->语句； 
```
### 例
对应代码：**ArrowDemo3.java**
```java
switch(weekday){
            case 1,2,3-> System.out.println("米饭");
            case 4,5-> System.out.println("面条");
            default -> System.out.println("日期输入错误");
        }
```
## switch可以有运行结果
### 例
对应代码：**SwitchResultDemo.java**
```java
 String food = switch(weekday){
            case 1,2,3->{
                yield"米饭";
            }
            case 4,5->{
                yield"面条";
            }
            default ->{
                yield"日期输入错误";
            }
        };
```
- 是String/int/char,关键在返回值的数据类型
- 这种写法适合“需要分支结果赋值给变量”的场景
- **小贴士：{ }外要加；**
## yield关键字
**yield用于显示返回分支的结果并终止switch**
### 例
对应代码：**SwitchResultDemo.java**
```java
case 1,2,3->{
                yield"米饭";
            }
```
也可以省略写为
```java
 case 1,2,3->"米饭";
```