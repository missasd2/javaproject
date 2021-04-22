package pearlsMore.chp1;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * JMH测试程序
 */
@BenchmarkMode(Mode.AverageTime)
@State(Scope.Thread)
@Fork(1)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 3)
@Measurement(iterations = 5)
public class TestJMH {

    String string = "";
    StringBuilder builder = new StringBuilder();

    @Benchmark
    public String stringAdd() {
        for (int i = 0; i < 1000; i++) {
            string = string + i;
        }
        return string;
    }

    @Benchmark
    public String builderAppend() {
        for (int i = 0; i < 1000; i++) {
            builder.append(i);
        }
        return builder.toString();
    }

    @Benchmark
    public String  getMinMax_1() {
        int[] nums = new int[1000];
        for (int i = 0; i < 1000; i++) {
            nums[i] = new Random().nextInt() * 1000;
        }
        int min = nums[1];
        int max = nums[1];
        for (int i = 0; i < 1000; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        return "min: " + min + " max: " + max;
    }

    @Benchmark
    public String getMinMax_2() {
        int[] nums = new int[1000];
        for (int i = 0; i < 1000; i++) {
            nums[i] = new Random().nextInt() * 1000;
        }
        int min = nums[1];
        int max = nums[1];
        for (int i = 0; i < 1000; i++) {
            if (nums[i] > max) {
                max = nums[i];
            } else if (nums[i] < min) {
                min = nums[i];
            }
        }
        return "min: " + min + " max: " + max;
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder().include(TestJMH.class.getSimpleName())
                .build();
        new Runner(opt).run();
    }

}
