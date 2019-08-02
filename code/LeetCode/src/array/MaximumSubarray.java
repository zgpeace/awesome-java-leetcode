package array;

// https://leetcode.com/problems/maximum-subarray/
public class MaximumSubarray {

  public int maxSubArrayWithDP(int[] nums) {
    int[] dp = new int[nums.length + 1];
    dp[0] = nums[0];
    int max = dp[0];
    for (int i = 1; i < nums.length; i++) {
      dp[i] = dp[i - 1] > 0 ? dp[i - 1] + nums[i] : nums[i];
      max = dp[i] > max ? dp[i] : max;
    }

    return max;
  }

  public int maxSubArray(int[] nums) {
    if (nums.length <= 0) {
      return 0;
    }
    int sum = 0;
    int max = nums[0];
    for (int i = 0; i < nums.length; i++) {
      sum = sum > 0 ? sum + nums[i] : nums[i];
      if (sum > max) {
        max = sum;
      }
    }

    return max;
  }
}
