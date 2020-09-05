package JavaSE.mianshi;

import java.io.*;

public class Car implements Serializable {
    private String brand;
    private Integer price;
    private Engine engine;

    public Car() {
    }

    public Car(String brand, Integer price, Engine engine) {
        this.brand = brand;
        this.price = price;
        this.engine = engine;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                ", engine=" + engine +
                '}';
    }

    public static void main(String[] args) {
        Car car1 = new Car();
        car1.setBrand("bmw");
        car1.setPrice(200000);
        car1.setEngine(new Engine("volvo", "jet"));

        Car car2 = car1;
        System.out.println(car1 == car2); // true,因为赋值传递的是对象的引用

        try {
            // 写入字节流
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ObjectOutputStream obs = new ObjectOutputStream(out);
            obs.writeObject(car1);
            obs.close();

            // 分配内存，写入原始对象，生成新对象
            ByteArrayInputStream ios = new ByteArrayInputStream(out.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(ios);
            // 返回生成的新对象
            Car car3 = (Car)ois.readObject();
            ois.close();
            System.out.println(car1 == car3); // false

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
