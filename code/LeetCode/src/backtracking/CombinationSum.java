package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/combination-sum/
public class CombinationSum {

  public static void main(String[] args) {
    CombinationSum obj = new CombinationSum();
    int[] candicates = {2, 3, 6, 7};
    int target = 7;
    List<List<Integer>> resultList = obj.combinationSum(candicates, target);
    System.out.println(Arrays.toString(resultList.toArray()));
  }

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> resultList = new ArrayList<>();
    Arrays.sort(candidates);
    recursive(candidates, target, 0, new ArrayList<>(), resultList);

    return resultList;
  }

  public void recursive(int[] candidates, int target, int start, List<Integer> list, List<List<Integer>> resultList) {
    if (target > 0) {
      for (int i = start; i < candidates.length && target >= candidates[i]; i++) {
        list.add(candidates[i]);
        recursive(candidates, target - candidates[i], i, list, resultList);
        list.remove(list.size() - 1);
      }
    } else if (target == 0) {
      resultList.add(new ArrayList<>(list));
    }
  }
}
