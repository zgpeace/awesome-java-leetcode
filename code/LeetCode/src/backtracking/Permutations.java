package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/permutations/
public class Permutations {

  public static void main(String[] args) {
    Permutations obj = new Permutations();
    obj.permuteWithCleanRecursive(new int[]{1, 2, 3});
  }

  public List<List<Integer>> permuteWithCleanRecursive(int[] nums) {
    LinkedList<List<Integer>> result = new LinkedList<>();
    result.add(new ArrayList<Integer>());
    int size;
    for (int n: nums) {
      size = result.size();
      for (; size > 0; size--) {
        List<Integer> resultItem = result.pollFirst();
        for (int i = 0; i <= resultItem.size(); i++) {
          List<Integer> newList = new ArrayList<>(resultItem);
          newList.add(i, n);
          result.add(newList);
        }
      }

    }

    return result;
  }

  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    if (nums == null || nums.length == 0) {
      return result;
    }

    // backtracking
    addItemInAllPosition(nums, 0, new ArrayList<Integer>(), result);

    return result;
  }

  private void addItemInAllPosition(int[] nums, int start, List<Integer> list, List<List<Integer>> result) {
    if (list.size() == nums.length) {
      result.add(list);
      return;
    }

    for (int i = 0; i <= list.size(); i++) {
      List<Integer> newList = new ArrayList<>(list);
      newList.add(i, nums[start]);
      addItemInAllPosition(nums, start + 1, newList, result);
    }
  }
}
