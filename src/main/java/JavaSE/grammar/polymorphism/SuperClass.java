package JavaSE.grammar.polymorphism;

/**
 * 表示父类
 */
public class SuperClass {

    private static String STR = "Super Class Static Variable";

    // 父类静态代码块
    static {
        System.out.println("Super Class Static Block: " + STR);
    }

    // 父类构造方法
    public SuperClass(){
        System.out.println("Super Class Constructor Method");
    }

    // 父类非静态代码块
    {
        System.out.println("Super Class Block" + STR);
    }
}
