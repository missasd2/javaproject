package DesignPattern.Behavior.ObserverPattern.Observer_1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * 通知者 抽象类
 */
public  class Subject {

    private List<Observer> observers = new ArrayList<Observer>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
