package dp;

import java.util.Arrays;

// https://leetcode.com/problems/climbing-stairs/
public class ClimbingStairs {

  int[] memo = null;
  // recursive : problem > Time Limit Exceeded
  public int climbStairs(int n) {
    if (memo == null) {
      memo = new int[n + 1];
      Arrays.fill(memo, -1);
    }
    if (n == 1 || n == 0) {
      return 1;
    }

    if (memo[n] != -1) {
      return memo[n];
    }
    memo[n] = climbStairs(n - 1) + climbStairs(n - 2);
    return memo[n];
  }

  // Fibonacci
  public int climbStairsWithFibonacci(int n) {
    if (n == 0 || n == 1) {
      return 1;
    }
    int pre = 1;
    int current = 1;
    int temp;
    for (int i = 2; i <= n; i++) {
      temp = pre + current;
      pre = current;
      current = temp;
    }

    return current;
  }

  // dynamic program
  public int climbStairsWithDP(int n) {
    if (n == 1 || n == 0) {
      return 1;
    }
    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;
    for (int i = 2; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }

    return dp[n];
  }
}
