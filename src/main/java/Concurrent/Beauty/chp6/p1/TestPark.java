package Concurrent.Beauty.chp6.p1;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.LockSupport;

public class TestPark {

    public void testPark(){
        LockSupport.park();
    }

    public static void main(String[] args) {
        TestPark testPark = new TestPark();
        testPark.testPark();

    }
}
