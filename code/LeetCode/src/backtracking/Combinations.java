package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/combinations/
public class Combinations {

  public static void main(String[] args) {
    Combinations obj = new Combinations();
    int n = 4;
    int k = 2;
    List<List<Integer>> resultList = obj.combineBaseOnFormular(n , k);
    System.out.println("resultList > " + Arrays.toString(resultList.toArray()));
  }

  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> resultList = new ArrayList<List<Integer>>();
    if (n == 0 || k == 0) {
      return resultList;
    }

    // dfs
    dfs(n, k, resultList, new ArrayList<Integer>(), 1);

    return resultList;
  }

  public void dfs(int n, int k, List<List<Integer>> resultList, List<Integer> list, int start) {
    if (k == 0) {
      resultList.add(new ArrayList<Integer>(list));
      return;
    }

    for (int i = start; i <= n - k + 1; i++) {
      // [1, 2], [1, 3], [1, 4]
      // [2, 3], [2, 4]
      // [3, 4]
      list.add(i);
      dfs(n, k - 1, resultList, list, i + 1);
      list.remove(list.size() - 1);
    }
  }

  // based on C(n,k)=C(n-1,k-1)+C(n-1,k)
  public List<List<Integer>> combineBaseOnFormular(int n, int k) {
    List<List<Integer>> resultList = new LinkedList<List<Integer>>();
    if (n < k || k == 0) {
      return resultList;
    }
    resultList = combineBaseOnFormular(n - 1, k - 1);
    // if at this point resultList is empty, it can only be that k - 1 == 0,
    // n - 1 < k - 1 is not possible since n >= k (if n < k, the function would have already returned at an early point)
    if (resultList.isEmpty()) {
      resultList.add(new LinkedList<Integer>());
    }
    for (List<Integer> list: resultList) {
      list.add(n);
    }

    resultList.addAll(combineBaseOnFormular(n - 1, k));

    return resultList;
  }
}
