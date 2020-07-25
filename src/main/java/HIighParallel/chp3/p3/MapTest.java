package HIighParallel.chp3.p3;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 *
 */
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@State(Scope.Benchmark)
public class MapTest {
    static Map hashMap = new HashMap();
    static Map syncHashMap = Collections.synchronizedMap(new HashMap());
    static Map concurrentHashMap = new ConcurrentHashMap();

    /**
     * 在setup()函数中，也就是测试正式开始之前，为每个测试的Map装了1000条数据
     */
    @Setup
    public void setup(){
        for (int i = 0; i < 10000; i++) {
            hashMap.put(Integer.toString(i), Integer.toString(i));
            syncHashMap.put(Integer.toString(i), Integer.toString(i));
            concurrentHashMap.put(Integer.toString(i), Integer.toString(i));
        }
    }

    @Benchmark
    public void hashMapGet(){
        hashMap.get("4");
    }
    @Benchmark
    public void syncHashMapGet(){
        syncHashMap.get("4");
    }
    @Benchmark
    public void concurrentHashMapGet(){
        concurrentHashMap.get("4");
    }
    @Benchmark
    public void hashMapSize(){
        hashMap.size();
    }
    @Benchmark
    public void syncHashMapSize(){
        syncHashMap.size();
    }
    @Benchmark
    public void concurrentHashMapSize(){
        concurrentHashMap.size();
    }

    public static void main(String[] args) throws RunnerException {
        // class.getSimpleName()得到类的简写名称
        //Options opt = new OptionsBuilder().include(MapTest.class.getSimpleName()).forks(1).warmupIterations(5).measurementIterations(5).threads(2).build();
        // 支持JSON文件的输出
        Options opt = new OptionsBuilder().include(MapTest.class.getSimpleName())
                .result("result.json")
                .resultFormat(ResultFormatType.JSON)
                .build();
        new Runner(opt).run();
    }
}
