package practice1;

import java.util.ArrayList;

public class Road {
    private ArrayList<SimpleCar> carList = new ArrayList<>();

    public void addCar(SimpleCar simpleCar) {
        carList.add(simpleCar);
    }
}
