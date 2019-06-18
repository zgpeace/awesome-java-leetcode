package array;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/majority-element/
public class MajorityElement {
  public static int majorityElement(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    int half = nums.length >> 1;
    for (int n: nums) {
      map.put(n, map.getOrDefault(n, 0) + 1);
      if (map.get(n) > half) {
        return n;
      }
    }

    return -1;
  }

  public static int majorityElementWithBoyerMoorVoting(int[] nums) {
    int count = 0;
    // default is invalid
    int candidate = -1;
    for (int n: nums) {
      if (count == 0) {
        candidate = n;
      }
      count += (candidate == n ? 1 : -1);
    }

    return candidate;
  }



  public static void main(String[] args) {
    int result = majorityElementWithBoyerMoorVoting(new int[]{6, 5, 5});
    System.out.println(result);
  }
}
