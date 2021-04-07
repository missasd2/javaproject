package SpringInAction.chp3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
// 引用了类路径下的配置文件
@PropertySource("classpath:SpringInAction/chp3/app.properties")
public class ExpressiveConfig {

    @Autowired
    Environment env;

    @Bean
    public void disc(){
        // 检索属性值
        // 属性文件会加载到Spring的Environment中，稍后可以从这里检索属性
        System.out.println(env.getProperty("disc.title"));
        System.out.println(env.getProperty("disc.artist"));

        // Environment的getProperty方法的重载版本，当执行属性不存在时，返回默认值
        System.out.println(env.getProperty("disc.artis", "U2"));

        // 返回自定义类型的默认值
        System.out.println(env.getProperty("db.connection.count", Integer.class, 30));

        // getProperty方法若没有指定默认值，且这个属性没有定义的话，返回为Null
        // getRequiredProperty方法，强制属性必须要定义;若没有定义则抛出IllegalStateException异常
        System.out.println(env.getRequiredProperty("disc.artist"));
    }

}
