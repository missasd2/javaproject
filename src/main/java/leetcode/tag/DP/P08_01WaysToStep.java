package leetcode.tag.DP;

/**
 * 面试题 08.01. 三步问题
 */
public class P08_01WaysToStep {
    public int waysToStep(int n) {
        long prepre = 1;
        long pre = 2;
        long cur = 4;
        if(n == 1) return (int)prepre;
        if(n == 2) return (int)pre;
        if(n == 3) return (int)cur;
        for(long i=4; i <= n; i++){
            // 先对部分和进行取模运算，然后对整体进行取模运算防止溢出
            long temp = (prepre + ((pre + cur)%1000000007))%1000000007;
            prepre = pre;
            pre = cur;
            cur = temp;
        }
        return (int)(cur%1000000007);
    }
}
