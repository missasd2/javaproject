package HlighParallel.chp6.p2;

public interface IDonkey {

    void eat();
    default void run(){
        System.out.println("donkey run");
    }
}
