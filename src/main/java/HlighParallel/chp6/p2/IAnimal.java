package HlighParallel.chp6.p2;

/**
 * jdk8之后，接口可以包含默认方法
 */
public interface IAnimal {
    default void breath(){
        System.out.println("breath");
    }
}
