package leetcode.tag.Array.SlidingWindow;

public class Demo1 {

    public static void calByLeapWindow(int[] array, int k) {
        if (array.length == 0 || k <= 0 || k > array.length) {// 非法参数不处理
            return;
        }

        int index = 0;// 记录最大子数组第1个元素的索引，目前是0
        int maxSum = 0;// 记录最大子数组和，目前是从左开始第1个子数组
        for (int i = 0; i < k; i++) {
            maxSum += array[i];
        }

        int curWindowSum = maxSum;
        for (int i = 1; i <= array.length - k; i++) {// 从下个元素开始，即窗口向右滑动
            curWindowSum = curWindowSum - array[i - 1] + array[k + i - 1];// 减去失效值，加上最新值
            if (curWindowSum > maxSum) {// 如果大于最大和，则记录
                maxSum = curWindowSum;
                index = i;
            }
        }

        /**打印结果*/
        System.out.print(maxSum + " // ");// 打印最大和
        System.out.print(array[index]);// 先打印第1个值
        for (int i = 1; i < k; i++) {
            int value = array[i + index];
            System.out.print(value >= 0 ? ("+" + value) : value);// 非负数前面打印+号
        }
        System.out.println();
    }

    public static void main(String[] args) {


        System.out.println("-------------");

        calByLeapWindow(new int[]{1, 2, 3, 4}, 2);
        //calByLeapWindow(new int[]{-1,4,7,-3,8,5,-2,6}, 3);
    }
}
