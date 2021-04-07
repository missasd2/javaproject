package DesignPattern.Behavior.ObserverPattern.dahua;

/**
 * 测试
 */
public class TestDahua {
    public static void main(String[] args) {
        Notifier notifier = new ConcreteNotifier();
        WatchingTVListener listener = new WatchingTVListener();
        notifier.addListener(listener, "stopWatchingTV", "方法参数");
        notifier.Notify();
    }
}
