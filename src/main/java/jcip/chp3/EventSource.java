package jcip.chp3;

import java.util.EventListener;

public interface EventSource {
    public void registerListener(EventListener listener);
}
