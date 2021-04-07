package DesignPattern.Behavior.ObserverPattern.dahua;

import java.util.ArrayList;
import java.util.List;

/**
 * 管理事件的类
 */
public class EventHandler {
    // 事件列表
    private List<Event> events;

    public EventHandler() {
        this.events = new ArrayList<Event>();
    }

    // 添加事件
    public void addEvent(Object object, String methodName, Object... params) {
        events.add(new Event(object, methodName, params));
    }
    // 通知
    public void Notify() {
        for (Event event : events) {
            event.invoke();
        }
    }
}
