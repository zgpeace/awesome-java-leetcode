package dp;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
public class BestTimeToBuyAndSellStockII {
  public int maxProfit(int[] prices) {
    int profit = 0;
    for (int i = 1; i < prices.length; i++) {
      if (prices[i] > prices[i - 1]) {
        profit += prices[i] - prices[i - 1];
      }
    }

    return profit;
  }

  public static int maxProfitWithBruteForce(int[] prices) {
    return calculate(prices, 0);
  }

  public static int calculate(int[] prices, int start) {
    if (start >= prices.length) {
      return 0;
    }
    // max profit
    int max = 0;
    // loop from start
    for (int i = start; i < prices.length; i++) {
      // current max;
      int maxProfit = 0;

      // loop after start
      for (int k = i + 1; k < prices.length; k++) {
        // current > start ,then two way: sell stock or keep
        if (prices[k] > prices[i]) {
          int profit = prices[k] - prices[i] + calculate(prices, k + 1);
          if (profit > maxProfit) {
            maxProfit = profit;
          }
        }
      }

      if (maxProfit > max) {
        max = maxProfit;
      }
    }

    return max;
  }

  public static int maxProfitWithValleyAndPeak(int[] prices) {
    if (prices.length <= 0) {
      return 0;
    }
    int max = 0;
    int valley;
    int peak;
    int i = 0;
    while (i < prices.length - 1) {
      // find the valley index
      while (i < prices.length - 1 && prices[i] >= prices[i + 1]) {
        i++;
      }
      valley = prices[i];
      // find the peak index
      while (i < prices.length - 1 && prices[i] <= prices[i + 1]) {
        i++;
      }
      peak = prices[i];
      max += peak - valley;
    }

    return max;
  }

  public static void main(String[] args) {
    int result = maxProfitWithValleyAndPeak(new int[]{1,2,3,4,5});
    System.out.println("result: " + result);
  }
}
