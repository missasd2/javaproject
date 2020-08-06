package HIighParallel.chp4.p4;

import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicStampedReferenceDemo {
    static AtomicStampedReference<Integer> money = new AtomicStampedReference<Integer>(19, 0);
    public static void main(String[] args) {
        // 模拟多个线程更新后台数据库，为用户充值
        for (int i = 0; i < 3; i++) {
            /**
             * 获得账户的时间戳;
             *      若赠与成功，则修改时间戳，使得系统不可能发生二次赠与；
              */
            final int timestamp = money.getStamp();
            new Thread(){
                @Override
                public void run() {
                    while (true){
                        while (true){
                            Integer m = money.getReference();
                            if (m<20){
                                // 赠与成功就将时间戳加1；
                                if (money.compareAndSet(m, m+20, timestamp, timestamp+1)){
                                    System.out.println("余额小于20元, 充值成功, 余额:"+money.getReference()+"元");
                                    break;
                                }
                            }else {
                                break;
                            }
                        }
                    }
                }
            }.start();
        }
        // 用户消费进程,模拟消费行为
        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    while (true){
                        int timestamp = money.getStamp();
                        Integer m = money.getReference();
                        if (m>10){
                            System.out.println("大于10元");
                            if (money.compareAndSet(m, m-10, timestamp, timestamp+1)){
                                System.out.println("成功消费10元，余额: "+money.getReference());
                                break;
                            }
                        }else {
                            System.out.println("没有足够的金额");
                            break;
                        }
                    }
                    try {
                        Thread.sleep(100);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}
