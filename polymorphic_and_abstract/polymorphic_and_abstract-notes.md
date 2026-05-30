- [多态](#多态)
    - [什么是多态](#什么是多态)
    - [多态的表现形式](#多态的表现形式)
    - [多态的前提](#多态的前提)
    - [示例](#示例)
    - [多态的好处](#多态的好处)
    - [多态调用成员的特点](#多态调用成员的特点)
        - [变量调用](#变量调用)
        - [方法调用](#方法调用)
    - [多态的弊端](#多态的弊端)
    - [类型转换](#类型转换)
        - [强制类型转换的注意事项](#强制类型转换的注意事项)
        - [instanceof关键字示例](#instanceof关键字示例)
    - [多态联系](#多态联系)
        - [练习一](#练习一)
- [抽象类和抽象方法](#抽象类和抽象方法)
    - [定义](#定义)
    - [格式](#格式)
    - [小贴士](#小贴士)
    - [示例](#示例-1)
    - [注意事项](#注意事项)

配套完整代码：GitHub仓库  
<https://github.com/LIN-commit/java-learning>  
代码所在目录：java-learning/polymorphic_and_abstract/
# 多态
## 什么是多态
**多态**：事物的多种形态  
`Student stu = new Student();`该对象为Student学生形态  
`Person per = new Student();`该对象实际类型是Student,只是被Person类型的引用变量指向了，是多态的典型写法
## 多态的表现形式
```text
父类类型 对象名称 = 子类对象;
```
## 多态的前提
- 有继承/实现关系
- 有父类引用指向子类对象`Fu f = new Zi();`
## 示例
题目：
- 学生类：  
  属性：姓名，账号，密码  
  行为：work:学生的工作是学习
- 老师类：  
  属性：姓名，账号，密码  
  行为：work:老师的工作是教书
- 学生管理系统：  
  行为：注册register  
  要求：能注册所有的角色  
  输出：姓名为张三的同学注册成功，账号zhangsan，密码123456

对应package:**example1**  
对应代码：
- **Person.java**
- **Student.java**
- **Teacher.java**
- **StudentManager.java**
- **Test.java**
```java
package example1;

public class Person {
    private String name;
    private String number;
    private String password;

    public Person() {
    }

    public Person(String name, String number, String password) {
        this.name = name;
        this.number = number;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public void work(){
        System.out.println("work");
    }
}

```
```java
package example1;

public class Student extends Person{
    public Student() {
    }

    public Student(String name, String number, String password) {
        super(name, number, password);
    }

    @Override
    public void work() {
        System.out.println("学生的工作是学习");
    }
}

```
```java
package example1;

public class Teacher extends Person{
    public Teacher() {
    }

    public Teacher(String name, String number, String password) {
        super(name, number, password);
    }

    @Override
    public void work() {
        System.out.println("老师的工作是教书");
    }
}

```
```java
package example1;

public class StudentManager {
    public void register(Person person){
        System.out.println("姓名为"+person.getName()+"的账户注册成功，账号为"+person.getNumber()+"，密码"+person.getPassword());
        person.work();
    }
}

```
```java
package example1;

public class Test {
    public static void main(String[] args) {
        Person stu = new Student("张三","zhangsan","123456");
        StudentManager s = new StudentManager();
        s.register(stu);
        Person t = new Teacher("蓝猫学姐","bluecat","456789");
        s.register(t);
    }
}

```
[运行结果]
```text
姓名为张三的账户注册成功，账号为zhangsan，密码123456
学生的工作是学习
姓名为蓝猫学姐的账户注册成功，账号为bluecat，密码456789
老师的工作是教书
```
## 多态的好处
- 方法中使用父类型作为参数，可接收父类对象+所有子类对象
- 如果子类中进行方法重写，利用多态调用方法，可以调用不同子类中重写的方法
## 多态调用成员的特点
- **变量调用**：编译看左边，运行也看左边
- **方法调用**：编译看左边，运行看右边
### 变量调用
```java
public class Fu{
    String name = "fu";
}
```
```java
public class Zi extends Fu{
    String name = "zi";
}
```
```java
Fu f = new Zi();
System.out.println(f.name);
```
- 编译看左边：把java文件编译成class文件的时候，看父类当中有没有这个变量，如果有则编译成功，没有就编译失败  
  在上述代码中，就看父类中有没有name这个变量

- 运行也看左边：在代码真正运行的时候，使用父类中的变量  
  所以上述代码的运行结果是`fu`

### 方法调用
- 编译看左边：在父类中有没有这个方法，如果没有代码报错
- 运行看右边：在代码真正运行的时候，运行的是子类里面的方法  
  如果子类没有重写父类里面的方法，使用的还是父类中的方法
## 多态的弊端
多态下不能使用子类的独有功能
## 类型转换
- **自动类型转换（从子到父）**：子类对象赋值给父类类型的变量
- **强制类型转换（从父到子）**：
```text
子类 对象变量= （子类）父类类型的变量
```
```java
Person p = new Student();
Student s = (Student)p;
```
**作用**：可以解决多态的弊端，可以实现调用子类的独有功能
### 强制类型转换的注意事项
- 转换类型与真实类型不一致会报错
- 转换的时候用instanceof关键字进行判断
### instanceof关键字示例
对应package:**example2**  
对应代码：
- **Person.java**
- **Fu.java**
- **Zi.java**
- **Test.java**
```java
package example2;

public class Person {
    public void show(){
        System.out.println("Person中的show方法被调用了");
    }
}

```
```java
package example2;

public class Fu extends Person{
    public void fushow(){
        System.out.println("Fu类中独有的fushow方法被调用了");
    }

}

```
```java
package example2;

public class Zi extends Fu{
    public void zishow(){
        System.out.println("zi类中独有的zishow方法被调用了");
    }
}

```
```java
package example2;

public class Test {
    public static void main(String[] args) {
        Person p = new Fu();
    /*
    此时p的实际类型是Fu
    但是遵循“调用方法：编译看左边，运行看右边”
    所以如果想要调用Fu类中独有而Person类中没有的方法，就要把p强制转为Fu类型
     */
        //p.fushow();
        //报错，因为Person类中没有fushow方法

        //Zi z = (Zi)p;
        //编译不会报错，但运行会报错

        //用instanceof关键字判断p是否是Fu类型
        if(p instanceof Fu){
            Fu f = (Fu)p;
        }else{
            System.out.println("请确定好类型，再进行转换");
        }
    }
}

```
## 多态联系
### 练习一
**题目**
- 自行车：  
  属性：品牌，行驶速度  
  行为：移动move，响铃ringBell
- 汽车：  
  属性：品牌，行驶速度  
  行为：移动move，鸣笛honk
- 人：  
  属性：名字，年龄，性别  
  行为：行驶交通工具（能使用所有交通工具）  
  测试类中创建Person对象，让这个人使用任意一款交通工具  、

对应package:**example3**  
对应代码：
- **Transport.java**
- **Bike.java**
- **Car.java**
- **Person.java**
- **Test.java**
```java
package example3;

public class Transport {
    private String brand;
    private double speed;

    public Transport() {
    }

    public Transport(String brand, double speed) {
        this.brand = brand;
        this.speed = speed;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void move(){
        System.out.println(brank+"交通工具正以"+speed+"km/h的速度移动");
    }
}

```
```java
package example3;

public class Bike extends Transport{
    public Bike() {
    }

    public Bike(String brand, double speed) {
        super(brand, speed);
    }

    @Override
    public void move() {
        System.out.println(getBrand()+"的自行车正以"+getSpeed()+"km/h的速度移动");
    }
    public void ringBell(){
        System.out.println("铃铃铃~");
    }
}

```
```java
package example3;

public class Car extends Transport{
    public Car() {
    }

    public Car(String brand, double speed) {
        super(brand, speed);
    }

    @Override
    public void move() {
        System.out.println(getBrand()+"的汽车正以"+getSpeed()+"km/h的速度移动");
    }
    public void honk(){
        System.out.println("嘟嘟嘟~");
    }
}

```
```java
package example3;

public class Person {
    private String name;
    private int age;
    private String gender;

    public Person() {
    }

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void use(Transport t){
        t.move();
        //现在并不知道调用的是bike还是car，所以不确定是鸣笛还是响铃
        if(t instanceof Bike){
            Bike b = (Bike)t;
            b.ringBell();
        }else if(t instanceof Car){
            Car c = (Car)t;
            c.honk();
        }else{
            System.out.println("没有这个类型");
        }
    }
}

```
```java
package example3;

public class Test {
    public static void main(String[] args) {
        Person p = new Person("蓝猫学姐",20,"女");
        System.out.println(p.getName()+", "+p.getAge()+", "+p.getGender());

        Bike b = new Bike("迪卡侬",5);
        p.use(b);

        Car c = new Car("大众",20);
        p.use(c);

    }
}
```
[运行结果]
```text
蓝猫学姐, 20, 女
迪卡侬的自行车正以5.0km/h的速度移动
铃铃铃~
大众的汽车正以20.0km/h的速度移动
嘟嘟嘟~
```
# 抽象类和抽象方法
## 定义
- **抽象方法**：将共性的行为（方法）抽取到父类之后，因为每一个子类的方法体是不一样的，所以，在父类中**不能确定具体的方法体**。该方法就可以定义为抽象方法
- **抽象类**：如果一个**类中存在抽象方法**，那么该类就**必须申明为抽象类**
## 格式
- **抽象方法**
```text
public abstract 返回值类型 方法名（参数列表）；
```  
- **抽象类**
```text
public abstract class 类名{...}
```
## 小贴士
alt+回车：自动修复代码中的bug
## 示例
**题目**  
猫类：  
属性：名字，颜色  
行为：猫吃鱼，猫抓老鼠，猫喝水  
狗类：  
属性：名字，颜色  
行为：狗吃骨头，狗看家，狗喝水

对应package:**example4**  
对应代码：
- **Animal.java**
- **Cat.java**
- **Dog.java**
- **Test.java**
```java
package example4;

public abstract class Animal {
    private String name;
    private String color;

    public Animal() {
    }

    public Animal(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    //eat抽象方法
    public abstract void eat();
    //喝水行为
    public void drink(){
        System.out.println("喝水");
    }
}

```
```java
package example4;

public class Cat extends Animal{
    public Cat() {
    }

    public Cat(String name, String color) {
        super(name, color);
    }

    @Override
    public void eat(){
        System.out.println("猫吃鱼");
    }
    public void catchMouse(){
        System.out.println("猫抓老鼠");
    }
}

```
```java
package example4;

public class Dog extends Animal{
    public Dog() {
    }

    public Dog(String name, String color) {
        super(name, color);
    }
    @Override
    public void eat(){
        System.out.println("狗吃骨头");
    }
    public void lookHome(){
        System.out.println("狗看家");
    }
}

```
```java
package example4;

public class Test {
    public static void main(String[] args) {
        Cat c = new Cat("小白","白色");
        System.out.println(c.getName()+", "+c.getColor());
        c.eat();
        c.catchMouse();
        c.drink();
        System.out.println("-----------");
        Dog d = new Dog("大黄","黄色");
        System.out.println(d.getName()+", "+d.getColor());
        d.eat();
        d.lookHome();
        d.drink();
    }
}

```
[运行结果]
```text
小白, 白色
猫吃鱼
猫抓老鼠
喝水
-----------
大黄, 黄色
狗吃骨头
狗看家
喝水
```
## 注意事项
- 抽象类不能实例化  
  `Animal a = new Animal();`是错误的
- 抽象类中不一定有抽象方法（作用：为了不让外界创建本类的对象），有抽象方法的类一定是抽象类
- 抽象类中可以有构造方法  
  构造方法的作用：为了给成员变量赋值
- 抽象类的子类  
  要么重写抽象类中所有的抽象方法  
  要么子类也是抽象类

