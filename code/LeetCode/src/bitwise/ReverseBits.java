package bitwise;

// https://leetcode.com/problems/reverse-bits/
public class ReverseBits {
  // you need treat n as an unsigned value
  public int reverseBits(int n) {
    int mask = 1;
    int result = 0;
    int appendInt;
    for (int i = 1; i <= 32; i++) {
      appendInt = 0;
      if ((mask & n) != 0) {
        appendInt = 1;
      }
      result = (result << 1) + appendInt;
      mask <<= 1;
    }

    return result;
  }
}
