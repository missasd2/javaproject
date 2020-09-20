package JavaSE.grammar.polymorphism;

public class Son extends Father{
    public void say(){
        System.out.println("son");
    }

    public static void action(){
        System.out.println("hit hit");
    }

    public static void main(String[] args) {
        Father f = new Son();
        // Java多态有两种情况：重载overloading和覆写override
        // 在覆写中，运用的是动态单分配，根据new的类型确定对象，从而确定调用的方法
        //当子类对象调用重写的方法时，调用的是子类的方法，而不是父类中被重写的方法。
        // 要想调用父类中被重写的方法，则必须使用关键字 super。
        // 在重载中，运用的是静态多分派，根据静态类型确定对象，因此不是根据new的类型确定调用的方法
        f.say();
        f.action();
    }
}
