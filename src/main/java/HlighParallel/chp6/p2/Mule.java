package HlighParallel.chp6.p2;

public class Mule implements IHorse, IAnimal{
    @Override
    public void eat(){
        System.out.println("Mule eat");
    }

    public static void main(String[] args) {
        Mule mule = new Mule();
        mule.eat();
        mule.breath();
        mule.run();
    }


}
