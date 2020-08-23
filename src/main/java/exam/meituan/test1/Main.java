package exam.meituan.test1;

import java.util.Scanner;

/**
 * 时间限制： 4000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 小美是美团的前端工程师，为了防止系统被恶意攻击，小美必须要在用户输入用户名之前做一个合法性检查，一个合法的用户名必须满足以下几个要求：
 *
 * 1.    用户名的首字符必须是大写或者小写字母。
 *
 * 2.    用户名只能包含大小写字母，数字。
 *
 * 3.    用户名需要包含至少一个字母和一个数字。
 *
 * 如果用户名合法，请输出“Accept”，反之输出“Wrong”。
 *
 *
 *
 * 输入描述
 * 输入第一行包含一个正整数T，表示需要检验的用户名数量。(1<=T<=100)
 *
 * 接下来有T行，每行一个不超过20的字符串s，表示输入的用户名。
 *
 * 输出描述
 * 对于每一个输入的用户名s，请输出一行，即按题目要求输出一个字符串。
 * 请使用标准输入输出(System.in, System.out)；
 * 勿使用图形、文件、网络、系统相关的操作，如java.lang.Process , javax.swing.JFrame , Runtime.getRuntime
 * 不要自定义包名称，否则会报错，即不要添加package answer之类的语句；
 * 您可以写很多个类，但是必须有一个类名为Main，并且为public属性，并且Main为唯一的public class
 * Main类的里面必须包含一个名字为'main'的静态方法（函数），这个方法是程序的入口
 *
 * 样例输入
 * 5
 * Ooook
 * Hhhh666
 * ABCD
 * Meituan
 * 6666
 * 样例输出
 * Wrong
 * Accept
 * Wrong
 * Wrong
 * Wrong
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 正整数T，表示需要检验的用户名数量。(1<=T<=100)
        int T = sc.nextInt();
        // names存储用户的输入
        String[] names = new String[T];
        for (int i = 0; i < T; i++) {
            names[i] = sc.next();
        }

        // 进行合法校验
        for (String s : names){
            if (check(s)){
                System.out.println("Accept");
            }else {
                System.out.println("Wrong");
            }
        }
    }

    private static boolean check(String name){
        // 为空
        if (name == null) return false;
        // 长度至少为2
        if (name.length() < 2) return false;
        char[] ch = name.toCharArray();
        // 首字符必须是大写或者小写字母
        if (!Character.isLetter(ch[0])) return false;
        int ch_count = 0;
        int num_count = 0;
        // 统计字母，数字个数；
        for (char c : ch){
            // 用户名只能包含大小写字母，数字。
            if (!Character.isLetterOrDigit(c)) {
                return false;
            }
            if (Character.isLetter(c)) ch_count++;
            if (Character.isDigit(c)) num_count++;
        }
        // 用户名需要包含至少一个字母和一个数字。
        if (ch_count == 0 || num_count == 0) return false;
        return true;
    }
}
