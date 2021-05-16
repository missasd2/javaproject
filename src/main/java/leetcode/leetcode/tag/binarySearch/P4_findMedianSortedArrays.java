package leetcode.leetcode.tag.binarySearch;

public class P4_findMedianSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] tmp = new int[m + n];
        int i = 0;
        int j = 0;
        int cur = 0;
        while(i < m && j < n) {
            if(nums1[i] <= nums2[j]) {
                tmp[cur] = nums1[i];
                i++;
                cur++;
            }else{
                tmp[cur] = nums2[j];
                j++;
                cur++;
            }
        }

        if(i == m) {
            while(j < n) {
                tmp[cur] = nums2[j];
                j++;
                cur++;
            }
        }

        if(j == n) {
            tmp[cur] = nums1[i];
            i++;
            cur++;
        }

        if((m + n) % 2 != 0) {
            return (double)tmp[(m + n)/2];
        }

        return ( (double)tmp[(m + n)/2] + (double)tmp[(m + n)/2 + 1] ) / 2;


    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
