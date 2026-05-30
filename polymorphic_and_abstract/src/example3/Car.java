package example3;

public class Car extends Transport{
    public Car() {
    }

    public Car(String brank, double speed) {
        super(brank, speed);
    }

    @Override
    public void move() {
        System.out.println(getBrand()+"的汽车正以"+getSpeed()+"km/h的速度移动");
    }
    public void honk(){
        System.out.println("嘟嘟嘟~");
    }
}
