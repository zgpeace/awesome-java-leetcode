package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/restore-ip-addresses/
public class RestoreIPAddress {

  public static void main(String[] args) {
    RestoreIPAddress obj = new RestoreIPAddress();
    String s = "25525511135";
    List<String> resultList = obj.restoreIpAddresses(s);
    System.out.println(Arrays.toString(resultList.toArray()));
  }

  public List<String> restoreIpAddresses(String s) {
    List<String> resultList = new ArrayList<String>();
    if (s == null || s.length() < 4) {
      return resultList;
    }

    // DFS
    dfs(resultList, s, 0, "", 0);

    return resultList;
  }

  private void dfs(List<String> resultList, String s, int start, String stored, int count) {
    //exit
    if (start == s.length() && count == 4) {
        resultList.add(stored);
    }

    if (start == s.length() || count == 4) {
      return;
    }

    for (int i = 1; i < 4; i++) {
      if (start + i > s.length()) {
        break;
      }
      String part = s.substring(start, start + i);
      if ((part.startsWith("0") && part.length() > 1) || (i == 3 && Integer.valueOf(part) > 255)) {
        continue;
      }
      dfs(resultList, s, start + i, stored + part + (count == 3 ? "" : "."), count + 1);
    }
  }
}
