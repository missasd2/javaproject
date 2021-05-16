package JavaSE.Collection.Queue;


import java.util.ArrayDeque;

/**
 * 用数组实现 队列
 */
public class MyArrayQueue {

    public static void main(String[] args) {
        String s = "s";
        System.out.println(reverse(-2147483648));

    }


        public static int reverse(int x) {
            String tmp = Math.abs(x) + "";
            System.out.println(Math.abs(x));
            int n = tmp.length();
            int index = 0;

            StringBuilder builder = new StringBuilder();
            for(int i = n-1; i >= 0; i--) {
                builder.append(tmp.charAt(i));
            }
            String res = builder.toString();
            for(int i = 0; i < n; i++) {
                if(res.charAt(i) != '0'){
                    index = i;
                    break;
                }
            }

            String result = res.substring(index, res.length());

            long num = Long.parseLong(result);
            if(x < 0) {
                if(num > Integer.MAX_VALUE ) {
                    return 0;
                } else {
                    return (int)(-1 * num);
                }
            }else {
                if(num > Integer.MAX_VALUE) {
                    return 0;
                }else {
                    return (int)num;
                }
            }
        }

}
