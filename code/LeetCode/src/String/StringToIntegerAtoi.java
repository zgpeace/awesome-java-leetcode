package String;

// https://leetcode.com/problems/string-to-integer-atoi/
public class StringToIntegerAtoi {

  public int myAtoi(String str) {
    if (str == null || str.length() == 0) {
      return 0;
    }
    char[] chars = str.toCharArray();
    int flag = 1;
    int result = 0;
    int i = 0;
    int len = chars.length;
    while (i < len && chars[i] == ' ') {
      i++;
    }
    if (i < len && chars[i] == '-') {
      flag = -1;
      i++;
    } else if (i < len && chars[i] == '+') {
      flag = 1;
      i++;
    }

    if (i < len) {
      int gap = chars[i] - '0';
      if (gap < 0 || gap > 9) {
        return 0;
      }
    }

    int maxDevideTen = Integer.MAX_VALUE / 10;
    int gap;
    for (; i < len; i++) {
      gap = chars[i] - '0';
      if (gap < 0 || gap > 9) {
        break;
      }

      if (flag == 1 && (result > maxDevideTen || (result == maxDevideTen && gap > 7))) {
        return Integer.MAX_VALUE;
      } else if (flag == -1 && (result > maxDevideTen  || (result == maxDevideTen && gap > 8))) {
        return Integer.MIN_VALUE;
      }

      result = result * 10 + gap;
    }

    return flag * result;
  }

}
