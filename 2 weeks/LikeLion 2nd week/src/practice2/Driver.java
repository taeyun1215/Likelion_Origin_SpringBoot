package practice2;

import java.security.Principal;
import java.security.PrivateKey;

public class Driver {
    private String name;
    private int license;

    public Driver() {
    }

    public Driver(String name, int license) {
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
        return "Driver{" +
                "name='" + name + '\'' +
                ", license=" + license +
                '}';
    }
}
