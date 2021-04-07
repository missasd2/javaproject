package DesignPattern.Behavior.ObserverPattern.dahua;

/**
 * 抽象通知
 */
public abstract class Notifier {
    private EventHandler eventHandler = new EventHandler();

    public abstract void addListener(Object object, String methodName, Object... params);

    public abstract void Notify();

    public EventHandler getEventHandler() {
        return eventHandler;
    }

    public void setEventHandler(EventHandler eventHandler) {
        this.eventHandler = eventHandler;
    }
}
