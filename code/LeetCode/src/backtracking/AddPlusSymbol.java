package backtracking;

import java.util.ArrayList;
import java.util.List;

public class AddPlusSymbol {

  public static void main(String[] args) {
    AddPlusSymbol obj = new AddPlusSymbol();
    String input1 = "125";
    Long result1 = obj.addPlus(input1);
    System.out.println("input > " + input1 + " ; result > " + result1);
    String input2 = "9999999999";
    Long result2 = obj.addPlus(input2);
    System.out.println("input > " + input2 + " ; result > " + result2);
  }

  public long addPlus(String input) {
    if (input == null || input.length() == 0) {
      return 0;
    }

    long result = 0;
    List<String> resultList = new ArrayList<String>();
    char[] chars = input.toCharArray();
    // dfs
    dfs(chars, resultList, "", 0);

    // loop list sum
    for (String s: resultList) {
      String[] nums = s.split("\\+");
      for (String n: nums) {
        result += Long.parseLong(n);
      }
    }

    return result;
  }

  private void dfs(char[] chars, List<String> resultList, String s, int start) {
    // exit
    if (start == chars.length - 1) {
      resultList.add(s + chars[chars.length - 1]);
      return;
    }
    s += chars[start];
    dfs(chars, resultList, s + '+', start + 1);
    dfs(chars, resultList, s, start + 1);
  }
}
