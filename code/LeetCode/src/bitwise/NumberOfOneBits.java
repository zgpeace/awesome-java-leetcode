package bitwise;

// https://leetcode.com/problems/number-of-1-bits/
public class NumberOfOneBits {
  // you need to treat n as an unsigned value
  public static int hanmmingWeight(int n) {
    int count = 0;
    while (n != 0) {
      n = n & (n - 1);
      count++;
    }

    return count;
  }

  public static int hanmmingWeightVerbose(int n) {
    int count = 0;
    int mask = 1;
    for (int i = 1; i <= 32; i++) {
      if ((n & mask) != 0) {
        count++;
      }
      mask <<= 1;
    }

    return count;
  }

  public static void main(String[] args) {
    System.out.println(hanmmingWeightVerbose(11));
  }
}
