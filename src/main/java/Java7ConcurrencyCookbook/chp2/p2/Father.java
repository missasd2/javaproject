package Java7ConcurrencyCookbook.chp2.p2;

public class Father implements Runnable{
    private Tom tom;

    public Father(Tom tom){
        this.tom = tom;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            tom.subAccount(1000);
        }
    }


}
