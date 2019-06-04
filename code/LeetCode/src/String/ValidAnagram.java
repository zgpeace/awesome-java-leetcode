package String;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/valid-anagram/
public class ValidAnagram {
  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    int count = 0;
    Map<Character, Integer> map = new HashMap<>();
    for (char c : s.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
      count++;
    }
    for (char c : t.toCharArray()) {
      if (map.containsKey(c) && map.get(c) > 0) {
        map.put(c, map.get(c) - 1);
      } else {
        return false;
      }
      count--;
    }

    return count == 0;
  }

  public boolean isAnagramWithSort(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    char[] sChars = s.toCharArray();
    char[] tChars = t.toCharArray();
    Arrays.sort(sChars);
    Arrays.sort(tChars);

    return Arrays.equals(sChars, tChars);
  }

  public boolean isAnagramWithChar(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    int[] count = new int[26];
    for (int i = 0; i < s.length(); i++) {
      count[s.charAt(i) - 'a']++;
      count[t.charAt(i) - 'a']--;
    }
    for (int i = 0; i < 26; i++) {
      if (count[i] != 0) {
        return false;
      }
    }

    return true;
  }
}
