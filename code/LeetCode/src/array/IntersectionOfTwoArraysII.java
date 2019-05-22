package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArraysII {

  public int[] intersect(int[] nums1, int[] nums2) {
    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    for (Integer i: nums1) {
      map.put(i, map.getOrDefault(i, 0) + 1);
    }

    for (Integer j: nums2) {
      if (map.containsKey(j) && map.get(j) > 0) {
        list.add(j);
        map.put(j , (map.get(j) - 1));
      }
    }


    int[] result = new int[list.size()];
    for (int i = 0; i < list.size(); i++) {
      result[i] = list.get(i);
    }

    return result;
  }
}
