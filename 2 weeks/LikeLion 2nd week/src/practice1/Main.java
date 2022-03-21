package practice1;

public class Main {

    public static void main(String[] args) {
	    CarDriver driver = new CarDriver("name", 1);
        SimpleCar car = new SimpleCar();
        car.setDriver(driver);

        Road route88 = new Road();
        route88.addCar(car);

        AnotherCar anotherCar = new AnotherCar(driver);
//        route88.addCar(anotherCar);
    }
}
