package number;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/missing-number/
public class MissingNumber {

  public static int missingNumber(int[] nums) {
    int left = 0;
    int right = nums.length - 1;
    Set<Integer> set = new HashSet<>();
    while (left <= right) {
      set.add(nums[left]);
      set.add(nums[right]);
      left++;
      right--;
    }
    left = 0;
    right = nums.length;
    while (left <= right) {
      if (!set.contains(left)) {
        return left;
      }
      if (!set.contains(right)) {
        return right;
      }
      left++;
      right--;
    }

    return nums.length;
  }

  public static int missingNumberWithSum(int[] nums) {
    int len = nums.length;
    int result = len;
    for (int i = 0; i < len; i++) {
      result = result - nums[i] + i;
    }

    return result;
  }

  public static int missingNumberWithSort(int[] nums) {
    Arrays.sort(nums);

    int len = nums.length;
    // Ensure that 0 is at the first index
    if (nums[0] != 0) {
      return 0;
    }
    // Ensure that n is at the last index
    if (nums[len - 1] != len) {
      return len;
    }

    // If we get here, then the missing number is on the range (0 , n)
    for (int i = 1; i < len; i++) {
      if (i != nums[i]) {
        return i;
      }
    }

    // Array was not missing any numbers
    return -1;
  }


  public static void main(String[] args) {
    int[] input = new int[]{3,0,1};
    int result = missingNumber(input);
  }
}
