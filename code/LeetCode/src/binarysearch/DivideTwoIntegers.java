package binarysearch;

// https://leetcode.com/problems/divide-two-integers/
public class DivideTwoIntegers {

  int maxOfHalf = Integer.MAX_VALUE >> 1;

  public static void main(String[] args) {
    DivideTwoIntegers obj = new DivideTwoIntegers();
    int result = obj.divide(-2147483648, -1);
    System.out.println("result > " + result);
  }

  public int divide(int dividend, int divisor) {
    // Reduce the problem to positive long integer to make it easier.
    // Use long to avoid integer overflow case.
    int sign = -1;
    if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) {
      sign = 1;
    }
    long ldividend = Math.abs((long)dividend);
    long ldivisor = Math.abs((long)divisor);

    // Take care the edge cases.
    if (ldivisor == 0) return Integer.MAX_VALUE;
    if ((ldividend == 0 || (ldividend < ldivisor))) return 0;

    long lans = ldivide(ldividend, ldivisor);

    int ans;
    if (lans > Integer.MAX_VALUE) {
      // Handle overflow.
      ans = (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
    } else {
      ans = (int)((sign == 1) ? lans : -lans);
    }

    return ans;
  }

  private long ldivide(long ldividend, long ldivisor) {
    // Recursion exit condition
    if (ldividend < ldivisor) {
      return 0;
    }

    // Find the largest multiple so that (divisor * multiple <= dividend),
    // whereas we are moving with stride 1, 2, 4, 8, 16...2^n for performance reason.
    // Think this as a binary search.
    long sum = ldivisor;
    long multiple = 1;
    while ((sum << 1) <= ldividend) {
      multiple <<= 1;
      sum <<= 1;
    }

    // Look for additional value for the multiple from the reminder (dividend - sum) recursively.
    return multiple + ldivide(ldividend - sum, ldivisor);
  }

}
