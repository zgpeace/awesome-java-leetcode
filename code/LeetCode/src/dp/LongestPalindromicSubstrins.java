package dp;

// https://leetcode.com/problems/longest-palindromic-substring/
public class LongestPalindromicSubstrins {

  public String longestPalindromeWithdp(String s) {
    if (s == null || s.length() == 0) {
      return "";
    }
    boolean[][] dp = new boolean[s.length()][s.length()];
    String result = "";
    for (int i = s.length() - 1; i >= 0; i--) {
      for (int k = i; k < s.length(); k++) {
        dp[i][k] = (s.charAt(i) == s.charAt(k) && (k - i < 3 || dp[i + 1][k - 1]));

        if (dp[i][k] && k - i + 1 > result.length()) {
          result = s.substring(i, k + 1);
        }
      }
    }

    return result;
  }

  public String longestPalindromeRecursive(String s) {
    if (s == null || s.length() == 0) {
      return "";
    }

    char[] chars = s.toCharArray();
    int max = 0;
    int start = 0;
    int end = 0;
    for (int i = 0; i < chars.length; i++) {
      if (validPalindrome(chars, i - max - 1, i)) {
        start = i - max - 1;
        end = i;
        max += 2;
      } else if (validPalindrome(chars, i - max, i)) {
        start = i - max;
        end = i;
        max += 1;
      }
    }

    return s.substring(start, end + 1);
  }

  public boolean validPalindrome(char[] chars, int start, int end) {
    if (start < 0) {
      return false;
    }
    while (start < end) {
      if (chars[start++] != chars[end--]) {
        return false;
      }
    }

    return true;
  }

  public static String longestPalindromeSynchronize(String s) {
    // edge case
    if (s == null || s.length() == 0) {
      return "";
    }
    int max = 1;
    String result = s.substring(0, 1);
    for (int i = 0; i < s.length(); i++) {
      int len1 = expandPalindrom(s, i, i);
      int len2 = expandPalindrom(s, i, i + 1);
      int len = Math.max(len1, len2);
      if (max < len) {
        max = len;
        int left = i - (len - 1) / 2;
        int right = i + len / 2;
        result = s.substring(left, right + 1);
      }
    }

    return result;
  }

  public static int expandPalindrom(String s, int left, int right) {
    while (left >= 0 && right < s.length()) {
      if (s.charAt(left) != s.charAt(right)) {
        break;
      }

      left--;
      right++;
    }

    return right - left - 1;
  }

  public static void main(String[] args) {
    String result = longestPalindromeSynchronize("bb");
    System.out.println(result);
  }

  public static String longestPalindrome(String s) {
    if (s == null || s.length() == 0) {
      return "";
    }
    int max = 1;
    String result = s.substring(0, 1);
    String current;
    for (int i = 1; i < s.length(); i++) {
      // assume the left string is palindrome, if its length is less than max, can break;
      int dreamMax = Math.min(i, s.length() - i - 1) * 2 + 1;
      if (max > dreamMax) {
        break;
      }

      // i is pivot center, such as 0i0
      current = helper(s, i - 1, i + 1);
      if (max < current.length()) {
        max = current.length();
        result = current;
      }

      // i & i - 1 is pivot center, such as 0ii0
      if (s.charAt(i) != s.charAt(i - 1)) {
        continue;
      }
      current = helper(s, i - 2, i + 1);
      if (max < current.length()) {
        max = current.length();
        result = current;
      }
    }

    return result;
  }

  public static String helper(String s, int left, int right) {
    while (left >= 0 && right < s.length()) {
      if (s.charAt(left) != s.charAt(right)) {
        break;
      }

      left--;
      right++;
    }

    return right - left == 2 ? "" : s.substring(left + 1, right);
  }
}
