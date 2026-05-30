- [面向对象](#面向对象)
    - [什么是面向对象](#什么是面向对象)
    - [类和对象](#类和对象)
        - [定义一个类描述一类事物](#定义一个类描述一类事物)
        - [创建对象，记录单独个体的所有信息](#创建对象记录单独个体的所有信息)
        - [练习](#练习)
        - [面向对象的小细节](#面向对象的小细节)
        - [练习](#练习-1)
    - [面向对象中的数据安全问题](#面向对象中的数据安全问题)
        - [private关键字](#private关键字)
        - [set/get方法](#setget方法)
        - [解决面向对象中的数据安全问题](#解决面向对象中的数据安全问题)
        - [练习1](#练习1)
        - [练习2](#练习2)
    - [this关键字](#this关键字)
        - [就近原则](#就近原则)
    - [构造方法](#构造方法)
        - [作用](#作用)
        - [格式](#格式)
        - [特点](#特点)
        - [执行时机](#执行时机)
        - [举例](#举例)
        - [练习](#练习-2)
        - [构造方法的注意事项](#构造方法的注意事项)

配套完整代码：GitHub仓库  
<https://github.com/LIN-commit/java-learning>  
代码所在目录：java-learning/oop/
# 面向对象
## 什么是面向对象
- 对象：把相关的数据和方法组织为一个**整体**来看待
- 面向对象：利用对象进行软件开发
## 类和对象
- 同一类的事物属性必须是一致的
### 定义一个类描述一类事物
- 类中的变量都不赋值
```java
public class Dog {
    String name;
    int age;
    double weight;
    String color;
}
```
### 创建对象，记录单独个体的所有信息
**1.创建对象**  
**创建对象的格式**：
```text
类名 对象名 = new 类名（）;**
```
`Dog d = new Dog ();`
- **new**:创建一个大空间
- **Dog**:管理狗狗的信息
- **d**:大空间的名字

**2.记录信息**
```java
public static void main(String[] args) {
        //创建对象
        Dog d1 = new Dog();
        //赋值
        d1.name = "小白";
        d1.age = 2;
        d1.weight = 3.5;
        d1.color = "白色";
    }
```
- **d**是对象名
- **.** 表示调用

记录第二只小狗的信息
（创建一个新对象）
```java
Dog d2 = new Dog();
d2.name = "大黄";
d2.age = 3;
d2.weight = 6.5;
d2.color = "黄色";
```
### 练习
**题目：利用面向对象思想表示狗狗（属性：名字，年龄，体重，毛发颜色）**  
对应package:**dogtest1**
对应代码：
- **Dog.java**
- **DogDemo1.java**  
  **（注：功能关联的类统一放一个包）**
```java
public class Dog {
    String name;
    int age;
    double weight;
    String color;
}

```
```java
public class DogDemo1 {
    public static void main(String[] args) {
        //1.记录第一只小狗的信息
        //创建对象
        Dog d1 = new Dog();
        //赋值
        d1.name = "小白";
        d1.age = 2;
        d1.weight = 3.5;
        d1.color = "白色";
        //获取第一只小狗的信息
        System.out.println(d1.name);
        System.out.println(d1.age);
        System.out.println(d1.weight);
        System.out.println(d1.color);

        System.out.println();

        //2.记录第二只小狗的信息
        Dog d2 = new Dog();
        d2.name = "大黄";
        d2.age = 3;
        d2.weight = 5.5;
        d2.color = "黄色";
        //获取第二只小狗的信息
        System.out.println(d2.name);
        System.out.println(d2.age);
        System.out.println(d2.weight);
        System.out.println(d2.color);
    }

}
```
[运行结果]
```text
小白
2
3.5
白色

大黄
3
5.5
黄色

```
**题目：创建对象记录学生信息**  
对应package:**student**  
对应代码：
- **Student.java**
- **StudentDemo.java**
```java
package student;

public class Student {
    String name;
    char gender;
    int age;
    double height;

}

```
```java
package student;

public class StudentDemo {
    public static void main(String[] args) {
        //记录第一个学生的信息
        Student s1 = new Student();
        s1.name = "良玉";
        s1.age = 25;
        s1.gender = '女';
        s1.height = 1.86;
        System.out.println(s1.name);
        System.out.println(s1.age);
        System.out.println(s1.gender);
        System.out.println(s1.height);

        System.out.println();

        //记录第二个学生的信息
        Student s2 = new Student();
        s2.name = "荀灌";
        s2.age = 13;
        s2.gender = '女';
        s2.height = 1.8;
        System.out.println(s2.name);
        System.out.println(s2.age);
        System.out.println(s2.gender);
        System.out.println(s2.height);
    }
}

```
[运行结果]
```text
良玉
25
女
1.86

荀灌
13
女
1.8
```
### 面向对象的小细节
- 描述一类事物的类叫**Javabean类**
- 带有main方法的叫作**测试类**
- Javabean类可以写属性和行为（行为表示这个类能干什么，用方法的形式体现）
- Javabean类中的方法不加**static**
### 练习
**题目：面向对象表示老师**
- 属性：姓名、年龄
- 行为：授课、吃饭、睡觉  
  对应package:**teacher**  
  对应代码：
- **Teacher.java**
- **TeacherDemo.java**
```java
package teacher;

public class Teacher {
    //属性
    String name ;
    int age;

    /*
    行为：表示这个类能干什么
    用方法表示
    在类中的方法不加static
     */
    //授课
    public void teach(){
        System.out.println("老师在授课");
    }

    //吃饭
    public void eat(){
        System.out.println("老师在吃饭");
    }

    //睡觉
    public void sleep(){
        System.out.println("老师在睡觉");
    }
}

```
```java
package teacher;

public class TeacherDemo {
    public static void main(String[] args) {
        //创建对象
        Teacher t = new Teacher();
        //赋值
        t.name = "张桂梅";
        t.age = 69;
        //获取老师的信息并打印在控制台
        System.out.println(t.name);
        System.out.println(t.age);
        //行为
        t.teach();
        t.eat();
        t.sleep();
    }

}

```
[运行结果]
```text
张桂梅
69
老师在授课
老师在吃饭
老师在睡觉
```
## 面向对象中的数据安全问题
### private关键字
是一个**权限修饰符**，可以修饰**成员变量**和**成员方法**
- **成员变量**：是定义在类中，同时定义在方法外的变量
```java
String name;
int age;
```
- **成员方法**：行为
- 特点：一旦被private修饰，只能**在本类中才能访问**，外界无法访问
```java
public class Dog{
    private int age;
}
```
此时变量age只能在本类Dog中访问，在其他类中`d.age = 5;`就会报错
### set/get方法
set 用于赋值，get 用于获取
```java
public class Dog {
    private int age;

    //set赋值
    public void setAge(int num){
        //判断num是否满足要求
    }

    //get获取
    public int getAge(){
        return age;
    }
}
```
这样的话，如果赋值的数据符合要求，就赋值成功，否则赋值失败
### 解决面向对象中的数据安全问题
1.私有化成员变量  
2.get/set方法
### 练习1
**题目：打印小狗的信息**  
对应package:**dogtest2**  
对应代码：
- **Dog2.java**
- **DogDemo2.java**
```java
package dogtest2;

public class Dog2 {
    //属性
    //姓名
    private String name;
    //年龄
    private int age;
    //get/set方法
    //姓名
    public void setName(String value){
        name =value;
    }
    public String getName(){
        return name;
    }
    //年龄
    public void setAge(int num){
        if (num>=0&&num<=15){
            age = num;
        }else{
            System.out.println(num+"不在限定范围内");
        }
    }
    public int getAge(){
        return age;
    }
    //行为
    public void eat(){
        System.out.println(age+"岁的"+name+"，正在吃骨头");
    }
}

```
```java
package dogtest2;

public class DogDemo2 {
    public static void main(String[] args) {
        /*
        小狗有属性：姓名、年龄
        行为：吃骨头
        要求1：小狗的年龄：0~15岁
        要求2：打印小狗所有的信息：小白，2岁
        要求3：调用吃骨头的方法，打印效果：2岁的小白，正在吃骨头
         */

        //创建对象
        Dog2 d = new Dog2();
        //赋值
        d.setName("小白");
        d.setAge(2);
        //打印小狗的信息
        System.out.println(d.getName()+","+d.getAge()+"岁");
        //打印小狗的行为
        d.eat();
    }

}

```
[运行结果]
```text
小白,2岁
2岁的小白，正在吃骨头
```
### 练习2
**题目：打印学生信息**  
对应package:**ooptest1**  
对应代码：
- **Student1.java**
- **StudentDemo1.java**
```java
package ooptest1;

public class Student1 {
    //属性
    private String name;
    private int age;
    private int height;
    private int weight;

    //get/set方法
    public void setName(String value){
        name = value;
    }
    public String getName(){
        return name;
    }

    public void setAge(int num){
        age = num;
    }
    public int getAge(){
        return age;
    }

    public void setHeight(int num){
        height = num;
    }
    public int getHeight(){
        return height;
    }

    public void setWeight(int num){
        weight = num;
    }
    public int getWeight(){
        return weight;
    }

    //行为
    public void study(){
        System.out.println(name +"努力学习");
    }
}

```
```java
package ooptest1;

public class StudentDemo1 {
    /*
    在校学生有属性：姓名，年龄，身高，体重
    行为：学习
    要求1：大一学生，张三，18岁，183cm，60kg，刚进大学努力学习
    要求2：大二期间张三体重增加了10kg
    要求3：大三期间张三身高增加2cm，体重减少3kg
    要求4：打印大学毕业之后，张三的所有信息
     */
    public static void main(String[] args) {
        Student1 s = new Student1();
        s.setName("张三");
        s.setAge(18);
        s.setHeight(183);
        s.setWeight(60);
        //大一
        System.out.println("大一学生，"+s.getName()+"，"+s.getAge()+"岁，"+s.getHeight()+"cm，"+s.getWeight()+"kg");
        System.out.print("刚进大学，");
        s.study();
        //大二
        //隐藏条件，年龄长一岁
        s.setAge(s.getAge()+1);
        s.setWeight(s.getWeight()+10);
        System.out.println("大二学生，"+s.getName()+"，"+s.getAge()+"岁，"+s.getHeight()+"cm，"+s.getWeight()+"kg");

        //大三
        s.setAge(s.getAge()+1);
        s.setHeight(s.getHeight()+2);
        s.setWeight(s.getWeight()-3);
        System.out.println("大三学生，"+s.getName()+"，"+s.getAge()+"岁，"+s.getHeight()+"cm，"+s.getWeight()+"kg");

        //刚上大四
        s.setAge(s.getAge()+1);
        System.out.println("大四学生，"+s.getName()+"，"+s.getAge()+"岁，"+s.getHeight()+"cm，"+s.getWeight()+"kg");
        //毕业
        s.setAge(s.getAge()+1);
        System.out.println("毕业，"+s.getName()+"，"+s.getAge()+"岁，"+s.getHeight()+"cm，"+s.getWeight()+"kg");

    }
}

```
[运行结果]
```text
大一学生，张三，18岁，183cm，60kg
刚进大学，张三努力学习
大二学生，张三，19岁，183cm，70kg
大三学生，张三，20岁，185cm，67kg
大四学生，张三，21岁，185cm，67kg
毕业，张三，22岁，185cm，67kg
```
## this关键字
- **成员变量**：定义在类中且定义在方法外的变量
- **局部变量**：定义在类中且定义在方法内的变量
### 就近原则
```java
public class Student{
    private int age;//成员变量
    //set赋值
    //如果将value改为age
    public void setAge(int age){//括号内是局部变量
        age = age;
        System.out.print(age);
    }
}
```

在上述代码中，如果将value改为age，那么打印的age是局部变量的age还是成员变量的age呢
- **就近原则**：使用变量时，先在方法中去找有没有对应的局部变量；如果有，就使用；如果没有，就去找对应的成员变量
- 所以代码`age=age``是错误的，两个age都是局部变量，是无法成功赋值的

如果方法中有对应的局部变量，但我需要使用成员变量呢？
- **this关键字**：直接使用成员变量，就给变量前加this  
  正确的代码是
```java
public class Student{
    private int age;//成员变量
    //set赋值
    //如果将value改为age
    public void setAge(int age){//括号内是局部变量
        this.age = age;
        System.out.print(this.age);
    }
}
```
## 构造方法
### 作用
在创建对象的时候给成员变量进行初始化的
### 格式
```text
修饰符 类名（参数）{
    方法体；
}
```
### 特点
- 方法名与类名相同，大小写也要一致
- 没有返回值类型，连void都没有
- 没有具体的返回值（不能由return带回结果数据）
### 执行时机
- 创建对象时由虚拟机调用，不能手动调用构造方法
- 每创建一次对象，就会调用一次构造方法
### 举例
```java
public class Student{
    private String name;
    private int age;
    public Student(){
        ......
        //空参构造方法
    }
    public Student(String name ,int age){
        ......
        //带全部参数构造方法
    }
}
```
```java
Student s1 = new Student();
//根据参数特点自动匹配，调用空参数构造方法

Student s2 = new Student("张三",23)
//调用带全部参数构造方法
```
### 练习
**题目：定义一个Javabean类描述学生**  
对应package:**ooptest2**  
对应代码：
- **Student2.java**
- **StudentDemo2.java**
```java
package ooptest2;

public class Student {
    //属性
    private String name;
    private int age;
    private String gender;
    //构造方法：一般会构造一个空参和一个全参
    public Student(){
    }
    public Student(String name,int age,String gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
    //set/get方法
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return age;
    }
    public void setGender(String gender){
        this.gender = gender;
    }
    public String getGender(){
        return gender;
    }


}

```
```java
package ooptest2;

public class StudentDemo2 {
    /*
    定义一个Javabean类描述学生
    属性：姓名，年龄，性别
     */
    public static void main(String[] args) {

        Student2 s = new Student2();
        System.out.println(s.getName());
        System.out.println(s.getAge());
        System.out.println(s.getGender());

        Student2 ss = new Student2("张三",18,"男");
        System.out.println(ss.getName());
        System.out.println(ss.getAge());
        System.out.println(ss.getGender());

    }
}
```
[运行结果]
```text
null
0
null
张三
18
男
```
### 构造方法的注意事项
- 如果没有定义构造方法，系统会给出一个默认的无参数构造方法
- 如果自己写了任意构造方法，系统将不再提供默认的构造方法
- 带参构造方法和无参数构造方法，两者方法名相同，但是参数不同，这叫作构造方法的重载
- 习惯：**无论是否使用，都手动书写无参数构造方法，和带全部参数的构造方法
- **在类中生成方法的快捷键：Alt+Insert**
- 点击快捷键，选择**Constructor**,选择**Select None**,构造空参方法
- 点击快捷键，选择**Constructor**，Ctrl+A，选择全部参数，构造全部参数的方法
- 点击快捷键，选择**Getter and Setter**，构造get/set方法


