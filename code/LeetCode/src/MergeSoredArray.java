public class MergeSoredArray {
    /*
    Merge Sorted Array
    Description
    Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

    Note:

    The number of elements initialized in nums1 and nums2 are m and n respectively.
    You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
    Example:

    Input:
    nums1 = [1,2,3,0,0,0], m = 3
    nums2 = [2,5,6],       n = 3

    Output: [1,2,2,3,5,6]
    Tags: Array, Two Pointers
     */

    /*
    思路
    题意是给两个已排序的数组 nums1 和 nums2，合并 nums2 到 nums1 中，两数组元素个数分别为 m 和 n，
    而且 nums1 数组的长度足够容纳 m + n 个元素，如果我们按顺序排下去，那肯定要开辟一个新数组来保存元素，
    如果我们选择逆序，这样利用 nums1 自身空间足矣，不会出现覆盖的情况，依次把大的元素插入到 nums1 的末尾，确保 nums2 中的元素全部插入到 nums1 即可。
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int position = m + n - 1;
        m--;
        n--;
        while (m >= 0 && n >= 0) {
            nums1[position--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
        }
        while (n >= 0) {
            nums1[position--] = nums2[n--];
        }

        System.out.print("result: ");
        for (int item: nums1) {
            System.out.print(item +" ");
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;
        merge(nums1, m, nums2,n);
    }

































}
