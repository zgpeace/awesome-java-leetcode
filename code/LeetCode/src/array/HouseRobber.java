package array;

import java.util.Arrays;

// https://leetcode.com/problems/house-robber/
public class HouseRobber {
  public static int rob(int[] nums) {
    // back tracking
    return subRob(nums, 0);

  }

  public static int subRob(int[] nums, int index) {
    if (index >= nums.length) {
      return 0;
    }
    // if select current
    int sum1 = nums[index] + subRob(nums,index + 2);
    // if not select current
    int sum2 = subRob(nums, index + 1);
    return Math.max(sum1, sum2);
  }

  public static int robReverse(int[] nums) {
    return subRobReverse(nums, nums.length - 1);
  }

  public static int subRobReverse(int[] nums, int index) {
    if (index < 0) {
      return 0;
    }
    return Math.max(subRobReverse(nums, index - 2) + nums[index], subRobReverse(nums, index - 1));
  }

  static int[] memo;

  public static int robReverseWithMemo(int[] nums) {
    memo = new int[nums.length];
    Arrays.fill(memo, -1);

    return subRobReverseWithMemo(nums, nums.length - 1);
  }

  public static int subRobReverseWithMemo(int[] nums, int index) {
    if (index < 0) {
      return 0;
    }
    if (memo[index] != -1) {
      return memo[index];
    }
    memo[index] = Math.max(subRobReverseWithMemo(nums, index - 2) + nums[index], subRobReverseWithMemo(nums, index - 1));

    return memo[index];
  }

  public static int robIterate(int[] nums) {
    if (nums.length <= 0) {
      return 0;
    }
    int[] memory = new int[nums.length + 1];
    memory[0] = 0;
    memory[1] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      memory[i + 1] = Math.max(memory[i], memory[i - 1] + nums[i]);
    }

    return memory[nums.length];
  }

  public static int robDP(int[] nums) {
    if (nums.length <= 0) {
      return 0;
    }
    int notRobPre = 0;
    int robPre = nums[0];
    int temp;
    for (int i = 1; i < nums.length; i++) {
      temp = Math.max(robPre, notRobPre + nums[i]);
      notRobPre = robPre;
      robPre = temp;
    }

    return robPre;
   }

   public static int robDPStatus(int[] nums) {
    int[][] dp = new int[nums.length + 1][2];
    for (int i = 1; i <= nums.length; i++) {
      dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
      dp[i][1] = nums[i - 1] + dp[i - 1][0];
    }

    return Math.max(dp[nums.length][0], dp[nums.length][1]);
   }

  public static void main(String[] args) {
    int[] input = {1, 2, 3, 1};
    int result;
    result = robDPStatus(input);
    System.out.println("result: " + result);
    input = new int[]{2, 7, 9, 3, 1};
    result = robDPStatus(input);
    System.out.println("result: " + result);
    input = new int[]{2, 1, 1, 2};
    result = robDPStatus(input);
    System.out.println("result: " + result);
  }
}
