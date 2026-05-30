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
