package leetcode.tag.topK;

import java.util.*;

/**
 * 前k个高频单词
 */
public class P692_topKFrequent {

    public List<String> topKFrequent(String[] words,  int k) {
        // 统计每个字符串出现的次数
        Map<String, Integer> cnt = new HashMap<String, Integer>();
        for (String word : words) {
            cnt.put(word, cnt.getOrDefault(word, 0) + 1);
        }

        // 存储字符串
        List<String> rec = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : cnt.entrySet()) {
            rec.add(entry.getKey());
        }

        /**
         * 对于出现次数相同的字符串，按照自然序
         * 对于出现频率不同的字符串，让出现频率较高的排在前面
         *
         */
        Collections.sort(rec, new Comparator<String>() {
            @Override
            public int compare(String word1, String word2) {
                return cnt.get(word1) == cnt.get(word2) ? word1.compareTo(word2) : cnt.get(word2) - cnt.get(word1);
            }
        });
        return rec.subList(0, k);
    }
}
