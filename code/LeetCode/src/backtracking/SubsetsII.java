package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/subsets-ii/
public class SubsetsII {

  public static void main(String[] args) {
    int[] nums = {1,2,2};
    SubsetsII obj = new SubsetsII();
    List<List<Integer>> resultList = obj.subsetsWithDup(nums);
    System.out.println(Arrays.toString(resultList.toArray()));
  }

  public List<List<Integer>> subsetsWithDup(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> resultList = new ArrayList<List<Integer>>();
    // dfs
    dfs(nums, resultList, new ArrayList<Integer>(), 0);

    return resultList;
  }

  private void dfs(int[] nums, List<List<Integer>> resultList, List<Integer> list, int start) {
    if (start <= nums.length) {
      resultList.add(list);
    }
    int i = start;
    while (i < nums.length) {
      list.add(nums[i]);
      dfs(nums, resultList, new ArrayList<Integer>(list), i + 1);

      list.remove(list.size() - 1);
      i++;
      while (i < nums.length && nums[i] == nums[i - 1]) {
        i++;
      }
    }

  }

  // still have some duplicate data
  //private void dfs1(int[] nums, List<List<Integer>> resultList, List<Integer> list, int start) {
  //  // exit
  //  if (start == nums.length) {
  //    resultList.add(new ArrayList<>(list));
  //    return;
  //  }
  //
  //  for (int i = start; i < nums.length; i++) {
  //    // duplicate case
  //    if (i > start && nums[i] == nums[i - 1]) {
  //      continue;
  //    }
  //
  //    // pick up
  //    list.add(nums[i]);
  //    dfs(nums, resultList, list, i + 1);
  //
  //    // not pick up
  //    list.remove(list.size() - 1);
  //    dfs(nums, resultList, list, i + 1);
  //  }
  //}
}
