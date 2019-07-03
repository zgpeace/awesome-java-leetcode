package dp;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class BestTimeToBuyAndSellStock {
  public int maxProfit(int[] prices) {
    int max = 0;
    int profit;
    for (int i = 0; i < prices.length; i++) {
      for (int k = i + 1; k < prices.length; k++) {
        profit = prices[k] - prices[i];
        if (profit > max) {
          max = profit;
        }
      }
    }

    return max;
  }

  public int maxProfitWithOnePass(int[] prices) {
    if (prices.length <= 0) {
      return 0;
    }
    int max = 0;
    int valley = prices[0];
    int gap;
    for (int p: prices) {
      if (valley > p) {
        valley = p;
      }
      gap = p - valley;
      if (max < gap) {
        max = gap;
      }
    }

    return max;
  }
}
