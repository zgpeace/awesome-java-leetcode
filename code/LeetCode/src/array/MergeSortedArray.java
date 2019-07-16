package array;

// https://leetcode.com/problems/merge-sorted-array/
public class MergeSortedArray {
  public static void merge(int[] nums1, int m, int[] nums2, int n) {
    int index = n + m - 1;
    int oneIndex = m - 1;
    int twoIndex = n - 1;
    while (oneIndex >= 0 && twoIndex >= 0) {
      nums1[index--] = nums1[oneIndex] > nums2[twoIndex] ? nums1[oneIndex--] : nums2[twoIndex--];
    }
    while (index >= 0) {
      nums1[index--] = oneIndex >= 0 ? nums1[oneIndex--] : nums2[twoIndex--];
    }
  }

  public static void main(String[] args) {
    int[] nums1 = {2, 0};
    int[] nums2 = {1};

    merge(nums1, 1, nums2, 1);
  }
}
