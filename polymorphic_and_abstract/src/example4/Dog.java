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
