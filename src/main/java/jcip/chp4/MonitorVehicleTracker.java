package jcip.chp4;

import jcip.annotate.GuardeBy;
import jcip.annotate.ThreadSafe;

import java.util.Map;

/**
 * 程序清单4-4 基于监视器模式的车辆追踪
 *
 */
@ThreadSafe
public class MonitorVehicleTracker {
    @GuardeBy("this")
    private final Map<String, MutablePoint> locations;

    public MonitorVehicleTracker(Map<String, MutablePoint> locations) {
        this.locations = locations;
    }
}
