package practice1;

public class CarDriver {
    private String name;
    private int license;

    public CarDriver() {
    }

    public CarDriver(String name, int license) {
        this.name = name;
        this.license = license;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLicense() {
        return license;
    }

    public void setLicense(int license) {
        this.license = license;
    }

    @Override
    public String toString() {
        return "CarDriver{" +
                "name='" + name + '\'' +
                ", license=" + license +
                '}';
    }
}
