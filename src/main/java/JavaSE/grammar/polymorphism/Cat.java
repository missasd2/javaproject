package JavaSE.grammar.polymorphism;

public class Cat extends Animal{

    // 抽象类的子类必须实现父类的所有抽象方法
    public void eat(){
        System.out.println("吃鱼");
    }

    public void work(){
        System.out.println("抓老鼠");
    }
}
