package backtracking;

import java.util.*;

// https://leetcode.com/problems/palindrome-partitioning/
public class PalindromePartitioning {

  public static void main(String[] args) {
    String s = "aab";
    PalindromePartitioning obj = new PalindromePartitioning();
    //List<List<String>> resultList = obj.partition(s);
    List<List<String>> resultList = obj.partitionWithDP(s);
    System.out.println(Arrays.toString(resultList.toArray()));
  }

  public List<List<String>> partition(String s) {
    List<List<String>> resultList = new ArrayList<List<String>>();
    // dfs
    dfs(s, 0, resultList, new ArrayList<String>());

    return resultList;
  }

  private void dfs(String s, int start, List<List<String>> resultList, List<String> list) {
    // exit
    if (start >= s.length()) {
      resultList.add(new ArrayList<String>(list));
      return;
    }

    // for
    for (int i = start; i < s.length(); i++) {

      // isPalindrome
      if (isPal(s, start, i)) {
        // add
        list.add(s.substring(start, i + 1));
        dfs(s, i + 1, resultList, list);

        // not add
        list.remove(list.size() - 1);
      }
    }
  }

  private boolean isPal(String s, int l, int r) {
    while (l < r) {
      if (s.charAt(l++) != s.charAt(r--)) {
        return false;
      }
    }

    return true;
  }

  public List<List<String>> partitionWithDP(String s) {
    int len = s.length();
    List<List<String>>[] results = new List[len + 1];
    results[0] = new ArrayList<List<String>>();
    results[0].add(new ArrayList<String>());

    boolean[][] pair = new boolean[len][len];
    for (int i = 0; i < len; i++) {
      results[i + 1] = new ArrayList<List<String>>();
      for (int left = 0; left <= i; left++) {
        if (s.charAt(left) == s.charAt(i) && (i-left <= 1 || pair[left + 1][i - 1])) {
          pair[left][i] = true;
          String sub = s.substring(left, i + 1);
          for (List<String> list: results[left]) {
            List<String> newList = new ArrayList<String>(list);
            newList.add(sub);
            results[i + 1].add(newList);
          }
        }
      }

    }

    return results[len];
  }
}
