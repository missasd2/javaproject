package JavaSE.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LearnMap {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 10; i++){
            map.put(i, i*2);
        }

        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        System.out.println(entries);
        System.out.println("==========");
        for (Map.Entry<Integer, Integer> entry : entries){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
        System.out.println(map.getOrDefault(11, -1));
        System.out.println(map.putIfAbsent(1, 2));
        System.out.println(map.putIfAbsent(11, 22));
    }
}
