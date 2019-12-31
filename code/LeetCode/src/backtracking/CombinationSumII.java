package backtracking;

import java.util.*;

// https://leetcode.com/problems/combination-sum-ii/
public class CombinationSumII {

  public static void main(String[] args) {
    CombinationSumII obj = new CombinationSumII();
    int[] candidates = {10,1,2,7,6,1,5};
    int target = 8;
    List<List<Integer>> resultList = obj.combinationSum2(candidates, target);
    System.out.println("resultList >> " + Arrays.toString(resultList.toArray()));
  }

  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> resultList = new ArrayList<>();
    Arrays.sort(candidates);
    recursive(candidates, target, resultList, new ArrayList<Integer>(), 0);

    return resultList;
  }

  public void recursive(int[] candidates, int target, List<List<Integer>> resultList, List<Integer> list, int start) {
    if (target == 0) {
      List<Integer> newList = new ArrayList<Integer>(list);

      resultList.add(newList);
    } else if (target > 0) {
      for (int i = start; i < candidates.length && target >= candidates[i]; i++) {
        if (i > start && candidates[i] == candidates[i - 1]) {
          continue;
        }
        list.add(candidates[i]);
        recursive(candidates, target - candidates[i], resultList, list, i + 1);
        list.remove(list.size() - 1);
      }
    }
  }
}
