package String;

// https://leetcode.com/problems/implement-strstr/
public class ImplementStrStr {

  public int strStr(String haystack, String needle) {
    if (haystack.length() == 0 && needle.length() == 0) {
      return 0;
    }
    if (haystack.length() == 0 || needle.length() == 0 || haystack.length() < needle.length()) {
      return -1;
    }

    for (int i = 0; i <= haystack.length() - needle.length(); i++) {
      for (int k = 0; k < needle.length(); k++) {
        if (haystack.charAt(i + k) != needle.charAt(k)) {
          break;
        }

        if (k == needle.length() - 1) {
          return i;
        }
      }
    }

    return -1;
  }

  public int strStrWithEqual(String haystack, String needle) {
    int hayLen = haystack.length();
    int needleLen = needle.length();
    if (needleLen == 0) {
      return 0;
    } else if (hayLen < needleLen) {
      return -1;
    }
    int zoom = hayLen - needleLen;
    for (int i = 0; i <= zoom; i++) {
      if (haystack.substring(i, i + needleLen).equals(needle)) {
        return i;
      }
    }

    return -1;
  }

  public int strStrElegant(String haystack, String needle) {
    for (int i = 0; ; i++) {
      for (int k = 0; ; k++) {
        if (k == needle.length()) {
          return i;
        }
        if (i + k == haystack.length()) {
          return -1;
        }
        if (haystack.charAt(i + k) != needle.charAt(k)) {
          break;
        }
      }
    }
  }
}
