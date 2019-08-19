package number;

// https://leetcode.com/problems/reverse-integer/
public class ReverseInteger {
  public int reverse(int x) {
    int result = 0;
    int pop;
    int maxIntDivideTen = Integer.MAX_VALUE / 10;
    int minIntDevideTen = Integer.MIN_VALUE / 10;
    while (x != 0 ) {
      pop = x % 10;
      // consider integer overflows, return -1
      if (result > maxIntDivideTen || (result == maxIntDivideTen && pop > 7)) {
        return 0;
      } else if (result < minIntDevideTen || (result == minIntDevideTen && pop < -8)) {
        return 0;
      }

      result = result * 10 + pop;
      x = x / 10;
    }

    return result;
  }
}
