package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/restore-ip-addresses/
public class RestoreIPAddress {

  public static void main(String[] args) {
    RestoreIPAddress obj = new RestoreIPAddress();
    String s = "25525511135";
    //List<String> resultList = obj.restoreIpAddresses(s);
    List<String> resultList = obj.restoreIpAddressesWithIterate(s);
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

    if (start >= s.length() || count == 4) {
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


  public List<String> restoreIpAddressesWithIterate(String s) {
    List<String> resultList = new ArrayList<String>();
    if (s == null || s.length() < 4) {
      return resultList;
    }

    int len = s.length();
    String splitS = ".";
    // iterate
    for (int fisrt = 1; fisrt < 4 && fisrt < len - 2; fisrt++) {
      for (int second = fisrt + 1; second < fisrt + 4 && second < len - 1; second++) {
        for (int third = second + 1; third < second + 4 && third < len; third++) {
          String part1 = s.substring(0, fisrt);
          String part2 = s.substring(fisrt, second);
          String part3 = s.substring(second, third);
          String part4 = s.substring(third);
          if (valideIP(part1) && valideIP(part2) && valideIP(part3) && valideIP(part4)) {
            String result = part1 + splitS + part2 + splitS + part3 + splitS + part4;
            resultList.add(result);
          }
        }
      }

    }

    return resultList;
  }

  private Boolean valideIP(String part) {
    if (part.length() == 0 || part.length() > 3
        || (part.startsWith("0") && part.length() != 1)
        || (part.length() == 3 && Integer.valueOf(part) > 255 )) {
      return false;
    }

    return true;
  }
}
