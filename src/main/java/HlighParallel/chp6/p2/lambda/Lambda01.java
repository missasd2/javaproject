package HlighParallel.chp6.p2.lambda;

import java.util.Arrays;
import java.util.List;

public class Lambda01 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        numbers.forEach( (Integer value) -> System.out.println(value));
    }
}
