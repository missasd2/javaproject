package jcip.chp4;

/**
 * 代码清单 4-5 与Java.awt.Point类似的可变Point类 （不要这么做）
 */
public class MutablePoint {
    public int x, y;

    public MutablePoint() {
        x = 0;
        y = 0;
    }
    public MutablePoint(MutablePoint p) {
        this.x = p.x;
        this.y = p.y;
    }
}
