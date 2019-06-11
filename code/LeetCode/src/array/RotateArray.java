package array;

import java.util.Arrays;

// https://leetcode.com/problems/rotate-array/
public class RotateArray {
  public static void rotate(int[] nums, int k) {
    int first;
    for (int i = 0; i < k; i++) {
      if (nums.length <= 0) {
        return;
      }
      first = nums[nums.length - 1];
      for (int n = nums.length - 1; n >= 0; n--) {
        nums[n] = n == 0 ? first : nums[n - 1];
      }
    }
  }

  public static void rotateWithStep(int[] nums, int k) {
    int len = nums.length;
    if (len <= 0 || k <= 0) {
      return;
    }
    k = k % len;
    int[] tempArray = new int[k];
    for (int i = 0; i < k; i++) {
      tempArray[k - 1 - i] = nums[len - 1 - i];
    }
    for (int n = len - 1; n > k - 1; n--) {
      nums[n] = nums[n - k];
    }
    for (int n = k - 1; n >= 0; n--) {
      nums[n] = tempArray[n];
    }

  }

  public static void rotateWithCyclicReplacement(int[] nums, int k) {
    int count = 0;
    int len = nums.length;
    // edge juge
    if (len <= 0 || k <= 0) {
      return;
    }
    // reduce k bigger than len;
    k = k % len;

    // start nums index
    for (int i = 0; count < len; i++) {
      int start = i;
      int prev = nums[start];
      // while step replace cycle
      do {
        int current = (start + k) % len;
        int next = nums[current];
        nums[current] = prev;
        prev = next;
        start = current;
        count++;
      } while (start != i);
    }
  }

  public static void rotateWithReverse(int[] nums, int k) {
    int len = nums.length;
    // edge juge
    if (len <= 0 || k <= 0) {
      return;
    }
    // reduce k bigger than len;
    k = k % len;
    subRotateWithReverse(nums, 0, nums.length - 1);
    subRotateWithReverse(nums, 0, k - 1);
    subRotateWithReverse(nums, k, nums.length - 1);
  }

  public static void subRotateWithReverse(int[] nums, int begin, int end) {
    while (begin < end) {
      int temp = nums[begin];
      nums[begin] = nums[end];
      nums[end] = temp;
      begin++;
      end--;
    }
  }

  public static void main(String[] args) {
    int[] input = new int[]{1,2,3,4,5,6,7};
    System.out.println(Arrays.toString(input));
    rotateWithReverse(input, 3);
    System.out.println(Arrays.toString(input));
  }
}
