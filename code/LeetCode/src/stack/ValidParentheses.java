package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// https://leetcode.com/problems/valid-parentheses/
public class ValidParentheses {
  public boolean isValid(String s) {
    Map<Character, Character> map = new HashMap<>();
    map.put(']', '[');
    map.put('}', '{');
    map.put(')', '(');
    Stack<Character> stack = new Stack<>();
    for (char c: s.toCharArray()) {
      if (c == '[' || c == '(' || c == '{') {
        stack.push(c);
        continue;
      }

      if (stack.isEmpty()) {
        return false;
      }

      char pre = stack.pop();
      if (map.get(c) != pre) {
        return false;
      }
    }

    return stack.isEmpty();
  }

}
