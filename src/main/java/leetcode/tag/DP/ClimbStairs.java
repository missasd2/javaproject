package leetcode.tag.DP;

public class ClimbStairs {
    public static int climbStairs(int n){
        if (n <= 2) return n;
        return climbStairs(n-2) + climbStairs(n-1);
    }

    public static void main(String[] args) {
        System.out.println(ClimbStairs.climbStairs(45));
    }
}
