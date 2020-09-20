package exam.yuanfudao.test1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 洗牌，将牌分为等大小的两堆
 * 比如说 012345，洗牌之后的索引排布为304152
 */
public class Solution1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // n 张牌
        int m = sc.nextInt(); // m 次洗牌

        ArrayList<Integer> cards = new ArrayList<>();
        for(int i = 0; i < n; i++){
            cards.add(sc.nextInt());
        }

        // 洗m次牌
        shuffle(cards, m);
        StringBuilder builder = new StringBuilder();
        for (int i : cards){
            builder.append(i).append(" ");
        }
        builder.deleteCharAt(builder.length() - 1);
        System.out.println(builder);
    }

    public static void shuffle(ArrayList<Integer> cards, int m){
        int n = cards.size();
        // 洗m次牌
        for (int i = 0; i < m; i++){
            // 每次洗牌的操作
            ArrayList<Integer> tmp = new ArrayList<>();
            tmp.addAll(cards);

            // 洗 0~N/2 的牌
            for (int j = 0; j < n/2; j++){
                cards.set(2 * j+1, tmp.get(j));
            }

            // 洗 N/2+1~N-1 索引的值
            for (int k = n/2; k < n; k++){
                cards.set(k%(n/2)*2, tmp.get(k));
            }
        }

    }
}
