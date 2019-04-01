package popular;

import java.util.Arrays;
import java.util.Stack;

public class LongestValidParentheses {

    /**
     * 用Stack存储开始匹配的上一个位置，那么当前的位置减去上个位置，就是最长的匹配,
     * 时间复杂度为O(n), 空间复杂度为O(n)
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        int len = s.length();
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxLen = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }

        return maxLen;
    }


    /**
     * 从左到右，又从右到左，两个方向找最长的匹配。
     * 时间复杂度为O(n), 空间复杂度为O(1)
     * @param s
     * @return
     */
    public int longestValidParenthesesWithoutStack(String s) {
        int left = 0;
        int right = 0;
        int maxLen = 0;
        int len = s.length();
        for (char c: s.toCharArray()) {
            if (c == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxLen = Math.max(maxLen, right * 2);
            } else if (right > left) {
                left = right = 0;
            }
        }

        left = right = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxLen = Math.max(maxLen, left * 2);
            } else if (left > right) {
                left = right = 0;
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String input = "((())";
        LongestValidParentheses obj = new LongestValidParentheses();
        //System.out.println("input: ((()), Output -> " + obj.longestValidParentheses(input));
        System.out.println("input: ((()), Output -> " + obj.longestValidParenthesesWithoutStack(input));
    }
}
