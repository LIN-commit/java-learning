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
        System.out.println(brand+"交通工具正以"+speed+"km/h的速度移动");
    }
}
