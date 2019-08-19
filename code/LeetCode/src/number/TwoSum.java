package number;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/two-sum/
public class TwoSum {
  public int[] twoSum(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
      for (int k = i + 1; k < nums.length; k++) {
        if (nums[i] + nums[k] == target) {
          return new int[]{nums[i], nums[k]};
        }
      }
    }

    return null;
  }

  public int[] twoSumWithHashMap(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      map.put(nums[i], i);
    }
    int remain;
    for (int i = 0; i < nums.length; i++) {
      remain = target - nums[i];
      if (map.containsKey(remain) && map.get(remain) != i) {
        return new int[]{i, map.get(remain)};
      }
    }

    throw new IllegalArgumentException("No two sum solution");
  }


  public int[] twoSumWithMap(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    int remain;
    for (int i = 0; i < nums.length; i++) {
      remain = target - nums[i];
      if (map.containsKey(nums[i])) {
        return new int[]{map.get(nums[i]) , i};
      }
      map.put(remain, i);
    }

    throw new IllegalArgumentException("No two sum solution");
  }
}
