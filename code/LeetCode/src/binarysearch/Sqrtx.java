package binarysearch;

// https://leetcode.com/problems/sqrtx/
public class Sqrtx {

  public static int mySqrt(int x) {
    if (x == 1 || x == 0) {
      return x;
    }
    int left = 0;
    int right = x;
    int mid;
    while (left < right) {
      mid = left + ((right - left) >> 1);
      if (mid > x / mid) {
        right = mid - 1;
      } else {
        if ((mid + 1) > x / (mid + 1)) {
          return mid;
        }
        left = mid + 1;
      }
    }

    return left;
  }

  public static void main(String[] args) {
    mySqrt(10);
  }
}
