package HIighParallel.chp3.p3;

import groovyjarjarcommonscli.OptionBuilder;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

/**
 * JMS中的State可以理解为变量或者数据模型的作用域，通常包括Benchamark级别和Thread级别
 *
 */
public class JMHSample_03_States {
    /**
     * 声明数据模型，是Benchmark级别
     */
    @State(Scope.Benchmark)
    public static class BenchmarkState{
        volatile double x = Math.PI;
    }

    /**
     * 声明数据模型，是Thread级别
     */
    @State(Scope.Thread)
    public static class ThreadState{
        volatile double x = Math.PI;
    }

    /**
     * 使用Benchmark方法对上述模型进行访问
     * 每个不同的测试线程都有自己的数据复制
     * @param state
     */
    @Benchmark
    public void measureUnshared(ThreadState state){
        state.x++;
    }

    /**
     * 所有测试线程共享一份数据
     * @param state
     */
    @Benchmark
    public void measureShared(BenchmarkState state){
        state.x++;
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder().include(JMHSample_03_States.class.getSimpleName()).threads(4).forks(1).build();
        new Runner(opt).run();
    }
}
