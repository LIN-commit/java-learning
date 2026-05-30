- [继承](#继承)
    - [什么是继承](#什么是继承)
    - [继承的好处](#继承的好处)
        - [示例](#示例)
    - [如何设计继承结构](#如何设计继承结构)
        - [示例](#示例-1)
    - [继承的特点](#继承的特点)
    - [继承中的成员特点](#继承中的成员特点)
        - [成员变量](#成员变量)
        - [如果出现重名的成员变量](#如果出现重名的成员变量)
        - [示例](#示例-2)
        - [成员方法](#成员方法)
        - [方法的重写](#方法的重写)
        - [示例](#示例-3)
        - [练习1](#练习1)
        - [方法重写的注意事项](#方法重写的注意事项)
        - [构造方法](#构造方法)
        - [示例](#示例-4)
    - [this和super关键字](#this和super关键字)
        - [this](#this)
        - [super](#super)
        - [示例](#示例-5)
        - [this调用本类构造方法的细节](#this调用本类构造方法的细节)
    - [总结：类中调用其他类的变量和方法](#总结类中调用其他类的变量和方法)
        - [调用普通类（非继承）](#调用普通类非继承)
        - [调用继承类（子类调用父类）](#调用继承类子类调用父类)
        - [如果对方是静态static的](#如果对方是静态static的)
    - [带有继承结构的标准JavaBean类](#带有继承结构的标准javabean类)
        - [练习一](#练习一)
        - [练习二](#练习二)
    - [继承的底层原理](#继承的底层原理)
        - [子类真正能继承父类的是什么](#子类真正能继承父类的是什么)
    - [Java中的权限修饰符](#java中的权限修饰符)

配套完整代码：GitHub仓库  
<https://github.com/LIN-commit/java-learning>  
代码所在目录：java-learning/oop_high/
# 继承
- 面向对象的三个特征：**封装，继承，多态**
- **封装**：我们写的Javabean类就是封装，将多个零散的变量封装起来
## 什么是继承
继承是类与类之间的一种父子关系，Java中提供关键字extends，用于建立类与类之间的关系
```java
public class Student extends Person{

}
```
- Student是**子类**，或者称为**派生类**
- Person是**父类**，或者称为**基类/超类**
## 继承的好处
- 可以把多个子类中重复的代码抽取到父类中，提高代码的复用性
- 子类可以在父类的基础上，增加其他的功能，使子类更强大
### 示例
**题目：利用继承定义下面的Javabean类，分别描述学生和老师**  
学生：  
属性：姓名，年龄，年级  
行为：吃饭，学习  
老师：  
属性：姓名，年龄，学科
行为：吃饭，教书

对应package:**oop_extend_test1**  
对应代码：
- **Person.java**
- **Student.java**
- **Teacher.java**
- **test.java**
  父类
```java
package oop_extend_test1;

public class Person {
    //父类
    //老师和学生共同的属性
    String name;
    int age;

    //老师和学生共同的行为
    public void eat(){
        System.out.println("吃饭");
    }
}

```
子类
```java
package oop_extend_test1;

public class Student extends Person{
    //学生特有的属性
    String grade;

    //学生特有的行为
    public void study(){
        System.out.println("学生在学习");
    }
}

```
子类
```java
package oop_extend_test1;

public class Teacher extends Person{
    //老师特有的属性
    String subject;

    //老师特有的行为
    public void teach(){
        System.out.println("老师在教书");
    }
}

```
测试类
```java
package oop_extend_test1;

public class test {
    public static void main(String[] args) {
        //创建对象
        Student s = new Student();
        s.name = "小明";
        s.age = 8;
        s.grade = "二年级";
        System.out.println(s.name+"，"+s.age+"岁，"+s.grade);
        s.eat();
        s.study();

        System.out.println("-----------------");

        //创建老师的对象
        Teacher t = new Teacher();
        t.name = "蓝猫老师";
        t.age = 20;
        t.subject = "计算机学科";
        System.out.println(t.name+"，"+t.age+"岁，"+t.subject);
        t.eat();
        t.teach();

    }
}

```
[运行结果]
```text
小明，8岁，二年级
吃饭
学生在学习
-----------------
蓝猫老师，20岁，计算机学科
吃饭
老师在教书
```
## 如何设计继承结构
当类与类之间，存在相同（共性）的内容，并满足子类是父类的一种，就可以考虑使用继承，来优化代码  
**复杂的继承结构如何设计？**
- 第一步：画图法
- 第二步：分类
- 第三步：抽取共性的内容不断往上抽取（从下往上）
- 第四步：写代码（从上往下写）
### 示例
**题目：现在有三个电子设备，请设计他们的继承结构**
- 安卓手机：  
  属性：品牌，价格  
  行为：打电话，发短信，NFC功能
- 苹果手机：  
  属性：品牌，价格  
  行为：打电话，发短信
- 笔记本电脑  
  属性：品牌，价格  
  行为：编程  
  ![](https://raw.githubusercontent.com/LIN-commit/java-learning/refs/heads/master/images/%E5%B1%8F%E5%B9%95%E6%88%AA%E5%9B%BE%202026-05-23%20124946.png)

对应package：**oop_extend_test2**  
对应代码：
- **Facility.java**
- **Phone.java**
- **Android.java**
- **Apple.java**
- **Laptop.java**
- **test.java**  
  智能设备
```java
package oop_extend_test2;

public class Facility {
    //三个智能设备的共同属性
    String brand;
    int price;
}
```
手机
```java
package oop_extend_test2;

public class Phone extends Facility{
    //两个手机的共同行为
    public void call(){
        System.out.println("利用手机打电话");
    }
    public void information(){
        System.out.println("利用手机发短信");
    }
}
```
安卓手机
```java
package oop_extend_test2;

public class Android extends Phone{
    //安卓手机的特有行为
    public void nfc(){
        System.out.println("安卓手机有nfc功能");
    }
}

```
苹果手机
```java
package oop_extend_test2;

public class Apple extends Phone{

}
```
笔记本电脑
```java
package oop_extend_test2;

public class Laptop extends Facility{
    //笔记本电脑特有的行为
    public void code(){
        System.out.println("利用笔记本电脑编程");
    }
}

```
测试类
```java
package oop_extend_test2;

public class test {
    public static void main(String[] args) {
        Android p1 = new Android();
        p1.brand ="安卓";
        p1.price =1999 ;
        System.out.println(p1.brand+","+p1.price);
        p1.call();
        p1.information();
        p1.nfc();
        System.out.println("-------------");
        Apple p2 = new Apple();
        p2.brand = "苹果";
        p2.price = 5999;
        System.out.println(p2.brand+","+p2.price);
        p2.call();
        p2.information();
        System.out.println("-------------");
        Laptop l = new Laptop();
        l.brand = "拯救者";
        l.price =10000 ;
        System.out.println(l.brand+","+l.price);
        l.code();
    }
}

```
[运行结果]
```text
安卓,1999
利用手机打电话
利用手机发短信
安卓手机有nfc功能
-------------
苹果,5999
利用手机打电话
利用手机发短信
-------------
拯救者,10000
利用笔记本电脑编程
```
## 继承的特点
- Java只支持**单继承**，不支持**多继承**，但支持**多层继承**  
  （1）**单继承**：一个子类只能继承一个父类  
  （2）**不能多继承**：子类不能同时继承多个父类
- 直接继承的父类叫作**直接父类**，间接继承的父类叫作**间接父类**
- Java中的顶级父类为：**Object**，每一个类都直接或间接的继承于Object
## 继承中的成员特点
### 成员变量
**书写规则**：把多个子类中相同的属性抽取到父类  
**调用规则**：遵守就近原则  
**就近原则**：先在局部位置找，本类成员位置找，父类成员位置找，逐级往上
### 如果出现重名的成员变量
```java
System.out.println(name);
System.out.println(this.name);
System.out.println(super.name);
```
- **this**:本类
- **super**:父类
### 示例
对应package:**oop_extend_test3**  
对应代码：
- **Fu.java**
- **Zi.java**
- **Test.java**
```java
package oop_extend_test3;

public class Fu {
    String name = "Fu";
}
```
```java
package oop_extend_test3;

public class Zi extends Fu{
    String name = "Zi";
    public void show(){
        String name = "ziShow";
        System.out.println(name);//局部变量
        System.out.println(this.name);//本类中的成员变量
        System.out.println(super.name);//父类中的变量
    }
}

```
```java
package oop_extend_test3;

public class Test {
    public static void main(String[] args) {
        Zi z = new Zi();
        z.show();

    }
}

```
[运行结果]
```text
ziShow
Zi
Fu
```
### 成员方法
**书写规则**:把多个子类中的共性成员方法抽取到父类当中  
**调用规则**：遵守就近原则  
**小贴士**：在子类的非静态方法中，调用父类的非静态方法，不需要创建父类对象，直接用`super.方法名()`调用即可
### 方法的重写
**方法重写**：在子类中，把父类的方法再写一遍，方法申明保持一致  
**使用场景**：如果父类的方法不能满足子类的要求了，子类中可以把该方法再写一遍
### 示例
**题目：手机的Javabean类**  
第一代手机：  
功能：打电话  
第二代手机：  
功能：打电话，发短信  
第三代手机：  
功能：打电话升级为视频通话，发短信，玩游戏  
对应package：**oop_extend_test4**  
对应代码：
- **FirstGeneration.java**
- **SecondGeneration.java**
- **ThirdGeneration.java**
- **Test.java**  
  第一代手机
```java
package oop_extend_test4;

public class FirstGeneration {
    //行为：打电话
    public void call(){
        System.out.println("利用手机打电话");
    }
}

```
第二代手机
```java
package oop_extend_test4;

public class SecondGeneration extends FirstGeneration{
    //特有行为：发短信
    public void sendMessage(){
        System.out.println("利用手机发短信");
    }
}

```
第三代手机
```java
package oop_extend_test4;

public class ThirdGeneration extends SecondGeneration{
    //按住Alt+Insert,选择override,选择要重写的方法
    /*
    注释/注解：都是对代码的解释说明
    注释：给程序员看的（文字性的内容）
    注解：给虚拟机看的
     */
    //@Override就是注解，让虚拟机检查我们重写的方法是否和原方法的格式相同
    @Override
    public void call() {
        System.out.println("开启视频");
        System.out.println("用手机打视频通话");
    }

    public void game(){
        System.out.println("利用手机打游戏");
    }
}

```
测试类
```java
package oop_extend_test4;

public class Test {
    
    public static void main(String[] args) {
        //创建第一代手机的对象
        FirstGeneration phone1 = new FirstGeneration();
        phone1.call();
        System.out.println("-----------------");
        //创建第二代手机的对象
        SecondGeneration phone2 = new SecondGeneration();
        phone2.call();
        phone2.sendMessage();
        System.out.println("-------------------");
        //创建第三代手机的对象
        ThirdGeneration phone3 = new ThirdGeneration();
        phone3.call();
        phone3.sendMessage();
        phone3.game();
    }
}

```
[运行结果]
```text
利用手机打电话
-----------------
利用手机打电话
利用手机发短信
-------------------
开启视频
用手机打视频通话
利用手机发短信
利用手机打游戏
```
### 练习1
**题目：某电商项目售卖智能设备，包括：手机，笔记本电脑，平板**  
1.所有智能设备有以下属性：商品名，商品价格行为  
计算商品价格：  
[0~1000)元，不打折  
[1000~5000)元，9折  
[5000~10000)元，8折  
超出10000元，7折  
2.手机享受额外补贴，在原有基础上打9折  
3.笔记本电脑和平板电脑不享受额外补贴  
对应package:**oop_extend_test5**  
对应代码：
- **SmartDevice.java**
- **Phone.java**
- **Laptop.java**
- **Test.java**
```java
package oop_extend_test5;

public class SmartDevice {
    String name;
    double price;
    public double payment(){
        if(price>=0 && price<1000){
            return price;
        }else if(price>=1000 && price<5000){
            return price*0.9;
        }else if(price>=5000 && price<10000){
            return price*0.8;
        }else if(price>=10000){
            return price*0.7;
        }else{
            return 0;
        }
    }
}

```
```java
package oop_extend_test5;

public class Phone extends SmartDevice {
    /*
    方法重写要注意：
    如果父类中的代码，我一行都不想用，就在子类中的方法体重新写一遍完整的代码
    如果父类中的代码我还想用，此时我只是在父类的基础上再加其他的逻辑
    此时可以先通过super关键字调用父类的方法，得到一个结果，再对这个结果进行操作
     */
    @Override
    public double payment() {
        //调用父类中的方法，得到基础价格
        double price = super.payment();
        return price*0.9;
    }
}

```
```java
package oop_extend_test5;

public class Laptop extends SmartDevice{
}
```
```java
package oop_extend_test5;

public class Test {
    public static void main(String[] args) {
        //创建子类对象，并查看结果
        Phone p = new Phone();
        p.name = "小米";
        p.price = 4999;
        double payment = p.payment();
        System.out.println(payment);
        System.out.println("---------------");
        Laptop lt = new Laptop();
        lt.name = "联想";
        lt.price = 10000;
        System.out.println(lt.payment());
    }
}

```

[运行结果]
```text
4049.1900000000005
---------------
7000.0
```
### 方法重写的注意事项
- 重写方法的名称，形参列表必须与父类中的一致，方法体按照实际需求书写
- final修饰类为最终类，里面所有的方法不能被重写
- private私有方法，static静态方法，final最终方法不能被重写
### 构造方法
父类中的构造方法不会被子类继承，只能通过super关键字调用
![](https://raw.githubusercontent.com/LIN-commit/java-learning/refs/heads/master/images/%E5%B1%8F%E5%B9%95%E6%88%AA%E5%9B%BE%202026-05-23%20170036.png)

**继承结构当中构造方法的小细节**
- 子类构造方法的第一行，有一个默认的`super()`，如果我们没写，JVM也会自动加上
- 如果想要访问父类的带参构造，`super(参数)`必须手动写上，不能省略
- 在创建对象的时候，先执行父类的构造方法，在执行子类的构造方法
### 示例
**题目：  
老师：  
属性：姓名，年龄，年级  
学生：  
属性：姓名，年龄，学科**  
对应package:**oop_extend_test6**  
对应代码：
- **Person.java**
- **Student.java**
- **Teacher.java**
- **Test.java**
```java
package oop_extend_test6;

public class Person {
    String name;
    int age;
    public Person(){
        System.out.println("Person空参构造被调用了");
    }
    public Person(String name,int age){
        this.name = name;
        this.age = age;
        System.out.println("父类的带参构造执行了");
    }
}

```
```java
package oop_extend_test6;

public class Student extends Person{
    String grade;
    //构造方法
    //1.空参构造
    public Student(){
        System.out.println("子类Student的空参构造执行了");
    }
    //2.带全部参数构造
    //父类中的属性：通过super（参数）的形式传递给父类的构造方法，用来赋值
    //子类中的属性：自己赋值
    public Student(String name,int age,String grade) {
        super(name, age);
        this.grade = grade;
        System.out.println("子类的带参构造执行了");
    }
}

```
```java
package oop_extend_test6;

public class Teacher extends Person{
    String subject;
    //构造方法快捷键：Alt+Insert
    public Teacher(){
        System.out.println("Teacher的空参构造被调用了");
    }
    public Teacher(String name,int age,String subject){
        super(name,age);
        this.subject = subject;
    }
}

```
```java
package oop_extend_test6;

public class Test {
    public static void main(String[] args) {
        Student stu = new Student("张三",16,"高一");
        //如果忘记了赋值的变量，点击括号，按住ctrl+p，就会显示了
        System.out.println(stu.name+", "+stu.age+", "+stu.grade);
        System.out.println("--------------");
        Teacher t = new Teacher();

    }
}

```
[运行结果]
```text
父类的带参构造执行了
子类的带参构造执行了
张三, 16, 高一
--------------
Person空参构造被调用了
Teacher的空参构造被调用了
```
## this和super关键字
### this
- `this.成员变量`访问**本类**成员变量
- `this.成员方法(…)`访问**本类**成员方法
- `this(…)`访问**本类**的其他构造方法
### super
- `super.成员变量`访问**父类**成员变量
- `super.成员方法(…)`访问**父类**成员方法
- `super(…)`访问**父类**构造方法
### 示例
**题目：按照下面的需求书写一个JavaBean  
学生：  
属性：姓名，年龄  
现在认为学生的默认名字为同学，默认年龄是18岁**  
对应package：**oop_extend_test7**  
对应代码：
- **Student.java**
- **Test.java**
```java
package oop_extend_test7;

public class Student {
    String name;
    int age;

    //this()：调用本类中的其他构造方法
    //Java规定，在构造方法中，使用this(...)调用本类其他构造方法时，它必须是构造方法的第一条语句
    public Student() {
        System.out.println("Student空参构造被调用了");
        //新版本可以把打印语句放在第一行，旧版本必须把this语句放第一行
        this("张三",18);
        //这里的this调用的是下面那个构造方法
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
```
```java
package oop_extend_test7;

public class Test {
    public static void main(String[] args) {
        Student stu = new Student();
        //这里调用的是空参构造，而空参构造调用了全参构造并给成员变量赋值了
        System.out.println(stu.name+", "+stu.age);
    }
}
```
[运行结果]
```text
Student空参构造被调用了
张三, 18
```
### this调用本类构造方法的细节
- 如果子类中有很多构造方法时，不能用`this()`互相调用（互相调用会让代码陷入无限循环），一定要预留一个调用父类的构造方法
- 如果构造方法中写上了`this()`，就不能再写`super()`，JVM也不会自动添加
- 在老版本中，`this()`只能写在构造方法的第一行，但是在新版本中去掉了这一限制

## 总结：类中调用其他类的变量和方法
### 调用普通类（非继承）
必须先`new.对象`，再用`对象.xxx`  
比如你现在在Phone类中，调用Student类的变量  
1.**调用变量**
```java
Student a = new Student();
a.变量名;
```
2.**调用方法**
```java
Student a = new Student();
a.方法名（）;
```
### 调用继承类（子类调用父类）
不用new对象！  
父类中的public方法，子类继承后可以**直接调用**  
只有在这两种情况下，才需要用super
- 重写方法时，调用父类的原方法  
  `super.方法名（）`
- 父类和子类有同名变量，想明确调用父类变量  
  `super.变量名`
### 如果对方是静态static的
不用new对象！
- 调用变量`类名.变量名`
- 调用方法`类名.方法名()`
## 带有继承结构的标准JavaBean类
### 练习一
**题目：书写一个完整的继承体系，要求私有化成员变量，get/set方法，构造方法，其他的成员方法**
- 本科学生：  
  属性：姓名，年龄，年级  
  行为：吃饭，睡觉，学习（攻读学士学位）
- 硕士研究生：  
  属性：姓名，年龄，年级  
  行为：吃饭，睡觉，学习（攻读硕士学位）
- 专业课老师：  
  属性：姓名，年龄，学科  
  行为：吃饭，睡觉，教书（教专业课知识）
- 通识课老师：  
  属性：姓名，年龄  
  行为：吃饭，睡觉，教书（教通识课知识）
- 过了一段时间，硕士研究生住宿条件升级，在豪华版学生公寓睡觉  
  对应package:**oop_extend_case1**  
  对应代码：
- **Person.java**
- **Student.java**
- **Undergraduate.java**
- **Master.java**
- **Teacher.java**
- **MajorCourseTeacher.java**
- **GeneralEducationTeacher.java**
- **Test.java**
```java
package oop_extend_case1;

public class Person {
    //共同属性：姓名，年龄
    private String name;
    private int age;
    //空参构造
    public Person() {
    }
    //全参构造
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //get/set方法
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
    //共同的行为：吃饭，睡觉
    public void eat(){
        System.out.println("吃饭");
    }
    public void sleep(){
        System.out.println("睡觉");
    }
}

```
```java
package oop_extend_case1;

public class Student extends Person{
    //学生特有属性：年级
    private String grade;
    //空参构造
    public Student() {
    }
    //全参构造
    public Student(String name, int age, String grade) {
        super(name, age);
        this.grade = grade;
    }

    //get/set方法
    //父类中的public方法，子类继承后可以直接调用
    //这里只需要写grade的get/set方法
    public String getGrade() {
        return grade;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }

    //学生共同行为：学习
    public void study(){
        System.out.println("学生学习");
    }
}

```
```java
package oop_extend_case1;

public class Undergraduate extends Student{
    //空参构造
    public Undergraduate() {
    }
    //全参构造
    public Undergraduate(String name, int age, String grade) {
        super(name, age, grade);
    }

    //重写学习方法
    @Override
    public void study() {
        System.out.println("本科学生攻读学士学位");
    }
}

```
```java
package oop_extend_case1;

public class Master extends Student{
    //空参构造
    public Master() {
    }
    //全参构造
    public Master(String name, int age, String grade) {
        super(name, age, grade);
    }

    //重写方法

    @Override
    public void sleep() {
        super.sleep();
        System.out.println("过了一段时间，研究生住宿条件升级，在豪华版学生公寓睡觉");
    }

    //重写学习方法
    @Override
    public void study() {
        System.out.println("研究生攻读硕士学位");
    }
}

```
```java
package oop_extend_case1;

public class Teacher extends Person{
    //空参构造
    public Teacher() {
    }
    //全参构造
    public Teacher(String name, int age) {
        super(name, age);
    }

    //老师共同行为：教书
    public void teach(){
        System.out.println("教书");
    }
}

```
```java
package oop_extend_case1;

public class MajorCourseTeacher extends Teacher{
    //专业课老师特有属性：学科
    private String subject;

    //空参构造
    public MajorCourseTeacher() {
    }
    //全参构造
    public MajorCourseTeacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    //get/set方法
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    //重写教书方法
    @Override
    public void teach() {
        System.out.println("专业课老师教授专业课知识");
    }
}

```
```java
package oop_extend_case1;

public class GeneralEducationTeacher extends Teacher{
    //空参构造
    public GeneralEducationTeacher() {
    }
    //全参构造
    public GeneralEducationTeacher(String name, int age) {
        super(name, age);
    }
    //重写教书方法
    @Override
    public void teach() {
        System.out.println("通识课老师教授通识课知识");
    }
}

```
```java
package oop_extend_case1;

public class Test {
    public static void main(String[] args) {
        Undergraduate s1 = new Undergraduate("张三",18,"大一");
        System.out.println(s1.getName()+","+s1.getAge()+","+s1.getGrade());
        s1.eat();
        s1.sleep();
        s1.study();
        System.out.println("---------");
        Master s2 = new Master("李四",23,"研一");
        System.out.println(s2.getName()+","+s2.getAge()+","+s2.getGrade());
        s2.eat();
        s2.sleep();
        s2.study();
        System.out.println("-----------");
        MajorCourseTeacher t1 = new MajorCourseTeacher("蓝猫老师",20,"计算机");
        System.out.println(t1.getName()+","+t1.getAge()+","+t1.getSubject());
        t1.eat();
        t1.sleep();
        t1.teach();
        System.out.println("----------------");
        GeneralEducationTeacher t2 = new GeneralEducationTeacher("王老师",30);
        System.out.println(t2.getName()+","+t2.getAge());
        t2.eat();
        t2.sleep();
        t2.teach();

    }
}

```
[运行结果]
```text
张三,18,大一
吃饭
睡觉
本科学生攻读学士学位
---------
李四,23,研一
吃饭
睡觉
过了一段时间，研究生住宿条件升级，在豪华版学生公寓睡觉
研究生攻读硕士学位
-----------
蓝猫老师,20,计算机
吃饭
睡觉
专业课老师教授专业课知识
----------------
王老师,30
吃饭
睡觉
通识课老师教授通识课知识
```
### 练习二
**题目：  
1.经理  
成员变量：工号，姓名，工资，管理奖金  
成员方法：工作（管理其他人），吃饭（吃米饭）  
2.厨师：  
成员变量：工号，姓名，工资  
成员方法：工作（炒菜），吃饭（吃米饭）**  
对应package：**oop_extend_case2**  
对应代码：
- **Employee.java**
- **Manager.java**
- **Chef.java**
- **Test.java**
```java
package oop_extend_case2;

public class Employee {
    //共同属性
    private String number;
    private String name;
    private int salary;
    //空参构造
    public Employee() {
    }
    //全参构造
    public Employee(String number, String name, int salary) {
        this.number = number;
        this.name = name;
        this.salary = salary;
    }

    //get/set方法
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    //共同行为
    public void work(){
        System.out.println("工作");
    }
    public void eat(){
        System.out.println("吃饭");
        /*
        经理和厨师的吃饭行为只是当前场景下的共性表现，
        父类只负责定义通用行为规范，不应该写死具体实现，
        否则后续子类扩展时会失去灵活性。
         */
    }
}

```
```java
package oop_extend_case2;

public class Manager extends Employee{
    //经理特有的属性
    private int bonus;
    //空参构造
    public Manager() {
    }
    //全参构造
    public Manager(String number, String name, int salary, int bonus) {
        super(number, name, salary);
        this.bonus = bonus;
    }

    //get/set方法

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    //重写吃饭方法

    @Override
    public void eat() {
        System.out.println("吃米饭");
    }

    //重写工作方法
    @Override
    public void work() {
        System.out.println("经理的工作是管理其他人");
    }
}

```
```java
package oop_extend_case2;

public class Chef extends Employee{
    //空参构造
    public Chef() {
    }
    //全参构造
    public Chef(String number, String name, int salary) {
        super(number, name, salary);
    }

    //重写吃饭方法
    @Override
    public void eat() {
        System.out.println("吃米饭");
    }

    //重写工作方法
    @Override
    public void work() {
        System.out.println("厨师的工作是炒菜");
    }
}

```
```java
package oop_extend_case2;

public class Test {
    public static void main(String[] args) {
        Manager m = new Manager("010203","张三",6000,2000);
        System.out.println(m.getNumber()+","+m.getName()+",工资是"+m.getSalary()+",管理奖金是"+m.getBonus());
        m.eat();
        m.work();
        System.out.println("----------");
        Chef c = new Chef("040506","李四",5000);
        System.out.println(c.getNumber()+","+c.getName()+",工资是"+c.getSalary());
        c.eat();
        c.work();
    }
}

```
[运行结果]
```text
010203,张三,工资是6000,管理奖金是2000
吃米饭
经理的工作是管理其他人
----------
040506,李四,工资是5000
吃米饭
厨师的工作是炒菜
```
## 继承的底层原理
### 子类真正能继承父类的是什么
- **构造方法**：不能被子类继承，可以利用super关键字调用
- **成员变量**：可以被子类继承，private私有的也可以，但是私有的变量无法直接调用
- **成员方法**：**虚方法**可以被继承  
  **final修饰**的最终方法不能被继承，可以被调用  
  **static修饰**的静态方法不能被继承，可以被调用  
  **private修饰**的私有方法不能被继承，不能被调用  
  **方法重写**：子类替换虚方法表里方法的地址值

- **虚方法**：就是普通的成员方法，非final、非static、非private修饰的方法

## Java中的权限修饰符
**权限修饰符**：其实就是Java中的关键字，用来控制一个成员被访问的范围  
**修饰的内容**：可以修饰成员变量，成员方法，构造方法等  
**作用范围由小到大**：private<默认<protected<public
![](https://raw.githubusercontent.com/LIN-commit/java-learning/refs/heads/master/images/%E5%B1%8F%E5%B9%95%E6%88%AA%E5%9B%BE%202026-05-26%20193735.png)

以上就是java面向对象的继承内容了。下一篇我们将学习多态，欢迎继续关注蓝猫学姐的java学习笔记~
