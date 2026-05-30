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
