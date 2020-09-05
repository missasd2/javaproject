package JavaSE.util.Abstract_Inteface;

/**
 * 抽象类：
 */
public abstract class Test1 {

    /**
     * 抽象方法：只给出方法定义而不具体实现的方法，抽象方法是没有方法体的，在代码的表达下就是没有{}
     * 包含一个或多个抽象方法的类也必须被声明为抽象类；
     */
    public abstract void f();

    public static int check(int i){
        System.out.println(i);
        return i;
    }

}
