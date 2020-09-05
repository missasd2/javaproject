package JavaSE.mianshi;

import java.io.Serializable;

public class Engine implements Serializable {

    private String brand;
    private String tech;

    public Engine() {
    }

    public Engine(String brand, String tech) {
        this.brand = brand;
        this.tech = tech;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "brand='" + brand + '\'' +
                ", tech='" + tech + '\'' +
                '}';
    }

}
