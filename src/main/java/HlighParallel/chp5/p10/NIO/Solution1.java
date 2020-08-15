package HlighParallel.chp5.p10.NIO;

public class Solution1 {

    public Integer solu(int[] n, int a, int x){
        int result = 0;
        int b = sum(n);
        int target = 60 * a * x + 60 * (8 - x); // 相当于总的时间
        if (b > target) return 0;

        if (b >= 60 * a * x){
            result = 60 * x + (b - 60 * a * x);
        }else {
           result = (int)Math.ceil(b / a);
        }

        return  result;
    }

    private int sum(int[] n){
        int result = 0;
        for (int x : n){
            result += x;
        }
        return result;
    }
}
