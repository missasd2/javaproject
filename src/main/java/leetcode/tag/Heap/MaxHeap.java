package leetcode.tag.Heap;

/**
 * 对数组建立大根堆
 */

public class MaxHeap {

    public int findKthLargest(int[] nums, int k) {
        int heapSize = nums.length;
        buildMaxHeap(nums, heapSize);
        System.out.println("========");
        for (int i = nums.length-1; i >= nums.length-k+1 ; --i) {
            swap(nums, 0, i);
            --heapSize;
            maxHeapify(nums, 0, heapSize);
            System.out.println("========");
        }
        // 构建大根堆
        // 步骤二：将堆顶元素与最后一个元素进行交换，然后剩下的n-1个元素进行堆化
        // 重复步骤二 k-1次
        // 则经过k-1次交换、堆化后堆顶的元素就是第k大元素
        return nums[0];

    }

    public void buildMaxHeap(int[] a, int heapSize){
        for (int i = heapSize/2; i >= 0 ; --i) {
            maxHeapify(a, i, heapSize);
        }
    }

    public void maxHeapify(int[] a, int i, int heapSize){
        int l = i * 2 +1;
        int r = i * 2 + 2;
        int largest = i;

        if ( l < heapSize && a[l] > a[largest]){
            largest = l;
        }
        if ( r < heapSize && a[r] > a[largest]){
            largest = r;
        }

        if (largest != i){
            swap(a, i, largest);
            maxHeapify(a, largest, heapSize);
        }
    }

    public void swap(int[] a, int i, int largest){
        int tmp = a[i];
        a[i] = a[largest];
        a[largest] =  tmp;
    }

    public static void main(String[] args) {
        int[] nums = {6, 5, 4, 5, 2, 3, 3, 1, 2};
        int k = 4;
        MaxHeap maxHeap = new MaxHeap();
        int kthLargest = maxHeap.findKthLargest(nums, k);
        System.out.println(kthLargest);
    }
}
