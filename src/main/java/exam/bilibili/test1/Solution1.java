package exam.bilibili.test1;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    public int GetMaxConsecutiveOnes (int[] arr, int k) {
        // write code here
        List<Integer> count = new ArrayList<Integer>();
        // 将0所在位置索引记录下来
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0){
                count.add(i);
            }
        }

        return 0;

    }
}
