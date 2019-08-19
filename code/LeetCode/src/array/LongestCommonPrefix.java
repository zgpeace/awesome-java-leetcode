package array;

// https://leetcode.com/problems/longest-common-prefix/
public class LongestCommonPrefix {

  public String longestCommonPrefix(String[] strs) {
    // edge trecking
    if (strs.length == 0) {
      return "";
    } else if (strs.length == 1) {
      return strs[0];
    }
    // find short string
    String shortString = strs[0];
    for (int i = 1; i < strs.length; i++) {
      if (strs[i].length() < shortString.length()) {
        shortString = strs[i];
      }
    }

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < shortString.length(); i++) {
      char c = shortString.charAt(i);
      for (int k = 0; k < strs.length; k++) {
        if (c != strs[k].charAt(i)) {
          return sb.toString();
        }

        if (k == strs.length - 1) {
          sb.append(c);
        }
      }
    }

    return sb.toString();
  }

  public static void main(String[] args) {
    String[] strs = {"flower","flow","flight"};
    longestCommonPrefixWithBinarySearch(strs);
  }

  public static String longestCommonPrefixWithBinarySearch(String[] strs) {
    if (strs == null || strs.length == 0) {
      return "";
    } else if(strs.length == 1) {
      return strs[0];
    }
    int minLen = strs[0].length();
    for (int i = 1; i < strs.length; i++) {
      if (strs[i].length() < minLen) {
        minLen = strs[i].length();
      }
    }
    int left = 1;
    int right = minLen;
    int mid;
    while (left <= right) {
      mid = left + ((right - left) >> 1);
      if (isCommonPre(strs, mid)) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    return strs[0].substring(0, (left + ((right - left) >> 1) ));
  }

  public static boolean isCommonPre(String[] strs, int len) {
    String preString = strs[0].substring(0, len);
    for (int i = 1; i < strs.length; i++) {
      if (strs[i].indexOf(preString) != 0) {
        return false;
      }
    }

    return true;
  }

  public String longestCommonPrefixWithDivideConque(String[] strs) {
    if (strs.length == 0) {
      return "";
    }

    return longestCommonPrefixWithDivideConque(strs, 0, strs.length - 1);
  }

  public String longestCommonPrefixWithDivideConque(String[] strs, int left, int right) {
    if (left == right) {
      return strs[left];
    }

    int mid = left + ((right - left) >> 1);
    String commonLeft = longestCommonPrefixWithDivideConque(strs, left, mid);
    String commonRight =  longestCommonPrefixWithDivideConque(strs, mid + 1, right);

    return commonBetweenTwoString(commonLeft, commonRight);
  }

  public String commonBetweenTwoString(String s1, String s2) {
    int minLen = Math.min(s1.length(), s2.length());
    for (int i = 0; i < minLen; i++) {
      if (s1.charAt(i) != s2.charAt(i)) {
        return s1.substring(0, i);
      }
    }

    return s1.substring(0, minLen);
  }


  public String longestCommonPrefixWithVerticalScan(String[] strs) {
    if (strs.length == 0) {
      return "";
    }
    for (int i = 0; i < strs[0].length(); i++) {
      char c = strs[0].charAt(i);
      for (int k = 1; k < strs.length; k++) {
        if (i == strs[k].length() || c != strs[k].charAt(i)) {
          return strs[0].substring(0, i);
        }
      }
    }

    return strs[0];
  }

  public String longestCommonPrefixWithHorizontalScan(String[] strs) {
    if (strs.length == 0) {
      return "";
    }
    String pre = strs[0];
    for (int i = 1; i < strs.length; i++) {
      while (strs[i].indexOf(pre) != 0) {
        pre = pre.substring(0, pre.length() - 1);
        if (pre.isEmpty()) {
          return "";
        }
      }
    }

    return pre;
  }
}
