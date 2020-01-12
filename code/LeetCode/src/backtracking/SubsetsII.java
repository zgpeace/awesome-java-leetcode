package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/subsets-ii/
public class SubsetsII {

  public static void main(String[] args) {
    int[] nums = {1,2,2};
    SubsetsII obj = new SubsetsII();
    //List<List<Integer>> resultList = obj.subsetsWithDup(nums);
    List<List<Integer>> resultList = obj.subsetsWithDupIterate(nums);
    System.out.println(Arrays.toString(resultList.toArray()));
  }

  public List<List<Integer>> subsetsWithDup(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> resultList = new ArrayList<List<Integer>>();
    // dfs
    //dfs(nums, resultList, new ArrayList<Integer>(), 0);
    dfsWithFor(nums, resultList, new ArrayList<Integer>(), 0);
    //subsetsWithDupHelper(nums, resultList, new ArrayList<Integer>(), 0);

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

  private void dfsWithFor(int[] nums, List<List<Integer>> resultList, List<Integer> list, int start) {
    // exit
    if (start <= nums.length) {
      resultList.add(new ArrayList<>(list));
    }

    for (int i = start; i < nums.length; i++) {
      // duplicate case
      if (i > start && nums[i] == nums[i - 1]) {
        continue;
      }

      // pick up
      list.add(nums[i]);
      dfsWithFor(nums, resultList, list, i + 1);

      // not pick up
      list.remove(list.size() - 1);
    }
  }

  public List<List<Integer>> subsetsWithDupIterate(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> resultList = new ArrayList<List<Integer>>();
    List<Integer> list = new ArrayList<Integer>();
    resultList.add(list);

    int duplicateStart = 0;
    for (int i = 0; i < nums.length; i++) {
      int begin = 0;
      int size = resultList.size();
      if (i > 0 && nums[i] == nums[i - 1]) {
        begin = duplicateStart;
      }

      for (int k = begin; k < size; k++) {
        List<Integer> newList = new ArrayList<Integer>(resultList.get(k));
        newList.add(nums[i]);
        resultList.add(newList);
      }

      duplicateStart = size;
    }

    return resultList;
  }
}
