package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// https://leetcode.com/problems/permutations-ii/
public class PermutationsII {

  public static void main(String[] args) {
    PermutationsII obj = new PermutationsII();
    int[] input = {1,1,2};
    List<List<Integer>> resultList = obj.permuteUnique(input);
    System.out.println(Arrays.toString(resultList.toArray()));
  }

  public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> resultList = new ArrayList<List<Integer>>();
    Arrays.sort(nums);
    boolean[] used = new boolean[nums.length];
    if (nums == null || nums.length == 0) {
      return resultList;
    }
    dfs(nums, resultList, new ArrayList<Integer>(), used);

    return resultList;
  }

  private void dfs(int[] nums, List<List<Integer>> resultList, List<Integer> list, boolean[] used) {
    if (list.size() == nums.length) {
      resultList.add(new ArrayList<Integer>(list));
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      if (used[i]) {
        continue;
      }
      if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
        continue;
      }
      used[i] = true;
      list.add(nums[i]);
      dfs(nums, resultList, list, used);
      used[i] = false;
      list.remove(list.size() - 1);
    }
  }
}
