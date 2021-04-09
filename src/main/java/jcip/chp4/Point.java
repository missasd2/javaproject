package jcip.chp4;

import jcip.annotate.Immutable;

/**
 * 程序清单4-6 在DelegatingVehicleTracker 中使用的不可变Point类
 */
@Immutable
public class Point {
    public final int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
