package practice2;

import java.util.ArrayList;

public class Road {
    private ArrayList<CarInterface> carsOnRoad;

    public Road() {
    }

    public void addCar(CarInterface car) {
        this.carsOnRoad.add(car);
    }
}
