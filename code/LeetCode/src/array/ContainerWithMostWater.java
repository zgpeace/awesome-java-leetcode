package array;

import sun.security.util.Length;

// https://leetcode.com/problems/container-with-most-water/
public class ContainerWithMostWater {

  public int maxAreaWithTwoPointer(int[] height) {
    int left = 0;
    int right = height.length - 1;
    int result = 0;
    while (left < right) {
      result = Math.max(result, Math.min(height[left], height[right]) * (right - left));
      if (height[left] < height[right]) {
        left++;
      } else {
        right--;
      }
    }

    return result;
  }

  public int maxArea(int[] height) {
    int current;
    int result = 0;
    for (int i = 0; i < height.length; i++) {
      for (int k = height.length - 1; k > i; k--) {
        current = (k - i) * Math.min(height[k], height[i]);
        if (current > result) {
          result = current;
        }
      }
    }

    return result;
  }
}
