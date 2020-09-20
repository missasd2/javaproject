package exam.didi.test1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * 破解X星人的密文
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * X星人最近流行打暗语，大家都喜欢把信息加密后再发送给对方，然后再偷偷告诉人家破解方法，他们觉得这样很酷。
 *
 * 某X星人发明了一种加密方法，该加密方法是将一个明文字符串从左到右分割成若干个长度相等的子字符串（最后一个子字符串的长度可以不同），然后将每个子字符串中的字符进行逆序，从而得到密文。
 *
 * 但是，X星人可不会轻易告诉你每个子字符串的长度是多少。还好你够聪明，每次都能够猜到X星人设置的长度值。
 *
 * 现在你成功截取了X星人的密文并且也猜到了X星人设置的长度值，能否写一个程序将该密文破解得到对应的明文呢？
 *
 *
 *
 * 输入描述
 * 单组输入。
 *
 * 每组测试数据的输入占两行，其中第一行包含一个正整数n，表示分割时每个子字符串的长度，第二行为密文字符串S。 （密文字符串S的长度<=1000，n<=100）
 *
 * 密文可能包含英文大小写字母、数字、空格和英文标点符号。
 *
 * 输出描述
 * 每组测试数据的输出占一行，表示破解密文后得到的明文。
 *
 *
 * 样例输入
 * 2
 * gogogoout
 * 样例输出
 * ogogoguot
 *
 * 提示
 * 输入样例2
 * 3
 * Gogo, go out!?
 * 输出样例2
 * goG ,o ogtuo?!
 *
 * 输入样例3
 * 6
 * hello
 * 输出样例3
 * olleh
 * 规则
 */
public class Solution1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(String.valueOf(sc.nextLine().charAt(0)));

         String s = sc.nextLine();
        //System.out.println(s);
        // 计算一共可以截取的长度相同的子串；
        int count = s.length() / n;
        StringBuilder builder = new StringBuilder();

        int first = 0;
        int second = n-1;
        for (int i = 0; i < count ; i++){
            String sub = s.substring(first, second); // 截取子串
            // 将截取的子串反向拼接
            for (int j = second; j >= first; j--){
                builder.append(s.charAt(j));
            }

            // 步进
            first = first + n;
            second = second + n;
        }

        // 处理剩余的尾巴子串
        int tail = s.length() % n;
        for (int i = 1; i <= tail; i++){
            builder.append(s.charAt(s.length() - i));
        }
        System.out.println(builder.toString());

    }
}
