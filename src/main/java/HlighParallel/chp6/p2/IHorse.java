package HlighParallel.chp6.p2;

public interface IHorse {
    // jdk8之前接口只能有抽象方法
    void eat();
    // jdk8 之后接口也可由实例方法
    default void run(){
        System.out.println("horse run");
    }
}
