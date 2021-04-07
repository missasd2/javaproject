package bit;

public class CountBits {

    public static int[] countBits(int num) {
        int[] res = new int[num+1];
        for (int i = 0; i <= num; i++) {
            res[i] = countOne(i);
        }
        return res;
    }

    private static int countOne(int i) {

        int count = 0;
        while (i > 0) {
            i = i & (i - 1);
            count++;
        }
        return count;
    }


    public static void main(String[] args) {
        int[] ints = countBits(3);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
}
