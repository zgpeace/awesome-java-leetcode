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
        /* 表示第一个数字不能跟以前相同，比如这里有两个1，那么[1, 2, 5]， [1,7]，就会有两个。
         *  第一次以1开头，那么第二个就要以2开头。这里需要调试就能找到规律。
        */
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
