package leetcode.tag.stack;

import java.util.Deque;
import java.util.LinkedList;

public class P224_Calculate {
    public int calculate(String s) {
        Deque<Integer> ops = new LinkedList<Integer>();
        ops.push(1);
        int sign = 1;

        int ret = 0;
        int n = s.length();
        int i = 0;
        while (i < n) {
            if (s.charAt(i) == ' ') { // 如果字符为空则跳过
                i++;
            } else if (s.charAt(i) == '+') { // 如果字符为加号，则获得符号队列的头部元素
                sign = ops.peek();
                i++;
            } else if (s.charAt(i) == '-') { // 获得符号队列的头部元素的负元素
                sign = -ops.peek();
                i++;
            } else if (s.charAt(i) == '(') { // 左括号表示，将符号添加到队列的尾部
                ops.push(sign); // 压栈
                i++;
            } else if (s.charAt(i) == ')') {
                ops.pop();  // 出栈
                i++;
            } else {
                long num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) { // 从高位迭代计算数字值
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                ret += sign * num;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        P224_Calculate solution = new P224_Calculate();
        String s = "(1+(4+5+2)-3)+(6+8)";
        String s1 = "2147483647";
        System.out.println(solution.calculate(s1));
    }
}
