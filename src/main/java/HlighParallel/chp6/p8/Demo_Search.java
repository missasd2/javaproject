package HlighParallel.chp6.p8;

import java.util.concurrent.ConcurrentHashMap;

public class Demo_Search {
    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        for (int i = 1; i <= 100 ; i++) {
            map.put(Integer.toString(i), i);
        }
        /**
         * search()操作会在Map找到第一个使得Function返回不为null的值。
         *
         */
        int found = map.search(Long.MAX_VALUE, (str, i) -> {
            if (i%2 == 0){
                return i;
            }
            return null;
        });
        System.out.println(found);
    }

}
