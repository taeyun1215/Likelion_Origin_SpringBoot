package practice2;

public class SmallCar extends AbstractCar implements CarInterface{
    private Driver driver;
//    private int velocity;

    @Override
    public void setDriver(Driver driver) {
        if(driver.getLicense() < 1) {
            throw new RuntimeException("insufficient License");
        }
        this.driver = driver;
    }

    @Override
    public void accelerate() {
        this.velocity += 10;
    }

    @Override
    public void brake() {
        this.velocity -= 10;
        super.brake();
    }
}
