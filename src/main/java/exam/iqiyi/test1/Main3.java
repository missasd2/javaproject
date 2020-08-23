package exam.iqiyi.test1;

import java.util.Scanner;
import java.util.Stack;

/**
 * 判断字符串括号是否有效
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 1. 左括号必须用相同类型的右括号闭合。
 *
 * 2. 左括号必须以正确的顺序闭合。
 *
 * 注意空字符串可被认为是有效字符串。
 *
 *
 *
 * 输入描述
 * 一个字符串，仅包含括号'('，')'，'{'，'}'，'['，']'
 *
 * 输出描述
 * 如果字符串验证有效，返回 True
 *
 * 如果字符串验证无效，返回 False
 *
 *
 * 样例输入
 * ()
 * 样例输出
 * True
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        if (check(str)){
            System.out.println("True");
        }else {
            System.out.println("False");
        }
    }

    private static boolean check(String str){
        if (str.length() == 0 || str == null) return true;
        if (str.length() % 2 != 0) return false;
        Stack<Character> stack = new Stack<Character>();
        // 进行栈初始化
        stack.push(str.charAt(0));
        for (int i=1; i<str.length(); i++){
            char c = str.charAt(i);
            if (c == '（' || c == '{'|| c == '[')
                stack.push(str.charAt(i));
            if (c == ')' || c == '}' || c == ']'){
                if (stack.isEmpty()) return false;
                char d = stack.pop();
                // 判断配对情况
                if (c == ')' && d != '(') return false;
                if (c == '}' && d != '{') return false;
                if (c == ']' && d != '[') return false;
            }
        }
        if (!stack.isEmpty()){
            return false;
        }
        return true;
    }
}
