package SpringInAction.chp4;

import SpringInAction.chp2.BlankDisc;
import SpringInAction.chp2.CompactDisc;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.ArrayList;

/**
 * 程序清单4.7 配置TrackCount记录每个磁道播放的次数
 */
@Configuration
@EnableAspectJAutoProxy  // 启用 AspectJ自动代理
public class TrackCounterConfig {

    @Bean
    public CompactDisc sgtPeppers() {
        BlankDisc cd = new BlankDisc();
        cd.setTitle("Sgt. Pepper's Lonely Hearts Club Band");
        cd.setArtist("The Beatles");
        ArrayList<String> tracks = new ArrayList<>();
        tracks.add("Sgt. Pepper's Lonely Hearts Club Band");
        tracks.add("With a Little Help from My Friends");
        tracks.add("Lucy in the Sky with Diamonds");
        tracks.add("Getting Better");
        tracks.add("Fixing a Hold");


        return cd;
    }
}
