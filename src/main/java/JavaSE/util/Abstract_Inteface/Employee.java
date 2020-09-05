package JavaSE.util.Abstract_Inteface;

/**
 * 如果一个类中没有包含足够的信息来描绘一个具体的对象，这样的类就是抽象类。
 *
 * 抽象类除了不能实例化对象之外，
 * 类的其它功能依然存在，成员变量、成员方法和构造方法的访问方式和普通类一样。
 *
 * 由于抽象类不能实例化对象，所以抽象类必须被继承，才能被使用。
 */
public abstract class Employee {
    private String name;
    private String address;
    private int number;

    public Employee(String name, String address, int number){
        System.out.println("Constructing an Employee");
        this.name = name;
        this.address = address;
        this.number = number;
    }

    public double computePay()
    {
        System.out.println("Inside Employee computePay");
        return 0.0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", number=" + number +
                '}';
    }
}
