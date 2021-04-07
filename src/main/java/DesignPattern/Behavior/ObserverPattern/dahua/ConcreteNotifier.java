package DesignPattern.Behavior.ObserverPattern.dahua;

/**
 * 具体通知
 */
public class ConcreteNotifier extends Notifier{

    @Override
    public void addListener(Object object, String methodName, Object... params) {
        this.getEventHandler().addEvent(object, methodName, params);
    }

    @Override
    public void Notify() {
        this.getEventHandler().Notify();
    }
}
