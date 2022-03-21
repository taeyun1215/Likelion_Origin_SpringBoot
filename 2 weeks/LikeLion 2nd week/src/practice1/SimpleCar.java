package practice1;

public class SimpleCar {
    private CarDriver driver;
    private int velocity;

    public SimpleCar() {
    }

    public SimpleCar(CarDriver driver, int velocity) {
        this.driver = driver;
        this.velocity = velocity;
    }

    public CarDriver getDriver() {
        return driver;
    }

    public void setDriver(CarDriver driver) {
        this.driver = driver;
    }

    public void accelerate() {
        this.velocity += 10;
    }

    public void brake() {
        this.velocity -= 10;
    }
}
