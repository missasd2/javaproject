package Java7ConcurrencyCookbook.chp2.p2;

public class Bank implements Runnable{
    private Account account;

    public Bank(Account account){
        this.account = account;
    }
    // 模拟扣钱
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            account.subtractAmount(1000);
        }
    }
}
