package binarysearch;

import java.util.Arrays;

// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
public class FindFirstAndLastPositionOfElementInSortedArray {

  public static void main(String[] args) {
    int[] nums = {2, 2};
    int target = 2;
    FindFirstAndLastPositionOfElementInSortedArray obj = new FindFirstAndLastPositionOfElementInSortedArray();
    int[] result = obj.searchRangeWithFirstGreatEqual(nums, target);
    System.out.println(Arrays.toString(result));
  }

  public int[] searchRangeWithFirstGreatEqual(int[] nums, int target) {
    int[] result = new int[]{-1, -1};
    // edge check
    if (nums == null || nums.length == 0) {
      return result;
    }
    int find = findFirstGreatEqual(nums, target);
    if (find >= nums.length || nums[find] != target) {
      return result;
    }
    result[0] = find;
    result[1] = findFirstGreatEqual(nums, target + 1) - 1;

    return result;
  }

  //find the first number that is greater than or equal to target.
  //could return A.length if target is greater than A[A.length-1].
  private int findFirstGreatEqual(int[] nums, int target) {
    int low = 0;
    int high = nums.length;
    while (low < high) {
      int mid = low + ((high - low) >> 1);
      //low <= mid < high
      if (nums[mid] < target) {
        low = mid + 1;
      } else {
        //should not be mid-1 when A[mid]==target.
        //could be mid even if A[mid]>target because mid<high.
        high = mid;
      }
    }

    return low;
  }

  public int[] searchRangeWithEasyTwoMethod(int[] nums, int target) {
    int[] result = new int[]{-1, -1};
    // edge check
    if (nums == null || nums.length == 0) {
      return result;
    }
    result[0] = findFisrt(nums, target);
    result[1] = findLast(nums, target);

    return result;
  }

  private int findFisrt(int[] nums, int target) {
    int result = -1;
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      int mid = left + ((right - left) >> 1);
      if (nums[mid] >= target) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
      if (nums[mid] == target) {
        result = mid;
      }
    }

    return result;
  }

  private int findLast(int[] nums, int target) {
    int result = -1;
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      int mid = left + ((right - left) >> 1);
      if (nums[mid] <= target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
      if (nums[mid] == target) {
        result = mid;
      }
    }


    return result;
  }

  public int[] searchRange(int[] nums, int target) {
    int[] result = new int[]{-1, -1};
    // edge check
    if (nums == null || nums.length == 0) {
      return result;
    }

    int left = 0;
    int right = nums.length - 1;
    int find = -1;
    while (left <= right && find == -1) {
      int mid = left + ((right - left) >> 1);
      if (nums[mid] == target) {
        find = mid;
        break;
      } else if (nums[mid] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    // no found return
    if (find == -1) {
      return result;
    }

    int findMinRight = find;
    while (left <= findMinRight) {
      int mid = left + ((findMinRight - left) >> 1);
      if (nums[mid] == target) {
        result[0] = mid;
        findMinRight = mid - 1;
      } else {
        // less than target
        left = mid + 1;
      }
    }

    int findMaxLeft = find;
    while (findMaxLeft <= right) {
      int mid = findMaxLeft + ((right - findMaxLeft) >> 1);
      if (nums[mid] == target) {
        result[1] = mid;
        findMaxLeft = mid + 1;
      } else {
        // more than target
        right = mid - 1;
      }
    }

    return result;
  }
}
