package practice2;

public class GoCart extends AbstractCar implements CarInterface{    // alt + enter 누르면 오류가 해결 됨.
    private Driver driver;
//    private int velocity;

//    public Driver getDriver() {
//        return driver;
//    }

    @Override
    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    @Override
    public void accelerate() {
        this.velocity += 5;
    }

    @Override
    public void brake() {
        this.velocity -= 5;
        super.brake();
    }
}