package HIighParallel.chp3.p3;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * JMH性能测试程序
 * Builder模式:建造者模式
 */
//@BenchmarkMode(Mode.AverageTime)
@BenchmarkMode(Mode.Throughput)
//@OutputTimeUnit(TimeUnit.MICROSECONDS)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class JMSHSample_01_HelloWorld {
    @Benchmark
    public void wellHelloThere(){

    }

    public static void main(String[] args) throws RunnerException {
        // 使用配置类 Options/OptionsBuilder
        Options opt = new OptionsBuilder().include(JMSHSample_01_HelloWorld.class.getSimpleName()).forks(1).build();
        new Runner(opt).run();

    }

}
