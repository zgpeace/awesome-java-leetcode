package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/subsets/
public class Subsets {

  public static void main(String[] args) {
    int[] nums = new int[]{1,2,3};
    Subsets obj = new Subsets();
    List<List<Integer>> resultList = obj.subsets(nums);
    System.out.println(Arrays.toString(resultList.toArray()));
  }

  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> resultList = new ArrayList<List<Integer>>();
    // dfs
    dfs(nums, resultList, new ArrayList<Integer>(), 0);

    return resultList;
  }

  private void dfs(int[] nums, List<List<Integer>> resultList, List<Integer> list, int index) {
    // exit
    if (nums == null || index == nums.length) {
      resultList.add(new ArrayList<Integer>(list));
      return;
    }

    // add item
    list.add(nums[index]);
    dfs(nums, resultList, list, index + 1);

    // not add item
    list.remove(list.size() - 1);
    dfs(nums, resultList, list, index + 1);
  }
}
