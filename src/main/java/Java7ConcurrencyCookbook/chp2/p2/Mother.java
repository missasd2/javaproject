package Java7ConcurrencyCookbook.chp2.p2;

import org.springframework.ui.Model;

public class Mother implements Runnable{
    private Tom tom;

    public Mother(Tom tom){
        this.tom = tom;
    }
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            tom.addAccount(1000);
        }
    }


}
