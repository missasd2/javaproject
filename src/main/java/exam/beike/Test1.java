package exam.beike;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // 库存商品总数
        int m = in.nextInt(); // 订单数量
        // 商品名——库存
        Map<String, Integer> storage = new HashMap<>();

        // 商品名——每份收益
        Map<String, Integer> price = new HashMap<>();

        // 初始化
        for (int i = 0; i < n; i++) {
            String tmp = in.next();
//            String[] s = tmp.split(" ");
            // 商品名
//            String name = s[0];
            String name = tmp;
            // 商品每份收益
            //int w = Integer.parseInt(s[1]);
            int w = in.nextInt();
            // 商品库存数量
            int c = in.nextInt();
            storage.put(name, storage.getOrDefault(name, 0) + c);
            price.put(name, price.getOrDefault(name, 0) + w);
        }

        // 处理订单
        int result = 0; // 总收入

        boolean flag = true; // 标记是否处理完所有订单; true表示处理完
        for (int i = 0; i < m; i++) {
            String line = in.next();
            //String[] lineArray = line.split(" ");
            String orderName = line;
            int orderCount = in.nextInt();

            int count = storage.get(orderName); // 商品数量
            // 库存不足
            if (count < orderCount)  {
                System.out.println("-" + (i+1));
                flag = false;
                break;
            }
            // 核减库存
            storage.put(orderName, count - orderCount);

            // 计算价格
            result += orderCount * price.get(orderName);
        }

        if (flag) {
            System.out.println(result);
        }



    }
}
