package leetcode.tag.Array;

import java.util.ArrayList;

/**
 * 输出集合的所有子集
 */
public class P77_combine1 {

    public static void main(String[] args) {
        int[] a = {2, 3, 4};
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 1; i < 8; i++) {

            ArrayList<Integer> middle = new ArrayList<>();
            for (int j=0; j<3; j++){
                if ( (i & (1<<j)) != 0){
                    middle.add(a[j]);
                }
            }
            list.add(middle);
        }

        System.out.println(list);

    }
}
