package leetcode.tag.stack;

import java.util.Deque;
import java.util.LinkedList;

public class P224_Calculate_1 {

    public int calculate(String s) {
        Deque<Integer> ops = new LinkedList<>();
        ops.push(1);
        int sign = 1;

        int ret = 0;
        int n = s.length();
        int i = 0;
        while (i < n) {
            char tmp = s.charAt(i);
            if (tmp == ' ') {
                i++;
            } else if (tmp == '+') {
                sign = ops.peek();
                i++;
            } else if (tmp == '-') {
                sign = -ops.peek();
                i++;
            } else if (tmp == '(') {
                ops.push(sign);
                i++;
            } else if (tmp == ')') {
                ops.pop();
                i++;
            } else {
                long num = 0;
                while (i < n && Character.isDigit(tmp)) {
                    num = num * 10 + tmp - '0';
                    i++;
                }
                ret += sign * num;
            }
        }
        return ret;
    }
}
