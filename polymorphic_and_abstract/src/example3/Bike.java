package example3;

public class Bike extends Transport{
    public Bike() {
    }

    public Bike(String brank, double speed) {
        super(brank, speed);
    }

    @Override
    public void move() {
        System.out.println(getBrand()+"的自行车正以"+getSpeed()+"km/h的速度移动");
    }
    public void ringBell(){
        System.out.println("铃铃铃~");
    }
}
