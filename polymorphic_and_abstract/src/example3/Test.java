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

