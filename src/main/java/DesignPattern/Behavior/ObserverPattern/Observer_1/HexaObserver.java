package DesignPattern.Behavior.ObserverPattern.Observer_1;

/**
 * 观察则实现类
 */
public class HexaObserver extends Observer{

    public HexaObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }
    @Override
    public void update() {

    }
}
