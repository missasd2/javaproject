package SpringInAction.chp4;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.HashMap;
import java.util.Map;

@Aspect
public class TrackCounter {

    private Map<Integer, Integer> trackCounts =
            new HashMap<>();
    // 还声明了要提供给 通知方法 的参数
    @Pointcut(
            "execution(* SpringInAction.chp4.CompactDisc.playTrack(int))"
            + "&&args(trackNumber)"
    )
    public void trackPlayed(int trackNumber) {}

    @Before("trackPlayed(trackNumber)")
    public void countTrack(int trackNumber) {
        int currentCount = getPlayCount(trackNumber);
    }

    public int getPlayCount(int trackNumber) {
        return trackCounts.containsKey(trackNumber) ?
                trackCounts.get(trackNumber) : 0;
    }
}
