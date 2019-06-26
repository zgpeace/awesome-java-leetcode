package array;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/single-number/
public class SingleNumber {
  public int singleNumber(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int n: nums) {
      if (set.contains(n)) {
        set.remove(n);
      } else {
        set.add(n);
      }
    }

    return (int)set.toArray()[0];
  }

  public int singleNumberWithBit(int[] nums) {
    int result = 0;
    for (int n: nums) {
      result ^= n;
    }

    return result;
  }
}
