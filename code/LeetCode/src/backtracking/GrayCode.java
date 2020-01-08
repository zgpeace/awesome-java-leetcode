package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/gray-code/
public class GrayCode {

  public static void main(String[] args) {
    GrayCode obj = new GrayCode();
    List<Integer> result = obj.grayCode(2);
    System.out.println(Arrays.toString(result.toArray()));
  }

  public List<Integer> grayCode(int n) {
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < (1<<n); i++) {
      result.add((i ^ i >> 1));
    }

    return result;
  }
}
