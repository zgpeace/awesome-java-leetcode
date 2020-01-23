package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/factor-combinations/
public class FactorCombinations {

  public static void main(String[] args) {
    FactorCombinations obj = new FactorCombinations();
    int n = 12;
    List<List<Integer>> resultList = obj.getFactors(12);
    System.out.println(Arrays.toString(resultList.toArray()));
  }

  public List<List<Integer>> getFactors(int n) {
    List<List<Integer>> resultList = new ArrayList<List<Integer>>();
    // DFS
    //dfs(resultList, new ArrayList<Integer>(), n, 2);
    //dfs1(resultList, new ArrayList<Integer>(), n, 2);
    dfs2(resultList, new ArrayList<Integer>(), n, 2);

    return resultList;
  }

  private void dfs(List<List<Integer>> resultList, List<Integer> list, int n, int start) {
    // exit
    if (n == 1) {
      if (list.size() > 1) {
        resultList.add(new ArrayList<Integer>(list));
      }

      return;
    }

    for (int i = start; i <= n; i++) {
      if (n % i == 0) {
        list.add(i);
        dfs(resultList, list, n / i, i);

        list.remove(list.size() - 1);
      }
    }
  }


  private void dfs1(List<List<Integer>> resultList, List<Integer> list, int n, int start) {
    for (int i = start; i * i < n; i++) {
      if (n % i == 0) {
        List<Integer> newList = new ArrayList<Integer>(list);
        newList.add(i);
        dfs1(resultList, newList, n / i, i);

        newList.add(n / i);
        resultList.add(newList);
      }
    }
  }

  private void dfs2(List<List<Integer>> resultList, List<Integer> list, int n, int start) {
    for (int i = start; i * i < n; i++) {
      if (n % i == 0) {
        list.add(i);
        dfs2(resultList, list, n / i, i);

        list.add(n / i);
        resultList.add(new ArrayList<Integer>(list));
        list.remove(list.size() - 1);
        list.remove(list.size() - 1);
      }
    }
  }
}
