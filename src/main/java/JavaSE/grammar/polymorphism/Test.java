package JavaSE.grammar.polymorphism;

public class Test {

    public static void main(String[] args) {
        show(new Cat()); // 以Cat对象调用show方法
        show(new Dog()); // 以Dog对象调用show方法

        Animal a = new Cat(); // 向上转型
        a.eat(); // 调用的是Cat的eat方法
        Cat c = (Cat) a; // 向下转型
    }

    public static void show(Animal animal){
        animal.eat();
        if (animal instanceof Dog){
            Dog d = (Dog)animal;
            d.work();
        }else if (animal instanceof Cat){
            Cat c = (Cat)animal;
            c.work();
        }
    }
}
