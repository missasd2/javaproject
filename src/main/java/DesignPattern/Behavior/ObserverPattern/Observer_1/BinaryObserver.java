package DesignPattern.Behavior.ObserverPattern.Observer_1;

/**
 * 创建实体 观察者
 */
public class BinaryObserver extends Observer{

    // 实体观察者 松耦合一个 通知者
    public BinaryObserver(Subject subject) {
        this.subject = subject;
        // 向耦合的通知者 注册 观察者  （松耦合）
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Binary String: " + Integer.toBinaryString( subject.getState()));
    }
}
