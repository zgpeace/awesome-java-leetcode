package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/palindrome-partitioning/
public class PalindromePartitioning {

  public static void main(String[] args) {
    String s = "aab";
    PalindromePartitioning obj = new PalindromePartitioning();
    List<List<String>> resultList = obj.partition(s);
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
}
