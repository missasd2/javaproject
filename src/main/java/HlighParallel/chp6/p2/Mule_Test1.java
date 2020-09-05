package HlighParallel.chp6.p2;

public class Mule_Test1 implements IHorse, IDonkey{

    public void eat(){
        System.out.println("donkey is eating");
    }

    @Override
    public void run(){
        System.out.println("Mule_Test1 is running");
    }

    public static void main(String[] args) {
        Mule_Test1 mule_test1 = new Mule_Test1();
        mule_test1.run();
    }
}
