package leetcode.tag.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P350_Intersect {

    // 哈希表
    public int[] intersect_hash(int[] nums1, int[] nums2) {
        // 1. 遍历长度较短的数组
        if (nums1.length > nums2.length) {
            return intersect_hash(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<>();
        // 2. 统计nums1中每个数字出现的次数
        for (int num : nums1) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }
        // 3. 定义保存结果的数组
        int[] intersection = new int[nums1.length];
        int index = 0;
        // 4.
        for (int num : nums2) {
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                // 4.1 向intersection数组中填入数字，并将该数字出现计数减一
                intersection[index++] = num;
                count--;
                // 更新count的值; 若count的值小于等于0，则移除哈希表中该条目
                if (count > 0) {
                    map.put(num, count);
                } else {
                    map.remove(num);
                }
            }
        }
        // 5. 选取数组部分元素
        return Arrays.copyOfRange(intersection, 0, index);

    }
}
