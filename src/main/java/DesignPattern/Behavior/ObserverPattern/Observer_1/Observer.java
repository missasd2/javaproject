package DesignPattern.Behavior.ObserverPattern.Observer_1;

/**
 * 观察者 抽象类
 */
public abstract class Observer {
    // 松耦合一个  通知者
    protected Subject subject;
    public abstract void update();
}
