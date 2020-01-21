package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/combination-sum-iii/
public class CombinationSumIII {

  public static void main(String[] args) {
    int k = 3;
    int n = 9;
    CombinationSumIII obj = new CombinationSumIII();
    List<List<Integer>> resultList = obj.combinationSum3(k ,n);
    System.out.println(Arrays.toString(resultList.toArray()));
  }

  public List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> resultList = new ArrayList<List<Integer>>();
    // dfs
    dfs(resultList, new ArrayList<Integer>(), k, n, 1);

    return resultList;
  }

  private void dfs(List<List<Integer>> resultList, List<Integer> list, int k, int sum, int start) {
    if (sum == 0 && k == 0) {
      resultList.add(new ArrayList<Integer>(list));
      return;
    }
    if (sum < 0) {
      return;
    }
    for (int i = start; i <= 9; i++) {
      // add num
      list.add(i);
      dfs(resultList, list, k - 1, sum - i, i + 1);

      // not add num
      list.remove(list.size() - 1);
    }
  }

}
