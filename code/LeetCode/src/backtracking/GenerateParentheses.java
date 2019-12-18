package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/generate-parentheses/
public class GenerateParentheses {

  public static void main(String[] args) {
    GenerateParentheses obj = new GenerateParentheses();
    List<String> result = obj.generateParenthesis(3);
    System.out.println("result > " + Arrays.toString(result.toArray()));
  }

  public List<String> generateParenthesis(int n) {
    List<String> result = new ArrayList<>();
    if (n <= 0) {
      return result;
    }

    helper(result, "", n, n);

    return result;
  }

  public void helper(List<String> result, String combine, int left, int right) {
    //exit
    if (left == 0 && right == 0) {
      result.add(combine);
      return;
    }

    if (left > 0) {
      helper(result, combine + '(', left - 1, right);
    }
    if (right > left) {
      helper(result, combine + ')', left, right - 1);
    }
  }
}
