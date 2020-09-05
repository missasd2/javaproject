package HlighParallel.chp6.p2;

public class WhiteHorse implements IHorse{

    public void eat(){
        System.out.println("The white horse is eating");
    }

    public static void main(String[] args) {
        WhiteHorse whiteHorse = new WhiteHorse();
        whiteHorse.eat();
        whiteHorse.run();
    }
}
