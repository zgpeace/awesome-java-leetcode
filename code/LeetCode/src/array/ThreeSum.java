package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/3sum/
public class ThreeSum {

  public static void main(String[] args) {
    int[] nums = {0, 0, 0, 0};
    threeSum(nums);
  }

  public static List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
    // edge condition track
    if (nums == null || nums.length < 3 || nums[0] > 0 || nums[nums.length - 1] < 0) {
      return result;
    }
    int l, r;
    int len = nums.length;
    // pivot i
    int i = 0;
    // increase the min one
    while (i < len - 2 && nums[i]+ nums[len - 1] * 2 < 0) {
      i++;
    }
    int rightMax = len - 1;
    // decrease the max one
    while (i < rightMax && nums[i] * 2 + nums[rightMax] > 0) {
      rightMax--;
    }

    int remain;
    for (; i < rightMax; i++) {
      if (i - 1 >= 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      l = i + 1;
      r = rightMax;
      remain = 0 - nums[i];
      // shrink between l and r
      while (l < r) {
        if (nums[l] + nums[r] == remain) {
          result.add(Arrays.asList(nums[i], nums[l], nums[r]));
          while (l < r && nums[l] == nums[++l]) {
          }
          while (l < r && nums[r] == nums[--r]) {
          }
        }
        while (l < r && nums[l] + nums[r] < remain) {
          l++;
        }
        while (l < r && nums[l] + nums[r] > remain) {
          r--;
        }
      }

    }

    return result;
  }
}
