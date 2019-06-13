package number;

// https://leetcode.com/problems/factorial-trailing-zeroes/
public class FactorialTrailingZeroes {
  public int trailingZeroes(int n) {
    int count = 0;
    while (n > 0) {
      n = n / 5;
      count += n;
    }

    return count;
  }

  public int trailingZeroesWithRecursive(int n) {
    return n == 0 ? 0 : n / 5 + trailingZeroesWithRecursive(n / 5);
  }
}
