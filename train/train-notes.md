- [原理](#原理)
    - [Java的运行机制](#java的运行机制)
    - [内存和内存地址](#内存和内存地址)
        - [内存](#内存)
        - [内存地址](#内存地址)
    - [Java中的内存分配](#java中的内存分配)
        - [栈内存](#栈内存)
        - [堆内存](#堆内存)
        - [方法区](#方法区)
        - [本地方法栈](#本地方法栈)
        - [程序计数器](#程序计数器)
        - [简单示例](#简单示例)
    - [数组的内存分配](#数组的内存分配)
- [算法训练](#算法训练)
    - [移除元素](#移除元素)
    - [红包问题](#红包问题)
    - [中位数](#中位数)
    - [统计个数](#统计个数)
        - [基础版](#基础版)
        - [进阶版](#进阶版)
    - [接雨水](#接雨水)
        - [动态规划思想DP](#动态规划思想dp)
    - [大乐透](#大乐透)

配套完整代码：GitHub仓库  
<https://github.com/LIN-commit/java-learning>  
代码所在目录：java-learning/train/  
本节对应代码：
- RemoveDemo1.java :使用创建新数组的方式，移除元素
- RemoveDemo2.java :使用两个指针，移除元素
- RedPacket.java :红包问题
- MiddleNumber.java :中位数
- CountDemo_error.java :统计个数，忽略出现并列第一的情况
- CountDemo_right.java :统计个数
- RainDemo.java :接雨水
- LotteryDemo.java :大乐透

# 原理
## Java的运行机制
- **Java程序运行的过程是怎样的？**  
  Java文件-->class字节码文件-->结果
- **Java是直接运行在操作系统里面的吗？**  
  不是，是运行在虚拟机里面的
- **虚拟机的好处是什么？**  
  利用虚拟机可以实现跨平台
- **为什么要跨平台？**  
  写一套代码，可以在任意的操作系统中运行
## 内存和内存地址
### 内存
软件在运行时，用来临时存储数据的
### 内存地址
给内存编号，更好地查找数据。这个编号就是内存地址
- 64位的系统：以64位的二进制表示
- 阅读弊端：二进制太长，转为十六进制
## Java中的内存分配
### 栈内存
**方法**被调用进栈执行，执行完毕出栈
### 堆内存
所有线程共享，存储对象、数组、字符串常量池  
小贴士：可以记为只要出现**new关键字**，就会涉及堆内存
### 方法区
存储**字节码信息**、常量、静态变量
### 本地方法栈
调用本地Native方法
### 程序计数器
记录当前线程执行的字节码指令地址（行号）
### 简单示例
```java
public class test {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}
```
这段代码涉及到的内存分配，有栈内存和方法区。  
（只有涉及到new这个关键字，才会涉及堆内存）
## 数组的内存分配
`int[] arr = {1,2,3};`  
注意：这个代码虽然看起来没有new，但是这段代码的完整版是  
`int[] arr= new int[] {1,2,3};`  
代码含有new关键字，所以还涉及堆内存。
# 算法训练
## 移除元素
**题目：给你一个数组nums和一个值val，你需要删除所有数值等于val的元素**  
方法一：创建一个新数组，存放数值和val不同的数据  
对应代码：**RemoveDemo1.java**
```java
public class RemoveDemo1 {
    //给你一个数组nums和一个值val，你需要删除所有数值等于val的元素
    /*
    举例1:
    输入：nums = [3,2,2,3] val = 3;
    输出：nums = [2,2] 剩余2个元素
    举例2：
    输入：nums = [0,1,2,2,3,0,4,2] val = 2
    输出：nums = [0,1,3,0,4] 剩余5个元素
     */
    //方法一：创建新数组，存放数值不等于val的数据
    public static void main(String[] args) {

        //定义原数组
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;

        //统计原数组中有多少数不低于val
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=val){
                count++;
            }
        }
        //定义一个新数组
        int[] arr = new int[count];
        //定义一个索引，用于在新数组中存放数据
        int index =0;
        //移除数值和val相同的数据
        for (int j = 0; j < nums.length; j++) {
            if(nums[j]!=val){
                arr[index]=nums[j];
                index++;
            }
        }
        //遍历打印新数组
        for (int k = 0; k < arr.length; k++) {
            System.out.print(arr[k]+" ");
        }
    }
}

```
[运行结果]
```text
0 1 3 0 4 
```
方法二：定义两个变量作为指针，直接在原数组上修改  
对应代码：**RemoveDemo2.java**
```java
public class RemoveDemo2 {
    //给你一个数组nums和一个值val，你需要删除所有数值等于val的元素
    /*
    举例1:
    输入：nums = [3,2,2,3] val = 3;
    输出：nums = [2,2] 剩余2个元素
    举例2：
    输入：nums = [0,1,2,2,3,0,4,2] val = 2
    输出：nums = [0,1,3,0,4] 剩余5个元素
     */
    //方法二：创建两个指针，在数组上直接修改
    public static void main(String[] args) {
        //定义数组
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        //定义两个数组
        int fast = 0;//用于遍历整个数组
        int slow = 0;//用于存入数据
        //遍历数组
        for ( fast = 0; fast < nums.length; fast++) {
            if(nums[fast]!=val){
                nums[slow]=nums[fast];
                slow++;
            }
        }
        for (int i = 0; i < slow; i++) {
            System.out.print(nums[i]+" ");
        }
    }
}


```
[运行结果]
```text
0 1 3 0 4 
```
方法一和方法二的区别：方法一的空间复杂度O(n)，因为创建了一个新数组，额外占用内存。方法二的空间复杂度是O(1)，占用内存少。
## 红包问题
**题目：给你两个整数M和N，M表示红包的总额，N表示红包的个数。现在又N个人来抽红包，打印每个人领的红包金额**  
对应代码：
```java
import java.util.Random;

public class RedPacket {
    /*
    题目：给你两个整数M和N，M表示红包的总额，N表示红包的个数。
    现在有N个人来抽红包，每个红包的金额都是随机的，打印每个人领的红包金额
     要求一：每个人最少一块钱
     要求二：每个人领完红包后，至少预留1*（未抽红包人数）元钱
     要求三：最后一个人那剩余总金额
     */
    public static void main(String[] args) {
        //生成随机数
        Random r = new Random();
        int n = 5;//红包个数
        int m = 100;//红包总金额
        //循环打印红包金额
        for (int i = 1; i <= (n-1); i++) {
            int k = n-i;
            int max = m-k;//每个红包金额不能为0，所以至少为未抽红包的人，每人留下一元
             int money = r.nextInt(max)+1;
             m-=money;
            System.out.println("第"+i+"个红包金额为"+money);
        }
        System.out.println("第"+n+"个红包金额为"+m);
    }
}

```
[运行结果]
```text
第1个红包金额为7
第2个红包金额为2
第3个红包金额为54
第4个红包金额为19
第5个红包金额为18
```
## 中位数
**题目：给定两个正序数组arr1和arr2，请先合并数组，并找出合并之后数组的中位数**  
对应代码：**MiddleNumber.java**
```java
public class MiddleNumber {
    /*题目：给定两个正序数组arr1和arr2，
    请先合并数组，并找出合并之后数组的中位数
    示例：
    1 2 3 4 5 6 7 8 9 中位数：5
    1 2 3 4 5 6 中位数：3.5
     */
    public static void main(String[] args) {
        //定义数组
        int[] arr1 = {3,4,5,6};
        int[] arr2 = {1,2};
        //定义一个新数组，用于存放合并后的数据
        int[] newArr = new int[arr1.length+arr2.length];
        //定义两个指针,用于比较两个数组的值
        int p1 = 0;
        int p2 = 0;
        //定义新数组的索引
        int index = 0;
        while(p1<arr1.length && p2<arr2.length){
            if (arr1[p1]<arr2[p2]){
                newArr[index]=arr1[p1];
                p1++;
            }else{
                newArr[index]=arr2[p2];
                p2++;
            }
            index++;
        }
        //处理arr1剩余的数据
        while(p1<arr1.length){
            newArr[index]=arr1[p1];
            p1++;
            index++;
        }
        //处理arr2剩余的数据
        while(p2<arr2.length){
            newArr[index]=arr2[p2];
            p2++;
            index++;
        }
        //打印合并后的数组
        for (int i = 0; i < newArr.length; i++) {
            System.out.print(newArr[i]+" ");
        }
        if(newArr.length%2==0){
            double num = (newArr[newArr.length/2-1]+newArr[newArr.length/2])/2.0;
            /*如果只是把num数据类型改为double，结果变为3.0
            在计算过程中出现小数，结果才是3.5
            所以把2改为2.0
             */
            System.out.println("中位数是"+num);
        }else{
            System.out.println("中位数是"+newArr[(newArr.length-1)/2]);
        }
    }
}

```
[运行结果]
```text
1 2 3 4 5 6 中位数是3.5
```
## 统计个数
**题目：学校选举学生会主席，有5个候选人。全校20名同学参与投票（每人一票，可以弃权，或者选1-5号）。  
投票使用Random模拟。  
0：弃权。1~5：给对应的人投票  
要求1：统计每个候选人的得票数和得票率，找出得票最多的候选人？  
要求2：统计弃票数和弃票率是多少？**
### 基础版
对应代码：**CountDemo_error.java**
```java
import java.util.Random;

public class CountDemo_error {
    /*
    题目：学校选举学生会主席，有5个候选人。全校20名同学参与投票
    （每人一票，可以弃权，或者选1-5号）。
     投票使用Random模拟。
     0：弃权。1~5：给对应的人投票
    要求1：统计每个候选人的得票数和得票率，找出得票最多的候选人？
    要求2：统计弃票数和弃票率是多少？
     */
    /*
    思路：
    生成随机票数，将五个候选人看做一个数组，生成一个的票数序号，就给对应候选人+1
    同时还可以表示弃票，即数组索引为0时
     */
    public static void main(String[] args) {
        //生成随机投票序号
        Random r = new Random();
        //定义一个数组，索引0表示弃票，索引1~5表示每个候选人的得票数
        int[] arr = new int[6];
        //随机生成序号，存入数组
        for (int i = 0; i < 20; i++) {
            int vote = r.nextInt(6);
            arr[vote]++;
        }
        //此时数组中记录的是每一位候选人的得票数
        /*求得票最多的候选人，要去除弃票数
        就是先把索引1设为最大值，之后的每一个数再和它比较
         */
        int max = arr[1];
        int index = 1;
        for (int i = 0; i < arr.length; i++) {
            if(i==0){
                System.out.println("弃票数是"+arr[i]);
                System.out.println("弃票率是"+arr[i]/20.0);//如果不是20.0，则结果就是整数
            }
            else{
                System.out.println("第"+i+"位候选人的得票数是"+arr[i]);
                System.out.println("第"+i+"位候选人的得票率是"+arr[i]/20.0);
                if(max<arr[i]){
                    max = arr[i];
                    index = i;
                }
            }
        }
        System.out.println("得票最多的候选人是第"+index+"位候选人");
    }
}

```
[运行结果]
```text
弃票数是2
弃票率是0.1
第1位候选人的得票数是3
第1位候选人的得票率是0.15
第2位候选人的得票数是1
第2位候选人的得票率是0.05
第3位候选人的得票数是5
第3位候选人的得票率是0.25
第4位候选人的得票数是5
第4位候选人的得票率是0.25
第5位候选人的得票数是4
第5位候选人的得票率是0.2
得票最多的候选人是第3位候选人
```
这个代码有一个逻辑问题，就是当两位选手的票数并列第一时，只会输出一个，漏掉另一个
### 进阶版
修改后的对应代码：**CountDemo_right.java**
```java
import java.util.Random;

public class CountDemo_right {
    /*
    修改代码，让代码可以输出票数并列第一的两位候选人
     */
    public static void main(String[] args) {
        //生成随机投票序号
        Random r = new Random();
        //定义一个数组，索引0表示弃票，索引1~5表示每个候选人的得票数
        int[] arr = new int[6];
        //随机生成序号，存入数组
        for (int i = 0; i < 20; i++) {
            int vote = r.nextInt(6);
            arr[vote]++;
        }
        //此时数组中记录的是每一位候选人的得票数
        for (int i = 0; i < arr.length; i++) {
            if(i==0){
                System.out.println("弃票数是"+arr[i]);
                System.out.println("弃票率是"+arr[i]/20.0);//如果不是20.0，则结果就是整数
            }
            else{
                System.out.println("第"+i+"位候选人的得票数是"+arr[i]);
                System.out.println("第"+i+"位候选人的得票率是"+arr[i]/20.0);
            }
        }
        //===========重点，找最高票（支持并列）============
        //第一步，先找到最高票数
        int max = arr[1];
        int index = 1;
        for (int j = 1; j < arr.length; j++) {
            if (max<arr[j]){
                max = arr[j];
                index=j;
            }
        }
        //第二步，把所有票数==max的候选人都找出来
        System.out.println("得票数最多的候选人是：");
        for (int k = 0; k < arr.length; k++) {
            if (arr[k]==max){
                System.out.println(k+"号");
            }
        }
    }
}

```
[运行结果]
```text
弃票数是3
弃票率是0.15
第1位候选人的得票数是2
第1位候选人的得票率是0.1
第2位候选人的得票数是6
第2位候选人的得票率是0.3
第3位候选人的得票数是1
第3位候选人的得票率是0.05
第4位候选人的得票数是6
第4位候选人的得票率是0.3
第5位候选人的得票数是2
第5位候选人的得票率是0.1
得票数最多的候选人是：
2号
4号
```
## 接雨水
**题目：给定n个非负整数表示每个宽度为1的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水  
输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]  
输出：6  
解释：下面是有数组表示的高度图，在这种情况下，可以接6个单位的雨水**  
[柱子高度图]
![柱子高度图](https://raw.githubusercontent.com/LIN-commit/java-learning/refs/heads/master/images/%E5%B1%8F%E5%B9%95%E6%88%AA%E5%9B%BE%202026-05-15%20105045.png)

[下雨时的柱子高度图]  
![下雨时的柱子高度图](https://raw.githubusercontent.com/LIN-commit/java-learning/refs/heads/master/images/%E5%B1%8F%E5%B9%95%E6%88%AA%E5%9B%BE%202026-05-15%20105334.png)

[接到雨水的柱子高度图]
![接到雨水的柱子高度图](https://raw.githubusercontent.com/LIN-commit/java-learning/refs/heads/master/images/%E5%B1%8F%E5%B9%95%E6%88%AA%E5%9B%BE%202026-05-15%20105351.png)

### 动态规划思想DP
- 假设右边有一根无限长的柱子  
  ![右边有柱](https://raw.githubusercontent.com/LIN-commit/java-learning/refs/heads/master/images/%E5%B1%8F%E5%B9%95%E6%88%AA%E5%9B%BE%202026-05-15%20122639.png)

- 假设左边有一根无限长的柱子
  ![左边有柱](https://raw.githubusercontent.com/LIN-commit/java-learning/refs/heads/master/images/%E5%B1%8F%E5%B9%95%E6%88%AA%E5%9B%BE%202026-05-15%20122659.png)

- 将两张图片重合，找出其中重叠的部分
  ![重合](https://raw.githubusercontent.com/LIN-commit/java-learning/refs/heads/master/images/%E5%B1%8F%E5%B9%95%E6%88%AA%E5%9B%BE%202026-05-15%20122714.png)

其中的重叠部分，就是题目要求的接到多少雨水  
对应代码：**
```java
public class RainDemo {
    //接雨水
    public static void main(String[] args) {
        //1.定义数组
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        //2.求右边有柱子时，雨水和柱子的总面积
        //2.1 定义数组
        int[] leftMax = new int[arr.length];
        //2.2 比较最高的柱子
        int temp = arr[0];
        //3.遍历数组
        for (int i = 1; i < arr.length; i++) {
            if (temp < arr[i]){
                leftMax[i] = arr[i];
                temp = arr[i];
            }else{
                leftMax[i] = temp;
            }
        }
        //3.求左边有柱子时，雨水和柱子的总面积
        int[] rightMax = new int[arr.length];
        temp = arr[arr.length-1];
        for (int j = arr.length-1; j >=0; j--) {
            if (temp < arr[j]){
                rightMax[j]=arr[j];
                temp = arr[j];
            }
            else{
                rightMax[j]=temp;
            }
        }
        //4.求交集
        int[] result = new int[arr.length];
        for (int k = 0; k < arr.length; k++) {
            if (leftMax[k]<rightMax[k])
                result[k]=leftMax[k];
            else
                result[k]=rightMax[k];
        }
        //求雨水和柱子的总面积
        int sum =0;
        for (int i = 0; i < result.length; i++) {
            sum += result[i];
        }
        //雨水面积=总面积-柱子面积
        for (int i = 0; i < arr.length; i++) {
            sum = sum - arr[i];
        }
        System.out.println(sum);

    }
}

```
[运行结果]
```text
6
```
## 大乐透
**题目：  
彩票规则：  
前区：1~35 选5个号码（唯一）  
后区：1~12 选2个号码（唯一）  
跨区可重复**

**中奖规则：   
一等奖：5+2  
二等奖：5+1  
三等奖：5+0/4+2  
四等奖：4+1/3+2  
五等奖：4+0/3+1/2+2  
六等奖：3+0/1+2/2+1/0+2**  
对应代码：
```java
import java.util.Random;
import java.util.Scanner;

public class LotteryDemo {
    //用random生成中奖号码
    //用scanner键盘录入抽奖号码
    public static void main(String[] args) {
        //调用方法，生成中奖号码
       int[] lotterNumber= lotteryNumber();
        System.out.print("彩票号码是");
       print(lotterNumber);
       //调用方法，录入抽奖号码
        int[] buyNumber= buyNumber();
        System.out.print("抽奖号码是");
        print(buyNumber);
        //调用方法，判断中了几等奖
        getWinningNumber(lotterNumber,buyNumber);
    }

    //随机生成中奖号码
    public static int[] lotteryNumber(){
        Random r = new Random();
        int[] arr = new int[7];
        //生成前区号码，1~35中选5个，唯一
        for (int i = 0; i < 5; ) {
            int num = r.nextInt(1,36);
            boolean flag = contains(num,arr,0,4);
            if (!flag){
                arr[i]=num;
                i++;
            }
        }
       //生成后区号码，1~12中选2个，唯一
        for (int i = 0; i < 2; ) {
            int num = r.nextInt(1,13);
            boolean flag = contains(num,arr,5,6);
            if (!flag){
                arr[i+5]=num;
                i++;
            }
        }
        return arr;
    }
    //判断生成的号码是否唯一
    public static boolean contains (int num,int[] arr,int start,int end){
        for (int i = start; i <= end; i++) {
            if (arr[i]==num){
                return true;
            }
        }
        return false;
    }

    //键盘录入模拟抽奖
    public static int[] buyNumber(){
        Scanner sc = new Scanner (System.in);
        int[] arr = new int[7];
        //输入前区的5个抽奖号码
        for (int i = 0; i < 5; ) {
            System.out.print("请输入第"+(i+1)+"个彩票号码：");
            int num = sc.nextInt();
            //判断范围
            if (num<1||num>35){
                System.out.println("当前输入的数字不在范围当中，请重新输入");
                continue;
            }
            //判断唯一
            boolean flag = contains(num,arr,0,4);
            if(flag){
                System.out.println("当前输入的数字已存在，请重新输入");
                continue;
            }
            arr[i]=num;
            i++;
        }
        //输入后区两个抽奖号码
        for (int i = 0; i < 2; ) {
            System.out.print("请输入第"+(i+6)+"个彩票号码：");
            int num = sc.nextInt();
            //判断范围
            if (num<1||num>12){
                System.out.println("当前输入的数字不在范围当中，请重新输入");
                continue;
            }
            //判断唯一
            boolean flag = contains(num,arr,5,6);
            if (flag){
                System.out.println("当前输入的数字已存在，请重新输入");
                continue;
            }
            arr[i+5]=num;
            i++;
        }
        return arr;
    }

    //打印数组
    public static void print(int[] arr){
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if(i==arr.length-1){
                System.out.print(arr[i]);
            }else {
                System.out.print(arr[i]+",");
            }
        }
        System.out.println("]");
    }

    //判断中了几等奖
    public static void getWinningNumber(int[] arr1,int[] arr2){
        int count1 = getCount(arr1,arr2,0,4);
        int count2 = getCount(arr1,arr2,5,6);
        if (count1==5 && count2==2)
            System.out.println("中了一等奖");
        else if(count1==5 && count2==1)
            System.out.println("中了二等奖");
        else if((count1==5 && count2==0) || (count1==4 && count2==2))
            System.out.println("中了三等奖");
        else if((count1==4&&count2==1)||(count1==3&&count2==2))
            System.out.println("中了四等奖");
        else if ((count1==4 && count2==0)||(count1==3 && count2==1)||(count1==2 && count2==2))
            System.out.println("中了五等奖");
        else if ((count1==3 && count2==0)||(count1==1 && count2==2)||(count1==2 && count2==1)||(count1==0 && count2==2))
            System.out.println("中了六等奖");
        else
            System.out.println("没中奖");
    }
    //判断前区或后区中了几个球
    public static int getCount(int[] arr1,int[] arr2,int start,int end){
        int count = 0;
        for (int i = start;i<=end;i++){
            boolean flag = contains(arr2[i],arr1,start,end);
            if(flag){
                count++;
            }
        }
        return count;
    }


}

```
[运行结果1]
```text
彩票号码是[32,17,22,14,10,8,11]
请输入第1个彩票号码：17
请输入第2个彩票号码：32
请输入第3个彩票号码：8
请输入第4个彩票号码：14
请输入第5个彩票号码：11
请输入第6个彩票号码：11
请输入第7个彩票号码：2
抽奖号码是[17,32,8,14,11,11,2]
中了五等奖
```
[运行结果2]
```text
彩票号码是[35,4,14,10,33,4,7]
请输入第1个彩票号码：8
请输入第2个彩票号码：22
请输入第3个彩票号码：4
请输入第4个彩票号码：6
请输入第5个彩票号码：19
请输入第6个彩票号码：2
请输入第7个彩票号码：12
抽奖号码是[8,22,4,6,19,2,12]
没中奖
```
[运行结果3]
```text
彩票号码是[17,8,34,19,16,6,3]
请输入第1个彩票号码：8
请输入第2个彩票号码：34
请输入第3个彩票号码：19
请输入第4个彩票号码：8
当前输入的数字已存在，请重新输入
请输入第4个彩票号码：16
请输入第5个彩票号码：7
请输入第6个彩票号码：3
请输入第7个彩票号码：6
抽奖号码是[8,34,19,16,7,3,6]
中了三等奖
```
