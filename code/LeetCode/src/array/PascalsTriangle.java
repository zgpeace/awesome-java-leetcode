package array;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/pascals-triangle/
public class PascalsTriangle {

  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> result = new ArrayList<>();
    for (int i = 1; i <= numRows; i++) {
      // current list
      List<Integer> current = new ArrayList<>();
      // pre list
      List<Integer> pre = i == 1 ? null : result.get(i - 1 - 1);
      for (int k = 0; k < i; k++) {
        if (k == 0 || k == i - 1) {
          current.add(1);
        } else {
          current.add(pre.get(k - 1) + pre.get(k));
        }
      }

      // add current list to result
      result.add(current);
    }

    return result;
  }
}
