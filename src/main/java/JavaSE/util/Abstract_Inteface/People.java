package JavaSE.util.Abstract_Inteface;

/**
 * 抽象：在java中
 * 抽象方法：只给出方法定义而不具体实现的方法；没有方法体
 * 抽象类：
 *  关键字abstract修饰
 *  包含一个或多个抽象方法
 *
 * 抽象类的使用：
 *      不可被实例化
 *      只可被子类继承使用，子类需实现父类所有抽象方法，否则需被声明为抽象类
 *
 * 抽象类的补充：
 *      1. 抽象类不能直接使用，需要子类去实现抽象类，然后使用其子类的实例
 *      2. 可以创建一个变量，其类型也是一个抽象类，并让他指向具体子类的一个实例，也就是可以使用抽象类来充当形参，实际实现类为实参，也就是多态的应用。
 *      3. 不能有抽象构造方法或抽象静态方法。
 *
 * 在下列情况下，一个类将成为抽象类：
 *
 *     当一个类的一个或多个方法是抽象方法时。
 *     当类是一个抽象类的子类，并且不能实现父类的所有抽象方法时。
 *     当一个类实现一个接口，并且不能实现接口的所有抽象方法时。
 * 注意：
 *     上面说的是这些情况下一个类将称为抽象类，没有说抽象类就一定会是这些情况。
 *     抽象类可以不包含抽象方法，包含抽象方法的类就一定是抽象类。
 *     事实上，抽象类可以是一个完全正常实现的类。
 */
public abstract class People {
    private String name;
    private int age;
    // 抽象方法
    public abstract void work();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
