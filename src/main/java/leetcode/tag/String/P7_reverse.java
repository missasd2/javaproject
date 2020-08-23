package leetcode.tag.String;

/**
 * 7. 整数反转
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class P7_reverse {
    public int reverse(int x){
        if (x == 0 || x == Integer.MIN_VALUE  || x == Integer.MIN_VALUE) return 0;
        boolean flag = true;
        if (x < 0){
            flag = false;
            x = -x;
        }
        String str = Integer.toString(x); // 正数变成字符串
        StringBuffer stringBuffer = new StringBuffer(str);
        str = stringBuffer.reverse().toString(); // StringBuffer翻转再变回字符串
        long result = Long.parseLong(str); // 字符串变成长整型
        if (!flag){
            result = -result;
        }
        if (result>Integer.MAX_VALUE || result<Integer.MIN_VALUE){
            return 0;
        }
        return (int)result;
    }
}
