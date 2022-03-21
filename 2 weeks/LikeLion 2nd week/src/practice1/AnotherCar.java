package practice1;

public class AnotherCar {
    private CarDriver driver;
    private int gear;
    private int velocity;

    public AnotherCar(CarDriver driver) {
        this.driver = driver;
    }

    public CarDriver getDriver() {
        return driver;
    }

    public int getGear() {
        return gear;
    }

    public int getVelocity() {
        return velocity;
    }

    public void accelerate() {
        this.velocity += 10;
    }

    public boolean brake() {
        if(this.velocity > 100) {
            throw new RuntimeException("too fast to hist brakes");
        }
        this.velocity -= 10;
        return true;
    }
}
