package jcip.chp3;

import java.util.EventListener;

/**
 * 代码清单3-7 隐式地使this引用溢出
 */
public class ThisEscape {
    public ThisEscape(EventSource source) {
        source.registerListener(new EventListener() {

        });
    }
}
