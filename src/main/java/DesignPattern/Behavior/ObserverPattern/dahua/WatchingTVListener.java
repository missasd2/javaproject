package DesignPattern.Behavior.ObserverPattern.dahua;

public class WatchingTVListener {

    public WatchingTVListener() {
        System.out.println("WATCHING TV");
    }
    public void stopWatchingTV(String s) {
        System.out.println("STOP WATCHING " + s);
    }
}
