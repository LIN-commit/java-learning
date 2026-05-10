- [数组](#数组)
    - [数组定义](#数组定义)
    - [数组的静态初始化](#数组的静态初始化)
        - [简单示例](#简单示例)
    - [数组的元素访问](#数组的元素访问)
        - [索引](#索引)
        - [数组元素获取](#数组元素获取)
        - [数组元素的修改](#数组元素的修改)
        - [示例](#示例)
    - [数组的遍历](#数组的遍历)
        - [简单示例](#简单示例-1)
    - [动态初始化](#动态初始化)
        - [简单示例](#简单示例-2)
    - [数组常见问题](#数组常见问题)
        - [索引越界](#索引越界)
    - [数组练习](#数组练习)
        - [例题：查找数据](#例题查找数据)
        - [例题：求最值](#例题求最值)
        - [例题：打乱数组中的数据](#例题打乱数组中的数据)
        - [去除重复数据](#去除重复数据)
        - [快慢指针](#快慢指针)
    - [LeetCode算法题](#leetcode算法题)
        - [两数之和](#两数之和)
        - [合并有序数组](#合并有序数组)
        - [查找元素](#查找元素)

# 数组
配套完整代码：GitHub仓库  
<https://github.com/LIN-commit/java-learning>  
代码所在目录：java-learning/arrays/  
本节对应代码：
- ArrayDemo1.java :数组静态初始化
- ArrayDemo2.java :数组的数据修改
- ArrayDemo3.java :数组的遍历
- ArrayDemo4.java :数组的动态初始化
- Index_error.txt :索引越界
- SearchDemo.java :查找数据
- MaxNumber.java :求最值
- PreDemo.java :交换两个变量的值
- ArrayShuffle.java :打乱数组中的数据
- OnlyDemo_error.java :去除重复数据的错误写法
- OnlyDemo_right.java :去除重复数据的正确写法
- PointerDemo.java :设置快慢指针
- SumDemo1.java :LeetCode算法题，两数之和
- MergeArray.java :LeetCode算法题，合并有序数组
- LeetSearch.java :LeetCode算法题，查找元素
## 数组定义
数组：是一种容器，可以用来存储同种数据类型的多个值

## 数组的静态初始化
静态初始化：创建数组时，直接给数组赋值
- 完整格式：
```text
数据类型[] 数组名 = new 数据类型[]{数据值，数据值……}
```
`int[] arr = new int[]{1,2,3};`
- 简写格式：
```text
数据类型[] 数组名 = {数据值，数据值……}
```
`int[] arr = {1,2,3}`  
**小贴士**：
- 数组是连续的空间
- 数组一旦定义，长度不可变
### 简单示例
对应代码：**ArrayDemo1.java**
```java
public class ArrayDemo1 {
    //数组定义的简单示例
    public static void main(String[] args) {
        //1.定义数组存储3位同学的年龄
        int[] ageArr1 = new int[]{18,19,20};
        int[] ageArr2 = {18,19,20};
        //2.定义数组存储3位同学的身高
        double[] heighArr1 = new double[]{1.64,1.78,1.68};
        double[] heighArr2 = {1.64,1.78,1.68};
        //3.定义数组存储3位同学的姓名
        String[] nameArr1 = new String[]{"zhangsan","lisi","wangwu"};
        String[] nameArr2 = {"zhangsan","lisi","wangwu"};

    }
}

```
## 数组的元素访问
### 索引
- 索引就是数组的一个编号，也叫作：角标、下标、编号
- 索引特点：从0开始，连续+1，不间断
### 数组元素获取
```text
变量 = 数组名[索引];
```
`int num = arr[5];`
### 数组元素的修改
```text
数组名[索引] = 数据值;
```
`arr[5]=10;`把索引为5的数据值改为10
### 示例
对应代码：**ArrayDemo2.java**
```java
public class ArrayDemo2 {
    //数组中的元素访问：获取、修改
    public static void main(String[] args) {
        //利用静态初始化创建数组
        int[] arr = {10,20,30,40,50};
        //获取数组中的元素
        int num = arr[0];
        System.out.println(num);
        System.out.println(arr[0]);
        //修改数组中的元素
        arr[1]=100;
        System.out.println(arr[1]);
    }
}
```
[运行结果]
```text
10
10
100
```
## 数组的遍历
遍历：利用循环依次获取数组里面的数据
### 简单示例
对应代码：**ArrayDemo3.java**
```java
public class ArrayDemo3 {
    //数组遍历
    public static void main(String[] args) {
        int[] arr={10,20,30,40,50};
        //利用循环遍历数组
        for (int i = 0; i <= 4; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        //如果数组长度是未知
        //利用length获取数组长度
        System.out.println(arr.length);
        //遍历数组
        for (int j =0; j<=arr.length-1;j++)
            System.out.print(arr[j]+" ");

    }
}
```
[运行结果]
```text
10 20 30 40 50 
5
10 20 30 40 50 
```
- 利用length获取数组长度  
  `数组名.length`
- 数组遍历的快速生成方式  
  `数组名.fori+回车`

## 动态初始化
动态初始化：创建数组的时候指定长度，由系统分配初始值
- int是0
- double是0.0
- String是null
  **完整格式**
```text
数据类型 数组名[] = new 数据类型[长度];
```
`int[] arr = new int[3];`
### 简单示例
对应代码：**ArrayDemo4.java**
```java
import java.util.Scanner;

public class ArrayDemo4 {
    //动态初始化
    //键盘录入5个整数，存入数组当中，并进行遍历
    public static void main(String[] args) {
        int[] arr = new int[5];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            System.out.println("请输入一个整数：");
            int num = sc.nextInt();
            //把接收到的数赋值给数组
            arr[i]=num;
        }
        //遍历数组
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]+" ");
        }
    }
}
```
[运行结果]
```text
请输入一个整数：
5
请输入一个整数：
4
请输入一个整数：
3
请输入一个整数：
2
请输入一个整数：
1
5 4 3 2 1 
```
## 数组常见问题
### 索引越界
若数组中有5个数据，那么索引范围就是0~4，若要索引10，代码就会报错  
对应代码：**Index_error.txt**
```java
public class error {
    //索引越界
    public static void main(String[] args) {
        //定义数组
        int[] arr = {10,20,30,40,50};
        int num = arr[10];
    }
}
```
[运行结果]  
代码报错，显示`ArrayIndexOutOfBoundsException`表示超出索引范围
## 数组练习
### 例题：查找数据
- 需求：已知数组元素位{33,5,22,44,55,33}，键盘录入任意一个数据，查找这个数据在数组中是否存在，如果数组中要查找的数据出现多次，只要显示第一次的索引即可
- 输出要求：如果存在，打印索引  
  如果不存在，提示：该数据不存在  
  对应代码：**SearchDemo.java**
```java
import java.util.Scanner;

public class SearchDemo {
    //查找数据
    public static void main(String[] args) {
        //定义数组
        int[] arr = {33,5,22,44,55,33};
        //键盘录入数据
        Scanner sc = new Scanner (System.in);
        System.out.println("请输入一个整数：");
        int num = sc.nextInt();
        //记录数组当中是否存在num false:不存在  true:存在
        boolean flag = false;
        /*
        记录数组中是否存在num还有一种方法
        int count =0;
         */
        for (int i = 0; i < arr.length; i++) {
            if (num==arr[i]){
                System.out.println(i);
                flag = true;
                //count++;
                break;
            }
        }
        //判断数据不存在
        //写法一：用boolean
        if (!flag)//即flag==false
            System.out.println("数据不存在");
        /*写法二：
        if (count==0)
            System.out.println("数据不存在");
         */

    }
}

```
[运行结果1]
```text
请输入一个整数：
33
0
```
[运行结果2]
```text
请输入一个整数：
22
2
```
[运行结果3]
```text
请输入一个整数：
21
数据不存在
```
### 例题：求最值
- 需求：已知数组元素位{33,5,22,44,55},找出最大值并打印  
  对应代码：**MaxNumber.java**
```java
public class MaxNumber {
    //找出数组中的最大值并打印
    public static void main(String[] args) {
        //创建数组
        int[] arr = {33,5,22,44,55};
        //定义一个变量，默认记录第一个值
        int max = arr[0];
        //让后面的数据依次和第一个值进行比较
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]>max)
                max = arr[i];
        }
        System.out.println(max);
    }
}
```
[运行结果]
```text
55
```
### 例题：打乱数组中的数据
- 前置练习  
  交换两个变量的值  
  对应代码：**PreDemo.java**
```java
public class PreDemo {
    //前置练习：交换两个变量的值
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        //借助第三方变量
        int temp = a;
        a = b;
        b = temp;
        System.out.println(a);
        System.out.println(b);
    }
}
```
[运行结果]
```text
20
10
```
- 题目需求：已知数组元素为{1,2,3,4,5,6,7,8,9,10},要求打乱数组中的数据
  对应代码：**ArrayShuffle.java**
```java
import java.util.Random;

public class ArrayShuffle {
    //已知数组为{1,2,3,4,5,6,7,8,9,10}，打乱数组的数据
    /*
    思路：
    第一步：0索引上的数据，跟随机位置上的数据进行交换
    第二步：1索引上的数据，跟随机位置上的数据进行交换
    重复上面过程
     */
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        Random r = new Random();
        //遍历数组
        for (int i = 0; i < arr.length; i++) {
            //获取一个随机索引
            int randomIndex = r.nextInt(arr.length);
            //拿索引i的元素，和随机索引上的数据交换
            int temp = arr[i];
            arr[i]=arr[randomIndex];
            arr[randomIndex]=temp;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
```
[运行结果1]
```text
6 3 1 7 4 8 5 9 2 10 
```
[运行结果2]
```text
10 1 6 3 5 4 7 8 2 9 
```
### 去除重复数据
题目需求：获取10个1~100之间的随机数并存入数组当中，要求数据是唯一的
- 对应代码：**OnlyDemo_error.java**
```java
import java.util.Random;

public class OnlyDemo {
    //生成随机数并存入数组，要求数据是唯一的
    /*
    思路：
    如果存在，就不存，继续生成下一个随机数
    如果不存在，就存入数组当中
     */
    public static void main(String[] args) {
        int[] arr = new int[10];
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            int num = r.nextInt(100)+1;//范围是1~100
            //对num进行判断，存在--不存，不存在--存入
            int count =0;
            for (int j = 0;  j< arr.length; j++) {
                if (num==arr[i]){
                    count++;
                    break;
                }
            }
            if (count==0)
                arr[i]=num;
        }
        for (int k = 0; k < arr.length; k++) {
            System.out.print(arr[k]+" ");
        }
    }
}

```
[运行结果1]
```text
95 9 45 73 34 17 35 49 92 63 
```
[运行结果2]
```text
34 23 72 85 0 0 29 31 21 74 
```
可以看到[运行结果2]是有问题的，随机数生成范围是1~100，而出现0的原因，是因为在生成重复的数据之后，这个重复的数值并没有存入数组，系统就分配默认初始值0
- 修改后的对应代码：**OnlyDemo_right.java**
```java
import java.util.Random;

public class OnlyDemo_right {
    //生成随机数并存入数组，要求数据是唯一的
   /*之前的代码OnlyDemo_error.java中
   出现重复数据，数组会填入默认值0，这是不符合题目需求的
    */
    public static void main(String[] args) {
        int[] arr = new int[10];
        Random r = new Random();
        for (int i = 0; i < arr.length; )//java中的for循环语句非常灵活，三部分都可以省略
        {
            int num = r.nextInt(100)+1;//范围是1~100
            //对num进行判断，存在--不存，不存在--存入
            int count =0;
            for (int j = 0;  j< arr.length; j++) {
                if (num==arr[j]){
                    count++;
                    break;
                }
            }
            if (count==0) {
                arr[i] = num;
                i++;//for循环的条件控制语句写在这里，只有存入数据i才会加1
            }
        }
        for (int k = 0; k < arr.length; k++)
            System.out.print(arr[k]+" ");
    }
}
```
[运行结果]
```text
92 63 42 74 56 4 73 97 48 35
```
### 快慢指针
- 题目需求：给定义一个递增有序数组，去除其中重复元素
- 思路：设置快慢指针  
  慢指针：存入的位置  
  快指针：找不重复的数据  
  相等->舍弃快指针位置的数据  
  不等->快指针的数据存入慢指针的位置  
  **注意：这里的指针其实就是两个变量**  
  对应代码：**PointerDemo.java**
```java
public class PointerDemo {
    public static void main(String[] args) {
        //定义一个递增有序数组，去除其中重复元素
        int[] arr={1,2,2,2,2,2,3,3,3,3};
        //定义两个指针
        int slow =0;
        int fast =1;
        //利用循环不断的移动快慢指针，找不同元素
        while(fast<arr.length){
            //判断两个指针指向数据是否相同
            if(arr[slow]!=arr[fast]){
                //不同
                slow++;
                arr[slow]=arr[fast];
            }
            fast++;
        }
        //输出结果
        for (int i = 0; i <=slow; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}

```
[运行结果]
```text
1 2 3
```
## LeetCode算法题
### 两数之和
**题目：给定一个整数数组nums和一个整数目标值target，请你在该数组中找出和为目标值target的那两个整数，并输出它们的数组索引**  
提示：先不考虑效率问题，两层循环即可
- 要求1：只要输出第一对满足要求的情况  
  对应代码：**SumDemo1.java**
```java
public class SumDemo1 {
    //两数之和
    //只要输出第一对满足要求的情况
    public static void main(String[] args) {
        //定义数组
        int[] arr={2,7,11,15};
        int target = 9;
        //定义一个变量作为慢指针
        int low =0;
       while(low<arr.length-1){
           int fast = low+1;//fast在每一轮都要重置
        while(fast<arr.length) {
            if (arr[low] + arr[fast] == target) {
                System.out.println(low+","+fast);
                return;//找到第一对满足条件的结果后，直接结束整个main
            }
                fast++;
        }
        low++;
       }
        System.out.println("没有和为"+target+"的索引对");
    }
}
```
[运行结果]
```text
0,1
```
- 要求：输出所有满足要求的情况  
  对应代码：**SumDemo2.java**
```java
public class SumDemo2 {
    //两数之和
    //输出所有满足要求的情况
    public static void main(String[] args) {
        //定义数组
        int[] arr = {2,7,11,15,1,8};
        int target =9;
        int count =0;
        //用变量定义一个慢指针
        int low = 0;
        while(low<arr.length-1){
            int fast = low+1;
            while(fast<arr.length){
                if(arr[low]+arr[fast]==target){
                    System.out.println(low+","+fast);
                    count++;
                }
                fast++;
            }
            low++;
        }
        if (count==0)
            System.out.println("没有和为"+target+"的索引对");
    }

}
```
[运行结果]
```text
0,1
4,5
```
### 合并有序数组
**题目：给你两个有序数组arr1和arr2，将两个数组中的数据合并到一个大数组中。**
- 要求：合并之后的数组也是有序的  
  对应代码：**MergeArray.java**
```java
public class MergeArray {
    //合并有序数组
    public static void main(String[] args) {
        //定义两个数组
        int[] arr1 = {1,3,5,7,9};
        int[] arr2 = {2,4,6,8,10};
        //定义一个动态初始化数组
        int[] arr3 = new int[arr1.length+arr2.length];
       int i = 0;//arr3的指针
       int p1 = 0;//arr1的指针
       int p2 = 0;//arr2的指针
        //合并两个有序数组
        while(p1 < arr1.length && p2 < arr2.length){
            if (arr1[p1] <= arr2[p2]){
                arr3[i]=arr1[p1];
                p1++;
            }else{
                arr3[i] = arr2[p2];
                p2++;
            }
            i++;
        }
        //如果arr1和arr2的长度不一样，那么要么p1会有剩余，要么p2会有剩余
        //处理arr1中剩余的元素
        while (p1 < arr1.length){
            arr3[i]=arr1[p1];
            p1++;
            i++;
        }
        //处理arr2中剩余的元素
        while (p2 < arr2.length){
            arr3[i]=arr2[p2];
            p2++;
            i++;
        }
        for (int j = 0;  j< arr3.length; j++) {
            System.out.print(arr3[j]+" ");
        }
    }
}

```
[运行结果]
```text
1 2 3 4 5 6 7 8 9 10 
```
### 查找元素
**题目：给定一个递增的有序数组和一个目标值，在数组中找到目标值，打印其索引。如果目标值不存在于数组中，打印应插入的位置。**  
对应代码：**LeetSearch.java**
```java
public class LeetSearch {
    //查找元素
    /*
    思路：遍历数组，找到第一个nums[i]>=target的值
    如果该位置的值==target，返回该位置（找到了）
    如果该位置的值>target，返回该位置（插入位置）
    如果遍历完都没找到，说明target最大，插入到末尾
     */
    public static void main(String[] args) {
        //定义数组
        int[] nums = {1,3,5,6};
        int target = 3;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>=target){
                System.out.println(i);
                return;//如果找到了直接退出主入口
            }
        }
        //遍历完都没找到，说明target比所有元素都大，插入末尾
        System.out.println(nums.length);
    }
}

```
[运行结果1]
```text
1
```
[运行结果2]
```text
//target赋值为2
1
```
[运行结果3]
```text
//target赋值为7
4
```